package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import modelo.HistorialCaja;
import modelo.Usuario;
import persistenciaFWK.adaptadores.IAdaptador;
import utilidades.InvalidException;
import utilidades.Utilidades;
import vista.MenuVista;

/**
 *
 * @author Kymera Systems SAS
 */
public class PuntoDeVenta implements IPublicadorDeEventos {

    private IAdaptador adaptador;
    public static Caja caja;
    public static Usuario usuarioActual;
    private List<ObservadorEventos> observadores;
    public static final String PERMISOS = "permisos";
    public static final String ESTABLECER_BASE = "base";
    public static final String CARGAR_USUARIO = "usuario";
    public static final String LANZAR_MENSAJE = "lanzar";
    public static final String CIERRE_CAJA = "cierre";
    public static final String CAJA_ABIERTA = "abierta";
    public static final String CARGAR_CATEGORIA = "categoria";
    public static final String CARGAR_CARGOS = "cargos";
    public static final String ACTUALIZAR_TABLA = "ACTUALIZAR";
    public static final String ADMINISTRAR_CAJAS = "ADMC";
    public static final String ONLINE = "OL";
    public static final String CARGAR_UNIDADES = "UNIDADES";
    public static final String CARGAR_MARCAS = "MARCAS";
    public static final String CARGAR_UBICACION = "UBICACION";

    /**
     * Constantes Buscadores
     */
    public static final String BUSCAR_PRODUCTO = "buscar_producto";
    public static final String BUSCAR_CLIENTE = "buscar_cliente";
    public static final String BUSCAR_PROVEEDOR = "buscar_proveedor";
    public static final String BUSCAR_COMPRA = "buscar_compras";
    public static final String DATOS_PRO_ENCON = "datos_pro_encon";
    public static final String DATOS_PER_ENCON = "datos_per_encon";
    public static final String DATOS_PRV_ENCON = "datos_prv_encon";
    public static final String DATOS_CLI_ENCON = "datos_cli_encon";
   
    /**
     * Constantes Venta
     */
    public static final String TOTAL_VENTA = "total";
    public static final String IMPUESTOS = "impues";
    public static final String SUBTOTAL_VENTA = "subtotal";
    public static final String DESC_VENTA = "descuento_venta";
    public static final String BASE_GRABABLE = "base_grabable";
    public static final String IVA_VENTA = "iva_venta";
    public static final String NUEVO_PRODUCTO = "nuevo_producto";
    public static final String MODIFICAR_CANTIDAD = "modificar_cantidad";
    public static final String ESTABLECER_CANTIDAD = "establecer_cantidad";
    public static final String NUM_TICKETE = "numero_tickete";
    public static final String CAMBIO_VENTA = "cambio_venta";
    public static final String ELIMINAR_LINEA = "eliminar_linea";
    public static final String CARGAR_TABLA = "cargar_tabla";
    public static final String ESTABLECER_CLIENTE = "establecer_cliente";
    public static final String ERROR_NO_DATOS = "error_datos";
    public static final String CLIENTE_VENTA = "cliente_venta";
    public static final String DATOS_ENCONTRADOS = "datos_encontrados";
    public static final String BUSCAR_PERSONAL = "buscar_personal";
    /**
     * Constantes Compra
     */
    public static final String TOTAL_COMPRA = "total_compra";
    public static final String IMPUESTOS_COMPRA = "impuesto_compra";
    public static final String SUBTOTAL_COMPRA = "subtotal_compra";
    public static final String BASE_G_COMPRA = "base_grabable_compra";
    public static final String IVA_COMPRA = "iva_compra";
    public static final String NUEVO_PRO_COMPRA = "nuevo_producto_compra";
    public static final String MODIFICAR_CANT_COMPRA = "modificar_cantidad_compra";
    public static final String ESTABLECER_CANT_COMPRA = "establecer_cantidad_compra";
    public static final String NUM_ORDEN = "numero_orden_compra";
    public static final String CAMBIO_COMPRA = "cambio_compra";
    public static final String ELIMINAR_LINEA_COMPRA = "eliminar_linea_compra";
    public static final String CARGAR_TABLA_COMPRA = "cargar_tabla_compra";
    public static final String ESTABLECER_PROVEEDOR = "establecer_proveedor";
    public static final String DATOS_COMPRA = "datos_compra";
    public static final String DATOS_LINEACOMPRA = "datos_linea";
    public static final String PROVEEDOR_COMPRA = "proveedor_compra";
    public static final String DATOS_PRODUCTO_COMPRA = "datos_producto_compra";
    /**
     * Numero Terminal de Punto de Venta
     */
    public static int TPV;
    public static final int INSERTAR = 1;
    public static final int MODIFICAR = 2;
    public static final int ELIMINAR = 3;
    public static final int ADMINISTRADOR = 1;
    public static final int SUPERVISOR = 3;
    public static final int CAJERO = 2;
    public static final int TECNICO = 4;
    private static PuntoDeVenta INSTANCIA;
    public static final int COMPRA = 1;
    public static final int PROVEEDOR = 2;

    private PuntoDeVenta() {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Usuario.class);
        observadores = new ArrayList();
    }

    public static PuntoDeVenta getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new PuntoDeVenta();
        }
        return INSTANCIA;
    }

    public void validarUsuario(String usuario, String contrasena) {
        usuarioActual = (Usuario) adaptador.getRegistro(usuario);
        if (usuarioActual != null) {
            if (usuarioActual.getContrasena().equals(contrasena)) {
                publicarEvento(PERMISOS, usuarioActual.getPermisos());
            } else {
                publicarEvento(LANZAR_MENSAJE, "Error: Contraseña Invalida");
                MenuVista.setInternal(1);
            }
        }
    }

    public boolean validarUsuarioInicial(String usuario, String contrasena) {
        usuarioActual = (Usuario) adaptador.getRegistro(usuario);
        if (usuarioActual != null) {
            if (usuarioActual.getContrasena().equals(contrasena)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void publicarEvento(String propiedad, Object valor) {
        for (ObservadorEventos obs : observadores) {
            obs.escuchadorEvento(this, propiedad, valor);
        }
    }

    public void addEscuchadorEventos(ObservadorEventos observador) {
        observadores.add(observador);
    }

    public void removeEscuchadorEventos(ObservadorEventos observador) {
        Class clase = observador.getClass();
        for (int i = 0; i < observadores.size(); i++) {
            if (clase.isInstance(observadores.get(i))) {
                observadores.remove(i);
            }
        }
    }

    public void borrarObservadores() {
        observadores.clear();
    }

    public String getNombreUsuarioActual() {
        return usuarioActual.getEmpleado();
    }

    public void iniciarCaja(String cajeroID) {
        caja = new Caja(cajeroID);
    }

    public void setSaldoAsignado(boolean estado) {
        publicarEvento(PuntoDeVenta.ESTABLECER_BASE, !estado);
    }

    public void administrarUsuarios(Object datos, int tipo) {
        CatalogosManager.getInstancia().administrarUsuarios(datos, tipo);
        cargarUsuario(CatalogosManager.PRIMERO);
    }

    /**
     * Obtiene un usuario segun la posicion secuencial de recorrido dentro del Mapa
     * @param pos
     */
    public void cargarUsuario(int pos) {
        Usuario user = null;
        if (usuarioActual.getPermisos() == CAJERO || usuarioActual.getPermisos() == TECNICO) {
            user = usuarioActual;
        } else {
            user = CatalogosManager.getInstancia().cargarUsuario(pos);
        }
        publicarEvento(CARGAR_USUARIO, user.toArray());
    }

    /**
     *
     * @param saldoEnCaja
     */
    public void realizarCierre(Map saldoEnCaja) {
	  //guardar saldos caja
        IAdaptador ac = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modelo.CierresCaja.class);
        Iterator i = saldoEnCaja.entrySet().iterator();
        double recogidasCaja = 0;

        while (i.hasNext()) {
            Map.Entry<Integer, Integer> me = (Entry) i.next();
            modelo.CierresCaja cierre = new modelo.CierresCaja(caja.getIdentificador(), me.getKey(), me.getValue());
            ac.putObject(cierre, IAdaptador.INSERTAR);
            recogidasCaja += cierre.getTotal();
        }
        
        //realizar cierre

        ac = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modelo.HistorialCaja.class);
        caja.realizarCierreCaja();
        List datos = new ArrayList();
        datos.add(caja.getHistorial().toArray());
        String[] parametros = {"PAGO", caja.getIdentificador()};
        Map mp = ac.getRegistros(parametros);
        if (mp == null || mp.isEmpty()) {
            datos.add(null);
        } else {
            datos.add(new ArrayList(mp.values()));
        }
        parametros[0] = "RECOGIDA";
        mp = ac.getRegistros(parametros);
        if (mp == null || mp.isEmpty()) {
            datos.add(null);
        } else {
            datos.add(new ArrayList(mp.values()));
        }     
        datos.add(recogidasCaja);
        publicarEvento(CIERRE_CAJA, datos);
    }

    /**
     * Obtiene la ultima caja realizada en la BD junto con sus movimientos
     */
    public void mostrarUltimoCierre() {

        List datos = new ArrayList();

        IAdaptador ac = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modelo.HistorialCaja.class);
        HistorialCaja hc = (HistorialCaja) ac.getRegistro("-1");

        datos.add(hc.toArray());
        String[] parametros = {"PAGO", hc.oid};
        Map mp = ac.getRegistros(parametros);
        if (mp == null || mp.isEmpty()) {
            datos.add(null);
        } else {
            datos.add(new ArrayList(mp.values()));
        }
        parametros[0] = "RECOGIDA";
        mp = ac.getRegistros(parametros);
        if (mp == null || mp.isEmpty()) {
            datos.add(null);
        } else {
            datos.add(new ArrayList(mp.values()));
        }
        int cantVentas = (Integer.parseInt(hc.getFacFinal()) - Integer.parseInt(hc.getFacInicial())) + 1;
        datos.add(String.valueOf(cantVentas));

        List totales = new ArrayList();
        totales.add(hc.getBaseGravable());
        totales.add(hc.getIva());
        totales.add((hc.getBaseGravable() + hc.getIva()));

        datos.add(totales);
        publicarEvento(CIERRE_CAJA, datos);
    }

    public boolean validarUltimoCierreCaja() {
        modelo.HistorialCaja cajaAnterior = null;
        IAdaptador ac = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modelo.HistorialCaja.class);
        Map mp = ac.getRegistros(PuntoDeVenta.usuarioActual.getUsuario());
        Iterator i = mp.entrySet().iterator();
        if(i.hasNext()){
            Map.Entry e = (Map.Entry) i.next();
            cajaAnterior = (HistorialCaja) e.getValue();
        }
        if (cajaAnterior != null) {
            if (cajaAnterior.getEstado().equalsIgnoreCase("ABIERTA")) {
                caja = new Caja(cajaAnterior);
                publicarEvento(CAJA_ABIERTA, cajaAnterior.toArray());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void cargarDatosCajas() {
        List<String> datos = new ArrayList();
        String[] parametros = {PuntoDeVenta.ADMINISTRAR_CAJAS, "ABIERTA"};
        IAdaptador adaptc = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modelo.HistorialCaja.class);
        Map<String, HistorialCaja> cajas = adaptc.getRegistros(parametros);
        int cv = 0;
        for (HistorialCaja c : cajas.values()) {
            cv = Integer.parseInt(c.getFacFinal()) - Integer.parseInt(c.getFacInicial());
            cv ++;
            String dt = Utilidades.establecerCaracteres(c.getCajero(), 28)
                    + Utilidades.establecerCaracteres(c.getFechaApertura() + " "
                    + c.getHoraApertura(), 40)
                    + Utilidades.establecerCaracteres("" + c.getSaldoBase(), 30)
                    + Utilidades.establecerCaracteres("" + cv, 30)
                    + Utilidades.establecerCaracteres("" + c.getSaldoFinal(), 30)
                    + Utilidades.establecerCaracteres("" + c.getTerminal(), 3) + "\n";
            datos.add(dt);
            System.out.println("linea gergada:"+dt);
        }
        publicarEvento(ADMINISTRAR_CAJAS, datos);
    }

    public void buscarProducto(String descripcion) throws InvalidException {
        publicarEvento(PuntoDeVenta.BUSCAR_PRODUCTO, CatalogosManager.buscarRegistro(descripcion, CatalogosManager.PRODUCTO));
    }

    public void buscarPersonal(String descripcion) throws InvalidException {
        publicarEvento(PuntoDeVenta.BUSCAR_PERSONAL, CatalogosManager.buscarRegistro(descripcion, CatalogosManager.PERSONAL));
    }

    public void buscarProveedor(String descripcion) throws InvalidException {
        /*switch (propiedad) {
            case PROVEEDOR: {
                publicarEvento(PuntoDeVenta.BUSCAR_PROVEEDOR,CatalogosManager.buscarRegistro(descripcion, CatalogosManager.PROVEEDOR));
                break;
            }
            case COMPRA: {*/
                publicarEvento(PuntoDeVenta.BUSCAR_PROVEEDOR,CatalogosManager.buscarRegistro(descripcion, CatalogosManager.PROVEEDOR));
                /*break;
            }
        }*/
    }

}

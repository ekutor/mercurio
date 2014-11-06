package vista;

import utilidades.InvalidException;
import control.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kymera Systems SAS
 */
public class FachadaInterfaz {

    private static FachadaInterfaz INSTANCIA;
    public final int PRIMERO = 0;
    public final int SIGUIENTE = 10;
    public final int ANTERIOR = 20;
    public final int ULTIMO = 99;
    public static final int INSERTAR = 1;
    public static final int MODIFICAR = 2;
    public static final int ELIMINAR = 3;
    public static final int ADMINISTRADOR = 1;
    public static final int SUPERVISOR = 3;
    public static final int CAJERO = 2;
    public static final int TECNICO = 4;
    public PuntoDeVenta ptoVenta;
    public RegistrosGenerales rgenerales;

    private FachadaInterfaz() {
        ptoVenta = PuntoDeVenta.getInstancia();
        rgenerales = new RegistrosGenerales();
    }

    public static FachadaInterfaz getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new FachadaInterfaz();
        }
        return INSTANCIA;
    }

    public PuntoDeVenta getPtoVenta() {
        return ptoVenta;
    }

    public void iniciarCaja() {
        if (PuntoDeVenta.usuarioActual != null) {
            ptoVenta.iniciarCaja(PuntoDeVenta.usuarioActual.getUsuario());
        }
    }

    public void establecerBaseCaja(double valor) {
        PuntoDeVenta.caja.asignarSaldoBase(valor);
    }

    public void habilitarItemBaseInicial(boolean estado) {
        ptoVenta.setSaldoAsignado(estado);
    }

    public boolean baseIniciada() {
        return PuntoDeVenta.caja.estadoBaseInicial();
    }

    public String getUsuarioActual() {
        return PuntoDeVenta.usuarioActual.getEmpleado();
    }

    public int getPermisosUsuario() {
        return PuntoDeVenta.usuarioActual.getPermisos();
    }

    public boolean validarCajero(String usuario, String contrasena) {
        ptoVenta.validarUsuario(usuario, contrasena);

        if (PuntoDeVenta.usuarioActual == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarUsuario(String usuario, String contrasena) {
        return ptoVenta.validarUsuarioInicial(usuario, contrasena);
    }

    public ControladorVenta nuevaVenta() {
        return PuntoDeVenta.caja.nuevaVenta();
    }

    public void introducirArticulo(int propiedad,String id, int cant) {
        PuntoDeVenta.caja.agregarLinea(propiedad, id, cant);
    }

    public void modificarCantidad(int propiedad,int numlin, int cant) {
        PuntoDeVenta.caja.modificarLinea(propiedad, numlin, cant);
    }

    public void setNumFactura() {
        PuntoDeVenta.caja.asignarFactura();
    }

    public void terminarVenta() {
        PuntoDeVenta.caja.terminarVenta();
    }

    public void deducirCambio(double paga) {
        PuntoDeVenta.caja.deducirCambio(paga);
    }

    public void eliminarFila(int propiedad,int fila) {
        PuntoDeVenta.caja.eliminarLinea(propiedad,fila);
    }

    public void establecerTotal(int propiedad) {
        PuntoDeVenta.caja.establecerTotal(propiedad);
    }

    public void buscarProducto(String descripcion) throws InvalidException {
        ptoVenta.buscarProducto(descripcion);
    }

    public void buscarProveedor(String id) throws InvalidException {
        ptoVenta.buscarProveedor(id);
    }
    
    public void buscarDatos(int propiedad,String desde, String hasta) {
        PuntoDeVenta.caja.buscarDatos(propiedad,desde, hasta);
    }

    public void usuarios(Object datos, int tipo) {
        ptoVenta.administrarUsuarios(datos, tipo);
    }

    public void clientes(Object datos, int tipo) {
        rgenerales.administrarClientes(datos, tipo);
    }

    public void personal(Object datos, int tipo) {
        rgenerales.administrarPersonal(datos, tipo);
    }

    public void producto(Object datos, int tipo) {
        rgenerales.administrarProducto(datos, tipo);
    }

    public void proveedor(Object datos, int tipo) {
        rgenerales.administrarProveedor(datos, tipo);
    }

    public void descuentos(Object datos, int tipo) {
        rgenerales.administrarDescuentos(datos, tipo);
    }

    public void descuentosxCateg(Object datos, int tipo) {
        rgenerales.administrarDescxCateg(datos, tipo);
    }

    public List getDescuentosDia() throws InvalidException {
        return rgenerales.getDescuentosDia();
    }

    public Map getSupervisores() {

        return CatalogosManager.getSupervisores();
    }

    public Map getEmpleados() {
        return CatalogosManager.getEmpleados();
    }
    public Map getEmpleadosActivos() {
        return CatalogosManager.getEmpleadosActivos();
    }

    public Map getClientes() {
        return CatalogosManager.getClientes();
    }

    public Map getProveedores() {
        return CatalogosManager.getProveedores();
    }

    public Map getUnidadMedida() {
        return CatalogosManager.getUnidadMedida();
    }

    public Map getCiudad(int dpto) {
        return CatalogosManager.getCiudad(dpto);
    }

    public String getCiudad(String idCiudad) {
        return CatalogosManager.getCiudad(idCiudad);
    }

    public Map getDpto() {
        return CatalogosManager.getDepartamentos();
    }

    public Map getCargos() {
        return CatalogosManager.getCargos();
    }

    public Map getCategoria() {
        return CatalogosManager.getCategoria();
    }

    public Map getProductos() {
        return CatalogosManager.getProductos();
    }

    public void cargarCategoria() {
        rgenerales.cargarCategoria();
    }

    public void cargarUsuario(int pos) {
        ptoVenta.cargarUsuario(pos);
    }

    public void cargarPersonal(int pos) {
        try{
        rgenerales.cargarPersonal(pos);
        }catch(InvalidException ex){

        }
    }

    public void cargarProveedor(int pos) {
        try {
            rgenerales.cargarProveedores(pos);
        } catch (InvalidException ex) {
        }
    }

    public void cargarCliente(int pos) {
        try {
            rgenerales.cargarCliente(pos);
        } catch (InvalidException ex) {
        }

    }

    public void cargarProductos(int pos) {
        try {
            rgenerales.cargarProductos(pos);
        } catch (InvalidException ex) {
        }
    }

    public int obtenerPosProducto(String nom) {
        return rgenerales.obtenerPosProducto(nom);
    }

    public ControladorCompra nuevaCompra() {
        return PuntoDeVenta.caja.nuevaCompra();
    }

    public void setNumOrden() {
        PuntoDeVenta.caja.asignarOrden();
    }

    public void terminarCompra() {
        PuntoDeVenta.caja.terminarCompra();
    }

    public void pagoATerceros(double monto, String tipoTercero, String factura, String observaciones, String nombre, String tipo, String supervisor, String moneda) {
        PuntoDeVenta.caja.agregarMovimiento(monto, tipoTercero, factura, observaciones, nombre, tipo, supervisor, moneda);
    }

    public void realizarCierre(Map saldos) {
        ptoVenta.realizarCierre(saldos);
    }

    public void mostrarUltCierre() {
        ptoVenta.mostrarUltimoCierre();
    }

    public void introducirProveedor(String valor) {
        PuntoDeVenta.caja.introducirProveedor(valor);
    }

    public void buscarCliente(String id) throws InvalidException {
        PuntoDeVenta.caja.buscarCliente(id);
    }

    public void introducirCliente(String valor) {
        PuntoDeVenta.caja.introducirCliente(valor);
    }

    public void stockMinimo(int cant) {
        rgenerales.stockMinimo(cant);
    }

    public void fechaVencimiento(String fecha) {
        rgenerales.fechaVencimiento(fecha);
    }

    public boolean validarCierre() {
        return ptoVenta.validarUltimoCierreCaja();
    }

    public void establecerImpuesto(int propiedad) {
        PuntoDeVenta.caja.establecerImpuesto(propiedad);
    }

    public void establecerNoFactProv(String valor) {
        PuntoDeVenta.caja.establecerNoFactProv(valor);
    }

    public void establecerEstado(String valor) {
        PuntoDeVenta.caja.establecerEstado(valor);
    }

    public void establecerFechaEntrega(String valor) {
        PuntoDeVenta.caja.establecerFechaEntrega(valor);
    }

    public void establecerFechaPedido(String valor) {
        PuntoDeVenta.caja.establecerFechaPedido(valor);
    }

    public void buscarComprasXEstado(String estado) {
        PuntoDeVenta.caja.buscarComprasXEstado(estado);
    }

    public void cargarCompra(String id) {
        PuntoDeVenta.caja.cargarCompra(id);
    }

    public void modificarCompra(String estado) {
        PuntoDeVenta.caja.modificarCompra(estado);
    }

    public Object buscarProductoXID(String id) {
        return PuntoDeVenta.caja.buscarProductoXID(id);
    }

    public void categoria(Object datos, int tipo) {
        rgenerales.administrarCategorias(datos, tipo);
    }

    public void actualizarTablaCategoria() {
        rgenerales.actualizarTablaCategoria();
    }

    public void actualizarTablaCargo() {
        rgenerales.actualizarTablaCargo();
    }

    public void cargos(Object datos, int tipo) {
        rgenerales.administrarCargos(datos, tipo);
    }

    public void cargarCargos() {
        rgenerales.cargarCargos();
    }

    public boolean validarCliente(String cliente) {
        return PuntoDeVenta.caja.validarCliente(cliente);
    }

    public void actualizarDatosAdminCajas() {
        ptoVenta.cargarDatosCajas();
    }

    public void buscarPersonal(String descripcion) throws InvalidException {
        ptoVenta.buscarPersonal(descripcion);
    }

    public void buscar(String id, int tipo) {
        switch (tipo) {
            case CatalogosManager.PERSONAL: {
                rgenerales.busquedas(id, CatalogosManager.PERSONAL);
                break;
            }
            case CatalogosManager.PROVEEDOR: {
                rgenerales.busquedas(id, CatalogosManager.PROVEEDOR);
                break;
            }
            case CatalogosManager.CLIENTE: {
                rgenerales.busquedas(id, CatalogosManager.CLIENTE);
            }

        }
    }

    public void unidadMedida(Object datos, int tipo) {
        rgenerales.administrarUnidades(datos, tipo);
    }

    public void marca(Object datos, int tipo) {
        rgenerales.administrarMarca(datos, tipo);
    }

    public void ubicacion(Object datos, int tipo) {
        rgenerales.administrarUbicacion(datos, tipo);
    }

  

    public Map getMarcas() {
        return CatalogosManager.getMarcas();
    }

    public Map getUbicacion() {
        return CatalogosManager.getUbicacion();
    }

    public void buscarCompras(String id) throws InvalidException {
        PuntoDeVenta.caja.buscarCompras(id);
    }

    public void eliminarTodasFilas(int propiedad) {
        PuntoDeVenta.caja.eliminarTodasLineas(propiedad);
    }

    public void actualizarTablaMarca() {
        rgenerales.actualizarTablaMarca();
    }

    public void actualizarTablaUnidad() {
        rgenerales.actualizarTablaUnidad();
    }
      public void actualizarTablaUbicacion() {
        rgenerales.actualizarTablaUbicacion();
    }

    public void cargarUnidades() {
        rgenerales.cargarUnidades();
    }

    public void cargarMarcas() {
        rgenerales.cargarMarcas();
    }

    public void cargarUbicaciones() {
        rgenerales.cargarUbicaciones();
    }

    public Map getCliente() {
        return CatalogosManager.getClientes();
    }

}

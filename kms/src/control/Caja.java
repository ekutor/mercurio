package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import modelo.*;
import persistenciaFWK.ManejadorArchivos;
import persistenciaFWK.adaptadores.IAdaptador;
import utilidades.InvalidException;
import utilidades.Utilidades;
import vista.MenuVista;

/**
 *
 * @author Kymera Systems SAS
 */
public class Caja {

    private ControladorVenta venta;
    private ControladorCompra compra;
    public static int numeroTickete, numeroOrden;
    private CatalogosManager ctlMana;
    private HistorialVentas historialVentas;
    private HistorialCompras historialCompras;
    private HistorialCaja caja;
    private boolean baseCargada, factInicialNOCargada;
    private IAdaptador movimientos;
    public double saldo;
    private static persistenciaFWK.ManejadorArchivos adm;
    private final String ARCHIVO = "config/etpi.cfg";
    public static final int VENTA = 1;
    public static final int COMPRA = 2;

    public Caja(String cajeroID) {
        movimientos = FactoriaServicios.getInstancia().getAdaptadorDeDatos(HistorialCaja.class);

        numeroTickete = this.ultimoTicket();
        numeroTickete++;
        Compra c = (Compra) FactoriaServicios.getInstancia().getAdaptadorDeDatos(Compra.class).getRegistro("-1");
        //para la primera compra
        if (c != null) {
            numeroOrden = Integer.parseInt(c.oid);
        }
        numeroOrden++;
        HistorialCaja hc = (HistorialCaja) movimientos.getRegistro("-1");
        //para la primera vez que ingresa a la BD
        int numeroCaja = 0;
        if (hc != null) {
            numeroCaja = Integer.parseInt(hc.oid);
        }
        numeroCaja++;
        factInicialNOCargada = true;
        caja = new HistorialCaja();
        caja.setId(String.valueOf(numeroCaja));
        caja.setCajero(cajeroID);
        caja.setFechaApertura(Utilidades.getFechaActual());
        caja.setHoraApertura(Utilidades.getHoraActual());
        caja.setTerminal(vista.MenuVista.tpv);
        this.asignarSaldoBase(0);

        movimientos.putObject(caja, IAdaptador.INSERTAR);

        historialCompras = new HistorialCompras();
        historialVentas = new HistorialVentas();
        ctlMana = CatalogosManager.getInstancia();

    }

    public Caja(HistorialCaja cajaAnterior) {
        movimientos = FactoriaServicios.getInstancia().getAdaptadorDeDatos(HistorialCaja.class);

        IAdaptador iv = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modelo.Venta.class);
        modelo.Venta v = (modelo.Venta) iv.getRegistro("-1");

        numeroTickete = this.ultimoTicket();
        numeroTickete++;
        Compra c = (Compra) FactoriaServicios.getInstancia().getAdaptadorDeDatos(Compra.class).getRegistro("-1");
        //para la primera compra
        if (c != null) {
            numeroOrden = Integer.parseInt(c.oid);
        }
        numeroOrden++;

        caja = cajaAnterior;
        if (caja.getFacFinal().equals("0")) {
            this.factInicialNOCargada = true;
        }
        if (caja.getSaldoBase() > 0) {
            baseCargada = true;
        }
        /*
        String[] parametros = {caja.getFechaApertura(), Utilidades.getFechaActual(), caja.getCajero()};
        
        Map m = iv.getRegistros(parametros);

        if (m != null) {
            Iterator itera = m.values().iterator();
            while (itera.hasNext()) {
                modelo.Venta vt = (modelo.Venta) itera.next();
                this.baseGrabale += vt.baseGrabable;
                this.iva += vt.iva;
            }
            numVentas = m.size();
        }
         */
        saldo += caja.getSaldoFinal();
        PuntoDeVenta.getInstancia().setSaldoAsignado(baseCargada);

        historialCompras = new HistorialCompras();
        historialVentas = new HistorialVentas();
        ctlMana = CatalogosManager.getInstancia();
    }

    public void asignarSaldoBase(double valor) {
        caja.setSaldoBase(valor);
        if (valor > 0) {
            baseCargada = true;
            caja.setSaldoBase(valor);
            saldo += valor;
            movimientos.putObject(caja, IAdaptador.MODIFICAR);

        } else {
            baseCargada = false;

        }
        PuntoDeVenta.getInstancia().setSaldoAsignado(baseCargada);
    }

    public boolean estadoBaseInicial() {
        return baseCargada;
    }

    public ControladorVenta nuevaVenta() {
        venta = new ControladorVenta();
        MenuVista.esVenta = true;
        return venta;
    }

    public ControladorCompra nuevaCompra() {
        compra = new ControladorCompra();
        MenuVista.esVenta = false;
        return compra;
    }

    public void asignarFactura() {
        venta.setOID(Utilidades.asignarCeros(numeroTickete));
        if (venta.estaFinalizada()) {
            numeroTickete++;
        }
    }

    public void asignarOrden() {
        compra.setOID(Utilidades.asignarCeros(numeroOrden));
        if (compra.estaFinalizada()) {
            numeroOrden++;
        }
    }

    public void agregarLinea(int propiedad, String id, int cant) {
        Producto pr = (Producto) CatalogosManager.getRegistro(id, CatalogosManager.PRODUCTO);
        if (pr != null) {
            switch (propiedad) {
                case VENTA: {
                    venta.agregarLineaDeVenta(pr, cant, (Double) CatalogosManager.getRegistro(id, CatalogosManager.DESCUENTO));
                    break;
                }
                case COMPRA: {
                    if (pr != null) {
                        compra.agregarLineaDeCompra(pr, cant, (Double) CatalogosManager.getRegistro(id, CatalogosManager.DESCUENTO));
                    }
                    break;
                }
            }
        } else {
            venta.publicarMensajeError(PuntoDeVenta.ERROR_NO_DATOS);
        }
    }

    public void modificarLinea(int propiedad, int linea, int cant) {
        switch (propiedad) {
            case VENTA: {
                venta.modificarLineaDeVenta(linea, cant);
                break;
            }
            case COMPRA: {
                compra.modificarLineaDeCompra(linea, cant);
                break;
            }
        }
    }

    public void terminarVenta() {
        for (LineaVenta lve : venta.lineasDeVenta) {
            if(lve.pr.getValidaStock().equalsIgnoreCase("SI")){
                actualizarStock(lve.pr.getId(), lve.getCantidad(), true);
            }
        }
        venta.datosVenta.setHora(Utilidades.getHoraActual());
        venta.finalizarVenta();
        historialVentas.ingresarVenta(venta.datosVenta.oid, venta.datosVenta);
        venta.cargarHistorial(historialVentas.traerDatos());
        saldo += venta.getTotal();
        if (this.factInicialNOCargada) {
            caja.setFacInicial(Utilidades.asignarCeros(numeroTickete));
            factInicialNOCargada = false;
        }
        caja.setSaldoFinal(saldo);
        caja.setFacFinal(venta.datosVenta.oid);
        
        caja.addABaseGravable(venta.datosVenta.baseGrabable);
        caja.addAIva(venta.datosVenta.iva);
        
              
        movimientos.putObject(caja, IAdaptador.MODIFICAR);
        caja.addVenta();
        this.guardarTicket(numeroTickete);
        MenuVista.esVenta = false;
        numeroTickete++;
        venta = null;
    }

    /**
     * Metodo que termina la Compra, actualiza el stock de los productos
     */
    public void terminarCompra() {
        /*for (LineaCompra lco : compra.lineasDeCompra) {
        actualizarStock(lco.pr.getId(), lco.getCantidad(), false);
        }*/
        compra.finalizarCompra();
        historialCompras.ingresarCompra(compra.datosCompra.oid, compra.datosCompra);
        compra.cargarHistorial(historialCompras.traerDatos());
        numeroOrden++;
        compra = null;
    }

    /**
     * Metodo que llama al metodo establecerCambio de la clase venta pasandole
     * un double como parametro
     * @param paga
     */
    public void deducirCambio(double paga) {
        if (MenuVista.esVenta) {
            venta.establecerCambio(paga);
        } else {
            compra.establecerCambio(paga);
        }

    }

    public void eliminarLinea(int propiedad, int fila) {
        switch (propiedad) {
            case VENTA: {
                venta.eliminarLineaDeVenta(fila);
                break;
            }
            case COMPRA: {
                compra.eliminarLineaDeCompra(fila);
                break;
            }
        }
    }

    /**
     * Metodo vacio que llama al metodo setTotal de la clase Venta para establecer
     * el total
     * @param propiedad
     */
    public void establecerTotal(int propiedad) {
        switch (propiedad) {
            case VENTA: {
                venta.setTotal();
                break;
            }
            case COMPRA: {
                compra.setTotal();
                break;
            }
        }
    }

    public void buscarCliente(String descripcion) throws InvalidException {
        venta.publicarCliente(CatalogosManager.buscarRegistro(descripcion, CatalogosManager.CLIENTE));
    }

    public void buscarDatos(int propiedad, String desde, String hasta) {
        switch (propiedad) {
            case VENTA: {
                historialVentas.setVentasEnCache(desde, hasta);
                venta.cargarHistorial(historialVentas.traerDatos());
                break;
            }
            case COMPRA: {
                historialCompras.setComprasEnCache(desde, hasta);
                compra.cargarHistorial(historialCompras.traerDatos());
                break;
            }
        }
    }

    public void actualizarStock(String idProducto, int cant, boolean esVenta) {
        ctlMana.actualizarStock(idProducto, cant, esVenta);
    }

    public double getDescuentos(String id) {
        return (Double) CatalogosManager.getRegistro(id, CatalogosManager.DESCUENTO);
    }

    public void introducirProveedor(String valor) {
        compra.establecerProveedor(valor);
    }

    public void introducirCliente(String valor) {
        CatalogosManager.idCliente = valor;
        venta.establecerCliente(valor);
    }

    public void agregarMovimiento(double monto, String tercero, String factura, String observaciones, String pagadoA, String tipo, String supervisor, String moneda) {
        if (saldo >= monto) {
            MovimientosCaja mc = new MovimientosCaja("0", tipo, moneda, observaciones, caja.getId(), monto, pagadoA, tercero, factura, supervisor);
            movimientos.putObject(mc, IAdaptador.INSERTAR);
            saldo -= monto;
            caja.setSaldoFinal(saldo);
            movimientos.putObject(caja, IAdaptador.MODIFICAR);
            PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.LANZAR_MENSAJE, "Movimiento Ingresado");
        } else {
            PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.LANZAR_MENSAJE, "No hay Dinero Suficiente para realizar esta Transaccion");
        }
    }

    public void realizarCierreCaja() {
        caja.setEstado("CERRADA");
        caja.setSaldoFinal(saldo);
        saldo = 0;
        caja.setFechaCierre(Utilidades.getFechaActual());
        caja.setHoraCierre(Utilidades.getHoraActual());

        movimientos.putObject(caja, IAdaptador.MODIFICAR);
    }

    public HistorialCaja getHistorial() {
        return caja;
    }

    public String getIdentificador() {
        return caja.oid;
    }

    public void establecerImpuesto(int propiedad) {
        switch (propiedad) {
            case VENTA: {
                venta.publicarImpuesto();
                break;
            }
            case COMPRA: {
                compra.publicarImpuesto();
                break;
            }
        }
    }

    public void establecerNoFactProv(String valor) {
        compra.establecerNoFactProv(valor);
    }

    public void establecerEstado(String valor) {
        compra.establecerEstado(valor);
    }

    public void establecerFechaEntrega(String valor) {
        compra.establecerFechaEntrega(valor);
    }

    public void establecerFechaPedido(String valor) {
        compra.establecerFechaPedido(valor);
    }

    public void buscarComprasXEstado(String estado) {
        this.historialCompras.setComprasEnCacheXEstado(estado);
        compra.cargarHistorial(historialCompras.buscarComprasEstado(estado));
    }

    public void cargarCompra(String id) {
        String[] idComp = new String[1];
        Map dat = null;
        idComp[0] = id;
        if(historialCompras.comprasEnCache.isEmpty()){
            dat = historialCompras.cargarComprasEnCache(Compra.class);
        }else{
            dat = historialCompras.comprasEnCache;
        }
        Compra datos = (Compra) dat.get(id);
        historialCompras.setLineasComprasEnCache(idComp);
        List lineas = historialCompras.getLineaCompra(id);
        compra.publicarDatosCompra(datos, lineas);
    }

    public void modificarCompra(String estado) {
        if (!estado.equals("Anulado")) {
            for (LineaCompra lco : compra.lineasDeCompra) {
                actualizarStock(lco.pr.getId(), lco.getCantidad(), false);
            }
        }
        compra.finalizarCompra();
        historialCompras.modificarCompra(compra.datosCompra.oid, compra.datosCompra);
        compra.cargarHistorial(historialCompras.traerDatos());

        compra = null;
    }

    public Object buscarProductoXID(String id) {
        return CatalogosManager.getRegistro(id, CatalogosManager.PRODUCTO);
    }

    public boolean validarCliente(String cliente) {
        return ctlMana.validarCliente(cliente, CatalogosManager.CLIENTE);
    }

    public void guardarTicket(int ultimoTicket) {
        try {
            if (adm == null) {
                adm = new persistenciaFWK.ManejadorArchivos(ARCHIVO);
            }
            adm.guardarDatoEncriptado(persistenciaFWK.ManejadorArchivos.UTV, String.valueOf(ultimoTicket));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int ultimoTicket() {
        int ut = 0;
        try {
            if (adm == null) {
                adm = new persistenciaFWK.ManejadorArchivos(ARCHIVO);
            }
            ut = Integer.parseInt(adm.cargarDatoDesencriptado(ManejadorArchivos.UTV));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ut;
    }

    public void buscarCompras(String descripcion) throws InvalidException {
        compra.publicarCompras(CatalogosManager.buscarRegistro(descripcion, CatalogosManager.COMPRA));
    }

    public void eliminarTodasLineas(int propiedad) {
        switch (propiedad) {
            case VENTA: {
                //venta.eliminarLineaDeVenta(fila);
                break;
            }
            case COMPRA: {
                compra.eliminarTodasLineasDeCompra();
                break;
            }
        }
    }

    public double getBase(){
        return caja.getBaseGravable();
    }
    public double getIva(){
        return caja.getIva();
    }
    public double getTotalCaja(){
        return caja.getSaldoFinal();
    }
    public int getCantVentas(){
        return caja.getNumVentas();
    }
}

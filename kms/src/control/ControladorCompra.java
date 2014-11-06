package control;

import java.util.*;
import modelo.Compra;
import modelo.Producto;
import modelo.Usuario;
import utilidades.Utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
public class ControladorCompra {
    private Map<Integer,Double> ivas;
    private boolean compraFinalizada = false;

    public modelo.Compra datosCompra;
    public List<LineaCompra> lineasDeCompra = new ArrayList();

    public ControladorCompra() {
        datosCompra = new modelo.Compra();
        ivas = new HashMap();
    }

    public void agregarLineaDeCompra(Producto pr, int cant,double porcDesc) {
        LineaCompra lc = new LineaCompra(pr, cant,datosCompra.oid);

        boolean encontrado = false;
        for (LineaCompra lco : lineasDeCompra) {
            if (lco.pr.getId().equals(pr.getId())) {
                if (cant <= 1) {
                    lco.addCantidad();
                } else {
                    lco.setCantidad(lco.getCantidad() + cant);
                }
                ArrayList modLinea = new ArrayList();
                modLinea.add(lineasDeCompra.indexOf(lco));
                modLinea.add(lco.getCantidad());
                modLinea.add(lco.getSubtotal());
                PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ESTABLECER_CANT_COMPRA, modLinea);
                agregarImpuesto(pr.getIva(), lco.getValorBaseG()+lco.getValorIva());
                establecerTotales();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) { 
            lineasDeCompra.add(lc);
            PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.NUEVO_PRO_COMPRA, lc.toArray());
            agregarImpuesto(pr.getIva(), lc.getValorBaseG()+lc.getValorIva());
            establecerTotales();
        }
    }
    public void modificarLineaDeCompra(int linea, int cant) {
        LineaCompra lc = lineasDeCompra.get(linea);
        lc.setCantidad(cant);
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.MODIFICAR_CANT_COMPRA, lc.toArray());
        agregarImpuesto(lc.pr.getIva(), lc.getValorBaseG()+lc.getValorIva());
        establecerTotales();
    }

    public void eliminarLineaDeCompra(int linea) {
        try{
            lineasDeCompra.remove(linea);
            PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ELIMINAR_LINEA_COMPRA, linea);
            establecerTotales();
        }catch(IndexOutOfBoundsException iobe){
          
        }
    }
    private void agregarImpuesto(int iva, double valor){
        if(ivas.containsKey(iva)){
            valor += ivas.get(iva);
        }
        ivas.put(iva, valor);
    }

    public boolean estaFinalizada() {
        return this.compraFinalizada;
    }

    public void finalizarCompra() {
        this.datosCompra.setLineasDeCompra(lineasDeCompra);
        compraFinalizada = true;
    }

    public void setTotal() {
        double total = 0;
        for (LineaCompra lc : lineasDeCompra) {
            total += lc.getSubtotal();
        }
        datosCompra.total = total;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.TOTAL_COMPRA, total);
    }
    public void setSubTotal() {
        double subTotal = 0;
        for (LineaCompra lc : lineasDeCompra) {
            subTotal += lc.getSubtotal();
        }
        datosCompra.subTotal = subTotal;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.SUBTOTAL_COMPRA, subTotal);
    }
    public void setBaseGrabable(){
        double baseGrabable = 0;
        for (LineaCompra lc : lineasDeCompra) {
            baseGrabable += lc.getValorBaseG();
        }
        datosCompra.baseGrabable = baseGrabable;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.BASE_G_COMPRA,  baseGrabable);
    }
    public void setIVA(){
        double iva = 0;
        for (LineaCompra lc : lineasDeCompra) {
            iva += lc.getValorIva();
        }
        datosCompra.iva = iva;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.IVA_COMPRA,  iva);
    }
    /**
     * Se encarga de Asigar los totales de la Venta
     */
    public void establecerTotales(){
        setSubTotal();
        setTotal();
        setBaseGrabable();
        setIVA();
    }
    public void setOID(String id) {
        this.datosCompra.setOID(id);
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.NUM_ORDEN, id);
    }

    public List<LineaCompra> getLineasDeCompra() {
        return lineasDeCompra;
    }

    public String getFechaPedido() {
        Date date = new Date();
        String fechaPedido = Utilidades.datetoString(date);
        return fechaPedido;
    }

    public String getUsuarioActual() {
        String usuario = ((Usuario) PuntoDeVenta.usuarioActual).getEmpleado();
        datosCompra.usuario = usuario;
        return usuario;
    }

    public void setFechaEntrega(String fechaEntrega) {
        datosCompra.fechaEntrega = fechaEntrega;
    }
    public void setFechaPedido(String fechaPedido) {
        datosCompra.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return datosCompra.total;
    }

    public void setTotal(double tota) {
        datosCompra.total = tota;
    }

    public String getEst() {
        return datosCompra.est;
    }

    public void setEst(String est) {
        datosCompra.est = est;
    }
    
    public void cargarHistorial(List datos){
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.CARGAR_TABLA_COMPRA,datos);
    }

    public void publicarProducto(List pro) {
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.BUSCAR_PRODUCTO,pro);
    }
    
    public void establecerProveedor(String valor) {
        datosCompra.provID = valor;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ESTABLECER_PROVEEDOR,valor);
    }

    public void publicarImpuesto() {
        ivas.clear();
        for(LineaCompra lc: lineasDeCompra){
            agregarImpuesto(lc.pr.getIva(), lc.getSubtotal());
        }
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.IMPUESTOS_COMPRA, ivas);
    }

    public void establecerNoFactProv(String valor) {
        datosCompra.factProveedor = valor;
    }

    public void establecerEstado(String valor) {
        datosCompra.est = valor;
    }

    public void establecerFechaEntrega(String valor) {
        datosCompra.fechaEntrega = valor;
    }

    public void establecerFechaPedido(String valor) {
        datosCompra.fechaPedido = valor;
    }

    public void publicarDatosCompra(Compra datos, List lineas) {
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.DATOS_COMPRA, datos.toArray());
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.DATOS_LINEACOMPRA, lineas);
    }
    public void establecerCambio(double paga) {
        datosCompra.pagoCon = paga;
        double cambio =0;
        if(datosCompra.pagoCon != 0){
            cambio = datosCompra.pagoCon - datosCompra.total;
        }
        else{
            cambio = 0;
        }
        datosCompra.cambio = cambio;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.CAMBIO_COMPRA, cambio);
    }

    public void publicarCompras(List datos) {
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.BUSCAR_COMPRA, datos);
    }

    public void eliminarTodasLineasDeCompra() {
        try{
            lineasDeCompra = new ArrayList();
            //PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ELIMINAR_TODAS_LINEAS_COMPRA);
            establecerTotales();
        }catch(IndexOutOfBoundsException iobe){

        }
    }


}

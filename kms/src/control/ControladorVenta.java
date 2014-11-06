package control;

import java.util.*;
import modelo.Producto;


/**
 *
 * @author Kymera Systems SAS
 */
public class ControladorVenta{

    private Map<Integer,Double> ivas;
    private boolean ventaFinalizada = false;
  

    public modelo.Venta datosVenta;
    public List<LineaVenta> lineasDeVenta = new ArrayList();

    public ControladorVenta() {
        datosVenta = new modelo.Venta();
        ivas = new HashMap();
    }

    public void agregarLineaDeVenta(Producto pr, int cant,double porcDesc) {
        LineaVenta lv = new LineaVenta(pr, cant);
        lv.setOID(datosVenta.oid);
        lv.aplicarDescuento(porcDesc);
        boolean encontrado = false;
        for (LineaVenta lve : lineasDeVenta) {
            if (lve.pr.getId().equals(pr.getId())) {
                if (cant <= 1) {
                    lve.addCantidad();
                } else {
                    lve.setCantidad(lve.getCantidad() + cant);
                }
                ArrayList modLinea = new ArrayList();
                modLinea.add(lineasDeVenta.indexOf(lve));
                modLinea.add(lve.getCantidad());
                modLinea.add(lve.getDescuento());
                modLinea.add(lve.getSubtotal());
                PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ESTABLECER_CANTIDAD, modLinea);
                agregarImpuesto(pr.getIva(), lve.getValorBaseG()+lve.getValorIva());
                establecerTotales();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) { 
            lineasDeVenta.add(lv);
            PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.NUEVO_PRODUCTO, lv.toArray());
            agregarImpuesto(pr.getIva(), lv.getValorBaseG()+lv.getValorIva());
            establecerTotales();
        }
    }
    public void modificarLineaDeVenta(int linea, int cant) {     
        LineaVenta lv = lineasDeVenta.get(linea);
        lv.setCantidad(cant);
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.MODIFICAR_CANTIDAD, lv.toArray());
        agregarImpuesto(lv.pr.getIva(), lv.getValorBaseG()+lv.getValorIva());
        establecerTotales();
    }

    private void agregarImpuesto(int iva, double valor){
        if(ivas.containsKey(iva)){
            valor += ivas.get(iva);
        }
        ivas.put(iva, valor);
    }
    public void eliminarLineaDeVenta(int linea) {
        try{
            lineasDeVenta.remove(linea);
            PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ELIMINAR_LINEA, linea);
            establecerTotales();
        }catch(IndexOutOfBoundsException iobe){
          
        }
    }

    public boolean estaFinalizada() {
        return this.ventaFinalizada;
    }

    public void finalizarVenta() {
        this.datosVenta.setLineasDeVenta(lineasDeVenta);
        ventaFinalizada = true;
    }
    public void setDescuentoTotal(){
        double descTotal = 0;
        for(LineaVenta lv: lineasDeVenta){
            descTotal += lv.getDescuento();
        }
        datosVenta.descTotal = descTotal;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.DESC_VENTA,descTotal);
    }

    public void setTotal() {
        double total = 0;
        for(LineaVenta lv: lineasDeVenta){
            total += lv.getSubtotal();
        }
        total -= datosVenta.descTotal;
        datosVenta.total = total;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.TOTAL_VENTA, total);
    }
    public void setSubTotalSinDesc() {
        double subTotal = 0;
        for (LineaVenta lv : lineasDeVenta) {
            subTotal += lv.getSubtotal();
        }
        datosVenta.subTotal = subTotal;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.SUBTOTAL_VENTA, subTotal);
    }
    public void setBaseGrabable(){
        double baseGrabable = 0;
        for (LineaVenta lv : lineasDeVenta) {
            baseGrabable += lv.getValorBaseG();
        }
        datosVenta.baseGrabable = baseGrabable;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.BASE_GRABABLE,  baseGrabable);
    }
    public void setIVA(){
        double iva = 0;
        for (LineaVenta lv : lineasDeVenta) {
            iva += lv.getValorIva();
        }
        datosVenta.iva = iva;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.IVA_VENTA,  iva);
    }
    /**
     * Se encarga de Asigar los totales de la Venta
     */
    
    public void establecerTotales(){
        setSubTotalSinDesc();
        setDescuentoTotal();
        setTotal();
        setBaseGrabable();
        setIVA();
    }

    public void establecerCambio(double paga) {
        datosVenta.pagoCon = paga;
        double cambio =0;
        if(datosVenta.pagoCon != 0){
            cambio = datosVenta.pagoCon - datosVenta.total;
        }
        else{
            cambio = 0;
        }
        datosVenta.cambio = cambio;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.CAMBIO_VENTA, cambio);
    }


   public void setOID(String id) {
        this.datosVenta.setOID(id);
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.NUM_TICKETE, id);
    }

    public double getTotal() {
        return datosVenta.total;
    }

    public void setTotal(double tota) {
        datosVenta.total = tota;
    }
    
    public void cargarHistorial(List datos){
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.CARGAR_TABLA,datos);
    }

   

    public void publicarCliente(List cli) {
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.BUSCAR_CLIENTE,cli);
    }
    public void establecerCliente(String valor) {
        datosVenta.cliente = valor;
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ESTABLECER_CLIENTE,valor);
    }

    public void publicarImpuesto() {
        ivas.clear();
        for(LineaVenta lv: lineasDeVenta){
            agregarImpuesto(lv.pr.getIva(), lv.getSubtotal()-lv.getDescuento());
        }
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.IMPUESTOS, ivas);
    }
    public void publicarMensajeError(String tipo){
        PuntoDeVenta.getInstancia().publicarEvento(tipo,"No hay Productos con ese Codigo!!!");
    }

}

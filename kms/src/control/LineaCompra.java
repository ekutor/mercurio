package control;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import modelo.Producto;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;
import utilidades.Utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
public class LineaCompra extends ObjetoPersistente{
    public Producto pr;
    public double subTotal;
    private int cantidad, cantidadRecibida;
    private String numOrden;
    private NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.US);
    private ArrayList datos;

    public LineaCompra(){
        setEstadoObjeto(EstadoNuevo.getInstancia());
        pr = new Producto();
    }

    public LineaCompra(Producto pr,int cant,String numOrden){
        this();
        this.pr = pr;
        this.cantidad =cant;
        this.setNumOrden(numOrden);
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
        this.setOID(numOrden+pr.getId());
    }

    public double getSubtotal(){
        subTotal = (pr.getCosto() * cantidad);
        return  subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setCantidad(int valor){
        cantidad = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCantidadRecibida() {
        return cantidadRecibida;
    }

    public void setCantidadRecibida(int cantidadRecibida) {
        this.cantidadRecibida = cantidadRecibida;
    }
    
    public void addCantidad(){
        cantidad++;
    }
    public List toArray(){
        datos = new ArrayList();
        datos.add(cantidad);
        datos.add(pr.oid);
        datos.add(pr.getDescripcion());
        datos.add(formato.format(pr.getCosto()));
        datos.add(formato.format(getSubtotal()));
        return datos;
    }
    public List eliminar(int linea){
        return null;
    }

    public double getValorIva(){
        double subT = this.getSubtotal();
        return Utilidades.getValorIva(subT, pr.getIva());
    }

    public double getValorBaseG(){
        double subT = this.getSubtotal();
        return Utilidades.getBaseGravable(subT, pr.getIva());
    }
    
    @Override
    public void setOID(String id) {
        oid = id;
    }
    

}

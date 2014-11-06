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
public class LineaVenta extends ObjetoPersistente{
    public Producto pr;
    public double descuento;
    private int cantidad;
    private NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.US);
    private ArrayList datos;
    private double porcentajeDesc;

    public LineaVenta(){
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public LineaVenta(Producto pr,int cant){
        this();
        this.pr = pr;
        this.cantidad =cant;
    }
    public double getSubtotal(){
        return  (pr.getPrecio() * cantidad)/*- getDescuento()*/;
    }
    public void setCantidad(int valor){
        cantidad = valor;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void addCantidad(){
        cantidad++;
    }
    public List toArray(){
        datos = new ArrayList();
        datos.add(cantidad);
        datos.add(pr.getId());
        datos.add(pr.getDescripcion());
        datos.add(formato.format(pr.getPrecio()));
        datos.add(formato.format(getDescuento()));
        datos.add(formato.format(getSubtotal()));
        return datos;
    }
    public List eliminar(int linea){
        return null;
    }
    
    public void aplicarDescuento(double porcentajeDesc) {
        this.porcentajeDesc = porcentajeDesc;
        this.descuento = pr.getPrecio() * (porcentajeDesc/100);
    }

    public double getDescuento() {
        return descuento * getCantidad();
    }

    public double getValorIva(){
        double subT = this.getSubtotal() - this.getDescuento();
        return Utilidades.getValorIva(subT, pr.getIva());
    }

    public double getValorBaseG(){
        double subT = this.getSubtotal() - this.getDescuento();
        return Utilidades.getBaseGravable(subT, pr.getIva());
    }
    
    @Override
    public void setOID(String id) {
        oid = id;
    }

}

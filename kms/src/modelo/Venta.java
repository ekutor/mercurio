package modelo;

import control.LineaVenta;
import control.PuntoDeVenta;
import java.util.ArrayList;
import java.util.List;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;
import utilidades.Utilidades;

/**
 *
 * @author Hector Sanchez Garcia
 */
public class Venta extends ObjetoPersistente {

    public String usuario, cliente, fecha, hora, est;
    private int porcDescuento;
    private double desuento;

    public double total, descTotal,subTotal,baseGrabable,iva;
    public double pagoCon,cambio;

    public List<LineaVenta> lineasDeVenta;

    public Venta() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public String getUsuarioActual() {
        usuario = ((Usuario) PuntoDeVenta.usuarioActual).getEmpleado();
        return usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(int porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public double getCamb() {
        return cambio;
    }

    public void setCamb(double camb) {
        this.cambio = camb;
    }

    public double getDesuento() {
        return desuento;
    }

    public void setDesuento(double desuento) {
        this.desuento = desuento;
    }

    public double getPaga_con() {
        return pagoCon;
    }

    public void setPaga_con(double paga_con) {
        this.pagoCon = paga_con;
    }

    public String getFecha() {
        fecha = Utilidades.getFechaActual();
        return fecha;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public ArrayList toArray() {
        ArrayList al = new ArrayList();
        al.add(oid);
        al.add(getUsuarioActual());
        al.add(getHora());
        al.add(getTotal());
        return al;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double tota) {
        this.total = tota;
    }

    public List<LineaVenta> getLineasDeVenta() {
        return lineasDeVenta;
    }

    public void setLineasDeVenta(List<LineaVenta> lineasDeVenta) {
        this.lineasDeVenta = lineasDeVenta;
    }
    
    @Override
    public void setOID(String id) {
        this.oid = id;
    }

   
}

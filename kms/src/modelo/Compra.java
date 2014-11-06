package modelo;

import control.LineaCompra;
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
public class Compra extends ObjetoPersistente {

    public double total, descTotal,subTotal,baseGrabable,iva;
    public double pagoCon, cambio;

    public String usuario, provID, fechaPedido,fechaEntrega, factProveedor,est,
            timestamp;

    public List<LineaCompra> lineasDeCompra;

    public Compra() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
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

    
    public double getCambio() {
        return cambio;
    }

    public void setCambio(double camb) {
        this.cambio = camb;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public ArrayList toArray(){
        ArrayList al = new ArrayList();
        al.add(oid);
        al.add(getEst());
        al.add(getFechaPedido());
        al.add(getFechaEntrega());
        al.add(getTotal());
        al.add(this.factProveedor);
        al.add(this.provID);
        al.add(getTimestamp());
        System.out.println("TIMESTAMP = " + getTimestamp());
        return al;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double tota) {
        this.total = tota;
    }

    public List<LineaCompra> getLineasDeCompra() {
        return lineasDeCompra;
    }

    public void setLineasDeCompra(List<LineaCompra> lineasDeCompra) {
        this.lineasDeCompra = lineasDeCompra;
    }
    
    @Override
    public void setOID(String id) {
        this.oid = id;
    }
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFactProveedor(String factProveedor) {
        this.factProveedor = factProveedor;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setProveedor(String provID) {
        this.provID = provID;
    }

    public String getProvID() {
        return provID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
   
}

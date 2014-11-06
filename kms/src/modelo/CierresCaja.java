package modelo;

import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Hector Sanchez Garcia
 */
public class CierresCaja extends ObjetoPersistente{
    private String caja;
    private int moneda;
    private int cantidad;
    private double total;

    public CierresCaja(){
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public CierresCaja(String caja, int moneda, int cantidad) {
        this();
        this.caja = caja;
        this.moneda = moneda;
        this.cantidad = cantidad;
        this.oid = caja;
        this.total = moneda * cantidad;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.setOID(caja);
        this.caja = caja;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        total = moneda * cantidad;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public double getTotal() {
        return total;
    }
    

    @Override
    public void setOID(String id) {
       oid =id;
    }

}


package modelo;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class MovimientosCaja extends ObjetoPersistente  {

    String id,tipo,tipoMoneda,tipoTercero,pagadaA,
            observaciones,factura,caja,supervisor;
    double monto;
    Timestamp hora;

    public MovimientosCaja(){
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public MovimientosCaja(String id, String tipo_mov, String tipoMoneda, String observaciones, String caja, double monto,String pagadoA,String tipoTercero,String factura,String supervisor) {
        this();
        this.id = id;
        this.tipo = tipo_mov;
        this.tipoMoneda = tipoMoneda;
        this.observaciones = observaciones;
        this.caja = caja;
        this.monto = monto;
        this.pagadaA = pagadoA;
        this.tipoTercero = tipoTercero;
        this.factura = factura;
        this.supervisor = supervisor;
        this.oid = id;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.oid = id;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public String getcaja() {
        return caja;
    }

    public void setcaja(String caja) {
        this.caja = caja;
    }

    public String gettipoMoneda() {
        return tipoMoneda;
    }

    public void settipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getpagadaA() {
        return pagadaA;
    }

    public void setpagadaA(String pagadaA) {
        this.pagadaA = pagadaA;
    }

    public String getobservaciones() {
        return observaciones;
    }

    public void setobservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getfactura() {
        return factura;
    }

    public void setfactura(String factura) {
        this.factura = factura;
    }

    public double getmonto() {
        return monto;
    }

    public void setmonto(double monto) {
        this.monto = monto;
    }

    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getHora() {
        String h = hora.toString();
        return h.substring(11, 16);
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }



    public List toArray(){
        List l = new ArrayList();
        l.add(this.id);
        l.add(this.caja);
        l.add(this.tipo);
        l.add(this.monto);
        l.add(this.tipoMoneda);
        l.add(this.pagadaA);
        l.add(this.tipoTercero);
        l.add(this.factura);
        l.add(this.observaciones);
        l.add(this.supervisor);
        l.add(this.getHora());
        return l;
    }

    @Override
    public String toString(){
        return id;
    }

    @Override
    public void setOID(String id) {
        oid = id;
    }

      
}

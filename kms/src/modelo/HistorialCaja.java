package modelo;

import java.util.ArrayList;
import java.util.List;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;
import utilidades.Utilidades;

/**
 *
 * @author Kymera Systems SAS
 */

public class HistorialCaja extends ObjetoPersistente  {

    String id,cajero,fechaApertura,fechaCierre="1900-01-01",
            horaApertura,horaCierre="0:00",estado="ABIERTA",
            facInicial="0",facFinal="0";
    double saldoBase,SaldoFinal,baseGravable,iva;
    int terminal,numVentas;

    public HistorialCaja(){
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    public void addVenta(){
        this.numVentas++;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.oid = id;
    }

    public double getSaldoFinal() {
        return SaldoFinal;
    }

    public void setSaldoFinal(double SaldoFinal) {
        this.SaldoFinal = SaldoFinal;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public double getSaldoBase() {
        return saldoBase;
    }

    public void setSaldoBase(double saldoBase) {
        this.saldoBase = saldoBase;
    }

    public String getFacFinal() {
        return facFinal;
    }

    public void setFacFinal(String facFinal) {
        this.facFinal = facFinal;
    }

    public String getFacInicial() {
        return facInicial;
    }

    public void setFacInicial(String facInicial) {
        this.facInicial = facInicial;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public double getBaseGravable() {
        return baseGravable;
    }

    public void setBaseGravable(double baseGravable) {
        this.baseGravable = Utilidades.reducirDecimales(baseGravable);
    }

    public void addABaseGravable(double valor){
        this.baseGravable+=valor;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = Utilidades.reducirDecimales(iva);
    }

    public void addAIva(double monto){
       this.iva += monto;
    }

    public List toArray(){
        List l = new ArrayList();
        l.add(this.id);
        l.add(this.cajero);
        l.add(this.fechaApertura);
        l.add(this.fechaCierre);
        l.add(this.horaApertura);
        l.add(this.horaCierre);
        l.add(this.saldoBase);
        l.add(this.SaldoFinal);
        l.add(this.facInicial);
        l.add(this.facFinal);
        l.add(this.estado);
        l.add(this.terminal);
        l.add(this.baseGravable);
        l.add(this.iva);
        l.add(this.numVentas);
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

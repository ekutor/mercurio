package modelo;

import java.util.ArrayList;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

public class Descuento extends ObjetoPersistente {

    private String idProd, fecIni, fecFin, estad, horIni, horFin,idCliente;
    private double descuento;
    private int id;

    public Descuento() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
        setId(0);
    }

    public Descuento(ArrayList datos) {
        this();
        setIdProd((String) datos.get(0));
        setDescuento(Double.parseDouble(datos.get(1).toString()));
        setIdCliente((String)datos.get(2));
        setFecIni((String) datos.get(3));
        setFecFin((String) datos.get(4));
        setHorIni((String) datos.get(5));
        setHorFin((String) datos.get(6));
        setEstad((String) datos.get(7));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.oid = "" + id;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getFecFin() {
        return fecFin;
    }

    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    public String getFecIni() {
        return fecIni;
    }

    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }

    public String getHorFin() {
        return horFin;
    }

    public void setHorFin(String horFin) {
        this.horFin = horFin;
    }

    public String getHorIni() {
        return horIni;
    }

    public void setHorIni(String horIni) {
        this.horIni = horIni;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getEstad() {
        return estad;
    }

    public void setEstad(String estad) {
        this.estad = estad.toUpperCase();
    }

    public int getHoraFinal() {
        String[] hora = this.horFin.split(":");
        if (Integer.parseInt(hora[0]) == 0) {
            return 24;
        } else {
            return Integer.parseInt(hora[0]);
        }
    }

    public int getMinFinal() {
        String[] hora = this.horFin.split(":");
        return Integer.parseInt(hora[1]);
    }

    public ArrayList toArray() {
        ArrayList datos = new ArrayList();
        datos.add(idProd);
        datos.add(descuento);
        datos.add(idCliente);
        datos.add(fecIni);
        datos.add(fecFin);
        datos.add(horIni);
        datos.add(horFin);
        datos.add(estad);
        return datos;
    }

    public String toString() {
        return idProd;
    }

    @Override
    public void setOID(String id) {
        this.oid = id;
    }

    public int getDiaFinal() {
        String[] dia = this.fecFin.split("-");
        return Integer.parseInt(dia[2]);
    }

    public int getAñoFinal() {
        String[] año = this.fecFin.split("-");
        return Integer.parseInt(año[0]);
    }

    public int getMesFinal() {
        String[] mes = this.fecFin.split("-");
        return Integer.parseInt(mes[1]);
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    

}

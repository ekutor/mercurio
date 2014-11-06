/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.math.BigDecimal;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

/**
 *
 * @author JUAN
 */
public class ScriptletReport extends JRDefaultScriptlet {

    public double totalVenta;
    public double totalCajero;
    public double iva;
    public double base;
    public int numVentCaj;
    public int numVentTot;
    public int cantidadVendida;
    public double totalMesDia;
    public double totalcierres;
    public double sumadorValor;

    public ScriptletReport() {
    }

    public void valoresACero() {
        totalVenta = 0;
        totalCajero = 0;
        iva = 0;
        base = 0;
        numVentCaj = 0;
        numVentTot = 0;
        cantidadVendida = 0;
        totalMesDia = 0;
        totalcierres = 0;
        sumadorValor = 0;
    }

    public Double calcular(Double valor) throws JRScriptletException {
        totalVenta += valor;
        sumaraCajero(valor);
        numVentTot++;
        numVentCaj++;
        return valor;
    }

    public Double sumaraCajero(Double valor) throws JRScriptletException {
        totalCajero += valor;
        return valor;
    }

    public Double getTotal() throws JRScriptletException {
        double t = totalVenta;
        totalVenta = 0;
        totalCajero = 0;
        return t;
    }

    public Double getTotalCajero() throws JRScriptletException {
        Double aux = totalCajero;
        totalCajero = 0.0;
        return aux;
    }

    public Integer getNumVentCaj() {
        int aux = numVentCaj;
        numVentCaj = 0;
        return aux;
    }

    public Integer getNumVentTot() {
        int n = numVentTot;
        numVentCaj = 0;
        numVentTot = 0;
        return n;
    }

    public Double reducirDecimal(Double v) {
        return utilidades.Utilidades.reducirDecimales(v);
    }

    public Double calcularIva(Double v) {
        iva += v;
        return v;
    }

    public Double getIvaTotal() {
        Double i = iva;
        iva = 0.0;
        return i;
    }

    public Double calcularBase(Double v) {
        base += v;
        return v;
    }

    public Double getBaseTotal() {
        Double b = base;
        base = 0.0;
        return b;
    }

    public Double getTotalDiaMes(Integer cant, Double precioUnt) {
        return cant * precioUnt;
    }

    public Integer setCantidadVendida(Integer cant) {
        cantidadVendida += cant;
        return cant;
    }

    public Integer getCantidadVendida() {
        Integer cant = cantidadVendida;
        cantidadVendida = 0;
        return cant;
    }

    public Double setTotalMesDia(Double total) {
        totalMesDia += total;
        return total;
    }

    public Double getTotalMesDia() {
        Double tot = totalMesDia;
        totalMesDia = 0.0;
        return tot;
    }

    public String getMes(Integer m) {
        return utilidades.Utilidades.getMes(m);
    }

    public Double getTotalCierre(Double d) throws JRScriptletException {
        totalcierres += d;
        return d;
    }

    public Double setTotalCierres() throws JRScriptletException {
        Double t = totalcierres;
        totalcierres = 0.0;
        return t;
    }

    public Double sumarValor(Double valor) throws JRScriptletException {
        sumadorValor += valor;
        return valor;
    }

    public Double getSumadorValor() throws JRScriptletException {
        double d = sumadorValor;
        sumadorValor = 0.0;
        return d;
    }
}

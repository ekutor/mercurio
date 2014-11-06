package conversores;

import utilidades.Utilidades;
import modelo.HistorialCaja;
import modelo.MovimientosCaja;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDCaja extends ConversorBDAbstracto {

    private static final String TABLA = "HISTORIAL_CAJA";
    private Map objetosEnCache;
    private boolean esMovimiento;

    public ConversorBDCaja() {
        setTabla();
        objetosEnCache = new HashMap();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        HistorialCaja v = null;
        if (regBD.next()) {
            v = cargarCaja(regBD);
        }
        return v;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            if (!this.esMovimiento) {
                HistorialCaja ve = null;

                while (regBD.next()) {
                    ve = cargarCaja(regBD);
                    mapa.put(ve.oid, ve);
                }
            } else {
                MovimientosCaja mc = null;

                while (regBD.next()) {
                    mc = cargarMovimiento(regBD);
                    mapa.put(mc.oid, mc.toArray());
                }
                this.esMovimiento = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConversorBDProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;
    }

    @Override
    protected void setTabla() {
        nombreTabla = TABLA;
    }

    @Override
    protected String insert(ObjetoPersistente obj) {
        if (obj instanceof HistorialCaja) {
            HistorialCaja caja = (HistorialCaja) obj;
            this.objetosEnCache.put(caja.oid, caja);

            String sentencia = "INSERT INTO " + TABLA +
                    " values('" + caja.oid + "','" + caja.getCajero() + "','" + caja.getFechaApertura() +
                    "','" + caja.getFechaCierre() + "','" + caja.getHoraApertura() + "','" 
                    + caja.getHoraCierre() + "',NOW()," + caja.getSaldoBase() +
                    "," + caja.getSaldoFinal() + ",'" + caja.getFacInicial() +
                    "','" + caja.getFacFinal() + "','" + caja.getEstado() + "',"+
                    caja.getTerminal() +","+caja.getBaseGravable()+","+caja.getIva()+
                    ","+caja.getNumVentas()+")";

            return sentencia;
        } else {
            MovimientosCaja mv = (MovimientosCaja) obj;
            this.objetosEnCache.put(mv.oid, mv);
            String sentencia = "INSERT INTO HISTORIAL_MOVIMIENTOS_CAJA values('" + mv.oid + "','" + mv.getcaja() + "','" + mv.gettipo() + "'," + mv.getmonto() + ",'" + mv.gettipoMoneda() + "','" + mv.getpagadaA() + "','" + mv.getTipoTercero() + "','" + mv.getfactura() + "','" + mv.getobservaciones() + "','" + mv.getSupervisor() + "',NOW())";
            return sentencia;
        }



    }

    @Override
    protected String update(ObjetoPersistente obj) {
        if (obj instanceof HistorialCaja) {
            HistorialCaja caja = (HistorialCaja) obj;
            this.objetosEnCache.put(caja.oid, caja);
            String sentencia = "UPDATE " + TABLA +
                    " SET FECHA_CIERRE = '" + caja.getFechaCierre() +
                    "', HORA_CIERRE = '" + caja.getHoraCierre() +
                    "', SALDO_INICIAL = " + caja.getSaldoBase() +
                    ", SALDO_FINAL = " + caja.getSaldoFinal() +
                    ", FAC_INI = '" + caja.getFacInicial()+
                    "', FAC_FIN = '" + caja.getFacFinal() +
                    "',BASEGRAVABLE = "+ caja.getBaseGravable() +
                    ", IVA = "+caja.getIva() +
                    ", ESTADO = '" + caja.getEstado() +
                    "', NUM_VENTAS = " + caja.getNumVentas() +
                    " WHERE ID = '" + caja.getId() + "'";

            return sentencia;
        } else {
            return "";
        }
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        if (obj instanceof HistorialCaja) {
            HistorialCaja caja = (HistorialCaja) obj;
            this.objetosEnCache.put(caja.oid, caja);

            String sentencia = "DELETE FROM " + TABLA +
                    "' WHERE ID = '" + caja.getId() + "'";

            return sentencia;
        } else {
            return "";
        }
    }

    public HistorialCaja cargarCaja(ResultSet rgsBD) {
        HistorialCaja caja = new HistorialCaja();
        try {
            caja.setEstadoObjeto(ObjetoPersistente.LIMPIO);
            caja.setId(regBD.getString(1));
            caja.setCajero(regBD.getString(2));
            caja.setFechaApertura(Utilidades.datetoString(regBD.getDate(3)));
            caja.setFechaCierre(Utilidades.datetoString(regBD.getDate(4)));
            caja.setHoraApertura(regBD.getString(5));
            caja.setHoraCierre(regBD.getString(6));
            caja.setSaldoBase(regBD.getDouble(8));
            caja.setSaldoFinal(regBD.getDouble(9));
            caja.setFacInicial(regBD.getString(10));
            caja.setFacFinal(regBD.getString(11));
            caja.setEstado(regBD.getString(12));
            caja.setTerminal(regBD.getInt(13));
            caja.setBaseGravable(regBD.getDouble(14));
            caja.setIva(regBD.getDouble(15));
            caja.setNumVentas(regBD.getInt(16));
            return caja;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return caja;

    }

    private MovimientosCaja cargarMovimiento(ResultSet regBD) {
        MovimientosCaja caja = new MovimientosCaja();
        try {
            caja.setEstadoObjeto(ObjetoPersistente.LIMPIO);
            caja.setId(regBD.getString(1));
            caja.setcaja(regBD.getString(2));
            caja.settipo(regBD.getString(3));
            caja.setmonto(regBD.getDouble(4));
            caja.settipoMoneda(regBD.getString(5));
            caja.setpagadaA(regBD.getString(6));
            caja.setTipoTercero(regBD.getString(7));
            caja.setfactura(regBD.getString(8));
            caja.setobservaciones(regBD.getString(9));
            caja.setSupervisor(regBD.getString(10));
            caja.setHora(regBD.getTimestamp(11));
            return caja;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return caja;
    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
        String resp = "";
        if (paramBusqueda[0].equalsIgnoreCase(control.PuntoDeVenta.ADMINISTRAR_CAJAS)) {

            resp ="SELECT HISTORIAL_CAJA.ID,PERSONAL.NOMBRE AS CAJERO,FECHA_APERTURA," +
                    "FECHA_CIERRE,HORA_APTURA,HORA_CIERRE, HISTORIAL_CAJA.TIMESTAMP," +
                    "SALDO_INICIAL,SALDO_FINAL,FAC_INI,FAC_FIN,HISTORIAL_CAJA.ESTADO,"+
                    "TERMINAL,BASEGRAVABLE,IVA,NUM_VENTAS "+
                    "FROM HISTORIAL_CAJA, PERSONAL " +
                    "WHERE HISTORIAL_CAJA.ESTADO =  '"+paramBusqueda[1]+"' " +
                    "AND PERSONAL.ID = HISTORIAL_CAJA.CAJERO ORDER BY HISTORIAL_CAJA.TIMESTAMP desc";
        }  else{
            this.esMovimiento = true;
            resp = "SELECT * FROM HISTORIAL_MOVIMIENTOS_CAJA WHERE TIPO_MOV = '" +
                    paramBusqueda[0] + "' AND CAJA = '" + paramBusqueda[1] + "'";
        }
        return resp;
    }

    @Override
    protected String crearSentencia(String paramBusqueda) {
        return "SELECT * FROM " + nombreTabla + " WHERE CAJERO='"+paramBusqueda+
                "' ORDER BY TIMESTAMP DESC LIMIT 1";
    }

    @Override
    protected String cargarSentenciaSQL() {
        return "SELECT * FROM " + nombreTabla + " WHERE TERMINAL="+control.PuntoDeVenta.TPV;
    }

}

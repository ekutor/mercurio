package conversores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import modelo.CierresCaja;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;



/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDCierres extends ConversorBDAbstracto {

    private static final String TABLA = "CIERRES";


    public ConversorBDCierres() {
        setTabla();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void setTabla() {
        nombreTabla = TABLA;
    }

    @Override
    protected String insert(ObjetoPersistente obj) {

            CierresCaja caja = (CierresCaja) obj;

            String sentencia = "INSERT INTO " + TABLA +
                    " VALUES('" + caja.getCaja() + "','" + caja.getMoneda()+
                    "','" + caja.getCantidad() +"',"+caja.getTotal()+",NOW())";

            return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String crearSentencia(String paramBusqueda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CierresCaja cargarCierre(ResultSet rgsBD) {
        CierresCaja caja = new CierresCaja();
        try {
            caja.setEstadoObjeto(ObjetoPersistente.LIMPIO);
            caja.setCaja(regBD.getString(1));
            caja.setMoneda(regBD.getInt(2));
            caja.setCantidad(regBD.getInt(3));
            return caja;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return caja;

    }

}

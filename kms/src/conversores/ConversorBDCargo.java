package conversores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import modelo.Cargo;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDCargo extends ConversorBDAbstracto {

    private String TABLA = "CARGOS";

    public ConversorBDCargo() {
        setTabla();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Cargo cr = null;
        if (regBD.next()) {
            cr = new Cargo();
            cr.setEstadoObjeto(ObjetoPersistente.LIMPIO);
            cr.setId(regBD.getString(1));
            cr.setNombre(regBD.getString(2));
        }
        return cr;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            Cargo cr = null;

            while (regBD.next()) {
                cr = new Cargo();
                cr.setEstadoObjeto(ObjetoPersistente.LIMPIO);
                cr.setId(regBD.getString(1));
                cr.setNombre(regBD.getString(2));


                mapa.put(cr.getId(), cr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mapa;

    }

    @Override
    protected String insert(ObjetoPersistente obj) {
        Cargo cg = (Cargo) obj;
        String sentencia = "INSERT INTO " + nombreTabla + " values('" + cg.getId() + "','" + cg.getNombre() + "',0)";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Cargo cg = (Cargo) obj;
        String sentencia = "UPDATE " + nombreTabla + " SET NOMBRE='" + cg.getNombre() + "' WHERE ID='" + cg.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        Cargo cg = (Cargo) obj;
        String sentencia = "UPDATE " + nombreTabla + " SET ESTADOREG=1 WHERE ID='" + cg.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected void setTabla() {
        nombreTabla = this.TABLA;
    }
    @Override
    protected String cargarSentenciaSQL() {
        return "SELECT * FROM " + nombreTabla + " WHERE ESTADOREG = 0";
    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
        return null;
    }

    @Override
    protected String crearSentencia(String paramBusqueda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}

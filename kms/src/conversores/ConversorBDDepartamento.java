package conversores;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Departamento;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDDepartamento extends ConversorBDAbstracto {

    private static final String TABLA = "DEPARTAMENTO";

    public ConversorBDDepartamento() {
        setTabla();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
      Departamento depto = null;
        if (regBD.next()) {
            depto = crearDepartamento(regBD);
        }
        return depto;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
             Departamento depto = null;

            while (regBD.next()) {
                depto = crearDepartamento(regBD);
                mapa.put(depto.getId(), depto);
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
        Departamento depto = (Departamento) obj;
        String sentencia = null;
        sentencia = "INSERT INTO " + nombreTabla + " values('" + depto.getId() + "','" + depto.getNombre() + "')";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Departamento depto = (Departamento) obj;
        String sentencia = null;
        sentencia = "UPDATE " + nombreTabla + " SET NOMBRE = '" + depto.getNombre() + "' WHERE ID='" +depto.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        Departamento depto = (Departamento) obj;
        String sentencia = "DELETE FROM " + nombreTabla + " WHERE ID ='" + depto.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    private Departamento crearDepartamento(ResultSet regBD) throws SQLException {
        Departamento depto = new Departamento();
        depto.setEstadoObjeto(ObjetoPersistente.LIMPIO);
        depto.setId(regBD.getString(1));
        depto.setNombre(regBD.getString(2));
    
        return depto;
    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
        return null;
    }
    @Override
    protected String crearSentencia(String paramBusqueda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String cargarSentenciaSQL() {
        return "SELECT * FROM "+nombreTabla+" ORDER BY NOMBRE";
    }

}

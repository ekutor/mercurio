package conversores;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ciudad;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDCiudad extends ConversorBDAbstracto {

     private static final String TABLA = "CIUDAD";

    public ConversorBDCiudad() {
        setTabla();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Ciudad ciudad = null;
        if (regBD.next()) {
            ciudad = crearCiudad(regBD);
        }
        return ciudad;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            Ciudad ciudad = null;

            while (regBD.next()) {
                ciudad = crearCiudad(regBD);
                mapa.put(ciudad.getId(), ciudad);
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
        Ciudad ciudad = (Ciudad) obj;
        String sentencia = null;
        sentencia = "INSERT INTO " + nombreTabla + " values('" + ciudad.getId() + "','" + ciudad.getNombre() + "','" + ciudad.getDepartamento() + "')";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Ciudad ciudad = (Ciudad) obj;
        String sentencia = null;
        sentencia = "UPDATE " + nombreTabla + " SET NOMBRE = '" + ciudad.getNombre() + "',DEPARTAMENTO='" + ciudad.getDepartamento() + "' WHERE ID='" + ciudad.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        Ciudad ciudad = (Ciudad) obj;
        String sentencia = "DELETE FROM " + nombreTabla + " WHERE ID ='" + ciudad.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    private Ciudad crearCiudad(ResultSet regBD) throws SQLException {
        Ciudad ciudad = new Ciudad();
        ciudad.setEstadoObjeto(ObjetoPersistente.LIMPIO);
        ciudad.setId(regBD.getString(1));
        ciudad.setNombre(regBD.getString(2));
        ciudad.setDepartamento(regBD.getString(3));
        return ciudad;
    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
        return null;
    }

    @Override
    protected String crearSentencia(String paramBusqueda) {
        return "SELECT * FROM "+ TABLA + " WHERE DEPARTAMENTO = '"+paramBusqueda+"' ORDER BY NOMBRE";
    }

   
    
}

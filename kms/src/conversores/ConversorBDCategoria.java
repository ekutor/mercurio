package conversores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;
/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDCategoria extends ConversorBDAbstracto {

    private  String TABLA ="CATEGORIA";

    public ConversorBDCategoria() {
        
        setTabla();
    }


    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Categoria  ct = null;
        if (regBD.next()) {
            ct = new Categoria ();
            ct.setEstadoObjeto(ObjetoPersistente.LIMPIO);
            ct.setId(regBD.getString(1));
            ct.setNombre(regBD.getString(2));
        }
        return ct;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            Categoria  ct = null;

            while (regBD.next()) {
                ct = new Categoria ();
                ct.setEstadoObjeto(ObjetoPersistente.LIMPIO);
                ct.setId(regBD.getString(1));
                ct.setNombre(regBD.getString(2));
                

                mapa.put(ct.getId(), ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConversorBDProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;

    }


    @Override
    protected String insert(ObjetoPersistente obj) {
        Categoria ct = (Categoria)obj;
        String sentencia = "INSERT INTO " +nombreTabla +" values('"+ ct.getId()+"','"+ct.getNombre()+"',0)";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
         Categoria ct = (Categoria)obj;
        String sentencia = "UPDATE " + nombreTabla +" SET NOMBRE='"+ct.getNombre()+"' WHERE ID='"+ct.getId()+"'";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        Categoria ct = (Categoria)obj;
        String sentencia = "UPDATE " + nombreTabla + " SET ESTADOREG = 1 WHERE ID ='" + ct.getId() + "'";
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conversores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ubicacion;
import modelo.UnidadMedida;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;
/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDUbicacion extends ConversorBDAbstracto {

    private  String TABLA ="UBICACION";

    public ConversorBDUbicacion() {

        setTabla();
    }


    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Ubicacion cr = null;
        if (regBD.next()) {
            cr = new Ubicacion();
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
            Ubicacion cr = null;

            while (regBD.next()) {
                cr = new Ubicacion();
                cr.setEstadoObjeto(ObjetoPersistente.LIMPIO);
                cr.setId(regBD.getString(1));
                cr.setNombre(regBD.getString(2));


                mapa.put(cr.getId(), cr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConversorBDProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;

    }
       @Override
        protected String cargarSentenciaSQL() {
            return "SELECT * FROM " + nombreTabla + " WHERE ESTADOREG = 0";
        }



    @Override
    protected String insert(ObjetoPersistente obj) {
        Ubicacion un = (Ubicacion) obj;
        String sentencia = null;
        sentencia = "INSERT INTO " +nombreTabla+" VALUES('"+ un.getId()+"','"+un.getNombre()+"',0)";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Ubicacion ct = (Ubicacion)obj;
        String sentencia = "UPDATE " + nombreTabla +" SET NOMBRE='"+ct.getNombre()+"' WHERE ID='"+ct.getId()+"'";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
       Ubicacion ct = (Ubicacion)obj;
        String sentencia = "UPDATE " + nombreTabla + " SET ESTADOREG = 1 WHERE ID ='" + ct.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected void setTabla() {
        nombreTabla = this.TABLA;
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
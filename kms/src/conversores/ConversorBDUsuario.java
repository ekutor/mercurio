package conversores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import modelo.Usuario;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDUsuario extends ConversorBDAbstracto {

    public ConversorBDUsuario() {
        setTabla();
    }

    @Override
    protected String cargarSentenciaSQL() {
        this.soloSentenciaUsuario = true;
        return "SELECT A.ID, A.NOMBRE, A.APELLIDO, B.CONTRASENA, B.TIPO FROM PERSONAL AS A INNER JOIN USUARIO AS B ON A.ID = B.USUARIO";
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Usuario us = null;
        if (regBD.next()) {
            us = crearUsuario(regBD);
        }
        return us;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            Usuario user = null;

            while (regBD.next()) {
                user = crearUsuario(regBD);
                mapa.put(user.getUsuario(), user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();        }
        return mapa;
    }

    @Override
    protected void setTabla() {
        this.nombreTabla = "USUARIO";
    }

    @Override
    protected String insert(ObjetoPersistente obj) {
        Usuario pr = (Usuario) obj;
        String sentencia = "INSERT INTO " + nombreTabla + " values('" + pr.getUsuario() + "','" + pr.getContrasena() + "','" + pr.getPermisos() + "',NOW(),0)";
        System.out.println(sentencia);

        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Usuario pr = (Usuario) obj;
        String sentencia = null;
        sentencia = "UPDATE " + nombreTabla + " SET CONTRASENA = '" + pr.getContrasena() + "',TIPO='" + pr.getPermisos() + "',TIMESTAMP = NOW() WHERE USUARIO='" + pr.getUsuario() + "'";


        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        Usuario pr = (Usuario) obj;
        String sentencia = "DELETE FROM " + nombreTabla + " WHERE USUARIO ='" + pr.getUsuario() + "'";
 
        return sentencia;
    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
        return null;
    }

    private Usuario crearUsuario(ResultSet regBD) throws SQLException {
        Usuario us = new Usuario();
        us.setEstadoObjeto(ObjetoPersistente.LIMPIO);
        us.setUsuario(regBD.getString(1));

        String nombre = regBD.getString(2);
        String apellido = regBD.getString(3);

        us.setEmpleado(nombre + " " + apellido);
        us.setContrasena(regBD.getString(4));
        us.setPermisos(regBD.getInt(5));
        return us;
    }

    @Override
    protected String crearSentencia(String paramBusqueda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

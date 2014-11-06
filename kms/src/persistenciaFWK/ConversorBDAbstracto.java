package persistenciaFWK;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que se encargara del enlace con la conexion a a la BD
 * @author Kymera Systems SAS
 */
public abstract class ConversorBDAbstracto extends PlantillaConversorPersistencia {

    protected ResultSet regBD;
    protected Statement st;
    protected String nombreTabla;
    protected boolean agregarImagen;
    protected byte[] imagen;
    protected String TRAER_DATOS;
    protected boolean soloSentenciaUsuario;
    protected boolean tranEjecutada;

    @Override
    protected final Object getObjetoAlmacenado(String id) throws SQLException {

        regBD = getRegistroBD(id);
        return getObjetoDelRegistro(id, regBD);
    }

    public ResultSet getRegistroBD(String id) throws SQLException, java.lang.NullPointerException {
        TRAER_DATOS = cargarSentenciaSQL();
        st = ConexionBD.getInstancia().getSentencia();

        if (id.equals("-1")) {
            regBD = st.executeQuery(TRAER_DATOS + " ORDER BY TIMESTAMP DESC LIMIT 1");
        } else {
            regBD = st.executeQuery(TRAER_DATOS + " WHERE ID=" + id);
        }


        return regBD;
    }

    @Override
    public Map getRegistrosBD() throws SQLException {

        TRAER_DATOS = cargarSentenciaSQL();
        st = ConexionBD.getInstancia().getSentencia();
        regBD = st.executeQuery(TRAER_DATOS);
        return getRegistrosDeTabla(regBD);
    }

    @Override
    public Map getRegistrosxParametros(String[] paramBusqueda) throws SQLException {

        st = ConexionBD.getInstancia().getSentencia();
        String query = crearSentencia(paramBusqueda);
        regBD = st.executeQuery(query);
        return getRegistrosDeTabla(regBD);
    }

    @Override
    public Map getRegistrosxParametros(String paramBusqueda) throws SQLException {
        String query = null;
        st = ConexionBD.getInstancia().getSentencia();
        query = crearSentencia(paramBusqueda);
        if (!query.equals(null)) {
            regBD = st.executeQuery(query);
        }
        return getRegistrosDeTabla(regBD);
    }

    @Override
    protected boolean putObjetoEnAlmacenamiento(ObjetoPersistente obj, int tipo) {
        tranEjecutada = true;

        String query = null;
        switch (tipo) {
            case INSERTAR: {
                query = insert(obj);
                break;
            }
            case MODIFICAR: {
                query = update(obj);
                break;
            }
            case ELIMINAR: {
                query = delete(obj);
                break;
            }
        }
        try {
            if (agregarImagen) {
                agregarImagen = false;
                PreparedStatement ps = ConexionBD.getInstancia().getPreparedStatement(query);
                ps.setBinaryStream(1, bytetoIS(imagen));
                ps.executeUpdate();
            } else {
                st = ConexionBD.getInstancia().getSentencia();
                st.execute(query);
            }
            setOnline(true);
        } catch (SQLException ex) {
            tranEjecutada = false;
            ConexionBD.cerrarConexion();
            System.out.println("ERROR Al EJECUTAR SENTENCIA EN LA BASE DE DATOS");
            System.out.println("query " + query);

            Pattern patron = Pattern.compile("Duplicate entry");
            Matcher comparador = patron.matcher(ex.getMessage());
            if (comparador.find()) {
                obj.recuperarRegistro = true;
                putObjetoEnAlmacenamiento(obj, MODIFICAR);
                FachadaDePersistencia.recuperarRegistroEliminado(obj);
            } else {
                setOnline(false);
                ex.printStackTrace();
            }
        }
        return tranEjecutada;
    }

    protected String cargarSentenciaSQL() {
        return "SELECT * FROM " + nombreTabla;
    }

    protected InputStream bytetoIS(byte[] arrayb) {
        ByteArrayInputStream bais = new ByteArrayInputStream(arrayb);
        return bais;

    }

    protected abstract Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException;

    protected abstract Map getRegistrosDeTabla(ResultSet regBD);

    protected abstract void setTabla();

    protected abstract String insert(ObjetoPersistente obj);

    protected abstract String update(ObjetoPersistente obj);

    protected abstract String delete(ObjetoPersistente obj);

    protected abstract String crearSentencia(String[] paramBusqueda);

    protected abstract String crearSentencia(String paramBusqueda);

}

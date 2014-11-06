package persistenciaFWK;
/* Implementacion de un patron Singleton
 * para el acceso a ala BD creando una conexion unica de principio a fin */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;


/**
 *
 * @author Kymera Systems SAS
 */

public class ConexionBD {

    private static ConexionBD INSTANCE = null;
    private Connection conexion;
    private Statement sentencia;
    public static String usuario;
    public static String password;
    public static String SERVIDOR;
    public static String SID;
    public static String PUERTO;

    private ConexionBD() throws SQLException {
        if (cargarDatosServidor()) {
            conectar();
            Backups.executeBackup();
        }
    }

    public void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        conexion = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR + "/" + SID, usuario, password);
        //conexion.setAutoCommit(false);
    }

    public static boolean probarConexion(){
        try{
            ConexionBD.getInstancia().conectar();
            System.out.println("CONECTADO A LA BD");
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            System.out.println(" NO CONECTADO A LA BD");
            return false;
        }
    }

    public boolean cargarDatosServidor() {
        ManejadorArchivos archivo;
        try {
            archivo = new ManejadorArchivos();
            archivo.cargarDatosServidor();
            if (archivo.servidor != null) {
                SERVIDOR = archivo.servidor;
                SID = archivo.sid;
                usuario = archivo.usuario;
                password = archivo.passw;
                PUERTO = archivo.puerto;
                return true;
            } else {
                return false;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static synchronized ConexionBD getInstancia() throws SQLException {
        if (INSTANCE == null) {
            INSTANCE = new ConexionBD();
        }
        return INSTANCE;
    }

    public Statement getSentencia() throws SQLException {
        sentencia = conexion.createStatement();
        return sentencia;
    }

    public Statement getSentenciaRS() throws SQLException {
        sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return sentencia;
    }

    public Connection getConection() {
        return conexion;
    }

    public static void cerrarConexion() {
        INSTANCE = null;
    }

    public PreparedStatement getPreparedStatement(String query)throws SQLException {
        return conexion.prepareStatement(query);
    }


   public static void main(String[] args){
       ConexionBD.probarConexion();
   }
    
}
package persistenciaFWK;

import java.util.Properties;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Encriptacion;

/**
 *
 * @author Kymera Systems SAS
 */
public class ManejadorArchivos {

    public Properties propiedades;
    private File archivo;
    public String servidor, puerto, usuario, sid, passw;
    public static String RAZON_SOCIAL = "RA001";
    public static String NIT = "NT001";
    public static String DIRECCION = "DR001";
    public static String NOMBRE = "NM001";
    public static String CIUDAD = "CD001";
    public static String LOGO = "LG001";
    public static String BYTES_LOGO = "LG002";
    public static String CANTIDAD_ITEMS = "CTI";
    public static String CANT1="1";
    public static String CANT2="2";
    public static String TMP1="3";
    public static String TMP2="4";
    public static String ACTIVO="5";
    public static String TPV="TPVXX";
    public static String STM="STM001";
    public static String PREFIJO="PRF001";
    public static String UTV="UTV001";//ultimo ticket de venta
    public static String ITV = "ITV001";//Imprimir Tiquete Venta
    public static String UTL_LOGO="UTL_LG";
    
    public ManejadorArchivos() throws FileNotFoundException, IOException {
        archivo = new File("config/system.cfg");// ruta de la ubicacion del archivo
        propiedades = new Properties();
        propiedades.load(new FileInputStream(archivo)); //para acceder al archivo
    }

    public ManejadorArchivos(String nombreArch) throws FileNotFoundException, IOException {
        archivo = new File(nombreArch);// ruta de la ubicacion del archivo
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        propiedades = new Properties();
        propiedades.load(new FileInputStream(archivo)); // para acceder al archivo

    }

    /**
     *
     * @param servidor
     * @param puerto
     * @param usuario
     * @param passw
     * @param sid
     */
    public void guardarDatosServidor(String servidor, String puerto, String usuario, String passw, String sid) {
        propiedades.setProperty("servidor", servidor);
        propiedades.setProperty("puerto", puerto);
        byte[] usu = Encriptacion.getInstacncia().encriptarParametro(usuario);
        propiedades.setProperty("usuario", Encriptacion.getInstacncia().bytestoString(usu));
        byte[] pas = Encriptacion.getInstacncia().encriptarParametro(passw);
        propiedades.setProperty("passw", Encriptacion.getInstacncia().bytestoString(pas));
        byte[] sidb = Encriptacion.getInstacncia().encriptarParametro(sid);
        propiedades.setProperty("sid", Encriptacion.getInstacncia().bytestoString(sidb));
        try {
            propiedades.store(new FileOutputStream(archivo), "Datos del Servidor de Bases de Datos");
        } catch (IOException ex) {
            Logger.getLogger(ManejadorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarDatosServidor() {
        servidor = propiedades.getProperty("servidor");
        puerto = propiedades.getProperty("puerto");

        usuario = propiedades.getProperty("usuario");
        byte[] crypto = Encriptacion.getInstacncia().stringtoBytes(usuario);
        usuario = Encriptacion.getInstacncia().desencriptarParametro(crypto);

        passw = propiedades.getProperty("passw");
        byte[] crypto2 = Encriptacion.getInstacncia().stringtoBytes(passw);
        passw = Encriptacion.getInstacncia().desencriptarParametro(crypto2);

        sid = propiedades.getProperty("sid");
        byte[] crypto3 = Encriptacion.getInstacncia().stringtoBytes(sid);
        sid = Encriptacion.getInstacncia().desencriptarParametro(crypto3);


    }

    public void guardarDatoEncriptado(String propiedad, String dato) {
        byte[] dat = Encriptacion.getInstacncia().encriptarParametro(dato);
        propiedades.setProperty(propiedad, Encriptacion.getInstacncia().bytestoString(dat));

        try {
            propiedades.store(new FileOutputStream(archivo), "Enterprise Information");
        } catch (IOException ex) {
            Logger.getLogger(ManejadorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String cargarDatoDesencriptado(String propiedad) {
        String dato = propiedades.getProperty(propiedad);
        try{
            byte[] crypto = Encriptacion.getInstacncia().stringtoBytes(dato);
            dato = Encriptacion.getInstacncia().desencriptarParametro(crypto);
        }catch(NullPointerException npe){
            dato ="0";
        }System.out.println("datoDesencriptado "+propiedad+":"+dato);
        return dato;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*ManejadorArchivos m = new ManejadorArchivos();

        m.guardarDatosServidor("localhost", "3306", "root", "admin", "kms");

        m.cargarDatosServidor();*/
        ManejadorArchivos adm = new persistenciaFWK.ManejadorArchivos("config/etpi.cfg");
        adm.guardarDatoEncriptado(ManejadorArchivos.RAZON_SOCIAL, "MEGANET");
        adm.guardarDatoEncriptado(ManejadorArchivos.NIT, "XXX.XXX.XXX");
        adm.guardarDatoEncriptado(ManejadorArchivos.NOMBRE, "MEGANET");
        adm.guardarDatoEncriptado(ManejadorArchivos.DIRECCION, "MZ 64 CS 5 JORDAN 8 ETP");
        adm.guardarDatoEncriptado(ManejadorArchivos.LOGO, "D:/Documentos/Mis imagenes/Mega.jpg");
        adm.guardarDatoEncriptado(ManejadorArchivos.CIUDAD, "IBAGUE");
        adm.guardarDatoEncriptado(ManejadorArchivos.CANT1, "20");
        adm.guardarDatoEncriptado(ManejadorArchivos.TMP1, "Minutos");
        adm.guardarDatoEncriptado(ManejadorArchivos.CANT2, "2");
        adm.guardarDatoEncriptado(ManejadorArchivos.TMP2, "Segundos");
        adm.guardarDatoEncriptado(ManejadorArchivos.ACTIVO, "0");
        adm.guardarDatoEncriptado(ManejadorArchivos.TPV, "1");
        adm.guardarDatoEncriptado(ManejadorArchivos.STM, "10");
        adm.guardarDatoEncriptado(ManejadorArchivos.PREFIJO, "MGT001");
        adm.guardarDatoEncriptado(ManejadorArchivos.UTV, "0353");
        adm.guardarDatoEncriptado(ManejadorArchivos.ITV, "0");
         adm.guardarDatoEncriptado(ManejadorArchivos.UTL_LOGO, "0");
    }
}

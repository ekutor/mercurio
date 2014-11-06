package utilidades;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.*;

/**
 *
 * @author Kymera Systems SAS
 */
public class Encriptacion {
    private static Encriptacion INSTANCIA;

    private final String claveCodificacion = "39h21e1c3t3o8r";
    private final String salto = "mindsoft";//solo 8 bytes
    private final String algoritmoEncripLlave = "PBEWithMD5AndDES";
    private String archivo = "ke.cfg";
    private Cipher c;
    private byte[] wrappedKey;
    private SecretKey passwordKey;
    private PBEParameterSpec paramSpec;


    private Encriptacion(){

    }
    public static Encriptacion getInstacncia(){
        if(INSTANCIA == null){
           INSTANCIA  = new Encriptacion();
        }
        return INSTANCIA;
    }
    
    public byte[] encriptarParametro(String dato) {

        byte[] encryptedData = null;
        try {
            generarLlavesDeConversion();
            //se especifica el algoritmo de codifciacion de datos
            c = Cipher.getInstance(algoritmoEncripLlave);
            //se especifica que se va aencriptar y la clave de encriptacion
            c.init(Cipher.ENCRYPT_MODE,passwordKey, paramSpec);

            //se obtienen los bytes de los datos a codificar -es mejor con bytes
            byte[] input = dato.getBytes();
            //se encriptan los bytes del dato.
            encryptedData = c.doFinal(input);

        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Encriptacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Encriptacion.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
        }
        return encryptedData;
    }

    public String desencriptarParametro(byte[] datoEncriptado) {
        String deencryptedData = null;
        try {
            
            generarLlavesDeConversion();
            //establece el desencriptador con el algoritmo de encriptado
            c = Cipher.getInstance(algoritmoEncripLlave);
            //lo inicializa con los parametros y el password especificado

            c.init(Cipher.DECRYPT_MODE, passwordKey, paramSpec);
            
            //desencripta el dato
            deencryptedData = new String(c.doFinal(datoEncriptado));
        } catch (InvalidKeySpecException ex) {
            ex.printStackTrace();
        } catch (InvalidAlgorithmParameterException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
        }
        return deencryptedData;
    }


    private void guardarLlave(byte[] llave) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            File f = new File(archivo);
            fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
            
            dos.write(llave);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                dos.close();
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void cargarLlave() {
        
        FileInputStream fis = null;
        DataInputStream dis = null;
        wrappedKey = new byte[32];
        try {
            File f = new File(archivo);
            fis = new FileInputStream(f);
            dis = new DataInputStream(fis);
            dis.read(wrappedKey);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                dis.close();
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void generarLlavesDeConversion() throws NoSuchAlgorithmException, InvalidKeySpecException {
            //se convierte el salto a bytes
            byte[] salt = salto.getBytes();

            //especifica los parametros para los rellenos o salto
            paramSpec = new PBEParameterSpec(salt, 20);
            //se codifica la clave de codificacion
            PBEKeySpec keySpec = new PBEKeySpec(claveCodificacion.toCharArray());

            //se crea el secret key con la clave de codificacion especificada
            SecretKeyFactory kf = SecretKeyFactory.getInstance(algoritmoEncripLlave);
            passwordKey = kf.generateSecret(keySpec);
    }
    /**
     * convierte a string sin usar el default de getbytes
     * @param array
     * @return
     */
    public String bytestoString(byte[] array){
        
        String resp="";
        for(int i=0;i<array.length;i++){
           resp+=array[i]+"h";//agrega de un entero(byte) en un string separado por h
       }
        return resp;
    }
    public byte[] stringtoBytes(String cadena) throws NullPointerException{
        String[] datos = cadena.split("h");
        byte[] bytes = new byte[datos.length];
        for(int i=0;i<datos.length;i++){
           bytes[i] = Byte.valueOf(datos[i]);
        }
        return bytes;
    }


     public static void main(String[] args){
        Encriptacion encr = new Encriptacion();
        byte[] b=encr.encriptarParametro("admin");
        encr.guardarLlave(b);
        String cadena = encr.bytestoString(b);
        byte[] h = encr.stringtoBytes(cadena);
        encr.desencriptarParametro(h);
    }
}

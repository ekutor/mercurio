package persistenciaFWK;

import utilidades.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;

import persistenciaFWK.ConexionBD;

/**
 *
 * @author Kymera Systems SAS
 */
public class Backups implements Runnable {

    private static final String ejecutable = "backup.bat";
    private static final String archivo = "bckp.sql";
    private static final String DEST = "d:\\BACKUPS";
    private static boolean ejecutar = true;

    public static boolean executeBackup() {
        Thread hilo = new Thread(new Backups());
        hilo.start();
        return ejecutar;
    }

    public static void creaArchivo(String user, String passw, String database, String pathToFile) {
        String command = "mysqldump --user=" + user + " --password=" + passw + " --host=localhost " + database + " > \"" + pathToFile + "\\" + archivo + "\"";
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File(ejecutable)));
            pw.println("cd c:\\wamp\\bin\\mysql\\mysql5.0.45\\bin");
            pw.println(command);
            pw.println("exit");

            pw.close();
        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }
    }

    public static void main(String... args) {
        //Backups.creaArchivo("kymera", "al3jf6he7", "kms", System.getProperty("user.dir"));
        Backups.executeBackup();
        //Backups.ComprimirDatos("D:\\BACKUPS", "prueba");
    }

    public void run() {
        try {
            while (Backups.ejecutar) {
                if (Utilidades.getHoraActualInt() >= 17) {
                    Backups.creaArchivo(ConexionBD.usuario, ConexionBD.password, ConexionBD.SID, System.getProperty("user.dir"));
                    Thread.sleep(3000);
                    Process proceso = Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\" + ejecutable);
                    Thread.sleep(5000);
                    Backups.ComprimirDatos(DEST, Utilidades.getFechaActual());
                    Thread.sleep(5000);
                    Backups.ComprimirDatos("data/backups", Utilidades.getFechaActual());
                    Thread.sleep(5000);
                    eliminarArchivos();
                    Backups.ejecutar = false;
                }
            }
        } catch (InterruptedException ex) {
            Backups.ejecutar = false;
            System.out.println("error " + ex.getMessage());
        } catch (IOException ex) {
            Backups.ejecutar = false;
            System.out.println("error " + ex.getMessage());
        }
    }

    public static void ComprimirDatos(String pathToDest, String arch) {
        int BUFFER = 2048;

        try {
            BufferedInputStream original = null;
            FileOutputStream destino = new FileOutputStream(pathToDest + "\\" + arch + ".gz");
            GZIPOutputStream zos = new GZIPOutputStream(new BufferedOutputStream(destino));
            //out.setMethod(ZipOutputStream.DEFLATED);
            byte data[] = new byte[BUFFER];
            //obtenemos la lista de los archivos del directorio actual
            File f = new File(System.getProperty("user.dir") + "/" + archivo);
            String files[] = f.list();

            //for (int i = 0; i > files.length; ++i) {
            //  System.out.println("Adding: " + files[i]);

            FileInputStream fi = new FileInputStream(f);
            original = new BufferedInputStream(fi, BUFFER);

            ZipEntry entry = new ZipEntry(f.getName());
            //zos.putNextEntry(entry);

            int count;
            while ((count = original.read(data, 0, BUFFER)) != -1) {
                zos.write(data, 0, count);
            }
            original.close();
            // }
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarArchivos() {
        File f = new File(ejecutable);
        f.delete();
        f = new File(archivo);
        f.delete();
    }
}

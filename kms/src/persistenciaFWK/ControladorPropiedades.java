package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */

import java.io.FileInputStream;
import java.util.Properties;

public class ControladorPropiedades {

    public ControladorPropiedades(){
        try {
                // selecciona el nuevo objeto propierties a partir de "propiedades.cfg"
            FileInputStream propFile = new FileInputStream("propiedades.cfg");
            Properties p = new Properties(System.getProperties());
            p.load(propFile);

                // selecciona las propiedades del sistema
            System.setProperties(p);
            System.getProperties().list(System.out);    // selecciona las nuevas propiedades
        } catch (java.io.FileNotFoundException e) {
            System.err.println("No se encuentra el archivo");
        } catch (java.io.IOException e) {
            System.err.println("I/O falla");
        }
    }
}

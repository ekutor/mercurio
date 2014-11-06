package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public class InfoNoDisponibleException extends Exception{

    public InfoNoDisponibleException() {
        lanzarExcepcionUI("Informacion inexistente en la Base de Datos",null);
    }

    public InfoNoDisponibleException(Throwable cause) {
        super(cause);
        lanzarExcepcionUI("Informacion inexistente en la Base de Datos",cause);
    }

    public InfoNoDisponibleException(String message, Throwable cause) {
        super(message, cause);
        this.lanzarExcepcionUI(message, cause);
    }

    public InfoNoDisponibleException(String message) {
        super(message);
        this.lanzarExcepcionUI(message, null);
    }

    private void lanzarExcepcionUI(String mensaje, Throwable cause) {
        new vista.DialogoError(mensaje,cause);
    }


}

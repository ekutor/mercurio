package utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
public class InvalidException extends Exception{

    public InvalidException() {
        lanzarExcepcionUI("Excepcion de ivalidez",null);
    }

    public InvalidException(Throwable cause) {
        super(cause);
        lanzarExcepcionUI("Error del Sistema",cause);
    }

    public InvalidException(String message, Throwable cause) {
        super(message, cause);
        this.lanzarExcepcionUI(message, cause);
    }

    public InvalidException(String message) {
        super(message);
        this.lanzarExcepcionUI(message, null);
    }

    private void lanzarExcepcionUI(String mensaje, Throwable cause) {
        new vista.DialogoError(mensaje,cause);
    }


}

package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
class FatalException extends Exception {

    public FatalException(String message, Throwable cause) {
        super(message, cause);
    }

    public FatalException(String message) {
        super(message);
    }
    
}

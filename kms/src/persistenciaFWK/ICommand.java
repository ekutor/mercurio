package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public interface ICommand {
    public void ejecutar();
    public boolean estaEjecutado();
}

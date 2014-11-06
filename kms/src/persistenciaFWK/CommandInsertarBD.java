package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public class CommandInsertarBD extends Command {

    public CommandInsertarBD(ObjetoPersistente obj) {
        this.objeto = obj;
    }

    public void ejecutar() {
        objeto.commit();
    }

    public boolean estaEjecutado() {
        return objeto.estaEjecutado();
    }
}

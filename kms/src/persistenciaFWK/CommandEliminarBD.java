package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public class CommandEliminarBD extends Command{

    public CommandEliminarBD(ObjetoPersistente obj) {
        this.objeto = obj;
    }
    
    public void ejecutar() {
        objeto.eliminar();
    }

    public boolean estaEjecutado() {
        return objeto.estaEjecutado();
    }
}

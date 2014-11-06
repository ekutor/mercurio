package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public class CommandActualizarBD extends Command {

    public CommandActualizarBD(ObjetoPersistente obj){
        this.objeto = obj;
    }

    public void ejecutar() {
        objeto.guardar();
    }

    public boolean estaEjecutado() {
        return objeto.estaEjecutado();
    }

}

package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public class EstadoLimpio extends EstadoObjeto{
    private static EstadoLimpio INSTANCIA;

    private EstadoLimpio(){

    }

    public static synchronized EstadoLimpio getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new EstadoLimpio();
        }
        return INSTANCIA;
    }

    @Override
    public void commit(ObjetoPersistente obj) {
        obj.setEstadoObjeto(EstadoSucio.getInstancia());
    }

    @Override
    public void rollback(ObjetoPersistente obj) {}

    @Override
    public void guardar(ObjetoPersistente obj) {
        obj.setEstadoObjeto(EstadoSucio.getInstancia());
    }

    @Override
    public void eliminar(ObjetoPersistente obj) {
        obj.setEstadoObjeto(EstadoAEliminar.getInstancia());
    }

}

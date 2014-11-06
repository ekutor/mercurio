package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public class EstadoAEliminar extends EstadoObjeto {

    private static EstadoAEliminar INSTANCIA;

    private EstadoAEliminar() {
    }

    public static synchronized EstadoAEliminar getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new EstadoAEliminar();
        }
        return INSTANCIA;
    }

    @Override
    public void commit(ObjetoPersistente obj) {
        if (FachadaDePersistencia.getInstancia().eliminar(obj)) {
            obj.setEstadoObjeto(EstadoEliminado.getInstancia());
            obj.ejecutar();
        }
    }

    @Override
    public void rollback(ObjetoPersistente obj) {
        if (FachadaDePersistencia.getInstancia().recargar(obj)) {
            obj.setEstadoObjeto(EstadoLimpio.getInstancia());
            obj.ejecutar();
        }
    }

    @Override
    public void guardar(ObjetoPersistente obj) {
    }

    @Override
    public void eliminar(ObjetoPersistente obj) {
        if (FachadaDePersistencia.getInstancia().eliminar(obj)) {
            obj.setEstadoObjeto(EstadoEliminado.getInstancia());
            obj.ejecutar();
        }
    }
}

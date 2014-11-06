package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public class EstadoSucio extends EstadoObjeto {

    private static EstadoSucio INSTANCIA;

    private EstadoSucio() {
    }

    public static synchronized EstadoSucio getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new EstadoSucio();
        }
        return INSTANCIA;
    }

    @Override
    public void commit(ObjetoPersistente obj) {
        if (FachadaDePersistencia.getInstancia().actualizar(obj)) {
            obj.setEstadoObjeto(EstadoLimpio.getInstancia());
            obj.ejecutar();
        }
    }

    @Override
    public void rollback(ObjetoPersistente obj) {
        FachadaDePersistencia.getInstancia().recargar(obj);
        obj.setEstadoObjeto(EstadoLimpio.getInstancia());

    }

    @Override
    public void guardar(ObjetoPersistente obj) {
        if (FachadaDePersistencia.getInstancia().actualizar(obj)) {
            obj.setEstadoObjeto(EstadoLimpio.getInstancia());
            obj.ejecutar();
        }
    }

    @Override
    public void eliminar(ObjetoPersistente obj) {
        obj.setEstadoObjeto(EstadoAEliminar.getInstancia());
    }
}

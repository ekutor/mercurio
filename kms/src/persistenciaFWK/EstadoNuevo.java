package persistenciaFWK;

/**
 * singleton
 * @author Kymera Systems SAS
 */
public class EstadoNuevo extends EstadoObjeto {

    private static EstadoNuevo INSTANCIA;

    private EstadoNuevo() {
    }

    public static synchronized EstadoNuevo getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new EstadoNuevo();
        }
        return INSTANCIA;
    }

    @Override
    public void commit(ObjetoPersistente obj) {
        if (FachadaDePersistencia.getInstancia().insertar(obj)) {
            obj.setEstadoObjeto(EstadoLimpio.getInstancia());
            obj.ejecutar();
        }
    }

    @Override
    public void rollback(ObjetoPersistente obj) {
    }

    @Override
    public void guardar(ObjetoPersistente obj) {
        obj.setEstadoObjeto(EstadoSucio.getInstancia());
    }

    @Override
    public void eliminar(ObjetoPersistente obj) {
        obj.ejecutar();
    }
}

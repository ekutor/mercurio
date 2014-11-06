package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public class EstadoEliminado extends EstadoObjeto{
    private static EstadoEliminado INSTANCIA;

    private EstadoEliminado(){

    }

    public static synchronized EstadoEliminado getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new EstadoEliminado();
        }
        return INSTANCIA;
    }
    @Override
    public void commit(ObjetoPersistente obj) {
        Transacciones.getInstancia().eliminarTransaccion(obj);
        obj.ejecutar();
    }

    @Override
    public void rollback(ObjetoPersistente obj) {}

    @Override
    public void guardar(ObjetoPersistente obj) {
    Transacciones.getInstancia().eliminarTransaccion(obj);
     obj.ejecutar();
    }

    @Override
    public void eliminar(ObjetoPersistente obj) {
    Transacciones.getInstancia().eliminarTransaccion(obj);
     obj.ejecutar();
    }

}

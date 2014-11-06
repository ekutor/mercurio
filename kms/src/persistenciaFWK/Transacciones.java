package persistenciaFWK;



/**
 * clase para ejecutar transacciones en la BD - singleton
 * @author Kymera Systems SAS
 */
public class Transacciones {

    private static Transacciones INSTANCIA;
    private static boolean ejecutar;
    

    private Transacciones() {

    }

    public synchronized static Transacciones getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new Transacciones();
        }
        return INSTANCIA;
    }

    public void addObjetoaInsertar(ObjetoPersistente obj) {
        if (obj != null) {
            obj.noEjecutado();
            arrancarTransacciones(new CommandInsertarBD(obj));
        }
    }

    public void addObjetoaEliminar(ObjetoPersistente obj) {
        if (obj != null) {
            obj.noEjecutado();
             arrancarTransacciones(new CommandEliminarBD(obj));
        }
    }

    public void addObjetoaActualizar(ObjetoPersistente obj) {
        if (obj != null) {
             obj.noEjecutado();
             arrancarTransacciones(new CommandActualizarBD(obj));
        }
    }

    public synchronized void eliminarTransaccion(ObjetoPersistente obj) {
       // Command c = new CommandEliminarBD(obj);
        //comandos.remove(c);
    }

    public void pararTransacciones() {
        ejecutar = false;
    }

    private void arrancarTransacciones(ICommand comando) {
        Executor exe = new Executor();
        exe.execute(comando);
    }


}

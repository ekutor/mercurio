package persistenciaFWK;

/**
 * clase que permitira establecer las acciones a los objetos de la BD
 * @author Kymera Systems SAS
 */
public abstract class ObjetoPersistente implements java.io.Serializable, Comparable {

    protected EstadoObjeto estadoObj;
    private boolean ejecutado;
    public int estadoObjetoInt;
    public String oid;
    /**
     * estado Nuevo es igual a 0
     */
    public static final int NUEVO = 0;
    /**
     * estado limpio igual 1
     */
    public static final int LIMPIO = 1;
    public static final int SUCIO = 2;
    public static final int AELIMINAR = 3;
    public static final int ELIMINADO = 10;
    public static final int NULO = -1;
    public boolean recuperarRegistro;

    public ObjetoPersistente(){
        setEstadoObjeto(ObjetoPersistente.NUEVO);
    }

    public void commit() {
        estadoObj.commit(this);
    }

    public void rollback() {
        estadoObj.rollback(this);
    }

    public void guardar() {
        estadoObj.guardar(this);
    }

    public void eliminar() {
        estadoObj.eliminar(this);
    }

    public void setEstadoObjeto(EstadoObjeto estado) {
        this.estadoObj = estado;
    }

    /**
     * metodo para establecer el estado persistente del objeto
     * @param estado
     */
    public void setEstadoObjeto(int estado) {
        
        switch(estado){
            case NUEVO:{
                setEstadoObjeto(EstadoNuevo.getInstancia());
                estadoObjetoInt = estado;
                break;
            }
            case LIMPIO:{
                setEstadoObjeto(EstadoLimpio.getInstancia());
                estadoObjetoInt = estado;
                break;
            }
            case SUCIO:{
                setEstadoObjeto(EstadoSucio.getInstancia());
                estadoObjetoInt = estado;
                break;
            }
            case AELIMINAR:{
                setEstadoObjeto(EstadoAEliminar.getInstancia());
                estadoObjetoInt = estado;
                break;
            }
            case ELIMINADO:{
                setEstadoObjeto(EstadoEliminado.getInstancia());
                estadoObjetoInt = estado;
                break;
            }
            case NULO:{
                setEstadoObjeto(null);
                break;
            }
        }
    }

    public boolean estaEjecutado(){
        return this.ejecutado;
    }

    public void ejecutar(){
        this.ejecutado=true;
    }

    public void noEjecutado(){
        this.ejecutado = false;
    }
    public abstract void setOID(String id);

    public int compareTo(Object o) {
        return 1;
    }
}

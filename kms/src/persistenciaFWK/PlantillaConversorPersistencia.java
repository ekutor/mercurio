package persistenciaFWK;

import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author Kymera Systems SAS
 */
public abstract class PlantillaConversorPersistencia implements IConversor{
    //private static Map objetosEnCache; verificar no pueden tener el mismo id dos objetos de clases diferentes

    public PlantillaConversorPersistencia() {
        //objetosEnCache = new HashMap();
    }
    /**
     *metodo plantilla
     *@param Identificador del Objeto
     *@return Objeto de datos
     */
    @Override
    public final synchronized Object get(String id)  throws SQLException {
       // Object obj = objetosEnCache.get(id);
       // if(obj==null){
        Object obj = null;
            //metodo de enganche
            obj = getObjetoAlmacenado(id);
            //objetosEnCache.put(id, obj);
        
        return obj;
    }

    @Override
    public void put(String id, Object obj) {
        //objetosEnCache.put(id, obj);
    }
    
    @Override
    public Map gets()  throws SQLException {
        //objetosEnCache.putAll(getRegistrosBD());
        return getRegistrosBD();
    }
    
    @Override
    public Map gets(String[] paramBusqueda)  throws SQLException{
        return getRegistrosxParametros(paramBusqueda);
    }

    @Override
    public Map gets(String paramBusqueda) throws SQLException {
        return getRegistrosxParametros(paramBusqueda);
    }
    @Override
    public boolean putEnAlmacenamiento(Object obj, int tipo){
        return putObjetoEnAlmacenamiento((ObjetoPersistente)obj, tipo);
    }
    /**
     * Metodo para esablecer el estado del software con el servido.
     * @param estado el estado de conexion del software
     */
    protected void setOnline(boolean estado){
        FachadaDePersistencia.setOnline(estado);
    }
    
   /**
     *metodo de enganche
     *@param Identificador del Objeto
     *@return Objeto de datos
     */
    protected abstract Object getObjetoAlmacenado(String id)  throws SQLException ;
    protected abstract Map getRegistrosBD()  throws SQLException ;
    protected abstract boolean putObjetoEnAlmacenamiento(ObjetoPersistente obj, int tipo);
    protected abstract Map getRegistrosxParametros(String[] paramBusqueda) throws SQLException;
    protected abstract Map getRegistrosxParametros(String paramBusqueda) throws SQLException;
}

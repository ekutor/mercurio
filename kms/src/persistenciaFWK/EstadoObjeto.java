package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */
public abstract class EstadoObjeto implements java.io.Serializable{
   
   public abstract void commit(ObjetoPersistente obj);

   public abstract void rollback(ObjetoPersistente obj);

   public abstract void guardar(ObjetoPersistente obj);

   public abstract void eliminar(ObjetoPersistente obj);

}
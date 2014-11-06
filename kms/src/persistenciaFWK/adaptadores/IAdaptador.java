package persistenciaFWK.adaptadores;
/**
 *
 * @author Kymera Systems SAS
 */
public interface IAdaptador {
    public static final int RECARGAR = 4;
    public static final int ELIMINAR = 3;
    public static final int MODIFICAR = 2;
    public static final int INSERTAR = 1;
    /**
     * Obtiene un Registro de la base de Datos buscado por id
     * o el ultimo registrado si el id es -1
     * @param ID
     * @return Un ObjetoPersistenre de la BD
     */
    public persistenciaFWK.ObjetoPersistente getRegistro(String ID);
    /**
     * Trae todos los registros de la BD
     * @return
     */
    public java.util.Map getRegistros();
    /**Trae Todos los registros que coincidan con un parametro dado
     * Segun el conversor de Persistencia en la BD
     * @param parametro de busqueda
     * @return los registros de la BD que cumpla con el parametro dado
     */
    public java.util.Map getRegistros(String parametro);
    /**Trae Todos los registros que coincidan con uno o varios parametros dados
     * Segun el conversor de Persistencia en la BD
     * @param parametro de busqueda
     * @return los registros de la BD que cumpla con los parametros dados
     */
    public java.util.Map getRegistros(String[] parametrosBusqueda);
    public Class getClaseObjeto();
    /**
     * Almacena un Objeto Persistente en la Base de Datos.
     * @param obj el objeto a almacenar
     * @param tipo
     */
    public void putObject(persistenciaFWK.ObjetoPersistente obj,int tipo);
    
}

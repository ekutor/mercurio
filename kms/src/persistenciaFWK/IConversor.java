package persistenciaFWK;

import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author Kymera Systems SAS
 */
public interface IConversor {
    public static final int RECARGAR = 4;
    public static final int ELIMINAR = 3;
    public static final int MODIFICAR = 2;
    public static final int INSERTAR = 1;


    /**
     *
     * @param oid
     * @return
     * @throws SQLException
     */
    public Object get(String oid)  throws SQLException ;
    /**
     *
     * @param oid
     * @param obj
     */
    public void put(String oid,Object obj);
    /**
     * 
     * @return
     * @throws SQLException
     */
    public Map gets()  throws SQLException;

    /**
     * trae todos los datos segun parametros de busqueda
     * @param paramBusqueda
     * @return
     * @throws SQLException
     */
    public Map gets(String[] paramBusqueda)  throws SQLException;

    public Map gets(String paramBusqueda)  throws SQLException;

    public boolean putEnAlmacenamiento(Object obj,int tipo);
}

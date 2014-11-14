/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import java.util.Map;

/**
 *
 * @author alsarmiento
 */
public interface IAdapatdor {

    void applyQBusiness(String query, String businessObject, List<Object> entities) throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception;

    void deleteEntities(List<?> entities) throws Exception;

    void deleteEntities(List<?> entities, String businessObject) throws Exception;

    void deleteEntity(Object entidad) throws Exception;

    void deleteEntity(Object entity, String businessObject) throws Exception;

    List<?> getData(String query, Map<Object, Object> params, String businessObject) throws Exception;

    List<?> getDataGrid(String query, Map<Object, Object> params, String businessObject, int offset, int limit, String objClass) throws Exception;

    void saveEntities(List<?> entities, String businessObject) throws Exception;

    Object saveEntity(Object entity, String businessObject) throws Exception;

    void update(String query, Map<Object, Object> params) throws Exception;
    
}

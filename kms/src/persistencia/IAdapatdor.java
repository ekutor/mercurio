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

    void applyQBusiness(String query, String PU, String businessObject, List<Object> entities) throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception;

    void deleteEntities(List<?> entities, String PU, boolean sync) throws Exception;

    void deleteEntities(List<?> entities, String PU, boolean sync, String businessObject) throws Exception;

    void deleteEntity(Object entidad, String PU) throws Exception;

    void deleteEntity(Object entity, String PU, String businessObject) throws Exception;

    List<?> getData(String query, String PU, Map<Object, Object> params, String businessObject, boolean sync) throws Exception;

    List<?> getData(String query, String PU, String valueField, String displayField, Map<Object, Object> params, String businessObject) throws Exception;

    List<?> getDataGrid(String query, String PU, Map<Object, Object> params, String businessObject, int offset, int limit, String objClass) throws Exception;

    void saveEntities(List<?> entities, String PU, String businessObject, boolean sync) throws Exception;

    Object saveEntity(Object entity, String PU, String businessObject) throws Exception;

    void update(String query, String PU, Map<Object, Object> params) throws Exception;
    
}

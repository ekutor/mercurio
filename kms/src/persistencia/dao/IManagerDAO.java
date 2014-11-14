/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.dao;

import com.google.inject.persist.Transactional;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author alsarmiento
 */
public interface IManagerDAO {

    /**
     * @param entities List of entities for delete
     * @throws Exception
     */
    @Transactional(rollbackOn = {SQLException.class})
    void delete(List<? extends Object> entities) throws Exception;

    @Transactional(rollbackOn = {SQLException.class})
    void delete(Object entity) throws Exception;

    /**
     * @param query Name of Query
     * @param params of query. The key must be String or int / Integer
     * @return
     */
    @Transactional
    List<Object> executeNamedQuery(String query, Map<Object, Object> params);

    @Transactional
    List<Object> executeNamedQuery(String query, Map<Object, Object> params, int start, int limit);

    /**
     * @param query SQL Query
     * @param params of query. The key must be String or int / Integer
     * @return
     */
    @Transactional
    List<? extends Object> executeNativeQuery(String query, Map<Object, Object> params);

    @Transactional(rollbackOn = {SQLException.class})
    void executeUpdate(String query, Map<Object, Object> params);

    @SuppressWarnings(value = "unused")
    Connection getConnection() throws Exception;

    EntityManager getEm();

    /**
     * @param klass Class of entity for find
     * @param key ID of Entity
     * @return
     */
    @Transactional
    Object getEntity(Class klass, Object key);

    EntityTransaction getTransaccion();

    void refreshEntity(Object entity);

    /**
     * @param entities List of Entities for save
     * @throws Exception
     */
    @Transactional(rollbackOn = {SQLException.class})
    void save(List<? extends Object> entidades);

    @Transactional(rollbackOn = {SQLException.class})
    Object save(Object entity) throws Exception;

    @Transactional(rollbackOn = {SQLException.class})
    void saveChanges();

    @Transactional(rollbackOn = {SQLException.class})
    Object update(Object entity) throws Exception;
    
    @Transactional
    List<? extends Object> executeDinamicQuery(String query,
            Map<Object, Object> params);
    
}

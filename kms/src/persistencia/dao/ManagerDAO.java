package persistencia.dao;

import co.com.personalsoft.base.db.Config;
import com.google.inject.persist.Transactional;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.sql.DataSource;
import persistencia.constants.Constant;
import persistencia.constants.OperationType;
import persistencia.constants.QueryType;

public class ManagerDAO implements IManagerDAO {

    /**
     * Proveedor del EntityManager.
     */
    Provider<EntityManager> provider;
    private EntityManager em = null;

    @Inject
    public ManagerDAO(Provider<EntityManager> provider) {
        this.provider = provider;
    }

    @SuppressWarnings("unused")
    @Override
    public Connection getConnection() throws Exception {
        Context initialContext = new InitialContext();
        if (initialContext == null) {
            throw new Exception("No se pudo obtener el contexto de la fuente de datos");
        }
        DataSource datasource = (DataSource) initialContext
                .lookup(Config.get().getString(Constant.DATASOURCE_CONTEXT));
        if (datasource == null) {
            throw new Exception("No se pudo obtener el objeto de la fuente de datos");
        }
        return datasource.getConnection();
    }

    public Connection getConnection1() {
        if (!em.isOpen()) {
            em = provider.get();
        }
        em.getTransaction().begin();
        return em.unwrap(java.sql.Connection.class);
    }

    @Override
    public EntityTransaction getTransaccion() {
        return em.getTransaction();
    }

    @Transactional( rollbackOn = {SQLException.class})
    @Override
    public void saveChanges() {
//		if(getTransaccion().isActive()){
//			getTransaccion().commit();
//		}
    }

    /**
     * Generic method for delete, save and update entities
     *
     * @param type (SAVE, DELETE, UPDATE)
     * @param entities (List of entities)
     * @throws Exception
     */
    private void processEntities(List<? extends Object> entities, OperationType type) {
        if (em == null || !em.isOpen()) {
            em = provider.get();
        }
        if (entities != null) {
            for (Object entidad : entities) {
                switch (type) {
                    case DELETE:
                        em.remove(em.merge(entidad));
                        break;
                    case SAVE:
                        em.merge(entidad);
                    default:
                        break;
                }

            }
        }
    }

    /**
     * @param entities List of Entities for save
     * @throws Exception
     */
    @Transactional( rollbackOn = {SQLException.class})
    @Override
    public void save(List<? extends Object> entidades) {
        processEntities(entidades, OperationType.SAVE);
    }

    @Override
    @Transactional( rollbackOn = {SQLException.class})
    public Object save(Object entity) throws Exception {
        if (em == null || !em.isOpen()) {
            em = provider.get();
        }
        return em.merge(entity);
    }

    @Transactional( rollbackOn = {SQLException.class})
    @Override
    public Object update(Object entity) throws Exception {
        if (em == null || !em.isOpen()) {
            em = provider.get();
        }
        return entity = em.merge(entity);
    }

    /**
     * @param klass Class of entity for find
     * @param key ID of Entity
     * @return
     */
    @Transactional
    @Override
    public Object getEntity(Class klass, Object key) {
        if (em == null || !em.isOpen()) {
            em = provider.get();
        }
        return (Object) em.find(klass, key);
    }

    @Override
    public void refreshEntity(Object entity) {
        if (em == null || !em.isOpen()) {
            em = provider.get();
        }
        em.refresh(entity);
    }

    /**
     * @param entities List of entities for delete
     * @throws Exception
     */
    @Transactional( rollbackOn = {SQLException.class})
    @Override
    public void delete(List<? extends Object> entities) throws Exception {
        processEntities(entities, OperationType.DELETE);
    }

    @Transactional( rollbackOn = {SQLException.class})
    @Override
    public void delete(Object entity) throws Exception {
        if (em == null || !em.isOpen()) {
            em = provider.get();
        }
        em.remove(em.merge(entity));
    }

    /**
     * @param query Query executed according to type
     * @param params parameters of query
     * @param type Query type
     * @return
     */
    @Transactional
    private List<Object> executeQuery(String query, Map<Object, Object> params, QueryType type) {
        if (em == null || !em.isOpen()) {
            em = provider.get();
        }
//		try {
        Query q = null;
        switch (type) {
            case JPQL:
                q = em.createQuery(query);
                break;

            case NAMED:
//				System.out.println("NamedQuery::" + query);
                q = em.createNamedQuery(query);
                break;

            case SQL:
                q = em.createNativeQuery(query);
                break;

            default:
                break;
        }
        if (params != null) {
            Iterator<Object> iter = params.keySet().iterator();
            while (iter.hasNext()) {
                Object indice = iter.next();
                if (indice instanceof String) {
                    q.setParameter((String) indice, params.get(indice));
                } else {
                    q.setParameter((Integer) indice, params.get(indice));
                }
            }
        }
        return q.getResultList();
    }

    @Transactional
    private List<Object> executeQuery(String query, Map<Object, Object> params, QueryType type, int start, int limit) {
        if (em == null || !em.isOpen()) {
            em = provider.get();
        }
        Query q = null;
        switch (type) {
            case JPQL:
                q = em.createQuery(query);
                break;

            case NAMED:
                q = em.createNamedQuery(query);
                break;

            case SQL:
                q = em.createNativeQuery(query);
                break;

            default:
                break;
        }
        q.setFirstResult(start);
        q.setMaxResults(limit);

        if (params != null) {
            Iterator<Object> iter = params.keySet().iterator();
            while (iter.hasNext()) {
                Object indice = iter.next();
                if (indice instanceof String) {
                    q.setParameter((String) indice, params.get(indice));
                } else {
                    q.setParameter((Integer) indice, params.get(indice));
                }
            }
        }
        return q.getResultList();
    }

    /**
     * @param query Name of Query
     * @param params of query. The key must be String or int / Integer
     * @return
     */
    @Transactional
    @Override
    public List<Object> executeNamedQuery(String query, Map<Object, Object> params) {
        return executeQuery(query, params, QueryType.NAMED);
    }

    @Transactional
    @Override
    public List<Object> executeNamedQuery(String query, Map<Object, Object> params, int start, int limit) {
        return executeQuery(query, params, QueryType.NAMED, start, limit);
    }

    @Transactional( rollbackOn = {SQLException.class})
    @Override
    public void executeUpdate(String query, Map<Object, Object> params) {
        Query q = em.createNamedQuery(query);
        if (params != null) {
            Iterator<Object> iter = params.keySet().iterator();
            while (iter.hasNext()) {
                Object indice = iter.next();
                if (indice instanceof String) {
                    q.setParameter((String) indice, params.get(indice));
                } else {
                    q.setParameter((Integer) indice, params.get(indice));
                }
            }
        }
        q.executeUpdate();
    }

    /**
     * @param query SQL Query
     * @param params of query. The key must be String or int / Integer
     * @return
     */
    @Transactional
    @Override
    public List<? extends Object> executeNativeQuery(String query,
            Map<Object, Object> params) {
        return executeQuery(query, params, QueryType.SQL);
    }

    /**
     * @param query JPQL Query
     * @param params of query. The key must be String or int / Integer
     * @return
     */
    @Transactional
    @Override
    public List<? extends Object> executeDinamicQuery(String query,
            Map<Object, Object> params) {
        return executeQuery(query, params, QueryType.JPQL);
    }

    @Override
    public EntityManager getEm() {
        if (em == null || !em.isOpen()) {
            em = provider.get();
        }
        return em;
    }
}

package persistencia;

import co.com.personalsoft.base.db.utils.DBUtils;
import com.google.inject.Inject;
import com.google.inject.persist.PersistService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.RollbackException;
import org.eclipse.persistence.exceptions.DatabaseException;
import persistencia.business.BusinessObjectPersistence;
import persistencia.business.BusinessObjectPersistenceMultiple;
import persistencia.business.BusinessObjectQuery;
import persistencia.dao.IManagerDAO;
import persistencia.dao.ManagerDAO;

/**
 * adapta a las necesidades ( Bd o al local )
 *
 * @author Kymera Systems SAS
 */
public class AdaptadorBD implements IAdapatdor {

    private ManagerDAO db;

    @Inject
    public AdaptadorBD(PersistService service, ManagerDAO db) {
        this.db = db;
        service.start();
    }

    @Override
    public List<?> getData(String query, String PU, Map<Object, Object> params,
            String businessObject, boolean sync) throws Exception {
        List<?> entities = new ArrayList<Object>();
        try {
            if (query != null) {
                if (db.getEm() == null || !db.getEm().isOpen()) {
                    db.getEm();
                }
                entities = db.executeNamedQuery(query, params);
            }
            entities = (List<Object>) DBUtils.deleteNulls(entities);
            if (businessObject != null) {
                BusinessObjectQuery business = ((BusinessObjectQuery) Class.forName(businessObject).newInstance());
                business.execute(db, entities);
                if (query != null) {
                    db.saveChanges();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public List<?> getDataGrid(String query, String PU, Map<Object, Object> params,
            String businessObject, int offset, int limit, String objClass) throws Exception {
        List<Object> entities = new ArrayList<Object>();
        try {
            if (query != null) {
                entities = db.executeNamedQuery(query, params);
            }
            entities = (List<Object>) DBUtils.deleteNulls(entities);
            if (businessObject != null) {
                applyQBusiness(query, PU, businessObject, entities);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void applyQBusiness(String query, String PU, String businessObject, List<Object> entities)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception {
        if (businessObject == null) {
            return;
        }
        BusinessObjectQuery negocio = ((BusinessObjectQuery) Class.forName(businessObject).newInstance());
        negocio.execute(db, entities);
        if (query != null) {
            db.saveChanges();
        }
    }

    @Override
    public List<?> getData(String query, String PU, String valueField, String displayField,
            Map<Object, Object> params, String businessObject) throws Exception {
        List<Object> entities = new ArrayList<Object>();
        List<Object> resultados = null;
        try {
            if (query != null) {
                query = "SELECT " + valueField + "," + displayField + " " + query + " ";
                resultados = (List<Object>) db.executeNativeQuery(query, params);
            }
            DBUtils.deleteNulls(resultados);
        } catch (Exception ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void update(String query, String PU, Map<Object, Object> params) throws Exception {
        try {
            db.executeUpdate(query, params);
            db.saveChanges();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Object saveEntity(Object entity, String PU, String businessObject)
            throws Exception {
        try {
            BusinessObjectPersistence business = null;
            if (businessObject != null) {
                business = ((BusinessObjectPersistence) Class.forName(businessObject).newInstance());
                business.beforeSave(db, entity);
            }
            if(db == null){
                System.out.println("Nulo");
            }
            entity = db.save(entity);
            if (businessObject != null) {
                business.afterSave(db, entity);
            }
            db.saveChanges();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (ex instanceof RollbackException) {
                RollbackException re = (RollbackException) ex;
                DatabaseException dbe = (DatabaseException) re.getCause();
                int errorCode = dbe.getErrorCode();
                if (errorCode == 4002) {
                    Exception e = new Exception("Error::Entrada Duplicada");
                    e.getMessage();
                    throw e;
                }
            }
            throw ex;
        }
        return entity;
    }

    @Override
    public void deleteEntities(List<?> entities, String PU, boolean sync)
            throws Exception {
        try {
            db.delete(entities);
            db.saveChanges();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void saveEntities(List<?> entities, String PU, String businessObject,
            boolean sync) throws Exception {
        try {
            BusinessObjectPersistenceMultiple business = null;

            if (businessObject != null) {
                business = ((BusinessObjectPersistenceMultiple) Class.forName(businessObject).newInstance());
                business.beforeSave(db, entities);
            }
            db.save(entities);
            if (businessObject != null) {
                business.afterSave(db, entities);
            }
            db.saveChanges();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteEntity(Object entidad, String PU) throws Exception {
        try {
            db.delete(entidad);
            db.saveChanges();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEntity(Object entity, String PU, String businessObject) throws Exception {
        try {
            BusinessObjectPersistence<Object> business = null;
            if (businessObject != null) {
                business = ((BusinessObjectPersistence<Object>) Class.forName(businessObject).newInstance());
                business.beforeSave(db, entity);
            }
            db.delete(entity);
            if (businessObject != null) {
                business.afterSave(db, null);
            }
            db.saveChanges();

        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteEntities(List<?> entities, String PU, boolean sync,
            String businessObject) throws Exception {
        try {

            BusinessObjectPersistenceMultiple business = null;

            if (businessObject != null) {
                business = ((BusinessObjectPersistenceMultiple) Class.forName(businessObject).newInstance());
                business.beforeSave(db, entities);
            }
            for (Object entity : entities) {
                db.delete(entity);
            }
            if (businessObject != null) {
                business.afterSave(db, entities);
            }
            db.saveChanges();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
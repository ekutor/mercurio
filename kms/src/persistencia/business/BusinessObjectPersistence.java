package persistencia.business;

import java.io.Serializable;
import persistencia.dao.IManagerDAO;

public interface BusinessObjectPersistence<E> extends Serializable {
	
	void beforeSave(IManagerDAO db, E entity) throws Exception;

	void afterSave(IManagerDAO db, E entity)
			throws Exception;
}

package persistencia.business;

import java.io.Serializable;
import java.util.List;
import persistencia.dao.IManagerDAO;

public interface BusinessObjectPersistenceMultiple<E> extends Serializable {
	
	void beforeSave(IManagerDAO db, List<? extends E> entities)
			throws Exception;

	void afterSave(IManagerDAO db, List<? extends E> entities)
			throws Exception;
}

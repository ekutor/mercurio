package persistencia.business;

import java.io.Serializable;
import java.util.List;
import persistencia.dao.IManagerDAO;

public interface BusinessObjectQuery extends Serializable {
	
	void execute(IManagerDAO db, List<?> data) throws Exception;
}

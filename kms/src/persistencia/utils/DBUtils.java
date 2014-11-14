package co.com.personalsoft.base.db.utils;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {


	public static List<Object> deleteNulls(List<?> data) {
		List<Object> ls = new ArrayList<Object>();
		for (Object tmp : data) {
			if (tmp != null)
				ls.add(tmp);
		}
		data = ls;
		return ls;
	}
}

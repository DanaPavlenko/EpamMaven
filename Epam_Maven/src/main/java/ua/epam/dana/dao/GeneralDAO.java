package ua.epam.dana.dao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<T, ID> {

	List<T> findAll () throws SQLException;
	T find (ID id) throws SQLException;
	int create (T elem) throws SQLException;
	int update (T elem) throws SQLException;
	int delete (ID id) throws SQLException;
	
}

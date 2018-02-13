package ua.epam.dana.service;

import java.sql.SQLException;
import java.util.List;

import ua.epam.dana.dao.impl.BreedDaoImpl;
import ua.epam.dana.model.BreedEntity;

public class BreedService {
	
	public List<BreedEntity> findAll() throws SQLException{
		return new BreedDaoImpl().findAll();
	}
	
	public BreedEntity find(Integer id) throws SQLException{
		return new BreedDaoImpl().find(id);
	}
	
	public int create (BreedEntity entity) throws SQLException{
		return new BreedDaoImpl().create(entity);
	}
	
	public int update (BreedEntity entity) throws SQLException{
		return new BreedDaoImpl().update(entity);
	}
	
	public int delete (Integer id) throws SQLException{
		return new BreedDaoImpl().delete(id);
	}

}

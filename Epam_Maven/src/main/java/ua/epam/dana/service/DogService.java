package ua.epam.dana.service;

import java.sql.SQLException;
import java.util.List;

import ua.epam.dana.dao.impl.DogDaoImpl;
import ua.epam.dana.model.DogEntity;

public class DogService {
	
	public List<DogEntity> findAll() throws SQLException{
		return new DogDaoImpl().findAll();
	}
	
	public List<DogEntity> findByName(String name) throws SQLException{
		return new DogDaoImpl().findByName(name);
	}
	
	public List<DogEntity> findByAge(Integer age) throws SQLException{
		return new DogDaoImpl().findByAge(age);
	}
	
	public DogEntity find(Integer id) throws SQLException{
		return new DogDaoImpl().find(id);
	}
	
	public int insert (DogEntity entity) throws SQLException{
		return new DogDaoImpl().create(entity);
	}
	
	public int update (DogEntity entity) throws SQLException{
		return new DogDaoImpl().update(entity);
	}
	
	public int delete (Integer id) throws SQLException{
		return new DogDaoImpl().delete(id);
	}

}

package ua.epam.dana.dao;

import java.sql.SQLException;
import java.util.List;

import ua.epam.dana.model.DogEntity;

public interface DogDAO extends GeneralDAO<DogEntity, Integer>{
	
	List<DogEntity> findByName(String name) throws SQLException;
	
	List<DogEntity> findByAge(int age) throws SQLException;

}

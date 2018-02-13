package ua.epam.dana.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.epam.dana.dao.DogDAO;
import ua.epam.dana.model.BreedEntity;
import ua.epam.dana.model.DogEntity;
import ua.epam.dana.persistant.ConnectionManager;
import ua.epam.dana.transformer.Transformer;

public class DogDaoImpl implements DogDAO{
	
	private static final String FIND_ALL = "SELECT * FROM dog";
	private static final String FIND_BY_ID = "SELECT * FROM dog WHERE id = ?";
	private static final String FIND_BY_NAME = "SELECT * FROM dog WHERE name = ?";
	private static final String FIND_BY_AGE = "SELECT * FROM dog WHERE age = ?";
	private static final String CREATE = "INSERT INTO dog (name, age, breedId) VALUES (?, ?, ?)";
	private static final String UPDATE = "UPDATE dog SET name = ?, age = ?, breedId = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM dog WHERE id = ?";

	public List<DogEntity> findAll() throws SQLException {
		List<DogEntity> dogs = new ArrayList<DogEntity>();
		Connection connection = ConnectionManager.getConnection();
	    Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(FIND_ALL);
		while (rs.next()){
			dogs.add((DogEntity)new Transformer(DogEntity.class).fromResultSetToEntity(rs));
		}
		
		return dogs;
	}

	public DogEntity find(Integer id) throws SQLException {
		DogEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(FIND_BY_ID); 
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    entity=(DogEntity)new Transformer(DogEntity.class).fromResultSetToEntity(resultSet);
                    break;            
        }
        return entity;
	}
	
	public List<DogEntity> findByName(String name) throws SQLException {
		List<DogEntity> dogs = new ArrayList<DogEntity>();
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(FIND_BY_NAME);
            ps.setString(1,name);
            ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    dogs.add((DogEntity) new Transformer(DogEntity.class).fromResultSetToEntity(resultSet));
                }
        return dogs;
	}

	public List<DogEntity> findByAge(int age) throws SQLException {
		List<DogEntity> dogs = new ArrayList<DogEntity>();
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(FIND_BY_AGE);
            ps.setInt(1, age);
            ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    dogs.add((DogEntity) new Transformer(DogEntity.class).fromResultSetToEntity(resultSet));
                }
        return dogs;
	}


	public int create(DogEntity elem) throws SQLException {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement ps = connection.prepareStatement(CREATE);
		ps.setString(1, elem.getName());
		ps.setInt(2, elem.getAge());
		ps.setInt(3, elem.getBreedId());
		return ps.executeUpdate();
	}

	public int update(DogEntity elem) throws SQLException {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setString(1, elem.getName());
		ps.setInt(2, elem.getAge());
		ps.setInt(3, elem.getBreedId());
		ps.setInt(4, elem.getId());
		return ps.executeUpdate();
	}

	public int delete(Integer id) throws SQLException {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement ps = connection.prepareStatement(DELETE);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

}

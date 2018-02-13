package ua.epam.dana.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.epam.dana.dao.BreedDAO;
import ua.epam.dana.model.BreedEntity;
import ua.epam.dana.persistant.ConnectionManager;
import ua.epam.dana.transformer.Transformer;

public class BreedDaoImpl implements BreedDAO {
	
	private static final String FIND_ALL = "SELECT * FROM breed";
	private static final String FIND = "SELECT * FROM breed WHERE id = ?";
	private static final String CREATE = "INSERT INTO breed (breed) VALUES (?)";
	private static final String UPDATE = "UPDATE breed SET breed = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM breed WHERE breed = ?";

	public List<BreedEntity> findAll() throws SQLException {
		List<BreedEntity> breeds = new ArrayList<BreedEntity>();
		Connection connection = ConnectionManager.getConnection();
	    Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(FIND_ALL);
		while (rs.next()){
			breeds.add((BreedEntity)new Transformer(BreedEntity.class).fromResultSetToEntity(rs));
		}
		
		return breeds;
	}

	public BreedEntity find(Integer id) throws SQLException {
		
		 BreedEntity entity=null;
	        Connection connection = ConnectionManager.getConnection();
	        PreparedStatement ps = connection.prepareStatement(FIND); 
	            ps.setInt(1,id);
	            ResultSet resultSet = ps.executeQuery();
	                while (resultSet.next()) {
	                    entity=(BreedEntity)new Transformer(BreedEntity.class).fromResultSetToEntity(resultSet);
	                    break;            
	        }
	        return entity;
	
	}

	public int create(BreedEntity elem) throws SQLException {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement ps = connection.prepareStatement(CREATE);
		ps.setString(1, elem.getBreed());
		return ps.executeUpdate();
	}

	public int update(BreedEntity elem) throws SQLException {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setString(1, elem.getBreed());
		ps.setInt(2, elem.getId());
		return ps.executeUpdate();
	}

	public int delete(Integer id) throws SQLException {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement ps = connection.prepareStatement(DELETE);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

}

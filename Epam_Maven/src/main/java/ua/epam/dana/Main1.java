package ua.epam.dana;

import java.sql.*;
import java.util.Scanner;

public class Main1 {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/Dogs?serverTimezone=UTC&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "1488";

	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement pStatement = null;
	private static ResultSet resSet = null;

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
			statement = connection.createStatement();
			readDataFromDog();
			readDataFromBreed();
			// updateDogAgeById();
			// deleteDogById();
			// insertDog();
			// insertBreed();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// close connection ,statement and resultset
			if (resSet != null)
				try {
					resSet.close();
				} catch (SQLException e) {
				} // ignore
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}

	}

	public static void insertDog() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dog's name");
		String name = sc.next();
		System.out.println("Enter it's age");
		int age = sc.nextInt();
		System.out.println("Enter it's breed id");
		int breedId = sc.nextInt();
		pStatement = connection.prepareStatement("INSERT INTO dog (Name, Age, BreedId) VALUES (?, ?, ?);");
		pStatement.setString(1, name);
		pStatement.setInt(2, age);
		pStatement.setInt(3, breedId);
		pStatement.executeUpdate();
		sc.close();

	}

	public static void insertBreed() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter breed of dog");
		String breed = sc.next();
		pStatement = connection.prepareStatement("INSERT INTO breed (Breed) VALUES (?)");
		pStatement.setString(1, breed);
		pStatement.executeUpdate();
		sc.close();
	}

	public static void readDataFromDog() throws SQLException {
		System.out.format("\n--------------- Dog --------------------");
		System.out.format("\n----------------------------------------\n");
		System.out.format("%3s %-10s %-4s %s\n", "ID", "Name", "Age", "Breed");
		resSet = statement
				.executeQuery("SELECT d.id, d.name, d.age, b.breed FROM Dog d LEFT JOIN Breed b ON d.breedId = b.id");
		while (resSet.next()) {
			int id = resSet.getInt(1);
			String name = resSet.getString(2);
			int age = resSet.getInt(3);
			String breed = resSet.getString(4);
			System.out.format("%3s %-10s %-4s %s \n", id, name, age, breed);

		}
	}

	public static void readDataFromBreed() throws SQLException {
		System.out.format("\n--------------- Breed -------------------");
		System.out.format("\n----------------------------------------\n");
		System.out.format("%3s %s \n", "ID", "Breed");
		resSet = statement.executeQuery("SELECT * FROM breed");
		while (resSet.next()) {
			int id = resSet.getInt(1);
			String breed = resSet.getString(2);
			System.out.format("%3s %s \n", id, breed);
		}
	}

	public static void updateDogAgeById() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id of dog you would like to update");
		int id = sc.nextInt();
		System.out.println("Enter new age");
		int age = sc.nextInt();
		pStatement = connection.prepareStatement("UPDATE dog SET age = ? WHERE id = ?;");
		pStatement.setInt(1, age);
		pStatement.setInt(2, id);
		int n = pStatement.executeUpdate();
		System.out.println("Updated " + n + " rows");
		sc.close();
	}

	public static void deleteDogById() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id of dog you would like to delete");
		int id = sc.nextInt();
		pStatement = connection.prepareStatement("DELETE FROM dog WHERE id =?;");
		pStatement.setInt(1, id);
		int n = pStatement.executeUpdate();
		System.out.println("Updated " + n + " rows");
		sc.close();
	}

}

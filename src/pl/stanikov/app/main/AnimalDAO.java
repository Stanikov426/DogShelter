package pl.stanikov.app.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.stanikov.app.main.Dog;
import pl.stanikov.app.main.ConnectionProvider;

public class AnimalDAO {
	
	    private final static String CREATE = "INSERT INTO animal(id, animalType, animalName, animalRase, animalFoto, animalDate) VALUES(?, ?, ?, ?, ?, ?);";
	    private final static String READDOG = "SELECT id, animalType, animalName, animalRase, animalFoto, animalDate FROM animal WHERE id = ? AND animalType = ?;";
	    private final static String READCAT = "SELECT id, animalType, animalName, animalRase, animalFoto, animalDate FROM animal WHERE id = ? AND animalType = ?;";
	    private final static String DELETE = "DELETE FROM animal WHERE id=?;";
	    
	    public Dog readDog(int id) {
	        Connection conn = null;
	        PreparedStatement prepStmt = null;
	        ResultSet resultSet = null;
	        Dog result = null;
	        try {
	            conn = ConnectionProvider.getConnection();
	            prepStmt = conn.prepareStatement(READDOG);
	            prepStmt.setInt(1, id);
	            prepStmt.setString(2, "Dog");
	            resultSet = prepStmt.executeQuery();
	            if(resultSet.next()) {
	                result = new Dog();
	                result.setId(resultSet.getInt("id"));
	                result.setPetName(resultSet.getString("animalName"));
	                result.setPetRasa(resultSet.getString("animalRase"));
	                result.setFilePath(resultSet.getString("animalFoto"));
	                result.setPetDate(resultSet.getString("animalDate"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            releaseResources(prepStmt, resultSet, conn);
	        }
	        return result;
	    }
	 
	    public boolean createDog(Dog dog) {
	        Connection conn = null;
	        PreparedStatement prepStmt = null;
	        boolean result = false;
	        try {
	            conn = ConnectionProvider.getConnection();
	            prepStmt = conn.prepareStatement(CREATE);
	            prepStmt.setString(1, dog.getPetId());
	            prepStmt.setString(2, dog.getType());
	            prepStmt.setString(3, dog.getPetName());
	            prepStmt.setString(4, dog.getPetRasa());
	            prepStmt.setString(5, dog.getFilePath());
	            prepStmt.setString(6, dog.getPetTime());
	            int rowsAffected = prepStmt.executeUpdate();
	            if (rowsAffected > 0) {
	                result = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            releaseResources(prepStmt, null, conn);
	        }
	        return result;
	    }
	    
	    public boolean deleteDog(Dog dog) {
	        Connection conn = null;
	        PreparedStatement prepStmt = null;
	        boolean result = false;
	        try {
	            conn = ConnectionProvider.getConnection();
	            prepStmt = conn.prepareStatement(DELETE);
	            prepStmt.setString(1, dog.getPetId());
	            int rowsAffected = prepStmt.executeUpdate();
	            if (rowsAffected > 0) {
	                result = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            releaseResources(prepStmt, null, conn);
	        }
	        return result;
	    }
	    
	    public Cat readCat(int id) {
	        Connection conn = null;
	        PreparedStatement prepStmt = null;
	        ResultSet resultSet = null;
	        Cat result = null;
	        try {
	            conn = ConnectionProvider.getConnection();
	            prepStmt = conn.prepareStatement(READCAT);
	            prepStmt.setInt(1, id);
	            prepStmt.setString(2, "Cat");
	            resultSet = prepStmt.executeQuery();
	            if(resultSet.next()) {
	                result = new Cat();
	                result.setId(resultSet.getInt("id"));
	                result.setPetName(resultSet.getString("animalName"));
	                result.setPetRasa(resultSet.getString("animalRase"));
	                result.setFilePath(resultSet.getString("animalFoto"));
	                result.setPetDate(resultSet.getString("animalDate"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            releaseResources(prepStmt, resultSet, conn);
	        }
	        return result;
	    }
	    
	    public boolean createCat(Cat cat) {
	        Connection conn = null;
	        PreparedStatement prepStmt = null;
	        boolean result = false;
	        try {
	            conn = ConnectionProvider.getConnection();
	            prepStmt = conn.prepareStatement(CREATE);
	            prepStmt.setString(1, cat.getPetId());
	            prepStmt.setString(2, cat.getType());
	            prepStmt.setString(3, cat.getPetName());
	            prepStmt.setString(4, cat.getPetRasa());
	            prepStmt.setString(5, cat.getFilePath());
	            prepStmt.setString(6, cat.getPetTime());
	            int rowsAffected = prepStmt.executeUpdate();
	            if (rowsAffected > 0) {
	                result = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            releaseResources(prepStmt, null, conn);
	        }
	        return result;
	    }
	    
	    public boolean deleteCat(Cat cat) {
	        Connection conn = null;
	        PreparedStatement prepStmt = null;
	        boolean result = false;
	        try {
	            conn = ConnectionProvider.getConnection();
	            prepStmt = conn.prepareStatement(DELETE);
	            prepStmt.setString(1, cat.getPetId());
	            int rowsAffected = prepStmt.executeUpdate();
	            if (rowsAffected > 0) {
	                result = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            releaseResources(prepStmt, null, conn);
	        }
	        return result;
	    }
	    
	    private void releaseResources(PreparedStatement prepStmt, ResultSet res,
	            Connection conn) {
	        try {
	            if (prepStmt != null && !prepStmt.isClosed()) {
	                prepStmt.close();
	            }
	            if (res != null && !res.isClosed()) {
	                res.close();
	            }
	            if (conn != null && !conn.isClosed()) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	    }
}

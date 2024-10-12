package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class DaoFactory {
	    private static final String DB_URL = "jdbc:mysql://localhost:3306/rental";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "";

	    public static Connection getConnection() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to establish a database connection.");
	        }
	    }
	}

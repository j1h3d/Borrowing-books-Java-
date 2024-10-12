package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Categorie;
import beans.Utilisateur;

public class UtilisateurDAOImpl implements  UtilisateurDAO {

	@Override

    public List<Utilisateur> lister() throws DaoException {
        Connection connection = null;
        List<Utilisateur> accounts = new ArrayList<>();

        try {
            connection = DaoFactory.getConnection();
            if (connection != null) {System.out.println("connected");}
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilisateur WHERE role='client'");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                Utilisateur account = new Utilisateur();
                
                account.setId(id);
                account.setUsername(username);
                account.setPassword(password);
                account.setEmail(email);
                account.setRole(role);
                accounts.add(account);
                System.out.println("CONNNECTED");
            }
       } catch (SQLException e) {
            throw new DaoException("Error communicating with the database");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Error closing database connection");
            }
        }
        return accounts;

    }

	@Override
	public void CreateUserAccount(Utilisateur a) throws DaoException {
        Connection connection = null;

        try {
            connection = DaoFactory.getConnection();

            // Assuming you have a table named 'account' with columns: id, username, password, email, role
            String query = "INSERT INTO utilisateur (username, email, password, role) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, a.getUsername());
                statement.setString(2, a.getEmail());
                statement.setString(3, a.getPassword());
                statement.setString(4, a.getRole());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException("Error creating client account");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Error closing database connection");
            }
        }
    }

    public Utilisateur authenticate(String username, String password) throws DaoException {
        Connection connection = null;
        try {
            connection = DaoFactory.getConnection();

            // Assuming you have a table named 'account' with columns: id, username, password, email, role
            String query = "SELECT * FROM utilisateur WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // User found, check password
                    String storedPasswordHash = resultSet.getString("password");
                    
                    // TODO: Implement a proper password hashing and comparison mechanism
                    // For simplicity, this example uses plain text comparison (not recommended for production)
                    if (password.equals(storedPasswordHash)) {
                        // Passwords match, create an Account object and return
                    	Utilisateur authenticatedAccount = new Utilisateur();
                        authenticatedAccount.setId(resultSet.getInt("id"));
                        authenticatedAccount.setUsername(username);
                        authenticatedAccount.setPassword(storedPasswordHash);
                        authenticatedAccount.setEmail(resultSet.getString("email"));
                        authenticatedAccount.setRole(resultSet.getString("role"));

                        return authenticatedAccount;
                    }
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error authenticating user");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Error closing database connection");
            }
        }

        // If user is not found or passwords don't match, return null
        return null;
    }
    @Override
    public void deleteUser(int userId) throws DaoException {
        Connection connection = null;

        try {
            connection = DaoFactory.getConnection();
            if (connection != null) {
                System.out.println("Connected to the database");

                // Assuming you have a table named 'hotel' with columns: id, name, city, stars, description
                String query = "DELETE FROM Utilisateur WHERE id=?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, userId);
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error deleting Client from the database");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Error closing database connection");
            }
        }
    }

}

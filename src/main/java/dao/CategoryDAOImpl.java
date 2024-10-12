package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Categorie;

public class CategoryDAOImpl implements CategoryDAO{
	
	
	public List<Categorie> getAllCategories() throws DaoException {
        Connection connection = null;
        List<Categorie> categories = new ArrayList<>();

        try {
            connection = DaoFactory.getConnection();
            if (connection != null) {
                System.out.println("Connected to the database");
                String query = "SELECT * FROM categories";
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int categorieId = resultSet.getInt("id");
                    String category_name = resultSet.getString("category_name");
                    String description = resultSet.getString("description");
                    String cat_image = resultSet.getString("cat_image");

                    Categorie categorie = new Categorie();
                    categorie.setId(categorieId);
                    categorie.setCategory_name(category_name);
                    categorie.setDescription(description);
                    categorie.setCat_image(cat_image);

                    categories.add(categorie);
                }
                for(Categorie category: categories){
                	System.out.println("Category name: " + category.getCategory_name());
                }
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

        return categories;
    }

  @Override
    public void addCategory(Categorie categorie) throws DaoException {
        Connection connection = null;

        try {
            connection = DaoFactory.getConnection();
            if (connection != null) {
                System.out.println("Connected to the database");

                // Assuming you have a table named 'hotel' with columns: id, name, city, stars, description
                String query = "INSERT INTO categories (category_name, description, cat_image) VALUES (?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, categorie.getCategory_name());
                    statement.setString(2, categorie.getDescription());
                    statement.setString(3, categorie.getCat_image());
                    
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error adding hotel to the database");
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

    @Override
    public void updateCategory(Categorie categorie) throws DaoException  {
        Connection connection = null;

        try {
            connection = DaoFactory.getConnection();
            if (connection != null) {
                System.out.println("Connected to the database");

                String query = "UPDATE categories SET category_name=?, description=?, cat_image=? WHERE id=?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, categorie.getCategory_name());
                    statement.setString(2, categorie.getDescription());
                    statement.setString(3, categorie.getCat_image());

                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error updating category in the database");
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

    @Override
    public void deleteCategory(int categorieId) throws DaoException {
        Connection connection = null;

        try {
            connection = DaoFactory.getConnection();
            if (connection != null) {
                System.out.println("Connected to the database");

                // Assuming you have a table named 'hotel' with columns: id, name, city, stars, description
                String query = "DELETE FROM hotel WHERE id=?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, categorieId);

                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error deleting category from the database");
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

	@Override
	public Categorie getCategoryById(int hotelId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}

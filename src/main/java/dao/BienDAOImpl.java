package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Bien;
public class BienDAOImpl implements BienDAO{
	
	
public List<Bien> rechercheBien(String motCle) throws ClassNotFoundException {
		
		
		Connection connection = null;
        List<Bien> searchs = new ArrayList<>();
        
		try {
				connection = DaoFactory.getConnection();
			String searchQuery = "Select * from bien where title like ?";
			PreparedStatement search = connection.prepareStatement(searchQuery);
			
			
			search.setString(1,"%"+motCle+"%");
			
			ResultSet result = search.executeQuery();
			
			
			
			while (result.next()) {
				int id =result.getInt("id");
				int category_id =result.getInt("category_id");
				String title = result.getString("title");
				String type = result.getString("type");
				String description = result.getString("description");
				String price_per_day = result.getString("price_per_day");
				String disponibility = result.getString("disponibility");
				String image = result.getString("image");
				Bien b = new Bien(id,category_id,type,title,description,price_per_day,disponibility,image);
				searchs.add(b);
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return searchs;
		
	} 

	public List<Bien> getBiensByCategory(int categoryId)throws DaoException{
		
		Connection connection = null;
        List<Bien> biens = new ArrayList<>();
        try {
        	connection = DaoFactory.getConnection();
        	PreparedStatement statement = connection.prepareStatement("SELECT * FROM bien WHERE category_id= ?");
        	statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int category_id = resultSet.getInt("category_id");
                String title = resultSet.getString("title");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                String price_per_day = resultSet.getString("price_per_day");
                String disponibilty = resultSet.getString("disponibility");
                String image = resultSet.getString("image");

                Bien book = new Bien(id, category_id, type, title, description, price_per_day, disponibilty, image);
                biens.add(book);
                System.out.println("CONNNECTED");
            }
            for(Bien bien: biens){
            	System.out.println("Book title: " + bien.getTitle());
            }

       } catch (SQLException e) {

            throw new DaoException("Error communicating with the database");

        }

		return biens;
	}
	
	
}

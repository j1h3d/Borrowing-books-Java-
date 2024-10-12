package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Reservation;

public class ReservationsDAOImpl implements ReservationsDAO{

	public void addReservation(Reservation r)throws DaoException{
		Connection connection = null;
		try {
			connection=DaoFactory.getConnection();
			String query="INSERT INTO reservation (id_user, id_bien, start_rent, end_rent, state, total_amount) VALUES (?,?,?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, r.getId_user());
                statement.setString(2, r.getId_bien());
                statement.setString(3, r.getStart_rent());
                statement.setString(4, r.getEnd_rent());
                statement.setString(5, r.getState());
                statement.setString(6, r.getTotal_amount());

                statement.executeUpdate();
                
            }
			String query1="UPDATE bien SET disponibility = 'Unavailable' WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query1)) {
                statement.setString(1, r.getId_bien());
                statement.executeUpdate();
            }
			
		}catch (SQLException e) {

            throw new DaoException("Error communicating with the database");
		}
		
	}
	public List<Reservation> listReservation() throws DaoException {
        Connection connection = null;
        List<Reservation> reservations = new ArrayList<>();

        try {
            connection = DaoFactory.getConnection();
            if (connection != null) {System.out.println("connected");}
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM reservation");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String id_user = resultSet.getString("id_user");
                String id_bien = resultSet.getString("id_bien");
                String start_rent = resultSet.getString("start_rent");
                String end_rent = resultSet.getString("end_rent");
                String state = resultSet.getString("state");
                String total_amount = resultSet.getString("total_amount");
                Reservation reservation = new Reservation();
                
                reservation.setId(id);
                reservation.setId_user(id_user);
                reservation.setId_bien(id_bien);
                reservation.setStart_rent(start_rent);
                reservation.setEnd_rent(end_rent);
                reservation.setState(state);
                reservation.setTotal_amount(total_amount);
                reservations.add(reservation);
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
        return reservations;

    }
	public void deleteReservation(int reservationId) throws DaoException {
	    Connection connection = null;
	    try {
	        connection = DaoFactory.getConnection();

	        String deleteQuery = "DELETE FROM reservation WHERE id = ?";
	        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
	            deleteStatement.setInt(1, reservationId);
	            deleteStatement.executeUpdate();
	        }
	    } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void updateBien(int bienId) throws DaoException {
	    Connection connection = null;
	    try {
	        connection = DaoFactory.getConnection();
	        String updateQuery = "UPDATE bien SET disponibility = 'Available' WHERE id = ?";
	        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
	            updateStatement.setInt(1, bienId);
	            updateStatement.executeUpdate();
	            System.out.println("ssssssHHHH");
	        }
	    } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}

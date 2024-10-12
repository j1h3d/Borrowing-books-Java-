package dao;

import java.util.List;

import beans.Reservation;

public interface ReservationsDAO {

	public void addReservation(Reservation r)throws DaoException;
	public List<Reservation> listReservation() throws DaoException;
	public void deleteReservation(int reservationId) throws DaoException;
	
}

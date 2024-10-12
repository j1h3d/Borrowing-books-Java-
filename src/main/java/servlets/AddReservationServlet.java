package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.Reservation;
import dao.DaoException;
import dao.ReservationsDAOImpl;

/**
 * Servlet implementation class AddReservationServlet
 * @param <Date>
 */
@WebServlet("/addReservation")
public class AddReservationServlet<Date> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_user = request.getParameter("id_user");
		String id_bien = request.getParameter("id_bien");
		String start_rent = request.getParameter("start_rent");
		String end_rent = request.getParameter("end_rent");
		String total_amount = request.getParameter("price_per_day");
		
		ReservationsDAOImpl ReservationDAO = new ReservationsDAOImpl();
		Reservation r = new Reservation();
		
		r.setId_user(id_user);
		r.setId_bien(id_bien);
		r.setStart_rent(start_rent);
		r.setEnd_rent(end_rent);
		r.setState("In process");
		r.setTotal_amount(total_amount);
		
		try {
			ReservationDAO.addReservation(r);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("home");
        dispatcher.forward(request, response);
		
	}

}

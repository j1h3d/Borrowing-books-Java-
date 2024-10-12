package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DaoException;
import dao.ReservationsDAOImpl;

/**
 * Servlet implementation class DeleteOrder
 */

public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String reservationIdStr = request.getParameter("reservationId");
        int reservationId = Integer.parseInt(reservationIdStr);
        String bienIdStr = request.getParameter("bienId");
        int bienId = Integer.parseInt(bienIdStr);
        System.out.println(bienId);
        
        ReservationsDAOImpl reservationDAO = new ReservationsDAOImpl();
        try {
            reservationDAO.deleteReservation(reservationId);
            reservationDAO.updateBien(bienId);
            response.sendRedirect("CartServlet");
           
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

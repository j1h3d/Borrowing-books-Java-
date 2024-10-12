package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dao.DaoException;
import dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/DeleteAccountServlet":
			doPost(request, response);
			break;
		}
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer les IDs des hôtels à supprimer depuis le formulaire
            String userId = request.getParameter("id");

            UtilisateurDAOImpl UserDAO = new UtilisateurDAOImpl();
            UserDAO.deleteUser(Integer.parseInt(userId));
            response.sendRedirect("admin-clients.jsp");

        } catch (DaoException e) {
            e.printStackTrace();
            response.getWriter().append("Erreur lors de la suppression de Client : " + e.getMessage());
        }
    }

}

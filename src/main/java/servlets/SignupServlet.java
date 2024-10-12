 package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDAOImpl;
import dao.DaoException;

/**
 * Servlet implementation class SignupServlet
 */

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        Utilisateur newClient = new Utilisateur();
        newClient.setUsername(username);
        newClient.setPassword(password);
        newClient.setEmail(email);
        newClient.setRole("client");
        
        
        UtilisateurDAOImpl accountDAO = new UtilisateurDAOImpl();
        try {
            accountDAO.CreateUserAccount(newClient);
            response.sendRedirect("login.jsp");
        } catch (DaoException e) {
            // Gérer les erreurs liées à l'accès à la base de données
            e.printStackTrace();
            response.getWriter().append("Erreur lors de la création de la client : " + e.getMessage());
        }
	}
	
}

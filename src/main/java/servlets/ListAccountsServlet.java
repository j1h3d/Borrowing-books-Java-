package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Utilisateur;
import dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class ListAccountsServlet
 */
public class ListAccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer la liste des comptes depuis la base de données
        	UtilisateurDAOImpl accountDAO = new UtilisateurDAOImpl();
            List<Utilisateur> accounts = accountDAO.lister();

            // Ajouter la liste des comptes à la requête
            request.setAttribute("accounts", accounts);

            // Transmettre la requête à la JSP pour affichage
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin-clients.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().append("Erreur: " + e.getMessage());
        }
    }

}

package servlets;

import java.io.IOException;
import java.util.List;

import beans.Categorie;
import beans.Utilisateur;
import dao.CategoryDAOImpl;
import dao.DaoException;
import dao.UtilisateurDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        // Assuming you have a method in AccountDAO to authenticate the user
        UtilisateurDAOImpl utilisateurDAO = new UtilisateurDAOImpl();
        Utilisateur authenticatedAccount = null;
        RequestDispatcher dispatcher=null;
    
		
        try {
            authenticatedAccount = utilisateurDAO.authenticate(username, password);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        

        if (authenticatedAccount != null) {
            // User is authenticated

            // Store user information in session (you can add more information as needed)
            int userId=authenticatedAccount.getId();
            String role = authenticatedAccount.getRole();
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            session.setAttribute("userId", userId);
            session.setAttribute("authenticatedUser", authenticatedAccount);
            // Forward to the appropriate home page based on the user's role
            if ("admin".equals(authenticatedAccount.getRole())) {
            	dispatcher=request.getRequestDispatcher("admin-home.jsp");
            } else {
                // Default to a generic home page for other roles
            	dispatcher=request.getRequestDispatcher("home");
            }
        } else {
            request.setAttribute("status", "failed");
            dispatcher=request.getRequestDispatcher("login.jsp");
        }
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        // Assuming you have a method in AccountDAO to authenticate the user
        UtilisateurDAOImpl utilisateurDAO = new UtilisateurDAOImpl();
        Utilisateur authenticatedAccount = null;
        RequestDispatcher dispatcher=null;
    
		
        try {
            authenticatedAccount = utilisateurDAO.authenticate(username, password);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        

        if (authenticatedAccount != null) {
            // User is authenticated

            // Store user information in session (you can add more information as needed)
            int userId=authenticatedAccount.getId();
            String role = authenticatedAccount.getRole();
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            session.setAttribute("userId", userId);
            session.setAttribute("authenticatedUser", authenticatedAccount);
            // Forward to the appropriate home page based on the user's role
            if ("admin".equals(authenticatedAccount.getRole())) {
            	dispatcher=request.getRequestDispatcher("admin-home.jsp");
            } else {
                // Default to a generic home page for other roles
            	dispatcher=request.getRequestDispatcher("home");
            }
        } else {
            request.setAttribute("status", "failed");
            dispatcher=request.getRequestDispatcher("login.jsp");
        }
        dispatcher.forward(request, response);
    }
}
package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Categorie;
import dao.CategoryDAOImpl;

/**
 * Servlet implementation class AdminHomeServlet
 */
public class AdminHomeServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	try {
	    		CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
	    		List<Categorie> categories = categoryDAO.getAllCategories();
	        
	    		request.setAttribute("categories", categories);
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-home.jsp");
	    		dispatcher.forward(request, response);
	    		
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().append("Erreur: " + e.getMessage());
	        }
	    }

}

package servlets;

import beans.Bien;
import beans.Categorie;
import dao.BienDAOImpl;
import dao.CategoryDAOImpl;
import dao.DaoException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AllCategoryServlet
 */
@WebServlet("/home")
public class AllCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        List<Categorie> categories = null;
			try {
				categories = categoryDAO.getAllCategories();
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("categories", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve categories from session
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        List<Categorie> categories = null;
			try {
				categories = categoryDAO.getAllCategories();
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("categories", categories);
			
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}

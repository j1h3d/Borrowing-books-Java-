package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Bien;
import dao.BienDAOImpl;
import dao.DaoException;

/**
 * Servlet implementation class BiensCatServlet
 */
@WebServlet("/DiscoverBooksServlet")
public class BiensCatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		BienDAOImpl BienDAO= new BienDAOImpl();
		try {
			List<Bien> biens = BienDAO.getBiensByCategory(categoryId);
			request.setAttribute("biens", biens);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("catalogue.jsp");
        dispatcher.forward(request, response);
	}

}

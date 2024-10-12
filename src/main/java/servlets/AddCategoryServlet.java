package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

import beans.Categorie;
import dao.DaoException;
import dao.CategoryDAOImpl;

/**
 * Servlet implementation class AddCategoryServlet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
				maxFileSize = 1024 * 1024 * 10,     
				maxRequestSize = 1024 * 1024 * 50)   
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");

	        // Get file part from request
			String categoryName = request.getParameter("category_name");
            String description = request.getParameter("description");
			Part filePart = request.getPart("cat_image");
	        String fileName = extractFileName(filePart);
	        String savePath = "images\\" + fileName;
	        
	        filePart.write(savePath);
            // Create a Hotel object
            Categorie newCategory = new Categorie(categoryName, description, savePath);
            newCategory.setCategory_name(categoryName);
            newCategory.setDescription(description);
            newCategory.setCat_image(savePath);

            // Add the new hotel to the database
            CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
            categoryDAO.addCategory(newCategory);

            // Redirect to the confirmation page or another appropriate page
            response.sendRedirect("admin-home.jsp");
        } catch (DaoException e) {
            // Handle exceptions appropriately (e.g., log the error)
            e.printStackTrace();
            response.getWriter().append("Erreur: " + e.getMessage());
        }
	}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length()-1);
            }
        }
        return "";
    }

}

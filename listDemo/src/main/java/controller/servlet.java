package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Item;
import dao.ItemDAO;

/**
 * Servlet implementation class servlet
 */
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//System.out.println("近來servlet");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			
			
			try {
				ItemDAO dao = new ItemDAO();
				List<Item> list = dao.select(request.getParameter("typename"));
				System.out.println(list);
				request.setAttribute("list", list);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

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
 * Servlet implementation class getAllServlet
 */
public class getAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("進來servlet");
		
		try {
			ItemDAO dao = new ItemDAO();
			List<Item> list = dao.selectAll();
			System.out.println("進來servlet.try");
			System.out.println(list);
			System.out.println(request.getParameter("typename"));
			request.setAttribute("list", list);
			request.setAttribute("type", request.getParameter("typename"));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		//	request.getRequestDispatcher("choose.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

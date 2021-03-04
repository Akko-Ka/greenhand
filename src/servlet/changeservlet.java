package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Bean;
import db.DBUtil;
import dao.Dao;

/**
 * Servlet implementation class changeservlet
 */
@WebServlet("/changeservlet")
public class changeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
		    Dao dao= new Dao();
	        int id = Integer.parseInt(request.getParameter("id"));
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        Bean bean=new Bean(id,username,password);
	        dao.update(bean);
	        request.setAttribute("message", "ÐÞ¸Ä³É¹¦");
	        request.getRequestDispatcher("servlet?method=list").forward(request, response);
	}
	 private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        // TODO Auto-generated method stub
	        request.setCharacterEncoding("utf-8");
		    Dao dao= new Dao();
	        List<Bean> list = dao.list();
	        request.setAttribute("list", list);
	        request.getRequestDispatcher("list.jsp").forward(request,response);
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

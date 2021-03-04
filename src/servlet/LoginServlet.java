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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sub_name = request.getParameter("sub_name");
        HttpSession a = request.getSession();
		Dao dao = new Dao();
		int s=0;
		if (sub_name.equals("用户登录")) {
		try {
			 s=dao.check(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s==0) {
			response.setHeader("refresh","0.1;url=failLogin.jsp");
		}
		else {
			a.setAttribute("account",username);
			request.getRequestDispatcher("usermain.jsp").forward(request,response);
		}
		}
		else if (sub_name.equals("管理员登录")) {
			try {
			 s=dao.check(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s==0) {
			response.setHeader("refresh","0.1;url=failLogin.jsp");
		}
		else {
			a.setAttribute("account",username);
			request.getRequestDispatcher("adminmain.jsp").forward(request,response);
		}
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

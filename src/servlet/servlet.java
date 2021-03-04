package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bean;
import db.DBUtil;
import dao.Dao;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	Dao dao=new Dao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Bean bean=new Bean(id,username,password);
 
        if(dao.insert(bean)) {
            request.setAttribute("message", "×¢²á³É¹¦");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
    
  //list,²éÔÄ
    private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        List<Bean> list = dao.list();
        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        String method=request.getParameter("method");
        if("insert".equals(method)) {
            insert(request,response);           
        }
        else if("list".equals(method)) {
            try {
                list(request,response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

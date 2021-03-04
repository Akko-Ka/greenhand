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
 * Servlet implementation class searchservlet
 */
@WebServlet("/searchservlet")
public class searchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		 String cxfs=request.getParameter("cxfs");
		 System.out.print(cxfs);

		 String str=request.getParameter("value");
		 Dao dao=new Dao();
		 List<Bean> list = null;
		
			 try {
				 if("1".equals(cxfs))
				 {
				list=dao.searchByUsername(str);
				} 
				 if("2".equals(cxfs))
				 {
				list=dao.searchById(str);
				} 
				
				 
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	   request.setAttribute("list", list);
	request.getRequestDispatcher("list.jsp").forward(request,response);
		 System.out.print(list.size());
		 
	}	
	 private void search(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
	        // TODO Auto-generated method stub
	        request.setCharacterEncoding("UTF-8");
	        response.setCharacterEncoding("utf-8");
	        String cxfs = request.getParameter("cxfs");    
	        System.out.print("cxfs");
	        request.setAttribute("search", "查询成功");
	        request.getRequestDispatcher("list.jsp").forward(request, response);
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

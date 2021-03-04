package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Bean;
import db.DBUtil;

public class Dao {//dao层
    private DBUtil dbutil=new DBUtil();


public Dao() {
    // TODO Auto-generated constructor stub

}
//注册
public boolean insert(Bean bean) {//插入数据的方法
    boolean f=false;
    String sql="insert into user(id,username,password) values('"+bean.getId()+"','"+bean.getUsername()+"','"+bean.getPassword()+"')";
    Connection conn=DBUtil.getConnection();//数据库连接，加载驱动
    Statement state=null;
    try
    {
        state=conn.createStatement();//实例化Statement对象,方便对sql语句进行操作
        System.out.println(conn);
        state.executeUpdate(sql);
        f=true;
        //执行数据库更新操作用于执行INSERT、UPDATE或DELETE语句以及SQLDDL（数据定义语言）语句，
        //例如CREATETABLE和DROPTABLE,（创建表和删除表）
    }catch(Exception e)//当try语句中s出现异常时，会执行catch中的语句
      {
        e.printStackTrace();//捕获异常的语句
      }
     finally //finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。
     {
         DBUtil.close(conn);
     }
    return f;
   }
//用户登入
public int check(String username,String password) throws SQLException {
	DBUtil db=new DBUtil();
	String sql="select * from user where username ="+username+" and password ="+password;
	Connection con=db.getConnection();
	PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	int s=0;
	if(rs.next()) {
		s=1;
	}
	return s;	
}
//查询
public List<Bean> list(){//查询所有方法
    String sql="select * from user order by id ASC";
    Connection conn=DBUtil.getConnection();
    Statement st=null;
    List<Bean> list=new ArrayList<>();
    ResultSet rs=null;
    Bean bean=null;
    try {
        st=conn.createStatement();
        st.executeQuery(sql);
        rs=st.executeQuery(sql);
        while(rs.next()) {
            int id=rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            bean=new Bean(id,username,password);
            list.add(bean);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        DBUtil.close(rs, st, conn);
    }
    return list;
}


public List<Bean> searchByUsername(String str) throws SQLException{//查询条件方法
    String sql="select * from user where(username like '%"+str+"%')";
    Connection conn=DBUtil.getConnection();
    Statement st=null;
    PreparedStatement pt = conn.prepareStatement(sql);
    List<Bean> search=new ArrayList<>();
    ResultSet rs=null;
    Bean bean=null;
    try {
      pt=conn.prepareStatement(sql);
        rs=pt.executeQuery();
        while(rs.next()) {
        	 int id=rs.getInt("id");
             String username = rs.getString("username");
             String password = rs.getString("password");
             bean=new Bean(id,username,password);
            search.add(bean);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        DBUtil.close(rs, st, conn);
    }
    return search;
}

public List<Bean> searchById(String str) throws SQLException{//查询条件方法
    String sql="select * from user where(id like '%"+str+"%')";
    Connection conn=DBUtil.getConnection();
    Statement st=null;
    PreparedStatement pt = conn.prepareStatement(sql);
    List<Bean> search=new ArrayList<>();
    ResultSet rs=null;
    Bean bean=null;
    try {
      pt=conn.prepareStatement(sql);
        rs=pt.executeQuery();
        while(rs.next()) {
        	 int id=rs.getInt("id");
             String username = rs.getString("username");
             String password = rs.getString("password");
             bean=new Bean(id,username,password);
            search.add(bean);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        DBUtil.close(rs, st, conn);
    }
    return search;
}
//删除
public boolean delete(String username) {//删除方法
    String sql="delete from user where username='"+username+"'";
    boolean f=false;
    Connection conn =DBUtil.getConnection();
    Statement st=null;
    try {
        st=conn.createStatement();
        st.executeUpdate(sql);
        f=true;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally{
        DBUtil.close(st, conn);
    }
    return f;
}
//修改
public boolean update(Bean bean) {//更新方法
    String sql="update user set id='"+bean.getId()+"',username='"+bean.getUsername()+"',password='"+bean.getPassword()+"'where id='"+bean.getId()+"'";
    Connection conn=DBUtil.getConnection();
    boolean f=false;
    Statement st=null;
    try {
        st=conn.createStatement();
        st.executeUpdate(sql);
        f=true;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return f;
}
}

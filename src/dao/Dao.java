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

public class Dao {//dao��
    private DBUtil dbutil=new DBUtil();


public Dao() {
    // TODO Auto-generated constructor stub

}
//ע��
public boolean insert(Bean bean) {//�������ݵķ���
    boolean f=false;
    String sql="insert into user(id,username,password) values('"+bean.getId()+"','"+bean.getUsername()+"','"+bean.getPassword()+"')";
    Connection conn=DBUtil.getConnection();//���ݿ����ӣ���������
    Statement state=null;
    try
    {
        state=conn.createStatement();//ʵ����Statement����,�����sql�����в���
        System.out.println(conn);
        state.executeUpdate(sql);
        f=true;
        //ִ�����ݿ���²�������ִ��INSERT��UPDATE��DELETE����Լ�SQLDDL�����ݶ������ԣ���䣬
        //����CREATETABLE��DROPTABLE,���������ɾ����
    }catch(Exception e)//��try�����s�����쳣ʱ����ִ��catch�е����
      {
        e.printStackTrace();//�����쳣�����
      }
     finally //finally��Ϊ�쳣�����һ���֣���ֻ������try/catch����У����Ҹ���һ�����飬��ʾ����������һ���ᱻִ�У�������û���׳��쳣����������������Ҫ�ͷ���Դ������¡�
     {
         DBUtil.close(conn);
     }
    return f;
   }
//�û�����
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
//��ѯ
public List<Bean> list(){//��ѯ���з���
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


public List<Bean> searchByUsername(String str) throws SQLException{//��ѯ��������
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

public List<Bean> searchById(String str) throws SQLException{//��ѯ��������
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
//ɾ��
public boolean delete(String username) {//ɾ������
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
//�޸�
public boolean update(Bean bean) {//���·���
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

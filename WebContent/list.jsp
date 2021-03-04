<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
         Object message = request.getAttribute("message");
         Object grade_list = request.getAttribute("grade_list");
         if(message!=null && !"".equals(message)){     
    %>
         <script type="text/javascript">
              alert("<%=request.getAttribute("message")%>");
         </script>
    <%} %>
    <div align="center">
        <h1 >信息列表</h1>
          <h1> 
        <form action="searchservlet" method="post">
        <select name="cxfs">
  <option  id="cxfs"value ="1">用户名</option>
  <option  id="cxfs" value ="2">id</option>
</select>
            <input type="text" id="value" name="value" placeholder="请输入条件">
            <input type="submit" id="select" name="select" value="查询" />
      </form>
        
        </h1>
        <a href="adminmain.jsp">返回主页</a>
        <table >
            <tr>
                <td>id</td>
                <td>username</td>
                <td>password</td>
                <td align="center" colspan="2">操作</td>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                   
                    <td><a href="check.jsp?id=${item.id}&username=${item.username}&password=${item.password}">修改</a></td>
                    <td><a href="deleteservlet?username=${item.username}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
                      
</html>
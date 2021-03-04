<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
<%
        Object message = request.getAttribute("message");
        if (message != null && !"".equals(message)) {
    %>
    <script type="text/javascript">
              alert("<%=request.getAttribute("message")%>"); //弹出对话框
    </script>
    <%
        }
    %>
    <div align="center">
        <h1>用户注册</h1>
        <a href="login.jsp">返回登入页</a>
       
  <form action="servlet?method=insert" method="post">
      <table id="addTable" class="table table-bordered  ">
       <tr class="text-center row">
               <tr> 
                  <td class="col-sm-2">
                    id
                  </td>
                  <td class="col-sm-4">
                   <input type="text" class="form-control"  name="id" id="id" >
                  </td>
              <tr class="text-center row">
                <td class="col-sm-2">
                  用户名
                </td>
                <td class="col-sm-4">
                   <input type="text" class="form-control"  name="username" id="username" >
                </td></tr>
                <tr>
                <td class="col-sm-2">
                  密码
                </td>
                <td class="col-sm-4">
                          <input type="password" class="form-control"  name="password" id="password" >
                </td>
              </tr>

            </table>
            <input type="submit" value="注册"  onclick= "return check()" /> 
      </form> 
    </div>

</body>
</html>
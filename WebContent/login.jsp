<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登入</title>
</head>
<body>
<div align="center">
        <h1>用户登入</h1>
       
  <form action="LoginServlet" method="post">
      <table id="addTable" class="table table-bordered  ">
       <tr class="text-center row">
               <tr> 
                 
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
                 <tr align="center" style="height: 20%">
					<td style="padding-left: 10px"><input type="submit" name="sub_name" value="用户登录"></td>
					<td style="padding-right: 40px;padding-left: 20px"><input type="submit" name="sub_name" value="管理员登录" ></td>
				</tr>
            </table>
             <input type="button" value="注册"
onclick="javascrtpt:window.location.href='register.jsp'" />
      </form> 
    </div>
</body>
</html>
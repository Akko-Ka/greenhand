<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改</title>
</head>
<body>
	<div align="center">
		<h1>修改</h1>
		<a href="adminmain.jsp">返回主页</a>
		<form action="changeservlet" method="get">
			<div>
				id:<input type="text" id="id" name="id" readonly="true"
					value="${param.id}" />
			</div>
			<div>
			用户名:<input type="text"  name="username" id="username" >
                     
					
			</div>
			<div>
			  密码:<input type="text" id="password" name="password"
					value="${param.password}" />
					
			</div>

			<div>
				 <input type="submit" value="修改"  onclick= "return check()" /> 
			</div>
		</form>
	</div>
</body>
</html>
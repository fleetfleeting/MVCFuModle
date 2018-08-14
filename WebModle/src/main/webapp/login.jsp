<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
<div>
    <h2>用户登陆</h2>
    <form action="${pageContext.request.contextPath}/LoinServlet" method="post">
        <input type="text" name="name" placeholder="请输入用户名"/>
        <input type="password" name="password" placeholder="请输入密码"/>
        <button type="submit">登陆</button>
    </form>
</div>
<div align="center">
    <div style="color:red" align="center">${msg}</div>
</div>
</body>
</html>

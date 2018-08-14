<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2>用户注册</h2>
    <form action="${pageContext.request.contextPath}/UseraddServlet" method="post">
        <input type="text" name="name" placeholder="请输入用户名"/>
        <input type="password" name="password" placeholder="请输入密码"/>
        <button type="submit">注册</button>
    </form>
</div>

<div align="center">
    <div style="color:red" align="center">${msg}</div>
</div>
</body>
</html>

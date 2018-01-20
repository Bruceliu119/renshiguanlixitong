<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 18-1-15
  Time: 下午7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div id="big">
    <div id="title">
        <h3>人事管理Hrm1.0系统</h3>
    </div>
    <div id="form">
        <div id="error">${requestScope.message }</div>
        <form action="login" method="post">
            <div class="login_item">
                <input type="text" name="loginname" placeholder="账号" />
            </div>
            <div class="login_item">
                <input type="password" name="password" placeholder="密码" />
            </div>
            <div id="submit">
                <input type="submit" value="登录" />
            </div>
        </form>
    </div>
</div>
</body>
</html>

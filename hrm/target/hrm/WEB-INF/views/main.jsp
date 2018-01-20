<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 18-1-15
  Time: 下午7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/main_function.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>主页</title>
</head>
<body>
<div id="big">

    <div id="header">
        <jsp:include page="main-element/title.jsp" />
    </div>

    <div id="content">

        <div id="left">
            <jsp:include page="main-element/left.jsp" />

        </div>

        <div id="right">
            <div id="right_title">当前位置:欢迎界面</div>
            <div id="show_message">
                欢迎使用人事管理Hrm1.0系统!
            </div>
        </div>

    </div>

</div>
</body>
</html>

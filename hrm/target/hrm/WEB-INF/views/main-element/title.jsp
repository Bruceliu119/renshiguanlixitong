<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 18-1-15
  Time: 下午7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        //获取系统时间，将时间以指定格式显示到页面。
        function systemTime()
        {
            //将时间显示到ID为time的位置，时间格式形如：19:18:02
            document.getElementById("time").innerHTML="当前时间:"+ getNowFormatDate();

            //每隔1000ms执行方法systemTime()。
            setTimeout("systemTime()",1000);
        }

        function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var seperator2 = ":";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
                + " " + date.getHours() + seperator2 + date.getMinutes()
                + seperator2 + date.getSeconds();
            return currentdate;
        }

    </script>
</head>
<body onload="systemTime()">
<div id="header_href">
    <a href="javaScript:void(0)" onclick="logout()" id="logout">注销登录</a>
    <a href="main" id="home">首页</a>
</div>
<div id="header_notice">
    <div id="user">当前用户:${sessionScope.user_session.username }</div>
    <div id="time"></div>
</div>
</body>
</html>

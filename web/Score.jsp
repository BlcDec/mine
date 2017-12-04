<%--
  Created by IntelliJ IDEA.
  User: KAI
  Date: 2017/12/3
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"%>
<%@ page import="WebServlet.OnlineTest.JudgeServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>您的网上测试成绩是：</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <!--[if IE]-->
  <script src="js/html5.js"></script>

</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <% response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("UTF-8");
                String name=null;
                String str;
                String score=request.getAttribute("score").toString();
                Cookie[] cookies=request.getCookies();
                if(cookies!=null){
                    for(int i=0;i<cookies.length;i++)
                    {
                        Cookie cookie=cookies[i];
                        if(cookie.getName().equals("username"));{
                        name=cookie.getValue();
                       }
                    }
                }
                str=name+"您的成绩是"+score;

            %>

            <font color="#FFFFFF"><h3 align="center"><%=str%>分</h3></font>
        </div>
    </div>
</div>
<script src="js/TweenLite.min.js"></script>
<script src="js/EasePack.min.js"></script>
<script src="js/rAF.js"></script>
<script src="js/demo-1.js"></script>
</body>
</html>

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
</head>
<body>
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

<h3 align="center"><%=str%>分</h3>
</body>
</html>

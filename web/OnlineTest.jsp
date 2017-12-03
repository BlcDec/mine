<%--
  Created by IntelliJ IDEA.
  User: KAI
  Date: 2017/12/1
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>网上测试</title>
</head>
<body>
<% response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");//解决编码问题
    String name=(String)request.getParameter("UserName");
    String promt="你好，"+name+"！ 欢迎进入J2EE测试系统";
%>
<h3 align="center"><%=promt%></h3>
<%
    promt="本次测试包含填空题、多选题、单选题和判断题，请认真答题，祝你答题顺利";
%>
<h3><%=promt%></h3>
<form action="result.jsp">
    <% promt="填空题 \n"; %>
    <h3><%=promt%></h3>
    J2EE教材的主编？<input type="text" name="author" value="" size="10" />
    <% promt="\n 单选题 \n"; %>
    <h3><%=promt%></h3>
    你所使用的开发环境是？
    <input type="radio" name="group1" value="VC" />VC
    <input type="radio" name="group1" value="NetBean" />NetBean
    <input type="radio" name="group1" value="Eclipse" />Eclipse
    <% promt="\n 多选题 \n"; %>
    <h3><%=promt%></h3>
    J2EE你学过什么？
    <input type="checkbox" name="checkbox1" value="Servlet" />Servlet
    <input type="checkbox" name="checkbox1" value="JSP" /> JSP
    <input type="checkbox" name="checkbox1" value="JavaBean" />Java Bean
    <input type="checkbox" name="checkbox1" value="JavaMail" />Java Mail
    <% promt="\n 判断题 \n"; %>
    <h3><%=promt%></h3>
    J2EE很有用           <input type="text" name="DM" value="" size="1" />
    <center>
        <input type="submit" value="提交" name="submit" />
    </center>
</form>
</body>
</html>

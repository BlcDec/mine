<%--
  Created by IntelliJ IDEA.
  User: KAI
  Date: 2017/12/1
  Time: 19:24
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <!--[if IE]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <title>网上测试</title>
</head>
<body>
<div class="distence left20">
    <font color="#FFFFFF">
        <div class="container demo-1">
            <div class="content">
                <div id="large-header" class="large-header">
                    <div>
                        <% response.setContentType("text/html;charset=UTF-8");
                            request.setCharacterEncoding("UTF-8");
                            String name=(String)request.getParameter("UserName");
                            String str;
                            Cookie []cookies=request.getCookies();
                            Cookie cookie=null;
                            if(cookies!=null){
                                for(int i=0;i<cookies.length;i++){
                                    cookie=cookies[i];
                                    if(cookie.getName().equals("username")){
                                        name=cookie.getValue();
                                        break;
                                    }
                                }
                            }
                            response.addCookie(cookie);
                            str="你好，"+name+"！ 欢迎进入JavaEE在线测试系统";

                        %>
                        <h3 align="center"><font color="#FFFFFF"> <%=str%></font></h3>

                        <div id="showTimes"></div>
                        <%
                           // long current_time=System.currentTimeMillis();
                            //long  end_time=1337875200000l;

                            //long time=current_time;
                            //long time=600000;
                            long time=600000;
                        %>
                        <script>
                            var second = <%= time / 1000%>; // 剩余秒数
                            // 写一个方法，将秒数专为天数
                            var toDays = function(){
                                var s = second % 60; // 秒
                                var mi = (second - s) / 60 % 60; // 分钟
                                var h =  ((second - s) / 60 - mi ) / 60 % 24; // 小时
                                var d =  (((second - s) / 60 - mi ) / 60 - h ) / 24 // 天

                                if(s===0&&mi===0&&h===0&&d===0){
                                    document.ansForm.submit();
                                }
                                return "剩余：" + d + "天" + h + "小时" + mi + "分钟" + s + "秒";
                            }
                            //然后写一个定时器
                            window.setInterval(function(){
                                second --;

                                document.getElementById("showTimes").innerHTML = toDays();
                            }, 1000);
                        </script>
                        <%
                            str="本次答卷共10小题，时间10分钟，请您注意答题时间。";
                        %>
                        <h3 ><font color="#FFFFFF"><%=str%></font></h3>
                        <script>

                            function selectRadio(name)
                            {
                                var arr=document.getElementsByName(name);
                                for(var i=0;i<arr.length;i++)
                                {
                                    if(arr[i].checked)
                                    {
                                        return true;
                                    }
                                }
                                return false;
                            }
                            function selectCheck(name)
                            {
                                var acc=document.getElementsByName(name);
                                for(var i=0;i<acc.length;i++)
                                {
                                    if(arr[i].checked)
                                    {
                                        return true;
                                    }
                                }
                                return false;
                            }
                            function validate() {

                                if(document.getElementById("test01").value.length==0){
                                    if (confirm("第一题没填提交表单?")) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                                else if(!selectRadio('test02')){
                                    if (confirm("第二题没选提交表单?")) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                                else if(!selectRadio('test03')){
                                    if (confirm("第三题没选提交表单?")) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }else if(!selectRadio('test04')){
                                    if (confirm("第四题没选提交表单?")) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }


                            }

                        </script>
                        <form id="ansForm" name="ansForm" action="JudgeServlet" method="post">
                            <% str="填空题 \n"; %>
                            <h3><%=str%></h3>
                            1、MVC的三个组成部分分别是:模型、视图、
                                <input id="test01" type="text" name="test01"  value="" size="10" />
                            <% str="\n 单选题 \n"; %>
                            <h3><%=str%></h3>
                            2、以下哪个HIbernate主键生成策略是实现主键按数值顺序递增的？
                            <br><br>
                            <input type="radio" name="test02"  value="A" />increment
                            <input type="radio" name="test02"  value="B" />Identity
                            <input type="radio" name="test02"  value="C" />sequence
                            <input type="radio" name="test02"  value="D" />native
                            <% str="\n 多选题 \n"; %>
                            <h3><%=str%></h3>
                            3、从以下哪个选项中不可以获得Servlet的初始参数？
                            <br><br>
                            <input type="checkbox" name="test03" value="A" />Servlet
                            <input type="checkbox" name="test03" value="B" /> ServletContext
                            <input type="checkbox" name="test03" value="C" />ServletConfig
                            <input type="checkbox" name="test03" value="D" />GenericServlet
                            <% str="\n 判断题 \n"; %>
                            <h3><%=str%></h3>
                            4、spring能管理的组件包括JSP。
                            <input type="radio" name="test04" value="true" />包括
                            <input type="radio" name="test04" value="false" />不包括
                            <center>
                                <input type="submit" value="提交" name="sub" onclick="return validate()" />
                            </center>
                        </form>
                    </div>
                </div>
            </div>
            <script src="js/TweenLite.min.js"></script>
            <script src="js/EasePack.min.js"></script>
            <script src="js/rAF.js"></script>
            <script src="js/demo-1.js"></script>
        </div>
    </font>
</div>
</body>
</html>

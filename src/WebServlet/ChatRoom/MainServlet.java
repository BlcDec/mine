package WebServlet.ChatRoom;

import WebServlet.OnlineTest.MysqlConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "MainServlet",urlPatterns = "/MainServlet")
public class MainServlet extends HttpServlet {

    protected void processLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(true);//开启会话
        String username, password;
        username = (String) request.getParameter("username");
        password = (String) request.getParameter("password");

        System.out.println(username);
        System.out.println(password);
        MysqlConnector mysqlConnector=new MysqlConnector();

        if (username != null && mysqlConnector.exeQuery(username,password)) {
                Cookie cookie1 = new Cookie("remname", username);
                Cookie cookie2 = new Cookie("rempwd", password);
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            session.setAttribute("UserName", username);
            session.setAttribute("IsLogin", "true");
            response.sendRedirect("LoginSuccessServlet");//用sendRedirect实现页面完全跳转
        }else {
            session.setAttribute("IsLogin", "false");
            response.sendRedirect("LoginErrorServlet");
        }

    }
    protected void processRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(true);//开启会话
        String username, password, remember;
        username = (String) request.getParameter("username");
        password = (String) request.getParameter("password");
        remember = (String) request.getParameter("remember");
        //在控制台中输出，方便审查
        System.out.println("remember:" + remember);
        System.out.println(username);
        System.out.println(password);
        MysqlConnector mysqlConnector=new MysqlConnector();

        if(username!=null&&mysqlConnector.exeQueryUserName(username)){
            System.out.println("用户已经存在");
            session.setAttribute("IsLogin", "false");
            response.sendRedirect("RegisterErrorServlet");
        }else{
            if(username!=null&&mysqlConnector.exeInsert(username,password)){
                session.setAttribute("IsLogin", "false");
                response.sendRedirect("RegisterOkServlet");
            }
        }


    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String login=(String)request.getParameter("submit");
        String register=(String)request.getParameter("register");
        System.out.println("登录按钮"+login);
        System.out.println("注册按钮"+register);

        if(register==null)
            processLogin(request,response);
        else
            processRegister(request,response);


    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
    }
}

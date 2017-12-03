package WebServlet.OnlineTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginVerificationServlet",urlPatterns = "/LoginVerificationServlet")
public class LoginVerificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(true);
        String username, password;
        username = (String) request.getParameter("logname");
        password = (String) request.getParameter("logpass");
        System.out.println(username);
        System.out.println(password);
        MysqlConnector mysqlConnector=new MysqlConnector();

        if (username != null && mysqlConnector.exeQuery(username,password)) {
            Cookie cookie1 = new Cookie("username", username);
            Cookie cookie2 = new Cookie("userpassword", password);
            cookie1.setMaxAge(7);
            cookie2.setMaxAge(7);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            session.setAttribute("UserName", username);
            session.setAttribute("IsLogin", "true");
            response.sendRedirect("OnlineTest.jsp");//用sendRedirect实现页面完全跳转
        }else {
            session.setAttribute("IsLogin", "false");
            response.sendRedirect("index.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

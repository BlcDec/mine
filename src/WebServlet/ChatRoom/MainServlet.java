package WebServlet.ChatRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "MainServlet",urlPatterns = "/MainServlet")
public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username, password, remember;
        HttpSession session = request.getSession(true);//开启会话

        username = (String) request.getParameter("username");
        password = (String) request.getParameter("password");
        remember = (String) request.getParameter("remember");
        //在控制台中输出，方便审查
        System.out.println("remember:" + remember);
        System.out.println(username);
        System.out.println(password);

        if (username != null && username.equals("123") && password.equals("123")) {
            if (remember != null && remember.equals("true")) {
                Cookie cookie1 = new Cookie("remname", username);
                Cookie cookie2 = new Cookie("rempwd", password);
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                cookie2.setMaxAge(60 * 60 * 24 * 7);


                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            session.setAttribute("UserName", username);
            session.setAttribute("IsLogin", "true");
            response.sendRedirect("LoginSuccessServlet");//用sendRedirect实现页面完全跳转
        } else if (username != null && username.equals("12") && password.equals("12")) {
            if (remember != null && remember.equals("true")) {//当用户勾选记住密码功能时，将密码返回给客户端保存，下次访问的时候先从客户端获取密码，这样就实现了记住密码功能
                Cookie cookie1 = new Cookie("remname", username);
                Cookie cookie2 = new Cookie("rempwd", password);
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            session.setAttribute("UserName", username);
            session.setAttribute("IsLogin", "true");
            response.sendRedirect("LoginSuccessServlet");
        } else {
            session.setAttribute("IsLogin", "false");
            response.sendRedirect("LoginFail.html");//页面完全跳转，不会出现乱码
        }
    }
}

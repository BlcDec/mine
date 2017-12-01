package WebServlet.ChatRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Cookie[] cookies=request.getCookies();
        String userName="",userPassword="";
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                Cookie cookie=cookies[i];
                if(cookie.getName().equals("remname")) {
                    userName = cookie.getValue();
                }else if(cookie.getName().equals("rempassword")){
                    userPassword=cookie.getValue();
                }
            }
        }



        PrintWriter out = response.getWriter();
        out.println("<html><head><title>登陆界面</title>");
        out.println("<meta http-equiv=\"content-type\" content=\"txt/html; charset=utf-8\" />");
        out.println("<style>");
        out.println("body{text-align:center}");
        out.println("#divcss5{margin:0 auto;border:1px solid #000;width:300px;height:100px}");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<div>");
        out.println("<form action='MainServlet' method='post'");
        out.println("<p>用户名：<input type='text' name='username' value=" +userName+ "></p>");
        out.println("<p>密  码：<input type='password' name='password' value=" +userPassword+ "></p>");
        out.println("<input type='submit' name='submit' value='登录'>");
        out.println("<input type='submit' name='register' value='注册'>");
        out.println("</div>");
        out.println("</body></html>");
    }
}

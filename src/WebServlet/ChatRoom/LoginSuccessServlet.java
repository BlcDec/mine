package WebServlet.ChatRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginSuccessServlet",urlPatterns = "/LoginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();//
        String username = "";
        if (session.getAttribute("UserName") != null) {
            username = session.getAttribute("UserName").toString();
        }

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>聊天室</title>");
        out.println("<meta http-equiv=\"content-type\" content=\"txt/html; charset=utf-8\" />");
        out.println("<style type='text/css'>#iframe1{width:600px;height:200px;}" +
                "iframe{width:600px;height:200px;margin-bottom:20px;}</style>");
        out.println("</head>");
        out.println("<center><h2><b>多人聊天系统</b></h2>");
        out.println("<lable>当前用户：" + username
                + "</lable><a href=\"LogoutServlet\"> 退出登录</a><br>");
        out.println("<iframe src='MessageServlet' id='iframe1'></iframe>");
        out.println("<br>");
        out.println("<iframe src='SendServlet'></iframe><br>");
        out.println("</body></html>");

    }
}

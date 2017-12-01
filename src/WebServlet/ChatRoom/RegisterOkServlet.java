package WebServlet.ChatRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterOkServlet",urlPatterns = "/RegisterOkServlet")
public class RegisterOkServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        session.removeAttribute("UserName");
        //session.setAttribute("IsLogin", "false");
        PrintWriter out = response.getWriter();




        out.println("<html><head><title>注册失败</title>");
        out.println("<meta http-equiv=\"refresh\" content =\"1;url=LoginServlet\">");
        out.println("<style>");
        out.println("body{text-align:center}");
        out.println("#divcss5{margin:0 auto;border:1px solid #000;width:300px;height:100px}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>注册成功，请登录</h2>");
        out.println("</body>");
        out.println("</html>");
    }

}

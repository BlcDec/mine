package WebServlet.ChatRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet",urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("UserName");
        //session.setAttribute("IsLogin", "false");
        PrintWriter out = response.getWriter();
        /*response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");*/

        out.println("<html><head><title>注销登陆</title>");
        out.println("<meta http-equiv=\"refresh\" content =\"1;url=LoginServlet\"></head>");
        out.println("<body>bye-----bye!!!!</body>");
        out.println("</html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}

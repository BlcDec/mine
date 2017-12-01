package WebServlet.ChatRoom;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SendServlet",urlPatterns = "/SendServlet")
public class SendServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("UserName");

        out.println("<html><body>");
        out.println("<lable>当前用户：" + username + "</lable><br>");
        out.println("<form action=\"SendServlet\" method=\"post\">");
        out.println("<div><textarea name=\"userMessages\" cols=\"50\" style=\"height:100px;\"></textarea></div>");
        out.println("<div><input type=\"submit\" id=\"submit\" value=\"发送\"/>");
        out.println("<input type=\"reset\" id=\"reset\" value=\"清空输入\"/></div>");
        out.println("</form>");
        out.println("</body></html>");
    }


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        ServletContext application = this.getServletContext();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        String time = formatter.format(currentTime);
        String username = (String) session.getAttribute("UserName");

        PrintWriter out = response.getWriter();

        String mywords = request.getParameter("userMessages");
        application.log(mywords);
        if (mywords == null) {
            mywords = "系统提示：可以聊天";
            application.setAttribute("words", mywords + "\n");
        } else if (mywords != null) {
            mywords = time+":" +username+ ":" + mywords;
            application.log(mywords);
            Object obj = application.getAttribute("words");
            if (obj == null) {
                application.setAttribute("words", mywords + "\n");
            } else {
                application.setAttribute("words", obj.toString() + mywords
                        + "\n");
            }
        }

        out.println("<html><body>");
        out.println("<lable>当前用户：" + username + "</lable><br>");
        out.println("<form action=\"SendServlet\" method=\"post\">");
        out.println("<div><textarea name=\"userMessages\" cols=\"50\" style=\"height:100px;\"></textarea></div>");
        out.println("<div><input type=\"submit\" id=\"submit\" value=\"发送\"/>");
        out.println("<input type=\"reset\" id=\"reset\" value=\"清空输入\"/></div>");
        out.println("</form>");
        out.println("</body></html>");

    }
}

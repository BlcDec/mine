package WebServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by KAI on 2017/11/21.
 */
//@WebServlet("/urlwrite1")
@WebServlet(name = "URLRewrite1",urlPatterns="/urlwrite1")
public class URLRewrite1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;chatset=gb2312");
        java.io.PrintWriter out = response.getWriter();
        HttpSession session =request.getSession();//如果没有session的话创建session，否则的话并没有session
        String contextPath = request.getContextPath();
        //String encodedUrl = response.encodeUrl(contextPath + "/url2?name=zhangsan&age=27");
        String encodedUrl=response.encodeURL(contextPath + "/url2?name=zhangsan&age=27");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>URL Rewriter</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>URL rewrite show:send parameter</h2>");
        out.println("turn to URL2<a href=\"" + encodedUrl + "\">here</a>.");
        out.println("<h3>"+encodedUrl+"</h3>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}

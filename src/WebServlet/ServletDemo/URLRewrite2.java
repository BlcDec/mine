package WebServlet.ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by KAI on 2017/11/22.
 */
//@WebServlet(name = "URLRewrite2")
@WebServlet(name="URLRewrite2",urlPatterns="/url2")

public class URLRewrite2 extends HttpServlet {
    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset=gb2312");
        java.io.PrintWriter out=response.getWriter();
        String contextPath=request.getContextPath();
        HttpSession session=request.getSession();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>URL Writer</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>URL ReWrite show : get parameter</h2>");
        out.println("name="+request.getParameter("name"));
        out.println("age="+request.getParameter("age"));
        out.println("<h3>"+request.getRequestURL()+"</h3>");
        out.println("<h3>"+session.getId()+"</h3>");
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

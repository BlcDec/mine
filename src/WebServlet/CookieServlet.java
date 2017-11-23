package WebServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by KAI on 2017/11/19.
 */
@WebServlet(name = "CookieServlet",urlPatterns={"/cookie"})
//@WebServlet("/Hello")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=null;
        Cookie[] cookies=request.getCookies();
        boolean newCookie=false;
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("SimpleServlet")){
                    cookie=cookies[i];
                }
            }//end for
        }//end if
        if(cookie==null){
            newCookie=true;
            int maxAge=10000;
            cookie=new Cookie("SimpleCookie","present by blcdec");
            cookie.setPath(request.getRealPath("/"));//request.getContextPath()
            cookie.setMaxAge(maxAge);//Returns the maximum age of the cookie, specified in seconds, By default, -1 indicating the cookie will persist until browser shutdown.
           // response.addCookie(cookie);
        }//end if
        response.addCookie(cookie);
        //show message
        response.setContentType("text/html");
        java.io.PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cookie Info</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Information about the cookie named \"SimpleServlet\"</h2>");
        out.println("Cookie value:"+cookie.getValue()+"<br>");
        if(newCookie){
            out.println("Cookie Max-Age:"+cookie.getMaxAge()+"<br>");
            out.println("Cookie Path:"+cookie.getPath()+"<br>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}

package WebServlet.ServletDemo;
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
@WebServlet(name = "CookieTrackServlet",urlPatterns={"/cookietrack"})
public class CookieTrackServlet extends HttpServlet {

    protected  void processRequest(HttpServletRequest request,HttpServletResponse response)
    throws ServletException,IOException{
        Cookie cookie=null;
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            boolean flag=false;
            for(int i=0;(i<cookies.length)&&(!flag);i++){
                if(cookies[i].getName().equals("VisitTimes")){
                    String v=cookies[i].getValue();
                    int value=Integer.parseInt(v)+1;
                    cookies[i].setValue(Integer.toString(value));
                    response.addCookie(cookies[i]);
                    flag=true;
                    cookie=cookies[i];
                }//end if
            }//end for
        }

        //create cookie
        if(cookie==null){
            int maxAge=1;
            cookie=new Cookie("VisitTimes","1");
            cookie.setPath(request.getContextPath());
            cookie.setMaxAge(maxAge);
            response.addCookie(cookie);
        }//end if
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cookie followSession</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>hello</h2>");
        out.println("Welcome you  "+cookie.getValue()+"  times to open this page<br>");
        out.println("Cookie Path:"+cookie.getPath()+"<br>");
        out.println("</body>");
        out.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}

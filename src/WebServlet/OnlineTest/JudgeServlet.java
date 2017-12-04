package WebServlet.OnlineTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JudgeServlet",urlPatterns="/JudgeServlet")
public class JudgeServlet extends HttpServlet {

    int score=0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html:charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String ans;
        String []temp=null;
        ans=request.getParameter("test01");
        Cookie[]cookies=request.getCookies();
        Cookie cookie=null;
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                cookie=cookies[i];
                if(cookie.getName().equals("username")){
                    break;
                }

            }
        }
        response.addCookie(cookie);
        if(ans.equals("控制器")){
            score+=25;
            System.out.println("test01");
        }
        ans="";
        temp=request.getParameterValues("test02");
        if(temp!=null) {
            for (int i = 0; i < temp.length; i++) {
                ans += temp[i];
            }
            if (ans.equals("A")) {
                score += 25;
                System.out.println("test02");
            }
        }
        ans="";
        temp=request.getParameterValues("test03");
        if(temp!=null) {
            for (int i = 0; i < temp.length; i++) {
                ans += temp[i];

            }
            if (ans.equals("ABD")) {
                score += 25;
                System.out.println("test03");
            }
        }
        ans=request.getParameter("test04");
        if(ans!=null) {
            if (ans.equals("false")) {
                score += 25;
                System.out.println("test04");
            }
        }
        request.setAttribute("score",score);
        request.getRequestDispatcher("/Score.jsp").forward(request,response);
        //System.out.println("run JudgeServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

//package WebServlet.ChatRoom;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName="FirstFilter",urlPatterns={"/*"})
//public class Filter implements Filter{
//    @Override
//    public void destroy() {
//        System.out.println("destroy---FirstFilter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
//        System.out.println("start----doFilter--FirstFilter");
//
//        HttpServletRequest request =(HttpServletRequest) arg0;
//        HttpServletResponse response =(HttpServletResponse) arg1;
//        //以上是强制内型转换，使用request对象和response对象
//
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        arg2.doFilter(arg0, arg1);//在页面跳转之前执行此语句前面的代码，执行完页面的代码之后，在执行后面的语句
//        System.out.println("第一个字符过滤器");
//        System.out.println("end------doFilter--FirstFilter");39     }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("init----FirstFilter ");
//    }
//}

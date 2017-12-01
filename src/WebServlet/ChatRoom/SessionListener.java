package WebServlet.ChatRoom;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener("这是一个用户信息监听器")
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    //监听器实现的两个接口，用于监听在线人数
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if(event.getName().equals("UserName"))
        {
            String current = (String) event.getSession().getServletContext().getAttribute("online");//获取当前用户人数
            String info = (String) event.getSession().getServletContext().getAttribute("Words");//当前用户的信息
            if(info==null)info ="";
            if(current == null) current="0";
            int c=Integer.parseInt(current);
            c++;
            current = String.valueOf(c);
            event.getSession().getServletContext().setAttribute("online", current);
            //event.getSession().getServletContext().setAttribute("Words", info+event.getValue()+" 加入聊天室\n");
        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if(event.getName().equals("UserName"))
        {
            String current = (String) event.getSession().getServletContext().getAttribute("online");
            String info = (String) event.getSession().getServletContext().getAttribute("Words");
            if(info==null)info ="";
            if(current==null)current = "0";
            int c = Integer.parseInt(current);
            c--;
            current = String.valueOf(c);
            event.getSession().getServletContext().setAttribute("online", current);
            event.getSession().getServletContext().setAttribute("Words", info+event.getValue()+" 离开了聊天室\n");
        }

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    }

}
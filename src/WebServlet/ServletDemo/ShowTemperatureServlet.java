/*
 * Created on 2004-6-13
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package WebServlet.ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author haoyulong
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class ShowTemperatureServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//TODO Method stub generated by Lomboz
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String Temperature=(String)getServletConfig().getServletContext().getAttribute("Temperature");
        if(Temperature==null){Temperature=new String("0");
        }
        String oldTemperature=(String)request.getSession().getAttribute("OldTemperature");
        
        
        out.println("<HTML><HEAD><TITLE>������Ϣ��ʾ "
	                + "</TITLE></HEAD>");
	    out.println("<BODY>");
	    out.println("��ǰ�������£�"+Temperature+"���϶�");
	    if(oldTemperature!=null){
	    	out.println("<BR>");
		    out.println("����sdf���£�"+oldTemperature+"���϶�");
        	
        }
	    out.println("</BODY></HTML>");
		//���»Ự�е�������Ϣ
	    request.getSession().setAttribute("OldTemperature",Temperature);

	}
}
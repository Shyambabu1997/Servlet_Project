package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class DateServlet extends HttpServlet {
	
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	Date d=new Date();
	pw.println("<h1 style=color:red;text-align:center>Date And Time:</h1>"+d);
	pw.close();
	}
	}

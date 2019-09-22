package student.radhe.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class PlainServlet extends HttpServlet
{
	static
	{
	System.out.println("Plain Servlet:static block");
	}
	public PlainServlet()
	{
	System.out.println("Plain Servlet:0 param constructor");
	}
	public void init(ServletConfig cg)
	{
	System.out.println("Plain Servlet:init(Servlet config)");
	}

public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter pw=res.getWriter();
res.setContentType("text/plain");
pw.println("<table border='2' align=center>");
pw.println("<tr><th> Name</th><th>Role</th><th>NickName</th></tr>");
pw.println("<tr><td>M S Dhoni</td><td>Sport</td><td>Mahi</td></tr>");
pw.println("<tr><td>Rahul Gandhi</td><td>Politics</td><td>Pappu</td></tr>");
pw.println("<tr><td>Salman Khan</td><td>Actor</td><td>Bhaijan</td></tr>");
pw.println("<tr><td>Katrina Kaif</td><td>Actress</td><td>Kat</td></tr>");
pw.println("<tr><td>Sania Mirza</td><td>Sport</td><td>Sania</td></tr>");
pw.println("</table>");

pw.close();
}
public void destroy()
{
System.out.println("Plain Servlet:destroy()");
}
}

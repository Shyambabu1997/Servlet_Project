package student.radhe.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LCTestServlet extends HttpServlet 
{
	static int i;
static
{
System.out.println("LCTest Servlet:static block");
}
public LCTestServlet()
{
System.out.println("LCTest Servlet:0 param constructor");
}
public void init(ServletConfig cg) throws ServletException
{
	super.init(cg);
	System.out.println("init() ");
}
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
{
	
System.out.println(" Execution start service(-,-)");
super.service(req,res);
System.out.println("Execution end service(-,-)");
HttpServletRequest req1;
HttpServletResponse res1;
req1=(HttpServletRequest)req;
res1=(HttpServletResponse)res;
doGet(req1,res1);
System.out.println("Second time execution start");
System.out.println("Execution of Explicitely called doPost() end");
}

	
	  public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException 
	  { 
		  i++;
	  System.out.println("No of time doGet() method is called"+i);
	  System.out.println("doGet(-,-) executed"); 
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html"); String user=null; 
	  String pass=null; 
	  ServletConfig cfg=getServletConfig(); 
	  user=cfg.getInitParameter("user");
	  pass=cfg.getInitParameter("password"); 
	  Date d=new Date();
	  pw.println("<h1 style=color:red;text-align:center>Date And Time:"+d+"</h1>");
	  pw.println("<h2 style=color:blue;>"+user+"</h2>");
	  pw.println("<h2 style=color:blue;>"+pass+"</h2>");
	  
	  pw.close(); 
	  }
	  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
	  System.out.println("doPost executed");
	  doGet(req, res);
	  }
	 
public void destroy()
{
System.out.println("LCTest Servlet:destroy()");
}
}

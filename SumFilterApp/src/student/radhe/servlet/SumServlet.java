package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SumServlet extends HttpServlet {
	ServletContext sc=null;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		int v1=0;
		int v2=0;
		v1=Integer.parseInt(req.getParameter("val1"));
		v2=Integer.parseInt(req.getParameter("val2"));
		pw.println("<h2 style=color:red;text-align:center>Result:"+(v1+v2)+"</h2>");
		pw.println("<a href='home.jsp'>Home</a>");
		sc=req.getServletContext();
		pw.println("<b>Request"+sc.getAttribute("reqCount")+"</b>");
		pw.println("Browser:"+req.getHeader("user-agent"));
		pw.close();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		doPost(req,res);
	}
}

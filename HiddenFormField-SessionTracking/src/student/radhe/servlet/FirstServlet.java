package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
@Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	PrintWriter pw=null;
	String name,adds,ms=null;
	String age=null;
	//General Setting
	pw=res.getWriter();
	res.setContentType("text/html");
	name=req.getParameter("f1t1");
	age=req.getParameter("f1t2");
	adds=req.getParameter("f1t3");
	ms=req.getParameter("ms");
	
	if(ms==null)
		ms="single";
	//Generate second dynamic from here
	if(ms.equalsIgnoreCase("married"))
	{
		pw.println("<h1 style=color:blue;text-align:center>F2:Information about Your Bachelor Life</h1><br>");
		pw.println("<form action= 'secondurl' method='post'><br>");
		pw.println("<b>Spouse Name:</b><input type='text' name='f2t1'><br>");
		pw.println("<b>No. of Kids:</b><input type='text' name='f2t2'><br>");
		pw.println("<input type='hidden' name='hname' value="+name+">");
		pw.println("<input type='hidden' name='hage' value="+age+">");
		pw.println("<input type='hidden' name='hadd' value="+adds+">");
		pw.println("<input type='hidden' name='hms' value="+ms+">");
		pw.println("<input type='submit' name='submit'>");
		pw.println("</form>");
		
	}
	else
	{
		pw.println("<h1 style=color:blue;text-align:center>F2:Information about Your Bachelor Life</h1><br>");
		pw.println("<form action= 'secondurl' method='post'><br>");
		pw.println("<b>When to Married</b><input type='text' name='f2t1'><br>");
		pw.println("<b>Why to Married</b><input type='text' name='f2t2'><br>");
		pw.println("<input type='hidden' name='hname' value="+name+">");
		pw.println("<input type='hidden' name='hage' value="+age+">");
		pw.println("<input type='hidden' name='hadd' value="+adds+">");
		pw.println("<input type='hidden' name='hms' value="+ms+">");
		
		pw.println("<input type='submit' name='submit'>");
		pw.println("</form>");
	}
		
	pw.close();
}
@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doPost(req, resp);
	}
}

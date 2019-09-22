package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/testurl")
public class ServletTest extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sc=null;
		sc=getServletContext();
	Enumeration e=sc.getInitParameterNames();
	while(e.hasMoreElements())
	{
		String name=(String)e.nextElement();
		String value=sc.getInitParameter(name);
		pw.println(name+"...."+value);
		pw.println();
		
	}
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}

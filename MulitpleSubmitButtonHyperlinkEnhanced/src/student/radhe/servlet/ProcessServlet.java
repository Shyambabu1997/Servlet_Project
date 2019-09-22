package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		String svalue=null;
		int v1=0;
		int v2=0;
		res.setContentType("text/html");
		svalue=req.getParameter("src");
		if(!svalue.equalsIgnoreCase("link1") && !svalue.equalsIgnoreCase("link2"))
		{
			v1=Integer.parseInt(req.getParameter("text1"));
			v2=Integer.parseInt(req.getParameter("text2"));
		}
		
		if(svalue.equalsIgnoreCase("sum")) {
		
		pw.println("<h3 style=color:blue;text-align:center>Result:"+(v1+v2)+"<h3>");
		}else if(svalue.equalsIgnoreCase("minus")) {
			pw.println("<h3 style=color:blue;text-align:center> Reslult:"+(v1-v2)+"<h3>");
		}
		else if(svalue.equalsIgnoreCase("product")) {
			pw.println("<h3 style=color:blue;text-align:center>Result:"+(v1*v2)+"<h3>");
		}
		else if(svalue.equalsIgnoreCase("link1"))
			pw.println("<h1 style=color:blue;text-align:center>"+new Date()+"<h3>");
		else
			pw.println("<h1 style=color:blue;text-align:center>"+System.getProperties()+"<h3>");
		
		pw.println("<a href='home.html>Home</a>");
		}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}

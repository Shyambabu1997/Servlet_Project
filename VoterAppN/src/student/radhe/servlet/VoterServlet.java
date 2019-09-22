package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	String name=null,fname=null;
	int age=0;
	pw=res.getWriter();
	
	res.setContentType("text/html");
	name=req.getParameter("pname");
	fname=req.getParameter("fname");
	age=Integer.parseInt(req.getParameter("page"));
	
	if(age<18)
		pw.println("<h1 style=color:blue;text-align:center;>"+name+" You are not eligible for vote wait for "+(18-age)+"years"+"</h1");
	else
		pw.println("<h1 style=color:blue;text-align:center;>"+name+"Congrats..!! You are eligible for vote.</h1> ");
	
	
	pw.println("<br><a href='home.html'><img src='homeicon.jpg'></a>");
	pw.close();
	}
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}
	}

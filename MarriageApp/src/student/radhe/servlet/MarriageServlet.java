package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {

	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
	System.out.println(" Execution start service(-,-)");
	
	super.service(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String name=null;
		int age=0;
		char gen=' ';
		pw=res.getWriter();
		res.setContentType("text/html");
		gen=req.getParameter("male").charAt(0);
		name=req.getParameter("name");
		age=Integer.parseInt(req.getParameter("age"));
		if(age>21 && gen=='F')
		pw.println("<h3 style=color:blue;text-align:center;> Congrats "+ name +" You are eligible for marriage ..Think Once Again</h3>" );
		else if(age>21 && gen=='M')
				pw.println("<h3 style=color:blue;text-align:center;> Congrats "+ name +" You are eligible for marriage ..Try to Make Happy others</h3>" );
		else
			pw.println("<h3 style=color:blue;text-align:center;> Sorry"+ name +" You are not eligible for Marriage..Wait </h3>" );
		 
		}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		Date d=new Date();
		pw.println("<h3 style=color:blue;text-align:center; Date and Time ::>"+d);
		//doPost(req,res);
	
	}
}

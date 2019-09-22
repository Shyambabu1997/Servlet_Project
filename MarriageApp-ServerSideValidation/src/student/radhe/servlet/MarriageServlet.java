package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String name=null;
		String age=null;
		int ageC=0;
		String gender=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		gender=req.getParameter("male");
		name=req.getParameter("name");
		age=req.getParameter("age");
		
		if(name.equals("") || name==null || name.length()==0) {
			pw.println("<h3 style=color:red;text-align:center;>Person name must not be empty</h1>");
		return;
		}
		if(age==null || age.equals("")|| age.length()==0){
			pw.println("<h3 style=color:red;text-align:center;>Person age must not empty</h3>");
		return;
		}
		else
		{
				try
				{
				ageC=Integer.parseInt(req.getParameter("age"));
				if(ageC>121 || ageC<=0) {
					pw.println("<h3 style=color:red;text-align:center>Age value should not greater than 120 or less than equal to 0</h3>");
				return;
				}
			}
				catch(NumberFormatException nfe)
				{
					pw.println("<h3 style=color:red;text-align:center>Age muste be numeric value</h3>");
					return;
				}
			}
		
			if(ageC>21)
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
	
	}

}

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
		int ageC=0;
		char gen=' ';
		String status=null;
		String age=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		gen=req.getParameter("male").charAt(0);
		name=req.getParameter("pname");
		age=req.getParameter("page");
		status=req.getParameter("flag");
		if(status.equals("no"))
			{
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
					ageC=Integer.parseInt(req.getParameter("page"));
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
			
					}
		else
		{
			ageC=Integer.parseInt(age);
		}
		if(ageC>21) {
			pw.println("<h3 style=color:blue;text-align:center;> Congrats "+ name +" You are eligible for marriage ..Try to Make Happy others</h3>" );
			pw.println("<br><a href='input.html'><img src='homeicon.jpg'></a>");
		}
			else {
	pw.println("<h3 style=color:blue;text-align:center;> Sorry"+ name +" You are not eligible for Marriage..Wait </h3>" );
	pw.println("<br><a href='input.html'><img src='homeicon.jpg'></a>");
}
		
	}
		
		
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doPost(req,res);
	}

}

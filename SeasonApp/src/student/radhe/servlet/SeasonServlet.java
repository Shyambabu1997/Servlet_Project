package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SeasonServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw=null;
		Calendar cal=null;
		int month=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		cal=Calendar.getInstance();
		month=cal.get(Calendar.MONTH)+1;
		if(month>=3 && month<=6)
			pw.println("<h1 style=color:blue;text-align:center>Hey This is summer season</h1>");
		else if(month>=7 && month<=10)
			pw.println("<h1 style=color:blue;text-align:center>Hey This is Rainy  season</h1>");
		else
			pw.println("<h1 style=color:blue;text-align:center>Hey This is Winter  season</h1>");
	
		pw.println("<a href='http://localhost:3030/SeasonApp/page.html'>Go to Homepage</a>");
		pw.close();
	}
	
}

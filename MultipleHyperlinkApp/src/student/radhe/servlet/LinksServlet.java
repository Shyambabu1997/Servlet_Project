package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LinksServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String link=null;
		pw=res.getWriter();
		Locale[] locales=Locale.getAvailableLocales();
		res.setContentType("text/html");
		link=req.getParameter("value");
		//System.out.println(link);
		if(link.equalsIgnoreCase("link1")) {
			for(Locale lc:locales) {
				pw.println(lc.getDisplayCountry()+"<br>");
			}
		}
		else if(link.equalsIgnoreCase("link2"))
		{
			for(Locale lc:locales)
				pw.println(lc.getDisplayLanguage()+"<br>");
		}
		else if(link.equalsIgnoreCase("link3"))
		{
			pw.println(System.getProperties()+"<br>");
		}
		else
			pw.println("<h1 style=color:red;text-align:center>"+new Date()+"</h1>");
		
		pw.close();	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

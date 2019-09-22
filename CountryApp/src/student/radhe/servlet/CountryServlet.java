package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CountryServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw=null;
		String[] capitals= {"New Delhi","Washington DC","Ishlambad","Bejing","Column"};
		int index=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		index=Integer.parseInt(req.getParameter("country"));
		pw.println("<h1 style=color:red;text-align:center;>Capital is "+capitals[index]+"<br><br>");
		pw.println("<a href='home.html'>Homepage</a>");
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	doPost(req,res);
	}

}

package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDefault extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
	
	PrintWriter pw=null;
	pw=resp.getWriter();
	resp.setContentType("text/html");
	pw.println("<h1 style=color:blue;text-align:left;>Bhai URL bhala re dia wa kan wa dekhi ki dia na Hack karuch </h1>");
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
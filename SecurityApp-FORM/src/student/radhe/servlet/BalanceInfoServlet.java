package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BalanceInfoServlet extends HttpServlet {
@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	System.out.println("BalanceInfoServlet.doGet()");
	PrintWriter pw=null;
	Random r=null;
	
	pw=res.getWriter();
	res.setContentType("text/html");
	
	r=new Random();
	int value=r.nextInt(1000000);
	System.out.println(value);
	System.out.println("value of R"+value);
	pw.println("<h1 style=color:green;text-align:center;>Your Balance :Rs. "+value+"</h1>");
}
@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

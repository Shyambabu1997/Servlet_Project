package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		String name=null;
		String pass=null;
		name=req.getParameter("uname");
		pass=req.getParameter("upass");
		System.out.println(name);
		System.out.println(pass);
		if(name.equalsIgnoreCase("radhe@gmail.com") && pass.equalsIgnoreCase("shyam"))
		{
			pw.println("<h1 style=color:green>Valid Credentials</h1>");
		}
		else
		{
			pw.println("<h1 style=color:red>InValid Credentials</h1>");
		}
		
		pw.println("<a href='login.html'>Home</a>");
		System.out.println("req object class name:"+req.getClass());
		System.out.println("res object class name:"+res.getClass());
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}

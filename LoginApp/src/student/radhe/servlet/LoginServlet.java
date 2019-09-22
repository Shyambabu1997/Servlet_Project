package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw=null;
		String user=null;
		String pass=null;
		String word[];
		pw=res.getWriter();
		res.setContentType("text/html");
		user=req.getParameter("userid");
		pass=req.getParameter("pass");
		int size=pass.length();
		if(size<7)
			pw.println("<h3 style=color:red:text-align:left;>Your password is weak</h3>");
		else
			pw.println("<h3 style=color:blue;text-align:left;>Your password is Strong</h3>");
		word=user.split("");
		for(int i=0;i<word.length;i++)
		{
		}
		
	
	
	
	
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

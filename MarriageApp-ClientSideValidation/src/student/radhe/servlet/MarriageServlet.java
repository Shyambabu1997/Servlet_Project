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
		int age=0;
		char gen=' ';
		pw=res.getWriter();
		res.setContentType("text/html");
		gen=req.getParameter("male").charAt(0);
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		
		if(age>21 && gen=='F')
		pw.println("<h3 style=color:blue;text-align:center;> Congrats "+ name +" You are eligible for marriage ..Think Once Again</h3>" );
		else if(age>21 && gen=='M')
				pw.println("<h3 style=color:blue;text-align:center;> Congrats "+ name +" You are eligible for marriage ..Try to Make Happy others</h3>" );
		else
			pw.println("<h3 style=color:blue;text-align:center;> Sorry"+ name +" You are not eligible for Marriage..Wait </h3>" );
		
		}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doPost(req,res);
	}

}

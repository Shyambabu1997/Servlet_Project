package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<h1 style=color:blue;text-align:center>Form Details are:</h1>");
		String name,add,mstatus=null;
		String when=null;
		String reason=null;
		String age=null;
		name=req.getParameter("f1t1");
		age=req.getParameter("f1t2");
		add=req.getParameter("f1t3");
		mstatus=req.getParameter("f1t4");
		reason=req.getParameter("f2t2");
		when=req.getParameter("f2t1");
		
		pw.println("<b>Form 1"+name+"......"+age+"......"+add+"......."+mstatus+"</b>");
		pw.println("<b>Form 2"+when+"<br>"+reason+"<br>"+"</b><br>");
		pw.println("<a href='form.html'>Home</a>");
		
		pw.close();	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doPost(req, resp);
	}
}

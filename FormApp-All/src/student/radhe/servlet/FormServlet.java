package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String name=null,gender=null,address=null,marrital="single",qualf=null,date=null,color=null;
		String courses[]=null;
		String hobbies[]=null;
		int age=0;
		pw=res.getWriter();
		res.setContentType("text/html");
	
		name=req.getParameter("fname");
		address=req.getParameter("faddress");
		marrital=req.getParameter("fms");
		qualf=req.getParameter("fqual");
		courses=req.getParameterValues("fcour");
		hobbies=req.getParameterValues("fhob");
		gender=req.getParameter("radio");
		age=Integer.parseInt(req.getParameter("fage"));
		date=req.getParameter("fdate");
		color=req.getParameter("color");
		if(gender.equalsIgnoreCase("M"))
		{
			if(age>0 && age<5)
				pw.println("<h1>You are a baby boy</h1>");
			else if(age<12)
				pw.println("<h1>You are a small boy</h1>");
			else if(age<19)
				pw.println("<h1>You are a teenager boy</h1>");
			else if(age<=35)
				pw.println("<h1>You are a young man</h1>");
			else if(age<50)
				pw.println("<h1>You are a middle aged man</h1>");
			else
				pw.println("<h1>You are a budda</h1>");
			
		}
		else if(gender.equalsIgnoreCase("F"))
		{
			if(age>0 && age<5)
				pw.println("<h1>You are a baby girl</h1>");
			else if(age<12)
				pw.println("<h1>You are a small girl</h1>");
			else if(age<19)
				pw.println("<h1>You are a teenager girl</h1>");
			else if(age<=35)
				pw.println("<h1>You are a young woman</h1>");
			else if(age<50)
				pw.println("<h1>You are a middle aged woman</h1>");
			else
				pw.println("<h1>You are a old woman</h1>");
			
		}
		pw.println("<hr>");
		pw.println("<h3 style=color:blue;text-align:left>Your given details are as follows:<br><h3>");
		pw.println("<br> Name	:"+name);
		pw.println("<br> Age	:"+age);
		pw.println("<br> DOB	:"+date);
		pw.println("<br> Address	:"+address);
		pw.println("<br> `Marrital Status	:"+marrital);
		pw.println("<br> Qualification	:"+qualf);
		pw.println("<br> Gender	:"+gender);
		pw.println("<br> Courses	:"+Arrays.toString(courses));
		pw.println("<br> Hobbies	:"+Arrays.toString(hobbies));
		pw.println("<br> Favoraite color	:"+color);
		
		
	}
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

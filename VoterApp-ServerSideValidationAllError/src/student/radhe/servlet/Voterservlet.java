package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Voterservlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	String name=null,fname=null;
	String age=null;
	int page=0;
	pw=res.getWriter();
	ArrayList errList=new ArrayList();
	res.setContentType("text/html");
	
	name=req.getParameter("pname");
	fname=req.getParameter("fname");
	age=req.getParameter("page");
	
	if(name==null || name.equals("") || name.length()==0)
		errList.add("Person name is mandatory");
	if(fname==null || fname.equals("")|| fname.length()==0)
		errList.add("Father name is mandatory");
	if(age==null || age.equals("") || age.length()==0)
		errList.add("Age is mandatory");
	else
	{
		try
		{
		page=Integer.parseInt(age);
		if(page<1 || page>120)
		{
			errList.add("Age Number should not less than 1 or greater than 120");
		}
	}
		catch(NumberFormatException nfe)
		{
			errList.add("Age number must be number type");
		}
	}
	
	if(errList.size()!=0) {
		for(Object msg:errList) {
			pw.println("<h3 style=color:blue;text-align:center;>"+msg.toString()+"</h3>");
			}
			return;
	}
	if(page<18)
		pw.println("<h1 style=color:blue;text-align:center;>"+name+" You are not eligible for vote wait for "+(18-page)+"years"+"</h1");
	else
		pw.println("<h1 style=color:blue;text-align:center;>"+name+"Congrats..!! You are eligible for vote.</h1> ");
	
	
	pw.println("<br><a href='input.html'><img src='homeicon.jpg'></a>");
	pw.close();
	}

	}

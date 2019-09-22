package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SecondServlet() {
    	System.out.println("SecondServlet.SecondServlet()");
    	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		String skill=null;
		int exp=0;
		exp=Integer.parseInt(req.getParameter("fexp"));
		skill=req.getParameter("fskills");
		//locate session object
		HttpSession ses=null;
		ses=req.getSession(false);
		ses.setAttribute("exp", exp);
		ses.setAttribute("skill",skill);
		System.out.println("Session id"+ses.getId());
		
		//create Dynamic form page
		pw.println("<h1 style=color:blue;text-align:center>Naukri Form:3</h1><br>");
		pw.println("<form action= 'thirdurl' method='post'><br>");
		pw.println("<b>Expected Salary:<input type='text' name='fsal'><br>");
		pw.println("Location:<input type='text' name='floc'><br>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='Submit'>");
		pw.println("</form>");
		System.out.println("Thrid form  created");
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}

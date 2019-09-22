package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/furl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		String name=null,age=null,fname=null;
		res.setContentType("text/html");
		//read from data
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		age=req.getParameter("fage");
		//create cookies
		//Create cookies
		Cookie ck1=new Cookie("od",name);
		Cookie ck2=new Cookie("mh",fname);
		Cookie ck3=new Cookie("nd",age);
		
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);
		

		pw.println("Cookies created");
		//create Dynamic form
		pw.println("<h1 style=color:blue;text-align:center>F2:Information about Your Bachelor Life</h1><br>");
		pw.println("<form action= 'secondurl' method='post'><br>");
		pw.println("<b>Income:</b><input type='text' name='income'><br>");
		pw.println("<b>Tax:</b><input type='text' name='tax'><br>");
		pw.println("<input type='submit' name='submit'>");
		pw.println("</form>");
			
	}
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	}

}

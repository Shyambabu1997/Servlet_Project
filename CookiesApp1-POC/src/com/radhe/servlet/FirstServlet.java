package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	PrintWriter pw=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	//Create cookies
	Cookie ck1=new Cookie("od","BBSR");
	Cookie ck2=new Cookie("mh","Maharastra");
	Cookie ck3=new Cookie("nd","NewDelhi");
	Cookie ck4=new Cookie("up","Luckhnow");
	res.addCookie(ck1);
	res.addCookie(ck2);
	
	res.addCookie(ck3);
	res.addCookie(ck4);
	ck3.setMaxAge(1800);
	ck4.setMaxAge(1800);
		pw.println("<h2>Cookies created<h2>");
	
	

	
	}
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

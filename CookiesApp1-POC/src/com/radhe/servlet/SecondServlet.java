package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/secondurl")
	public class SecondServlet extends HttpServlet {


		
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		String s1=null,s2=null,s3=null,s4=null;
		Cookie cookies[]=null;
		cookies=req.getCookies();
		pw.println("<h1>Cookies values</h1>");
		for(Cookie ck:cookies) {
			pw.println("<br>"+ck.getName()+"------->"+ck.getValue());
			
		}
		pw.close();
		}
		

		
		
		public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}

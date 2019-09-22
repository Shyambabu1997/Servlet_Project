package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cubeurl")
public class CubeServlet extends HttpServlet {
  
    public CubeServlet() {
    	System.out.println("CubeServlet.CubeServlet()");
    			}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		int no=0,cube=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		//read form data
		no=Integer.parseInt(req.getParameter("no"));
		cube=no*no*no;
		pw.println("<h1>Square:	"+cube+"</h1>");
	
	}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

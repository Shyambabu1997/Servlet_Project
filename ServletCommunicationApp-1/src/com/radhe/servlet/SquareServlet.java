package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/squareurl")
public class SquareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SquareServlet() {
       System.out.println("SquareServlet:0 param constructor");
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		int no=0,square=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd=null;
		//read form data
		no=Integer.parseInt(req.getParameter("no"));
		square=no*no;
		pw.println("<h1>Square:	"+square+"</h1>");
		//get servlet context of curent webapp
		ServletContext sc1=getServletContext();
		//get servlet context of second webapp
		ServletContext sc2=sc1.getContext("/ServletCommunicationApp-2");
		System.out.println(sc2);
		rd=sc2.getRequestDispatcher("/cubeurl");
		rd.include(req, res);
		//close stream
		pw.close();
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

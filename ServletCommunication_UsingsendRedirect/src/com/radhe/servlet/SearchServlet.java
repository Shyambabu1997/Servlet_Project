package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
      
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		String query=null,engine=null;
		query=req.getParameter("search");
		engine=req.getParameter("enginee");
		String url=null;
		
		if(engine.equalsIgnoreCase("google"))
			url="http://www.google.com/search?q="+query;
		else if(engine.equalsIgnoreCase("yahoo"))
			url="http://www.yahoo.com/search?="+query;
		else if(engine.equalsIgnoreCase("bing"))
		url="http://www.bing.com/search?="+query;
	
	System.out.println("Before searchServlet:sendRedirect(-)");
	res.sendRedirect(url);
	RequestDispatcher rd=req.getRequestDispatcher("form.html");
	rd.include(req, res);
	System.out.println("After searchServlet:sendRedirect(-)");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

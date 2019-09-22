package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/errurl")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ErrorServlet() {
System.out.println("ErrorServlet.ErrorServlet()");
}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//general setting
				PrintWriter pw=null;
				pw=response.getWriter();
				response.setContentType("text/html");
				
				pw.println("<h1>Internal Problem........Try Again</h1>");
				
				pw.println("<a href=form.html>Home</a>");
				pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

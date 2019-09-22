package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FirstServlet() {
        System.out.println("FirstServlet.FirstServlet()");
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		String name=null,address=null;
				int age=0;
		name=req.getParameter("fname");
		address=req.getParameter("fadds");
		age=Integer.parseInt(req.getParameter("fage"));
		HttpSession ses=null;
		ses=req.getSession(true);
		ses.setAttribute("name", name);
		ses.setAttribute("age", age);
		ses.setAttribute("address", address);
		//create Dynamic form page
		pw.println("<h1 style=color:blue;text-align:center>Naukri Form:2</h1><br>");
		pw.println("<form action="+res.encodeURL("secondurl")+" method='post'><br>");
		pw.println("</b>Experience:<input type='text' name='fexp'><br>");
		pw.println("<b>Skills:<select name='fskills'><br>");
		pw.println("<option>--Select--</option><option>Java</option><option>Oracle</option><option>.Net</option><option>UI</option><option>Python</option>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' name='Continue'></b>");
		pw.println("</form>");
		System.out.println("Second form created");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}


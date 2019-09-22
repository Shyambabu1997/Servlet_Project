package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	public static final String query="INSERT INTO COOKIES_PERSON VALUES(COOKIESPNO_SEQ.NEXTVAL,?,?,?,?,?)";
	@Resource(name="jndi")
	private DataSource ds=null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		String name=null,fname=null;
		int age=0,income=0,tax=0;
		Cookie cookies[]=null;
		Connection con=null;
		PreparedStatement ps=null;
		//read data
		income=Integer.parseInt(req.getParameter("income"));
		tax=Integer.parseInt(req.getParameter("tax"));
		
		cookies=req.getCookies();
		name=cookies[0].getValue();
		fname=cookies[1].getValue();
		age=Integer.parseInt(cookies[2].getValue());
		
			try {
				con=ds.getConnection();
				ps=con.prepareStatement(query);
				ps.setString(1, name);
				ps.setString(2, fname);
				ps.setInt(3, age);
				ps.setInt(4,income);
				ps.setInt(5,tax);
				int count=ps.executeUpdate();
				
				if(count==0) {
					pw.println("Person insertion failed");
				}
				else
				{
					pw.println("Person insertion successed");
				}
				pw.println("Both Form Data as follows");
				pw.println("Form 1----->"+name+"     "+fname+"     "+age);
				pw.println("Form 2----->"+income+"   "+tax);
				pw.println("<a href='form.html'>Home</a>");
				pw.close();
				
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

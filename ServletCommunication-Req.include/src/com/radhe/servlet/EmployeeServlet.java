package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


//@WebServlet("/empurl")
public class EmployeeServlet extends HttpServlet {

	Connection con;
	 PreparedStatement ps;
	 private static final String query="SELECT * FROM EMP WHERE EMPNO=?";
	
	@Override
	public void init() throws ServletException {
		 
	   //getting the connection..
	   try {
		con=getConnection();
		//getting PreparedStatement object..
		ps=con.prepareStatement(query);
	   } 
	   catch (Exception e) {
	      e.printStackTrace();	
	   }
		
	 }

	public Connection getConnection() throws Exception {
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:/comp/env/jndi");
		con=ds.getConnection();
		return con;
	}
       
   

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//general setting
		PrintWriter pw=null;
		ResultSet rs=null;
		int empno=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd1=null,rd2=null,rd3=null;
		
		rd1=req.getRequestDispatcher("/header");
		rd1.include(req, res);
		
		//read form data
		empno=Integer.parseInt(req.getParameter("empno"));
		System.out.println(empno);
		try {
			ps.setInt(1, empno);
			rs=ps.executeQuery();
		
		int count=0;
	while(rs.next()) {
		count++;
		pw.println("EmpNo---->"+rs.getString(1));
		pw.println("EmpName-->"+rs.getString(2));
		pw.println("Job	  --->"+rs.getString(3));
		pw.println("Salary--->"+rs.getInt(6));	
		pw.println("DeptNo--->"+rs.getInt(8));
	}
	if(count==0)
		pw.println("<h1>No Records Found</h1>");
	
	//adding the hyperlinks..
	pw.println("<a href='input.html'>home</a>");
	//adding the footer component..
	rd3=req.getRequestDispatcher("footer.html");
	rd3.include(req,res);
	rs.close();
	pw.close();
		}
		
	catch(Exception e)
	{
		
		e.printStackTrace();
		rd2=req.getRequestDispatcher("/errurl");
		rd2.forward(req, res);
	}
		
		
		
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}
		@Override
		public void destroy() {
		
		
		}
		


}

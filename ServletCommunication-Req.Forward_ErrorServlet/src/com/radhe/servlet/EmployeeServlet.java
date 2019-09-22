package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/empurl")
public class EmployeeServlet extends HttpServlet {
	ServletConfig config;
	private static final String query="SELECT * FROM EMP WHERE ENAME=?";
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;


	}
   
    public EmployeeServlet() {
        System.out.println("EmployeeServlet.EmployeeServlet()");
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//general setting
		PrintWriter pw=null;
		pw=response.getWriter();
		response.setContentType("text/html");
		int empno=0;
		String driver=null,url=null,user=null,password=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		RequestDispatcher rd=null;
		
		//read form data
		empno=(Integer.parseInt(request.getParameter("empno")));
		
		driver=config.getInitParameter("driver");
		url=config.getInitParameter("url");
		user=config.getInitParameter("user");
		password=config.getInitParameter("password");
		try {
			Class.forName(driver);	
			con=DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement(query);
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
		}
		catch(Exception e)
		{

			rd=request.getRequestDispatcher("/errurl");
			rd.forward(request, response);
		}
			
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	}

}

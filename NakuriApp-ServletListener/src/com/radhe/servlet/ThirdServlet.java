package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet({ "/ThirdServlet", "/thirdurl" })
public class ThirdServlet extends HttpServlet {
	@Resource(name="jndi")
	private DataSource ds;
	private static final long serialVersionUID = 1L;
	public static final String query="INSERT INTO NAUKRI_APP VALUES(NAUKRI_ID.NEXTVAL,?,?,?,?,?,?,?)";
       
    
    public ThirdServlet() {
        System.out.println("ThirdServlet.ThirdServlet()");
        }

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			
			PrintWriter pw=null;
			pw=res.getWriter();
			res.setContentType("text/html");
			//read form data
			String location=null,name=null,address=null,skill=null;
			int age=0,exp=0;
			float salary=0.0f;
			salary=Float.parseFloat(req.getParameter("fsal"));
			location=req.getParameter("floc");
			
			//locate session object
			HttpSession ses=null;
			ses=req.getSession(false);
			System.out.println("Session id"+ses.getId());
			//read data from session object;
			name=(String)ses.getAttribute("name");
			address=(String)ses.getAttribute("address");
			age=(Integer)(ses.getAttribute("age"));
			exp=(Integer)(ses.getAttribute("exp"));
			skill=(String)(ses.getAttribute("skill"));
			System.out.println("Database connection starts---->");
			Connection con=null;
			PreparedStatement ps=null;
			int count=0;
			//insert form1,form2,form3 data into database
		
			try {
				con=ds.getConnection();
				ps=con.prepareStatement(query);
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, address);
				ps.setString(4,skill);
				ps.setInt(5, exp);
				ps.setString(6, location);
				ps.setFloat(7, salary);
			count=ps.executeUpdate();
			
			if(count==0)
				pw.println("<h1>Registration Failed</h1>");
				else
					pw.println("<h1>Registration Successed</h1>");
			
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				doGet(request, response);
	}

}

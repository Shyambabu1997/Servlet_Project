package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/poolurl")
public class PoolServlet extends HttpServlet {
	
	@Resource(name="jndi")
	private DataSource ds;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
	PrintWriter pw=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	
	int cno=0;
	String cname,cadd=null;
	int billamt=0;
	PreparedStatement ps=null;
	Connection con=null;
	int result=0;
	String QUERY="INSERT INTO customer_registration VALUES(?,?,?,?)";
	//get form data
	cno=Integer.parseInt(req.getParameter("cno"));
	cname=req.getParameter("cname");
	cadd=req.getParameter("cadd");
	billamt=Integer.parseInt(req.getParameter("billamt"));
	System.out.println(billamt);
	try {
		System.out.println("try block");
	con=makeConnection();
	ps=con.prepareStatement(QUERY);
	ps.setString(1,cname);
	ps.setInt(2,cno);
	ps.setString(3,cadd);
	ps.setInt(4,billamt);
	result=ps.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println("PoolServlet.doPost()");
		e.printStackTrace();
	}
	
	finally
	{
		try {
		if(ps!=null)
			ps.close();
		}
	
	catch(SQLException se)
	{
		se.printStackTrace();
	}
		
	}
	if(result!=0)
		pw.println("<h1 style=color:red;text-align:center>Registration Successful</h1>");
	else
	pw.println("<h1 style=color:red;text-align:center>Registration Failed</h1>");
	
	pw.println("<a href='register.html'>Home</a>");
	pw.close();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);	
		
	}
	private Connection makeConnection() 
	{
		Connection con=null;
		try
		{

		 con=ds.getConnection();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return con;
	}

}

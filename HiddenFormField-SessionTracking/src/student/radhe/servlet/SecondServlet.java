package student.radhe.servlet;

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
import javax.sql.DataSource;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public static final String query="INSERT INTO PERSON_INFO VALUES(PID_SEQ.NEXTVAL,?,?,?,?,?,?)";
	@Resource(name="jndi")
	private DataSource ds;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		Connection con=null;
		PreparedStatement ps=null;
		pw.println("<h1 style=color:blue;text-align:center>Form Details are:</h1>");
		String name,add,mstatus=null;
		String when=null;
		String reason=null;
		int age=0;
		name=req.getParameter("hname");
		age=Integer.parseInt(req.getParameter("hage"));
		add=req.getParameter("hadd");
		mstatus=req.getParameter("hms");
		reason=req.getParameter("f2t2");
		when=req.getParameter("f2t1");
		int count=0;
		pw.println("<b>Form 1"+name+"......"+age+"......"+add+"......."+mstatus+"</b>");
		pw.println("<b>Form 2"+when+"<br>"+reason+"<br>"+"</b><br>");
		pw.println("<a href='form.html'>Home</a>");
		try
		{
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3,add);
			ps.setString(4,mstatus);
			ps.setString(5, reason);
			ps.setString(6,when);
			count=ps.executeUpdate();
			pw.println("database lines");
			if(count==0)
			{
				pw.println("registration failed");
				
			}
			else
			{
				pw.println("registration successed");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		finally {
			try{
				if(ps!=null) 
					ps.close();
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try{
				if(con!=null) 
					con.close();
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try{
				if(pw!=null) 
					pw.close();
				
			}
			catch(Exception se)
			{
				se.printStackTrace();
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doPost(req, resp);
	}
}

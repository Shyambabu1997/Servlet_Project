package student.radhe.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException
{
String query="select empno,ename,job,sal  from emp where empno=?";
PrintWriter pw=null;
Connection con=null;
PreparedStatement ps=null;
int empno=0;	
ResultSet rs=null;
pw=res.getWriter();
res.setContentType("text/html");
empno=Integer.parseInt(req.getParameter("empno"));
ServletConfig sc=null;
sc=getServletConfig();
String driver,url,dbuser,dbpass=null;
driver=sc.getInitParameter("driver");
url=sc.getInitParameter("dburl");
dbuser=sc.getInitParameter("dbuser");
dbpass=sc.getInitParameter("dbpass");
try
{
Class.forName(driver);
con=DriverManager.getConnection(url,dbuser,dbpass);
//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Sanil1997");
ps=con.prepareStatement(query);
ps.setInt(1,empno);
rs=ps.executeQuery();
pw.println("<h2 style=color:blue;text-align:center>Employee details are :"+"</h2>");
if(rs.next())
{
pw.println("<br>Employee No.	"+rs.getInt(1));
pw.println("<br>Employee Name	"+rs.getString(2));
pw.println("<br>Employee Desg	"+rs.getString(3));
pw.println("<br>Employee Salary	"+rs.getFloat(4));
}
else{
pw.println("<br><h1>Employee Not Found</h1>");
}
}//end of try
catch(ClassNotFoundException csf)
{
csf.printStackTrace();
}
catch(SQLException se)
{
se.printStackTrace();
}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
try
{
if(rs!=null)
rs.close();
}
catch(SQLException sq)
{
sq.printStackTrace();
}

try
{
if(ps!=null)
ps.close();
}
catch(SQLException sq)
{
sq.printStackTrace();
}

try
{
if(con!=null)
con.close();
}
catch(SQLException sq)
{
sq.printStackTrace();
}
}//end of finally
pw.println("<br><a href='input.html'>Home</a>");

try
{
if(pw!=null)
pw.close();
}
catch(Exception sq)
{
sq.printStackTrace();
}
}//end of doGet(-,-)
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
doPost(req,res);
}//end of doPost(-,-)

}//end of class
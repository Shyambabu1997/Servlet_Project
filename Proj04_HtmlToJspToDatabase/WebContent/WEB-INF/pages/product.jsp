<%@page import="java.sql.*" %>
<%!
Connection con;
PreparedStatement ps1,ps2;
ResultSet rs;
public void jspInit(){

try{
	ServletConfig sc=getServletConfig();
	String driver=null,user=null,pass=null,url=null;
	driver=sc.getInitParameter("driver");
	user=sc.getInitParameter("user");
	pass=sc.getInitParameter("pass");
	url=sc.getInitParameter("url");
Class.forName(driver);
con=DriverManager.getConnection(url,user,pass);

ps1=con.prepareStatement("INSERT INTO PRODUCT_INFO VALUES(PR_ID.NEXTVAL,?,?,?)");//call query name
ps2=con.prepareStatement("SELECT * FROM PRODUCT_INFO");

}
catch(SQLException se){
	se.printStackTrace();
}
catch(ClassNotFoundException ce)
{
ce.printStackTrace();	
}
}

%>
<%
//read special values
String val=request.getParameter("s1");
if(val.equalsIgnoreCase("register")){
	//Read form data
	String name=null;
	float quantity=0.0f;
	double price=0.0;
	name=request.getParameter("fname");
	quantity=Float.parseFloat((request.getParameter("fqnty")));
	price=Double.parseDouble(request.getParameter("fprice"));
	//Set PreparedStatemet object
	ps1.setString(1, name);
	ps1.setFloat(2,quantity);
	ps1.setDouble(3, price);
	int result=ps1.executeUpdate();
	if(result==0){
		%>
		<b>Registration Failed</b>
	<% }
	else{
		%>
		<b>Registration Successed</b>
		<%}
}
else {

rs=ps2.executeQuery();
ResultSetMetaData md=rs.getMetaData();
%>
<table border="1">
<tr>
<%for(int i=1;i<=md.getColumnCount();i++){%>
<th><%=md.getColumnLabel(i)%></th>
<%} %>
</tr>
<% while(rs.next()){ %>
<tr><% for(int i=1;i<=md.getColumnCount();i++){%>
<td><%=rs.getString(i) %>
<%} %>
</tr>
<%}%>
</table>
<%}%>

<a href="form.html">Home</a>
<%! public void jspDestroy(){
	try{
		if(rs!=null)
			rs.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	try{
		if(ps1!=null)
			ps1.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	try{
		if(ps2!=null)
			ps2.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	try{
		if(con!=null)
			con.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
}


%>
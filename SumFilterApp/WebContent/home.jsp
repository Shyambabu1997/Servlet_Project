<h1 style=color:blue;text-align:center>Welcome To Our Webpage</h1>
<form  action="sumurl" method="post">
Value 1:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="val1"><br>
Value 2:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="val2"><br>
&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Add">
</form>
<br>
request:::<%=application.getAttribute("reqCount")%>
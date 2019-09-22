package student.radhe.servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.SingleThreadModel;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class MarkerInterface extends HttpServlet implements SingleThreadModel{  
	public MarkerInterface()
	{
	System.out.println("MarkerInterface():0 param constructor");
	}
	public void init()
	{
		System.out.println("init() method executed");
	}
public void doGet(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    
    out.print("welcome");  
    try{Thread.sleep(10000);}catch(Exception e){e.printStackTrace();}  
    out.print(" to servlet");  
    out.close();  
    }  
} 

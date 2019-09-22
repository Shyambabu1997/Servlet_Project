package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/billurl")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BillServlet() {
    
    	System.out.println("BillServlet.BillServlet()");
    }
        
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//general setting
		PrintWriter pw=null;
		String name=null;
		float price=.0f;
		int quantity=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("fname");
		price=Float.parseFloat(req.getParameter("fprice"));
		quantity=Integer.parseInt(req.getParameter("fquantity"));
		
		if(price>5000) {
			System.out.println("In if condition");
			//res.sendRedirect("http://localhost:3030/ServletCommunication-SendRedirectApp-2/disurl?name="+name+"&quantity="+quantity+"&price="+price);
			res.sendRedirect("http://localhost:3030/ServletCommunication-SendRedirectApp-2/disurl?fname="+name+"&fquantity="+quantity+"&fprice="+price);
		
		
		}
		else{
			pw.println("From Bill Servlet Component");
			pw.println("<b><center>Bill Details");
			pw.println("----------------");
			pw.println("Customer Name:"+name+"<br>");
			pw.println("No of Quantity:"+quantity+"<br>");
			pw.println("Discount:"+"---"+"<br>");
			pw.println("Total Amount:"+price+"</b></center><br>");
			pw.println("<b><a href='form.html'>Home</a></b><br>");
			
			pw.close();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

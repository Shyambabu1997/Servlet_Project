package com.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dis")
public class DiscountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DiscountServlet() {
       System.out.println("DiscountServlet.DiscountServlet()");
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		String name=null;
		float price=0.f,pricenew=0.f,discount=0.0f;
		int quantity=0;
	
		name=req.getParameter("fname");
		price=Float.parseFloat(req.getParameter("fprice"));
		quantity=Integer.parseInt(req.getParameter("fquantity"));
		discount=price*0.3f;
		pricenew=price-discount;
			pw.println("From Bill Servlet Component<br>");
			pw.println("<b><center>Bill Details");
			pw.println("----------------");
			pw.println("Customer Name:"+name+"<br>");
			pw.println("No of Quantity:"+quantity+"<br>");
			pw.println("Total Amount:"+price+"<br>");
			pw.println("Discount:"+discount+"<br>");
			pw.println("Total Amount:"+pricenew+"</b></center><br>");
			pw.println("<b><a href='form.html'>Home</a></b>");
			
			pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package student.radhe.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class InputFilter implements Filter {
	static {
		System.out.println("InputFilter.static block");
	}
	public InputFilter()
	{
		System.out.println("InputFilter() 0 param constructor");
	}
	@Override
	public void init(FilterConfig config)
	{
		System.out.println("InputFilter.init()");
	}
	@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)	throws IOException, ServletException {
	System.out.println("InputFilter.doFilter(-,-,-)");
	PrintWriter pw=null;
	pw=res.getWriter();
	res.setContentType("text/html");
int val1=0;
int val2=0;
val1=Integer.parseInt(req.getParameter("val1"));
val2=Integer.parseInt(req.getParameter("val2"));
if(val1<=0 || val2<=0)
{
	pw.println("<h2 style=color:red;0>Plsss Give Valid Input re bhai</h2>");
}
else
{
	System.out.println("check input before");
	chain.doFilter(req, res);
	System.out.println("check input after");
}
}
@Override
public void destroy()
{
	System.out.println("InputFilter.destroy()");
}
}

package student.radhe.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/*")
public class RequestCountFilter implements Filter {
	int count=0;
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)	throws IOException, ServletException {
	System.out.println("RequestCountFilter.doFilter()");
	count++;
		PrintWriter pw=null;
		ServletContext ct=null;
		pw=res.getWriter();
	res.setContentType("text/html");
	ct=req.getServletContext();
	ct.setAttribute("reqCount",count);
	System.out.println("RCF: before do Filter(-,-)");
	chain.doFilter(req, res);
	System.out.println("RCF: after do Filter(-,-)");
		
	}
	@Override
public void init(FilterConfig config)
{
	
}
	@Override
	public void destroy()
	{
		
	}
}

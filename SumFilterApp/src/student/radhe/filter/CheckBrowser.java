package student.radhe.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class CheckBrowser extends GenericFilter{

 @Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	PrintWriter pw=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	String browser=null;
	browser=((HttpServletRequest)req).getHeader("user-agent");
	System.out.println(browser);
	if(browser.contains("Safari"))
	{
		pw.println("Request must not be given from Safari");
	return;
	}
	else 
	{
		chain.doFilter(req, res);
	}
	
}

	}


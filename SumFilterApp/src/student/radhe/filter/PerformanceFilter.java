package student.radhe.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.GenericFilter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class PerformanceFilter extends GenericFilter {
ServletContext sc=null;
 @Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		sc=config.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long start=0;
		long end=0;
		//sc=getServletContext();
		start=System.currentTimeMillis();
		chain.doFilter(request,response);
		end=System.currentTimeMillis();
		System.out.println(((HttpServletRequest)request).getRequestURI()+ "has taken "+(end-start)+"ms");
	sc.log(((HttpServletRequest)request).getRequestURI()+ "has taken "+(end-start)+"ms");
	}

}

package student.radhe.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class TimeCheckFilter extends GenericFilter {

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=null;
		int hour=0;
		pw=response.getWriter();
		
		response.setContentType("text/html");
		Calendar cal=null;
		cal=Calendar.getInstance();
		hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<9 || hour>17)
		{
			pw.println("Plzzz register in between 9 AM to 4 PM");
		}
		else
		{
			chain.doFilter(request, response);
		}
	}

}

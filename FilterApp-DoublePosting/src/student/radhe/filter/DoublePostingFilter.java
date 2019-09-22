package student.radhe.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter({"/register.jsp","/registerurl"})
public class DoublePostingFilter extends GenericFilter {


	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {	
		HttpServletRequest hreq=null;
		HttpSession ses=null;
		int ctoken=0;
		int stoken=0;
		hreq=(HttpServletRequest)req;
		ses=hreq.getSession();
		if(hreq.getMethod().equalsIgnoreCase("GET"))
		{
			stoken=new Random().nextInt(10000);
		ses.setAttribute("serverToken", stoken);
		chain.doFilter(req, res);
		}
		else {
			stoken=(int)ses.getAttribute("serverToken");
		ctoken=Integer.parseInt(req.getParameter("clientToken"));
		System.out.println(stoken+"...."+ctoken);
		if(stoken==ctoken)
		{
			ses.setAttribute("serverToken", new Random().nextInt(10000));
			chain.doFilter(req, res);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/err.html");
			rd.forward(req,res);
		}
	}
	}
}

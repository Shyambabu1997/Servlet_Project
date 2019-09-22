package student.radhe.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.radhe.wrappers.MyRequest;
import student.radhe.wrappers.MyResponse;

//@WebFilter("/loginurl")
public class LoginFilter extends GenericFilter{
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=null;
		MyRequest myrequest=new MyRequest((HttpServletRequest)req);
		MyResponse myresponse=new MyResponse((HttpServletResponse)res);
		chain.doFilter(myrequest, myresponse);
		String result=myresponse.toString();
		result=result+"By Shyam";
		pw=res.getWriter();
		pw.println(result);

	}

}

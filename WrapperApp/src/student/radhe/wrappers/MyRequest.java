package student.radhe.wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

	HttpServletRequest req;
	public MyRequest(HttpServletRequest req) {
		super(req);
		this.req=req;
		
	}
@Override
public String getParameter(String name) {
	String value=req.getParameter(name);
	if(name.equalsIgnoreCase("uname")) {
		if(!value.endsWith("@gmail.com"))
		{
			return value+"@gmail.com";
		}
	}
	
	return value;
}
}

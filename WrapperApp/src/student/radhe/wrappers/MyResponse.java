package student.radhe.wrappers;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper{
	public MyResponse(HttpServletResponse res) {
		super(res);
		this.res=res;
		writer=new CharArrayWriter();
	}
	private HttpServletResponse res;
	private CharArrayWriter writer;
	
	
	@Override
		public 	PrintWriter getWriter() throws IOException
		{
			PrintWriter pw=new PrintWriter(writer);
			return pw;
		}
	@Override
	public String toString() {
		return writer.toString();
	}
	

	
	

	
	

}

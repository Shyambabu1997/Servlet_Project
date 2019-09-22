package student.radhe.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		 String fname=null;
		 File f=null;
		 InputStream is=null;
		 ServletContext sc=null;
		 String mimeType=null;
		 OutputStream os=null;
		 byte buffer[]=null;
		 
		//creating object of file to locate the file..
		 fname=req.getParameter("file");
		 f=new File("e:/store/"+fname);
			//getting the length of the file and setting as response object..
			 res.setContentLengthLong(f.length());
			 System.out.println("file name"+fname);
			//getting ServletContext object..
			sc=req.getServletContext();
			//getting the mime type of the file...
			mimeType=sc.getMimeType(f.getAbsolutePath());
			res.setContentType(mimeType);
			//make resposnse object as Content-disposition.header..
			 res.addHeader("content-disposition","attatchment;fileName="+f.getName());
			 //create input stream pointing to file
			 is=new FileInputStream(f);
			//create OutputStream pointing to response object..
			 os=res.getOutputStream();
			//place stream based logic to write file content to response object..
			 buffer =new byte[4096];
			 int count=0;
			 while((count=is.read(buffer))!=-1)
			 {
				 os.write(buffer,0,count);
			 }
			is.close();
			os.close();
	
	}
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}

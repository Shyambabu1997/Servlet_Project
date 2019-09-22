package student.radhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

//@WebServlet("/upurl")
public class UpServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		UploadBean bean=null;
		MultipartFormDataRequest nreq=null;
		Hashtable ht=null;
		UploadFile file=null;
		try{
			//prepare special request object
		nreq=new MultipartFormDataRequest(req);
		//specify file uploading bean setting
		bean=new UploadBean();
		bean.setFolderstore("E:\\java");
		bean.setOverwrite(false);
		//complete file uploading
		bean.store(nreq);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//get all upload files
		ht=nreq.getFiles();
		Enumeration e=ht.elements();
		while(e.hasMoreElements())
		{
			file=(UploadFile)e.nextElement();
			pw.println("<br>"+file.getFileName()+"...."+file.getFileSize());
		}
			
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doPost(req, res);
	}
}

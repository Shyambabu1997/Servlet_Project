package com.radhe.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class WebAppAnalyzer implements HttpSessionListener {

	private long start,end;
	
	
    public WebAppAnalyzer() {
    System.out.println("WebAppAnalyzer.WebAppAnalyzer()");
    	
    }

	    public void sessionCreated(HttpSessionEvent se)  { 
        
	    	start=System.currentTimeMillis();
	    	se.getSession().getServletContext().log("Session Started At:"+start);
	    	
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         end=System.currentTimeMillis();
         System.out.println(end);
         se.getSession().getServletContext().log("Session End atL:"+end);
         se.getSession().getServletContext().log("Session has taken "+(end-start)+" ms");
         
    }
	
}

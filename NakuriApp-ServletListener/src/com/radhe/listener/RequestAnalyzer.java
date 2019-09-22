package com.radhe.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


@WebListener
public class RequestAnalyzer implements ServletRequestListener {
	private long start,end;
   
    public RequestAnalyzer() {
        System.out.println("RequestAnalyzer.RequestAnalyzer()");
    }

	
    public void requestDestroyed(ServletRequestEvent sre)  { 
    
    	start=System.currentTimeMillis();
    	ServletContext sc=sre.getServletContext();
    	sc.log(((HttpServletRequest)sre.getServletRequest()).getRequestURL()+"has started at"+new Date());
    	  }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
         end=System.currentTimeMillis();
         ServletContext sc=sre.getServletContext();
     	sc.log(((HttpServletRequest)sre.getServletRequest()).getRequestURL()+"has taken"+(end-start)+"ms");
    }
	
}

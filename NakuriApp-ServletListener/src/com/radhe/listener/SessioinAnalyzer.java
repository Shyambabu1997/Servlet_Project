package com.radhe.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class SessioinAnalyzer implements ServletContextListener {

	private long start,end;
	private ServletContext sc;
	
    public SessioinAnalyzer() {
       
    System.out.println("SessioinAnalyzer.SessioinAnalyzer()");
    
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
   
    start=System.currentTimeMillis();
    sce.getServletContext().log("Web application started at:"+new Date());
    
    
    }    public void contextInitialized(ServletContextEvent sce)  { 
     
    	end=System.currentTimeMillis();
    	
    	sce.getServletContext().log("Web application end at"+end+" has taken"+(end-start)+"ms");
    	
    }
	
}

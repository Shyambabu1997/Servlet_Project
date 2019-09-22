package com.radhe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.radhe.dto.JobSeekerDTO;
import com.radhe.service.JobSeekerService;
import com.radhe.service.JobSeekerServiceImp;

@WebServlet({ "/thirdurl" })
public class ThirdServlet extends HttpServlet {
	@Resource(name="jndi")
	private DataSource ds;
	private static final long serialVersionUID = 1L;
	public static final String query="INSERT INTO NAUKRI_APP VALUES(NAUKRI_ID.NEXTVAL,?,?,?,?,?,?,?)";
       private JobSeekerService service;
    
    public ThirdServlet() {
        System.out.println("ThirdServlet.ThirdServlet()");
        service=new JobSeekerServiceImp();
        }

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			
			PrintWriter pw=null;
			pw=res.getWriter();
			res.setContentType("text/html");
			//read form data
			String location=null,name=null,address=null,skill=null;
			int age=0,exp=0;
			float salary=0.0f;
			salary=Float.parseFloat(req.getParameter("fsal"));
			location=req.getParameter("floc");
			
			//locate session object
			HttpSession ses=null;
			ses=req.getSession(false);
			System.out.println("Session id"+ses.getId());
			//read data from session object;
			name=(String)ses.getAttribute("name");
			address=(String)ses.getAttribute("address");
			age=(Integer)(ses.getAttribute("age"));
			exp=(Integer)(ses.getAttribute("exp"));
			skill=(String)(ses.getAttribute("skill"));
			JobSeekerDTO dto=null;
			//convert to DTO class object
			dto=new JobSeekerDTO();
			dto.setName(name);
			dto.setAddress(address);
			dto.setAge(age);
			dto.setExperience(exp);
			dto.setSalary(salary);
			dto.setLocation(location);
			dto.setSkill(skill);
			
			try {
				String result=service.register(dto);
				pw.println("<h1>"+result+"</h1>");
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				doGet(request, response);
	}

}

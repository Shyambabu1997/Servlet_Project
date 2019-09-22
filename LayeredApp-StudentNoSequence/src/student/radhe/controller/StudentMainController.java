package student.radhe.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.radhe.dto.StudentDTO;
import student.radhe.servlet.StudentService;
import student.radhe.servlet.StudentServiceImp;
import student.radhe.vo.StudentVO;

@WebServlet("/studenturl")
public class StudentMainController extends HttpServlet {

	StudentService stservice;
	@Override
	public void init() throws ServletException {
		stservice =new StudentServiceImp();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//get form data into vo class
		StudentVO vo=new StudentVO();
		vo.setSname(req.getParameter("sname"));
		vo.setM1(Integer.parseInt(req.getParameter("m1")));
		vo.setM2(Integer.parseInt(req.getParameter("m2")));
		vo.setM3(Integer.parseInt(req.getParameter("m3")));
		//Convert inot DTO class object
		StudentDTO dto=new StudentDTO();
		dto.setSname(req.getParameter("sname"));
		dto.setM1(Integer.parseInt(req.getParameter("m1")));
		dto.setM2(Integer.parseInt(req.getParameter("m2")));
		dto.setM3(Integer.parseInt(req.getParameter("m3")));
		
		//use service
		try
		{
			String status=stservice.register(dto);
			pw.println("<h1 style=color:green;text-align:center>"+status+"</h1>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
				doGet(req, resp);

	}
}

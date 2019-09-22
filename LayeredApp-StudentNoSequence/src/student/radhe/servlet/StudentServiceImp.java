package student.radhe.servlet;

import student.radhe.bo.StudentBO;
import student.radhe.dao.StudentDAO;
import student.radhe.dao.StudentDAOImp;
import student.radhe.dto.StudentDTO;

public class StudentServiceImp implements StudentService {

	@Override
	public String register(StudentDTO dto) throws Exception {
		
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentDAO dao=new StudentDAOImp();
		int count=0;
		//write business logic to calculate total,avg,result;
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if((dto.getM1()<35 | dto.getM2()<35 | dto.getM3()<35))
			result="fail";
		else
			result="pass";
		//create BO class object
		StudentBO bo=new StudentBO();
		bo.setSname(dto.getSname());
		bo.setAvg(avg);
		bo.setResult(result);
		bo.setTotal(total);
		//use DAO
		count=dao.insert(bo);
		if(count==0)
			return "Registratioin failed";
		else 
			return "Registration Successed";
	}

}

package com.radhe.service;

import com.radhe.bo.JobSeekerBO;
import com.radhe.dao.JobSeekerDAO;
import com.radhe.dao.JobSeekerDAOImp;
import com.radhe.dto.JobSeekerDTO;

public class JobSeekerServiceImp implements JobSeekerService {
	private JobSeekerDAO dao;
	public JobSeekerServiceImp() {
		dao=new JobSeekerDAOImp();
	}

	@Override
	public String register(JobSeekerDTO dto) throws Exception {
		
		String name=null,address=null,skill=null,location=null;
		int age=0,exp=0;
		float salary=0.f;
		JobSeekerBO bo=null;
		name=dto.getName();
		address=dto.getAddress();
		skill=dto.getSkill();
		location=dto.getLocation();
		age=dto.getAge();
		exp=dto.getExperience();
		salary=dto.getSalary();
		bo=new JobSeekerBO();
		bo.setName(name);
		bo.setAddress(address);
		bo.setAge(age);
		bo.setExperience(exp);
		bo.setSalary(salary);
		bo.setSkill(skill);
		//use dao
		int count=dao.insert(bo);
		if(count==0)
			return "Registraion Failed";
		else
			return "Registration Successed";
		
	}

}

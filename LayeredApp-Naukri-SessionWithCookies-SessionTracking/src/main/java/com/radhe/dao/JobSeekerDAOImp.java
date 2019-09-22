package com.radhe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.radhe.bo.JobSeekerBO;

public class JobSeekerDAOImp implements JobSeekerDAO {
	
	public static final String query="INSERT INTO NAUKRI_APP VALUES(NAUKRI_ID.NEXTVAL,?,?,?,?,?,?,?)";
	private Connection getPooledConnection()  throws Exception {
		Connection con=null;
		InitialContext ic=null;
		ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/comp/env/jndi");
		con=ds.getConnection();
		return con;
	}
	

	@Override
	public int insert(JobSeekerBO bo) throws Exception {
		
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//insert form1,form2,form3 data into database
		String name=null,address=null,skill=null,location=null;
		int age=0,exp=0;
		float salary=0.f;
		name=bo.getName();
		address=bo.getAddress();
		skill=bo.getSkill();
		location=bo.getLocation();
		age=bo.getAge();
		exp=bo.getExperience();
		salary=bo.getSalary();
		
		
		try {
			con=getPooledConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, address);
			ps.setString(4,skill);
			ps.setInt(5, exp);
			ps.setString(6, location);
			ps.setFloat(7, salary);
			count=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}

}

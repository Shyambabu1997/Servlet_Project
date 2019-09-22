package student.radhe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import student.radhe.bo.StudentBO;

public class StudentDAOImp implements StudentDAO {
	
	public final String QUERY="INSERT INTO LAYEREDAPP_STUDENT VALUES(BALIA.NEXTVAL,?,?,?,?)";
	
	private Connection getConnectionPool() throws Exception{
		
		Connection con=null;
		InitialContext ic=null;
		ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/comp/env/jndi");
		con=ds.getConnection();
		return con;
	}
@Override
public int insert(StudentBO bo) throws Exception {
	Connection con=null;
	PreparedStatement ps=null;
	int result=0;
	con=getConnectionPool();
	ps=con.prepareStatement(QUERY);
	ps.setString(1,bo.getSname());
	ps.setInt(2,bo.getTotal());
	ps.setFloat(3,bo.getAvg());
	ps.setString(4, bo.getResult());
	result = ps.executeUpdate();
	
	return result;
}
	

	}


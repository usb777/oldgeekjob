package jUnit.DaoTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.JobStatus_Dao;
import model.JobStatus;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TEST_JobStatus_DAO
{

	JobStatus_Dao jobstatusdao;
	JobStatus jobstatus, jobstatus_check;
	int generatedId;
	boolean willDelete;
	int isUpDated;
	
	
	@Before
	public void setUp() throws Exception
	{
	//	uDAO = new Users_Dao();  // check
      //  user = new Users( 1, "FName","lName",	"Login","email","telefona",2,"pasw" ); //user
		jobstatusdao = new JobStatus_Dao();
		jobstatus.setJs_id(4);
		jobstatus.setName("New status");
		
		jobstatus_check = new JobStatus(1,"enabled");
		
		
	}
	
	
	@Test
	public void test_getJobStatus() throws SQLException, NullPointerException 
	{
		generatedId  = 4;
		
		assertEquals(jobstatus_check.getJs_id(), jobstatus.getJs_id());
		assertEquals(jobstatus_check.getName(), jobstatus.getName());
		
		
	
	}

	

}

package jUnit.DaoTest;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.Jobs_Dao;
import model.Jobs;
import model.States;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TEST_Jobs_Dao 
{
	
	Jobs_Dao jobs_DAO;
	Jobs job, job_check;
	
	int generatedId;
	boolean willDelete;
	int isUpDated;
	
	
	
	@Before
	public void setUp() throws Exception
	{
		jobs_DAO = new Jobs_Dao(); //check
		//states = new States( 1, "moderator" );  //real
		job.setId(1);
		job.setTitle("good job");				
	    job.setCompensation("35K");
	    job.setDescription("good job for you"); 
	    job.setEducation("PHD");
	    job.setResponsibilities(" city in your hand");
	    job.setQualification("super qualification");
	    job.setSkills("boxing , shooting");				
	    job.setU_id(1);
	    job.setJobstatus_id(1);
	    job.setEmploymenttype_id(1);				
	    job.setBenefits("best benefits and dental");
	    job.setContact_info(" we work here");
	//    jobs.setDate_publication(date_publication); 
	    job.setCity("ROchester");
	    job.setState_id(13);
		
	}
	
	
	@Test
	public void test_getJobs() throws SQLException, ClassNotFoundException, IOException 
	{
		if(generatedId==0) 	generatedId = 1;
		List<Jobs> jobs_checks = jobs_DAO.getJobs();
		
		assertThat(jobs_checks, notNullValue());
		for (Jobs jobs1 : jobs_checks) 
		{
			
		
			assertEquals(jobs1.getId(),job.getId() );
			assertEquals(jobs1.getTitle(),job.getTitle());				
			assertEquals(jobs1.getCompensation(), job.getCompensation());
			assertEquals(jobs1.getDescription(), job.getDescription()); 
			assertEquals(jobs1.getEducation(), job.getEducation());
			assertEquals(jobs1.getResponsibilities(), job.getResponsibilities());
			assertEquals(jobs1.getQualification(), job.getQualification());
			assertEquals(jobs1.getSkills(), job.getSkills());				
			assertEquals(jobs1.getU_id(), job.getU_id());
			assertEquals(jobs1.getJobstatus_id(), job.getJobstatus_id());
			assertEquals(jobs1.getEmploymenttype_id(), job.getEmploymenttype_id());				
			assertEquals(jobs1.getBenefits(), job.getBenefits());
			assertEquals(jobs1.getContact_info(), job.getContact_info());
		//    jobs.setDate_publication(date_publication); 
			assertEquals(jobs1.getCity(), job.getCity());
			assertEquals(jobs1.getState_id(), job.getState_id());
			
		}
	}
	
	
	@Test
	public void test_getJobById() throws SQLException, ClassNotFoundException, IOException 
	{
		if(generatedId==0) 	generatedId = jobs_DAO.save(job);
		job_check =jobs_DAO.getJobById(generatedId);
		
		assertEquals(job_check.getId(),is(generatedId) );
		assertEquals(job_check.getTitle(),job.getTitle());				
		assertEquals(job_check.getCompensation(), job.getCompensation());
		assertEquals(job_check.getDescription(), job.getDescription()); 
		assertEquals(job_check.getEducation(), job.getEducation());
		assertEquals(job_check.getResponsibilities(), job.getResponsibilities());
		assertEquals(job_check.getQualification(), job.getQualification());
		assertEquals(job_check.getSkills(), job.getSkills());				
		assertEquals(job_check.getU_id(), job.getU_id());
		assertEquals(job_check.getJobstatus_id(), job.getJobstatus_id());
		assertEquals(job_check.getEmploymenttype_id(), job.getEmploymenttype_id());				
		assertEquals(job_check.getBenefits(), job.getBenefits());
		assertEquals(job_check.getContact_info(), job.getContact_info());
	//    jobs.setDate_publication(date_publication); 
		assertEquals(job_check.getCity(), job.getCity());
		assertEquals(job_check.getState_id(), job.getState_id());
	}
	
	
	@Test
	public void test_getJobsFrontEnd() throws SQLException, ClassNotFoundException, IOException 
	{
		if(generatedId==0) 	generatedId = 1;
		List<Jobs> jobs_checks = jobs_DAO.getJobsFrontEnd();
		
		assertThat(jobs_checks, notNullValue());
		for (Jobs jobs1 : jobs_checks) 
		{
			
		
			assertEquals(jobs1.getId(),job.getId() );
			assertEquals(jobs1.getTitle(),job.getTitle());				
			assertEquals(jobs1.getCompensation(), job.getCompensation());
			assertEquals(jobs1.getDescription(), job.getDescription()); 
			assertEquals(jobs1.getEducation(), job.getEducation());
			assertEquals(jobs1.getResponsibilities(), job.getResponsibilities());
			assertEquals(jobs1.getQualification(), job.getQualification());
			assertEquals(jobs1.getSkills(), job.getSkills());				
			assertEquals(jobs1.getU_id(), job.getU_id());
			assertEquals(jobs1.getJobstatus_id(), job.getJobstatus_id());
			assertEquals(jobs1.getEmploymenttype_id(), job.getEmploymenttype_id());				
			assertEquals(jobs1.getBenefits(), job.getBenefits());
			assertEquals(jobs1.getContact_info(), job.getContact_info());
		//    jobs.setDate_publication(date_publication); 
			assertEquals(jobs1.getCity(), job.getCity());
			assertEquals(jobs1.getState_id(), job.getState_id());
			
		}
	}
	
	
	/**
	 * Test delete method
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Test
	public void test_deleteJob() throws SQLException, ClassNotFoundException, IOException 
	{
		generatedId = jobs_DAO.save(job);
		System.out.println("Generated id = " + generatedId);
		int i=	jobs_DAO.delete(generatedId);
		System.out.println(i);
			System.out.println(generatedId);
			assertEquals(jobs_DAO.getJobById(generatedId),null);
		
	}
	
	@Test
	public void test_saveJob() throws SQLException, ClassNotFoundException, IOException 
	{
		if(generatedId!=0) 	jobs_DAO.delete(generatedId);
		generatedId = jobs_DAO.save(job);
		System.out.println(generatedId);
		job_check = jobs_DAO.getJobById(generatedId);
		
		assertEquals(job_check.getId(),job.getId() );
		assertEquals(job_check.getTitle(),job.getTitle());				
		assertEquals(job_check.getCompensation(), job.getCompensation());
		assertEquals(job_check.getDescription(), job.getDescription()); 
		assertEquals(job_check.getEducation(), job.getEducation());
		assertEquals(job_check.getResponsibilities(), job.getResponsibilities());
		assertEquals(job_check.getQualification(), job.getQualification());
		assertEquals(job_check.getSkills(), job.getSkills());				
		assertEquals(job_check.getU_id(), job.getU_id());
		assertEquals(job_check.getJobstatus_id(), job.getJobstatus_id());
		assertEquals(job_check.getEmploymenttype_id(), job.getEmploymenttype_id());				
		assertEquals(job_check.getBenefits(), job.getBenefits());
		assertEquals(job_check.getContact_info(), job.getContact_info());
	//    jobs.setDate_publication(date_publication); 
		assertEquals(job_check.getCity(), job.getCity());
		assertEquals(job_check.getState_id(), job.getState_id());
		
	}
	
	
	@Test
	public void test_updateJob() throws SQLException, ClassNotFoundException, IOException 
	{
		
		if(generatedId==0) 	generatedId = jobs_DAO.save(job);
	
		job_check = jobs_DAO.getJobById(generatedId);
		System.out.println("testUpdateUserInfo "+generatedId);
		isUpDated = jobs_DAO.update(generatedId,job_check);

		assertEquals(job_check.getId(),job.getId() );
		assertEquals(job_check.getTitle(),job.getTitle());				
		assertEquals(job_check.getCompensation(), job.getCompensation());
		assertEquals(job_check.getDescription(), job.getDescription()); 
		assertEquals(job_check.getEducation(), job.getEducation());
		assertEquals(job_check.getResponsibilities(), job.getResponsibilities());
		assertEquals(job_check.getQualification(), job.getQualification());
		assertEquals(job_check.getSkills(), job.getSkills());				
		assertEquals(job_check.getU_id(), job.getU_id());
		assertEquals(job_check.getJobstatus_id(), job.getJobstatus_id());
		assertEquals(job_check.getEmploymenttype_id(), job.getEmploymenttype_id());				
		assertEquals(job_check.getBenefits(), job.getBenefits());
		assertEquals(job_check.getContact_info(), job.getContact_info());
	//    jobs.setDate_publication(date_publication); 
		assertEquals(job_check.getCity(), job.getCity());
		assertEquals(job_check.getState_id(), job.getState_id());

		assertEquals(isUpDated, 1);
	}
	
	
	
	
	
	
	

}

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

import dao.Profile_Dao;
import dao.Users_Dao;
import model.Profile;
import model.Users;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_Profile_Dao 
{

	Profile_Dao profileDAO;
	Profile profile, profile_check;
	int generatedId;
	boolean willDelete;
	int isUpDated;
	
	@Before
	public void setUp()  throws Exception
	{
		profileDAO = new Profile_Dao();  // check
       // user = new Users( 1, "FName","lName",	"Login","email","telefona",2,"pasw" ); //user
		profile.setP_id(1);
		profile.setU_id(1);
	    profile.setDescription("descriptor");
	    profile.setGithub("github");
	    profile.setLinkedin("Linkedin");
	    profile.setResume_url("MyResume.doc");
		
	}	
	
	@Test 
	public void test_GetProfileByUserId() throws SQLException 
	{
		
		if(generatedId==0) 	generatedId = profileDAO.save(profile.getP_id());
		profile_check = profileDAO.getProfileByUserId(generatedId);
		
		assertEquals(profile_check.getP_id(), profile.getP_id());
		assertEquals(profile_check.getU_id(), profile.getU_id());
		assertEquals(profile_check.getDescription(), profile.getDescription());
		assertEquals(profile_check.getGithub(), profile.getGithub());
		assertEquals(profile_check.getLinkedin(), profile.getLinkedin());
		assertEquals(profile_check.getResume_url(), profile.getResume_url());	
		
	}
	
	@Test 
	public void test_getMaxProfileId() throws SQLException
	{
		
		 int  profile_id = profileDAO.getMaxProfileId();
		 Profile profi_check = profileDAO.getProfileByUserId(profile_id);
		 
	        

	        assertNotNull(profi_check);
	        assertEquals(profile_id,profi_check.getP_id());
		
		
	}
	
	
	
	@Test
	public void test_update() throws SQLException, ClassNotFoundException, IOException 
	{
		if(generatedId==0) generatedId = profileDAO.save(profile.getP_id());
	    profile_check = profileDAO.getProfileByUserId(generatedId);
		System.out.println("testUpdateProfileInfo "+generatedId);
		isUpDated = profileDAO.update(generatedId, profile_check);				

		assertThat(profile_check.getP_id(), is(1));
		assertThat(profile_check.getU_id(), is(1));
		assertThat(profile_check.getDescription(), is("descriptor"));
		assertThat(profile_check.getGithub(), is("github"));
		assertThat(profile_check.getLinkedin(), is("Linkedin")); 
		assertThat(profile_check.getResume_url(), is("MyResume.doc")); 
		
		assertEquals(isUpDated, 1);
	
	}
	
	@Test
	public void test_getProfiles() throws SQLException, ClassNotFoundException, IOException
	{
		if(generatedId==0) generatedId = profileDAO.save(profile.getP_id());
		List<Profile> profiles_checks = profileDAO.getProfiles();
		
		assertThat(profiles_checks, notNullValue());
		for (Profile profiles : profiles_checks) 
		{
			
		
			assertEquals(profiles.getP_id(), profile.getP_id());
			assertEquals(profile_check.getU_id(), profile.getU_id());
			assertEquals(profile_check.getDescription(), profile.getDescription());
			assertEquals(profile_check.getGithub(), profile.getGithub());
			assertEquals(profile_check.getLinkedin(), profile.getLinkedin());
			assertEquals(profile_check.getResume_url(), profile.getResume_url());	
		}
	}
	
	
	
	
}

package jUnit.DaoTest;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.Users_Dao;
import model.Users;
/**
 * 
 */

/**
 * @author Dzmitry Samoila
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TEST_Users_Dao
{
	
	Users_Dao uDAO;
	Users user, u_check;
	int generatedId;
	boolean willDelete;
	int isUpDated;
	
	@Before
	public void setUp()  throws Exception
	{
		uDAO = new Users_Dao();  // check
        user = new Users( 1, "FName","lName",	"Login","email","telefona",2,"pasw" ); //user
	
	}

	

	@Test
	public void testSaveUser() throws SQLException, NullPointerException 
	{
       if(generatedId!=0)		uDAO.delete(generatedId);
		
		
		generatedId = uDAO.save(user);
		
		System.out.println(generatedId);
		
		u_check = uDAO.getUserById(generatedId);
		
		assertEquals(u_check.getU_id(), user.getU_id());
		assertEquals(u_check.getFname(), user.getFname() );
		assertEquals(u_check.getLname(), user.getLname() );
		assertEquals(u_check.getEmail(), user.getEmail());
		assertEquals(u_check.getPassword(), user.getPassword()); 
		assertEquals(u_check.getLogin(), user.getLogin());		
		assertEquals(u_check.getRole_id(), user.getRole_id());		
		assertEquals(u_check.getTelefona(), user.getTelefona());
		
	
	}
	
	
	@Test
	public void test_getUsers() throws SQLException, NullPointerException 
	{
		u_check = uDAO.getUsers().get(0);
						
		assertEquals(u_check.getU_id(), user.getU_id());
		assertEquals(u_check.getFname(), user.getFname() );
		assertEquals(u_check.getLname(), user.getLname() );
		assertEquals(u_check.getEmail(), user.getEmail());
		assertEquals(u_check.getPassword(), user.getPassword()); 
		assertEquals(u_check.getLogin(), user.getLogin());		
		assertEquals(u_check.getRole_id(), user.getRole_id());		
		assertEquals(u_check.getTelefona(), user.getTelefona());
	
	}
	
	
	@Test
	public void test_deleteUser() throws SQLException, NullPointerException
	{
		generatedId = uDAO.save(user);
		System.out.println(generatedId);
		int i=	uDAO.delete(generatedId);
		System.out.println(i);
			System.out.println(generatedId);
			assertEquals(uDAO.getUserById(generatedId),null);
	}
	
	
	@Test
	public void test_updateUser() throws SQLException, NullPointerException
	{
		
		
		if(generatedId==0) 	generatedId = uDAO.save(user);
	
		u_check = uDAO.getUserById(generatedId);
		System.out.println("testUpdateUserInfo "+generatedId);
		isUpDated = uDAO.update(generatedId, u_check );

		assertThat(u_check.getU_id(), is(1));
		assertThat(u_check.getFname(), is("FName"));
		assertThat(u_check.getLname(), is("lName"));
		assertThat(u_check.getLogin(), is("Login"));
		assertThat(u_check.getEmail(), is("email"));
		assertThat(u_check.getTelefona(), is("telefona"));
		assertThat(u_check.getRole_id(), is(2));
		assertThat(u_check.getPassword(), is("pasw"));
		
		
		
		
		//1, "FName","lName",	"Login","email","telefona",2,"pasw"
		assertEquals(isUpDated, 1);
	}
	
	
	

}

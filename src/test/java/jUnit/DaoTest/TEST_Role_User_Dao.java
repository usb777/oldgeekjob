package jUnit.DaoTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.Role_User_Dao;
import dao.Users_Dao;
import model.Role_User;
import model.Users;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TEST_Role_User_Dao
{
	Role_User_Dao roleuser_DAO;
	Role_User roleuser, roleuser_check;
	
	int generatedId;
	boolean willDelete;
	int isUpDated;
	
	
	
	@Before
	public void setUp() throws Exception
	{
		roleuser_DAO = new Role_User_Dao(); //check
		roleuser = new Role_User( 2, "moderator" );  //real
		
	}

	@Test
	public void test_getRoleUsers() throws SQLException, NullPointerException 
	{
		roleuser_check = roleuser_DAO.getRoleUsers().get(2);		
		assertEquals(roleuser_check.getRole_id(), roleuser.getRole_id() );
		assertEquals(roleuser_check.getName(), roleuser.getName() );
	
	}
	
	

}

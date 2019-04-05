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


import dao.States_Dao;
import model.States;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TEST_States_Dao 
{

	States_Dao states_DAO;
	States states, states_check;
	
	int generatedId;
	boolean willDelete;
	int isUpDated;
	
	
	
	@Before
	public void setUp() throws Exception
	{
		states_DAO = new States_Dao(); //check
		//states = new States( 1, "moderator" );  //real
		states.setSt_id(1);
		states.setShortname("AL");
		states.setName("Alabama");
		
		
	}
	
	@Test
	public void test_getStates() throws SQLException, ClassNotFoundException, IOException 
	{
		if(generatedId==0) 	generatedId = 1;
		List<States> states_checks = states_DAO.getStates();
		
		assertThat(states_checks, notNullValue());
		for (States states1 : states_checks) 
		{
			
		
			assertEquals(states1.getSt_id(), states.getSt_id());
			assertEquals(states1.getShortname(), states.getShortname());			
			assertEquals(states1.getName(),states.getName());
			
		}
	
	}
	
	
	
	
}

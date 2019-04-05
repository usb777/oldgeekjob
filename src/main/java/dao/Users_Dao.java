package dao;
/**
 * exemples: (JDBC template)
 *  https://www.mkyong.com/spring/spring-jdbctemplate-querying-examples/
 *  https://www.javatpoint.com/spring-mvc-crud-example
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import model.Jobs;
import model.Users;


public class Users_Dao 
{

JdbcTemplate template;  
 
public void setTemplate(JdbcTemplate template) 
{  
   this.template = template;  
}  	

/**
 * shows all users in the system
 * @return
 */
public List<Users> getUsers()
{  
    return template.query("select * from Users order by u_id",new RowMapper<Users>()
    {  
        public Users mapRow(ResultSet rs, int row) throws SQLException 
        {  
        	Users users=new Users(); 
        	
        	users.setU_id(rs.getInt(1));
        	users.setFname(rs.getString(2));
        	users.setLname(rs.getString(3));
        	users.setLogin(rs.getString(4));
        	users.setEmail(rs.getString(5));
        	users.setTelefona(rs.getString(6));
        	users.setRole_id(rs.getInt(7));
            
        	users.setPassword(rs.getString(8));
            return users;  
        }  
    });  
}



/**
 * shows all users in the system ,except admins
 * @return
 */
public List<Users> getUsersForModerator()
{  
    return template.query("select * from Users where role_id<>1 order by u_id",new RowMapper<Users>()
    {  
        public Users mapRow(ResultSet rs, int row) throws SQLException 
        {  
        	Users users=new Users(); 
        	
        	users.setU_id(rs.getInt(1));
        	users.setFname(rs.getString(2));
        	users.setLname(rs.getString(3));
        	users.setLogin(rs.getString(4));
        	users.setEmail(rs.getString(5));
        	users.setTelefona(rs.getString(6));
        	users.setRole_id(rs.getInt(7));
            
        	users.setPassword(rs.getString(8));
            return users;  
        }  
    });  
}



/**
 * shows all users in the system ,except current User by u_id
 * @return
 */
public List<Users> getUsersExceptById(int user_id)
{  
    return template.query("select * from Users where u_id<>? order by u_id",new Object[] {user_id} ,new RowMapper<Users>()
    {  
        public Users mapRow(ResultSet rs, int row) throws SQLException 
        {  
        	Users users=new Users(); 
        	
        	users.setU_id(rs.getInt(1));
        	users.setFname(rs.getString(2));
        	users.setLname(rs.getString(3));
        	users.setLogin(rs.getString(4));
        	users.setEmail(rs.getString(5));
        	users.setTelefona(rs.getString(6));
        	users.setRole_id(rs.getInt(7));
            
        	users.setPassword(rs.getString(8));
            return users;  
        }  
    });  
}





/**
 * This method checks existing user by Login
 * @param login
 * @return
 */
public boolean isValidLogin(String login)
{  
	
	
	boolean flag = false;
	
	
  int countUsers =  template.queryForObject(" select count(*) from users where login ='"+login+"'   ",Integer.class);
    		
   if (countUsers>0) 
    	{flag = true;}
    else 
    	{flag = false;}
    
    
    return flag;
}


/*TEST*/
public int findTotalModerators()
{
	
	final int ROLE_EMPLOYER = 2;
	String sql = "SELECT COUNT(*) FROM users where role_id = ? ";		
	
	int size_Of_query = template.queryForObject(sql, new Object[] { ROLE_EMPLOYER }, new BeanPropertyRowMapper(Integer.class));
	return size_Of_query;
	
}
/*TEST*/
public int findTotalEmployers()
{
	
	final int ROLE_EMPLOYER = 3;
	String sql = "SELECT COUNT(*) FROM users where role_id = '"+ROLE_EMPLOYER+"' ";		
	
	int size_Of_query = template.queryForObject( sql,  Integer.class );		
	return size_Of_query;
}

/*TEST*/
public int findTotalJobSeekers()
{
	
	final int ROLE_EMPLOYER = 4;
	String sql = "SELECT COUNT(*) FROM users where role_id = '"+ROLE_EMPLOYER+"' ";		
	
	int size_Of_query = template.queryForObject( sql,  Integer.class );		
	return size_Of_query;
	
}




public int save(final Users users)
{  
  /*	
    String sql="INSERT INTO Users (U_ID, FNAME, LNAME, LOGIN, EMAIL, TELEFONA, ROLE_ID, PASSWORD) "
    		+ "VALUES "
    		+ "('"+(getMaxUserId()+1)+"', '"+users.getFname()+"', '"+users.getLname()+"',
    		 '"+users.getLogin()+"', '"+users.getEmail()
    		+"', '"+users.getTelefona()+"', '"+users.getRole_id()+"', '"+users.getPassword()+"')";
    
    return template.update(sql);  
    
    */
	
	 final String INSERT_USER_SQL = 
			 "INSERT INTO Users "
			    + " (U_ID, FNAME, LNAME, LOGIN, EMAIL, TELEFONA, ROLE_ID, PASSWORD) "
	    		+ " VALUES "
	    		+ " (  ?,   ?   ,   ?  ,   ?   ,   ?  ,    ?    ,   ?    ,   ? ) ";
	 
	 final int user_id = getMaxUserId()+1 ;
	 
	 return template.update(new PreparedStatementCreator() 
	    {
		 /*
		    //1	    //2     //3    //4   //5    //6        //7      //8     
		    (U_ID, FNAME, LNAME, LOGIN, EMAIL, TELEFONA, ROLE_ID, PASSWORD) 
		    	*/
	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

	        PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL);
	        
	        statement.setInt(1, user_id);// set parameters you need in your insert
	        statement.setString(2, users.getFname()  );// set parameters you need in your insert
	        statement.setString(3, users.getLname()  );//
	        statement.setString(4, users.getLogin()  );
	        statement.setString(5, users.getEmail()  );
	        statement.setString(6, users.getTelefona() ); 
	        statement.setInt(7, users.getRole_id()  );
	        statement.setString(8, users.getPassword() );
	        
	        return statement;
	    }
	});
    
	 
} 



/**
 * 
 * @param login
 * @return
 */
public Users getUserByLogin(String login)
{ 
	  String sql="select * from Users where login = ?";  
	    return template.queryForObject(sql, new Object[]{login},new BeanPropertyRowMapper<Users>(Users.class));
} 

public Users getUserById(int id)
{  
    String sql="select * from Users where u_id= ? ";  
  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Users>(Users.class));  
}  


/**
 * return max id, used for primary key of table Users 
 * @return
 */
public Integer getMaxUserId()
{
	String sql = "select max(u_id) from users";
		 
	int maxUserId = template.queryForObject(sql, Integer.class);
	
	return maxUserId;
		
}

/**
 * method delete User by id from database
 * @param id
 * @return
 */
public int delete(final int id)
{  
	/*
    String sql="delete from Users where U_id="+id+"";  
    return template.update(sql);  
    */
    
	final String DELETE_USER_SQL="delete from Users where u_id = ?";  
	 
    return template.update(new PreparedStatementCreator() 
    {
      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
      {

        PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);
        
        statement.setInt(1, id);// set parameters you need in your insert
               
        return statement;
    }
}); 
    
    
}

public int update(final int user_id, final Users users)
{  
	
/*	
    String sql="UPDATE USERS "
    		+ "SET FNAME = '"+users.getFname()+"', "
    		+ " LNAME = '"+users.getLname()+"',"
    		+ " LOGIN = '"+users.getLogin()+"',"
    		+ " EMAIL = '"+users.getEmail()+"', "
    		+ " TELEFONA = '"+users.getTelefona()+"', "
    		+ " ROLE_ID = '"+users.getRole_id()+"',"
    		+ " PASSWORD = '"+users.getPassword()+"'"
    		+ " WHERE U_ID='"+id+"'" ; 
    		 
    return template.update(sql);  
    
  */ 
    

	 final String UPDATE_USER_SQL = " UPDATE USERS "
	    		+ "SET FNAME = ?, "    //1
	    		+ " LNAME = ?, "       //2
	    		+ " LOGIN = ?, "       //3
	    		+ " EMAIL = ?, "       //4
	    		+ " TELEFONA = ?, "    //5
	    		+ " ROLE_ID =  ?, "    //6
	    		+ " PASSWORD = ? "     //7
	    		+ " WHERE U_ID = ? " ; //8  
	 
	 
	 
	 return template.update(new PreparedStatementCreator() 
	    {
		 /*
		           //1	    //2   //3    //4    //5       //6        //7      //8     
		    (    FNAME,   LNAME, LOGIN, EMAIL, TELEFONA, ROLE_ID, PASSWORD ,  U_ID 
		    	*/
	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

	        PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);
	        
	       
	        statement.setString(1, users.getFname()  );// set parameters you need in your insert
	        statement.setString(2, users.getLname()  );//
	        statement.setString(3, users.getLogin()  );
	        statement.setString(4, users.getEmail()  );
	        statement.setString(5, users.getTelefona() ); 
	        statement.setInt   (6, users.getRole_id()  );
	        statement.setString(7, users.getPassword() );
	        statement.setInt   (8, user_id);// set parameters you need in your insert 
	        return statement;
	    }
	});
   
    
    
}  

/**
 * This method update Users info without Hashed Password
 * @param user_id
 * @param users
 * @return
 */
public int updateNoPassword(final int user_id, final Users users)
{  
	 final String UPDATE_USER_SQL = " UPDATE USERS "
	    		+ " SET FNAME = ?, "    //1
	    		+ " LNAME = ?, "       //2
	    		+ " LOGIN = ?, "       //3
	    		+ " EMAIL = ?, "       //4
	    		+ " TELEFONA = ?, "    //5
	    		+ " ROLE_ID =  ?, "    //6	    		
	    		+ " WHERE U_ID = ? " ; //7  
	 
	 
	 
	 return template.update(new PreparedStatementCreator() 
	    {
		 /*
		           //1	    //2   //3    //4    //5       //6       //7     
		    (    FNAME,   LNAME, LOGIN, EMAIL, TELEFONA, ROLE_ID,   U_ID 
		    	*/
	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

	        PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);
	        
	       
	        statement.setString(1, users.getFname()  );// set parameters you need in your insert
	        statement.setString(2, users.getLname()  );//
	        statement.setString(3, users.getLogin()  );
	        statement.setString(4, users.getEmail()  );
	        statement.setString(5, users.getTelefona() ); 
	        statement.setInt   (6, users.getRole_id()  );	        
	        statement.setInt   (7, user_id);// set parameters you need in your insert 
	        return statement;
	    }
	});
  
} 
	
	
}

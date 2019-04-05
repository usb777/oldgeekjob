package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import model.Profile;



@Controller
public class Profile_Dao
{

	 
	JdbcTemplate template;  
	 
	public void setTemplate(JdbcTemplate template) 
	{  
	   this.template = template;  
	}  	

	public List<Profile> getProfiles()
	{  
	    return template.query(" select * from Profile order by date_modification ",new RowMapper<Profile>(){  
	        public Profile mapRow(ResultSet rs, int row) throws SQLException {  
	        	Profile profile=new Profile(); 
	        	
	        	
	        	
	        	
	        	profile.setP_id(rs.getInt(1));
	        	profile.setDescription(rs.getString(2));
	        	profile.setU_id(rs.getInt(3));
	        	profile.setLinkedin(rs.getString(4));
	        	profile.setGithub(rs.getString(5));	     		
	        	profile.setResume_url(rs.getString(6));
	        	profile.setDate_modification(rs.getDate(7));
	        	
	          
	            
	            return profile;  
	        }  
	    });  
	}
	
	
	/**
	 * return max id, used for primary key of table Profile 
	 * @return
	 */
	public Integer getMaxProfileId()
	{
		String sql = "select max(p_id) from profile";
			 
		Integer maxProfileId = template.queryForObject(sql, Integer.class);
		
		return maxProfileId;
			
	}	
	
	
	
	/**
	 * Insert new Profile 
	 * @param user_id
	 * @return
	 */
	public int save(int user_id) throws NullPointerException
	{ 
		
		
		final int    profileId = getMaxProfileId()+1;       //1
		final String description = "skills, qualification"; //2
		final int u_id = user_id;                           //3
		final String linkedin = "linkedinurl";              //4
		final String github = "github_url";                 //5
		final String resume_url = "resume_url";             //6
	
		final String SAVEPROFILE_SQL =	"INSERT INTO Profile"
				+ "( p_id,"            //1
				+ "  description, "    //2
				+ "  u_id , "          //3
				+ "  linkedin, "       //4
				+ "  github,"          //5 
				+ "  resume_url,	"  //6
				+ "  date_modification)"  //7
				+ " VALUES "
				+ "(?,?,?,?,?,?,? )";
	  
	  
		  return template.update(new PreparedStatementCreator() 
		    {
		   public PreparedStatement createPreparedStatement(Connection connection) 	throws SQLException 
		     {

		        PreparedStatement statement = connection.prepareStatement(SAVEPROFILE_SQL);
		      
		        statement.setInt(1, profileId  );// set parameters you need in your insert
			    statement.setString(2, description);// set parameters you need in your insert
		        statement.setInt(3, u_id  );// set parameters you need in your insert
		        statement.setString(4, linkedin);// set parameters you need in your insert
		        statement.setString(5, github);// set parameters you need in your insert
		        statement.setString(6, resume_url);// set parameters you need in your insert
		        statement.setDate(7, new java.sql.Date(System.currentTimeMillis()));  //java.sql.Date.valueOf(java.time.LocalDate.now())
		       
		        return statement;
		    }
		});  
			/*	
		    String sql=
		    "INSERT INTO Profile ( p_id, description, u_id , linkedin, github,resume_url,	date_modification) "
		    		+ "VALUES "
		    		+ "("+(lastProfileId)+", 'skills, qualification', " + user_id + " ,'linkedinurl','github_url','resume_url ', TO_DATE('2018-09-22 13:20:07', 'YYYY-MM-DD HH24:MI:SS') )";
		    
		    return template.update(sql);  
		    */  
		  
		  
	} 

	
	public Profile getProfileByUserId(int userID)
	{  
	    String sql="select * from Profile where u_id=?";  
	  
	    return template.queryForObject(sql, new Object[]{userID},new BeanPropertyRowMapper<Profile>(Profile.class));  
	}
	
	

	
	public int update(int p_id, Profile profile)
	{ /* 
	    String sql="UPDATE PROFILE SET "
	    		+ " DESCRIPTION = '"+profile.getDescription()+"', "
	    		+ " U_ID = '"+profile.getU_id()+"',"
	    		+ " LINKEDIN = '"+profile.getLinkedin()+"', "
	    		+ " GITHUB = '"+profile.getGithub()+"', "
	    		+ " RESUME_URL = '"+profile.getResume_url()+"',"
	    		+ " DATE_MODIFICATION = TO_DATE('2018-09-20 23:07:53','YYYY-MM-DD HH24:MI:SS') "
	    		+ " WHERE P_ID = '"+profile.getP_id()+"'    " ; 
	    		 
	    return template.update(sql); 
	    */
	    
	    final String description = profile.getDescription(); //1
	    final int u_id = profile.getU_id();                  //2
	    final String linkedin = profile.getLinkedin();       //3
	    final String github = profile.getGithub();           //4
	    final String resume_url = profile.getResume_url();   //5
	    
	    final int profile_id = profile.getP_id();
	    
		
	    /* Safety Sql query */
		final String UPDATE_PROFILE_SQL = 
				                  "UPDATE PROFILE SET  "
				                + " DESCRIPTION = ?, "     //1
					    		+ " U_ID = ?, "            //2   
					    		+ " LINKEDIN = ?, "        //3
					    		+ " GITHUB = ?, "          //4   
					    		+ " RESUME_URL = ?, "      //5
					    		+ " DATE_MODIFICATION = ? "  //6
					    		+ " WHERE P_ID = ?" ;        //7
	    return template.update(new PreparedStatementCreator() 
	    {
	   public PreparedStatement createPreparedStatement(Connection connection) 	throws SQLException 
	     {

	        PreparedStatement statement = connection.prepareStatement(UPDATE_PROFILE_SQL);
	        
	        statement.setString(1, description);// set parameters you need in your insert
	        statement.setInt(2, u_id  );// set parameters you need in your insert
	        statement.setString(3, linkedin);// set parameters you need in your insert
	        statement.setString(4, github);// set parameters you need in your insert
	        statement.setString(5, resume_url);// set parameters you need in your insert
	        statement.setDate(6, new java.sql.Date(System.currentTimeMillis()));  //java.sql.Date.valueOf(java.time.LocalDate.now())
	        statement.setInt(7, profile_id  );// set parameters you need in your insert
	        
	        
	       
	        
	       
	        
	        return statement;
	    }
	});   
	    
	    
	    
	    
	} 

	public int updateResumeUrl(final String resume_url, final int u_id)
	{
	final String SQL_UpdateProfileResumeUrl = 	
		" UPDATE PROFILE SET "+ 
		" RESUME_URL = ? ,"+ 
		" DATE_MODIFICATION = ? "+ 
		" WHERE U_ID = ? ";

	return template.update(new PreparedStatementCreator() 
	{
		
	    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
	{

	    PreparedStatement statement = connection.prepareStatement(SQL_UpdateProfileResumeUrl);
	    
	   
	    statement.setString(1, resume_url);           
	      statement.setDate(2, new java.sql.Date(System.currentTimeMillis()));	   
	       statement.setInt(3, u_id );
	   System.out.println(new java.sql.Date(System.currentTimeMillis()));
	    return statement;
	}
	});
		
	}
	 
	
	

	
	
}

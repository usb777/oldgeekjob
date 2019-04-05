package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import model.JobAssignment;

public class JobAssignment_Dao
{
	
	JdbcTemplate template;  
	 
	public void setTemplate(JdbcTemplate template) 
	{  
	   this.template = template; 
	   
	}  	

	public List<JobAssignment> getAssignmentJobs(int user_id)
	{  
		 // new Object[]{user_id}  equal    Object[] parameter = {user_id}
		
	    return template.query("select " + 
	    		" ja.ja_id, " +    //1
	    		" ja.job_id, " +   //2
	    		" ja.u_id, " +   //3
	    		" ja.date_assignment, " +  //4
	    		" jobs.title AS job_title, " +   //5
	    		" jobseeker.login as jobseeker, " +   //6
	    		" jobs.date_publication as job_postdate, " +  //7 
	    		" employer.login as employer  " +  //8
	    		" FROM Job_Assignment ja " +   
	    		" JOIN JOBS jobs on jobs.id = ja.job_id " + 
	    		" JOIN USERS jobseeker on jobseeker.u_id = ja.u_id " + 
	    		" JOIN Users employer on employer.u_id = jobs.u_id " + 
	    		" WHERE jobs.jobstatus_id = 1 and jobseeker.u_id = ? ", new Object[]{user_id},new RowMapper<JobAssignment>()
	    {  
	        public JobAssignment mapRow(ResultSet rs, int row) throws SQLException 
	        {  
	        	JobAssignment job_assignment=new JobAssignment(); 
	        	
	        	
	        	        	
	        	job_assignment.setJa_id(rs.getInt(1));
	        	job_assignment.setJob_id(rs.getInt(2));
	        	job_assignment.setU_id(rs.getInt(3));
	        	job_assignment.setDate_assignment(rs.getDate(4));
	        	job_assignment.setJob_title(rs.getString(5));
	        	job_assignment.setJobseeker(rs.getString(6));
	        	job_assignment.setJob_postdate(rs.getDate(7));
	        	job_assignment.setEmployer(rs.getString(8));
	        	
	            return job_assignment;  
	        }  
	    });  
	}	
	

/**
 * method delete Job by id from database
 * @param id
 * @return
 */
public int delete(final int id)
{  
    final  String DELETE_AJOB_SQL = "delete from Job_Assignment where ja_id = ?";
    
    return template.update(new PreparedStatementCreator() 
    {
      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
      {

        PreparedStatement statement = connection.prepareStatement(DELETE_AJOB_SQL);
        
        statement.setInt(1, id);// set parameters you need in your insert
               
        return statement;
    }
});  
    
    
    
    
    
    
}

public int save(final int job_id, final int user_id)
{

  final int ja_id = getMaxJobAssignmentId()+1;   // parameter 1	
	
  final  String INSERT_AJOB_SQL = "INSERT INTO JOB_ASSIGNMENT (JA_ID, JOB_ID, U_ID, DATE_ASSIGNMENT)"
  		+ " VALUES (?, ?, ?, ?)";
	    
	    return template.update(new PreparedStatementCreator() 
	    {
	      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
	      {

	        PreparedStatement statement = connection.prepareStatement(INSERT_AJOB_SQL);
	        
	        statement.setInt(1, ja_id);// set parameters you need in your insert
	        statement.setInt(2, job_id);// set parameters you need in your insert
	        statement.setInt(3, user_id);// set parameters you need in your insert
	       statement.setDate(4, new java.sql.Date(System.currentTimeMillis())); 
	        
	        
	        
	        return statement;
	    }
	});  
	    
	
	
}

/**
 * return max id, used for primary key of table Profile 
 * @return
 */
public Integer getMaxJobAssignmentId()
{
	String sql = "select max(JA_ID) from JOB_ASSIGNMENT";
		 
	Integer maxJobAssignmentId = template.queryForObject(sql, Integer.class);
	
	return maxJobAssignmentId;
		
}

public boolean checkAssignment(int job_id, int user_id )
{
   
    	boolean flag = false;
	
	
    int countAssignmentJob =  template.queryForObject(" select count(*) from JOB_ASSIGNMENT where job_id='"+job_id+"'"
    		+ " and u_id='"+user_id+"' ",Integer.class);
    		
   if (countAssignmentJob>0) 
    	{flag = true;}
    else 
    	{flag = false;}    
    
    return flag; 
    
    
    
}



}

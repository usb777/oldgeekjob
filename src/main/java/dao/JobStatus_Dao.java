package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.JobStatus;


public class JobStatus_Dao 
{
	JdbcTemplate template;  
	 
	public void setTemplate(JdbcTemplate template) 
	{  
	   this.template = template;  
	} 
	
	
	/**
	 * method create List of all records from Job_Status table 
	 * @return
	 */
	public List<JobStatus> getJobStatus()
	{  
	    return template.query("select * from Job_Status order by js_id",new RowMapper<JobStatus>()
	    {  
	        public JobStatus mapRow(ResultSet rs, int row) throws SQLException
	        {  
	        	JobStatus jobstatus = new JobStatus();    
	     	      	 
	        	 jobstatus.setJs_id(rs.getInt(1));
	        	 jobstatus.setName(rs.getString(2));
	            return jobstatus;  
	        }  
	    });  
	}
	
	
}

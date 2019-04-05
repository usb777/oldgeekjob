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

import model.Jobs;


public class Jobs_Dao 
{


JdbcTemplate template;  
private static final String SQL_ALLJOBS = "select jobs.id, " + 
		"    jobs.education, " + 
		"	jobs.responsibilities, " + 
		"	jobs.qualification, " + 
		"	jobs.skills, " + 
		"	jobs.u_id, " + 
		"	jobs.jobstatus_id, " + 
		"	jobs.employmenttype_id, " + 
		"	jobs.benefits, " + 
		"	jobs.contact_info, " + 
		"	jobs.date_publication, " + 
		"	jobs.city, " + 
		"	jobs.state_id , " + 
		"    u.login AS user_login, " + 
		"    js.name AS jobstatus_name, " + 
		"    et.name as employmenttype_name, " + 
		"    st.name as state_name " + 
		" from Jobs jobs " + 
		" Join users u on u.u_id = jobs.u_id " + 
		" Join job_status js on js.js_id = jobs.jobstatus_id " + 
		" Join employment_type et on et.et_id = jobs.employmenttype_id " + 
		" Join states st on st.st_id = jobs.state_id " + 
		" order by date_publication ";
 
public void setTemplate(JdbcTemplate template) 
{  
   this.template = template;  
}  	


/**
 * show all jobs on FrontEnd Page
 * @return list of all jobs
 */
public List<Jobs> getJobsFrontEnd()
{  
    return template.query("select * from jobs where Jobstatus_id = 1    order by Date_publication ",new RowMapper<Jobs>()
    {  
        public Jobs mapRow(ResultSet rs, int row) throws SQLException
        {  
        	Jobs jobs = new Jobs();       	
        	
     	
        	 jobs.setId(rs.getInt(1)) ;        		
        	 jobs.setTitle(rs.getString(2)) ;        		
        	 jobs.setCompensation(rs.getString(3)) ;
        	 jobs.setDescription(rs.getString(4)) ;
        	 jobs.setEducation(rs.getString(5)) ;
        	 jobs.setResponsibilities(rs.getString(6)) ;
        	 jobs.setQualification(rs.getString(7));
        	 jobs.setSkills(rs.getString(8)) ;
        	 jobs.setU_id(rs.getInt(9));
        	 jobs.setJobstatus_id(rs.getInt(10)) ;        		 
        	 jobs.setEmploymenttype_id(rs.getInt(11));        	
        	 jobs.setBenefits(rs.getString(12)) ;        	
        	 jobs.setContact_info(rs.getString(13)) ;
        	 jobs.setDate_publication( rs.getDate(14)) ;        	 
        	 jobs.setCity(rs.getString(15));        	 
        	 jobs.setState_id(rs.getInt(16));
           /* 
        	 jobs.setUser_login(rs.getString(17));
             jobs.setState_name(rs.getString(18));
             jobs.setEmploymenttype_name(rs.getString(19));
             jobs.setState_name(rs.getString(20));
             */
             
            return jobs;  
        }  
    });  
} 



public List<Jobs> getJobs()
{  
    return template.query("select * from jobs  order by id",new RowMapper<Jobs>()
    {  
        public Jobs mapRow(ResultSet rs, int row) throws SQLException
        {  
        	Jobs jobs = new Jobs();       	
        	
     	
        	 jobs.setId(rs.getInt(1)) ;        		
        	 jobs.setTitle(rs.getString(2)) ;        		
        	 jobs.setCompensation(rs.getString(3)) ;
        	 jobs.setDescription(rs.getString(4)) ;
        	 jobs.setEducation(rs.getString(5)) ;
        	 jobs.setResponsibilities(rs.getString(6)) ;
        	 jobs.setQualification(rs.getString(7));
        	 jobs.setSkills(rs.getString(8)) ;
        	 jobs.setU_id(rs.getInt(9));
        	 jobs.setJobstatus_id(rs.getInt(10)) ;        		 
        	 jobs.setEmploymenttype_id(rs.getInt(11));        	
        	 jobs.setBenefits(rs.getString(12)) ;        	
        	 jobs.setContact_info(rs.getString(13)) ;
        	 jobs.setDate_publication( rs.getDate(14)) ;        	 
        	 jobs.setCity(rs.getString(15));        	 
        	 jobs.setState_id(rs.getInt(16));
           /* 
        	 jobs.setUser_login(rs.getString(17));
             jobs.setState_name(rs.getString(18));
             jobs.setEmploymenttype_name(rs.getString(19));
             jobs.setState_name(rs.getString(20));
             */
             
            return jobs;  
        }  
    });  
} 
	


public List<Jobs> getJobsWithShortDescriptions()
{  
    return template.query("select * from jobs order by id ",new RowMapper<Jobs>()
    {  
        public Jobs mapRow(ResultSet rs, int row) throws SQLException
        {  
        	Jobs jobs = new Jobs();       	
        	
     	util.Utilit utility = new util.Utilit();
     	
        	 jobs.setId(rs.getInt(1)) ;        		
        	 jobs.setTitle(rs.getString(2)) ;        		
        	 jobs.setCompensation(rs.getString(3)) ;
        	 
        	 
        	 jobs.setDescription( utility.shortDescription(rs.getString(4), 15)     ) ;
        	 
        	 
        	 jobs.setEducation(rs.getString(5)) ;
        	 
        	 jobs.setResponsibilities(utility.shortDescription(rs.getString(6),15)) ;
        	 
        	 jobs.setQualification(utility.shortDescription(rs.getString(7),15) );
        	 
        	 
        	 jobs.setSkills(utility.shortDescription( rs.getString(8),15) ) ;
        	 
        	 
        	 jobs.setU_id(rs.getInt(9));
        	 jobs.setJobstatus_id(rs.getInt(10)) ; 
        	 jobs.setEmploymenttype_id(rs.getInt(11));  
        	 
        	 
        	 
        	 jobs.setBenefits(utility.shortDescription(rs.getString(12),15)) ;   
        	 
        	 
        	 jobs.setContact_info(rs.getString(13)) ;
        	 
        	 
        	 jobs.setDate_publication( rs.getDate(14)) ;        	 
        	 jobs.setCity(rs.getString(15));        	 
        	 jobs.setState_id(rs.getInt(16));
           /* 
        	 jobs.setUser_login(rs.getString(17));
             jobs.setState_name(rs.getString(18));
             jobs.setEmploymenttype_name(rs.getString(19));
             jobs.setState_name(rs.getString(20));
             */
             
            return jobs;  
        }  
    });  
} 
	




/**
 * method return Jobs Object by ID with all fields
 * @param id
 * @return
 */
public Jobs getJobById(int id)
{   // Object parameter = new Object[]{id};
    String sql="select * from Jobs where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Jobs>(Jobs.class));  
} 

/**
 * method return Jobs Object by ID with all fields
 * @param id
 * @return
 */
public int getUserIdByJobidFromJobs(int id)
{  
    String sql="select u_id from Jobs where id='"+id+"'";  
    return template.queryForObject(sql, Integer.class);  
} 


/**
 * This method return number of jobs in system
 * @return
 */
public int getTotalJobs()
{
	
	
	String sql = "SELECT COUNT(*) FROM Jobs ";		
	int totalJobs = template.queryForObject( sql,  Integer.class );		
	return totalJobs;
}


/**
 * This method return number of Active jobs in system
 * @return
 */
public int getTotalActiveJobs()
{
	
	String sql = "SELECT count(*) FROM Jobs where jobstatus_id = 1";		
	int totalActiveJobs = template.queryForObject( sql,  Integer.class );		
	return totalActiveJobs;
}

/**
 * method Update Job data
 * @param id is Job id
 * @param jobs  insert Job object instance
 * @return  
 */
public int update(final int id, final Jobs jobs)
{  
	
	
    
	final String UPDATE_JOB_SQL="UPDATE JOBS " + 
			"SET TITLE = ?, " +  //1
			"COMPENSATION = ?, " + //2
			"DESCRIPTION = ?, " +  //3
			"education = ?, " + //4
			"RESPONSIBILITIES = ?, " + //5
			"QUALIFICATION = ?, " +  //6
			"SKILLS = ?, " +   //7
			"U_ID = ?, " +  //8
			"JOBSTATUS_ID = ?, " + //9 
			"EMPLOYMENTTYPE_ID = ?, " + //10 
			"BENEFITS = ?, " +  //11
			"CONTACT_INFO = ?, " + //12
			"DATE_PUBLICATION = ?, " + //13
			"CITY = ?, " +    //14
			"STATE_ID = ? " +   //15
			" WHERE id = ?" ; //16
	
	
return template.update(new PreparedStatementCreator() 
{
	/*
//1	  //2     //3           //4         //5         //6                //7                         
(ID, TITLE, COMPENSATION, DESCRIPTION, EDUCATION, RESPONSIBILITIES, QUALIFICATION, 
//8      //9     //10          //11              /12       //13 
SKILLS, U_ID, JOBSTATUS_ID, EMPLOYMENTTYPE_ID, BENEFITS, CONTACT_INFO,
  //14              //15   //16
  DATE_PUBLICATION, CITY, STATE_ID) 
	*/
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

    PreparedStatement statement = connection.prepareStatement(UPDATE_JOB_SQL);
    
   
    statement.setString(1, jobs.getTitle());           
    statement.setString(2,jobs.getCompensation()  );
    statement.setString(3, jobs.getDescription()  );
    statement.setString(4, jobs.getEducation()  );    
    statement.setString(5,jobs.getResponsibilities()  );
    statement.setString(6, jobs.getQualification()  );
    statement.setString(7, jobs.getSkills()  );
    statement.setInt(8, jobs.getU_id() );
    statement.setInt(9, jobs.getJobstatus_id() );
    statement.setInt(10, jobs.getEmploymenttype_id() );
    statement.setString(11, jobs.getBenefits()  );
    statement.setString(12, jobs.getContact_info()  );  
    statement.setDate(13, new java.sql.Date(System.currentTimeMillis())); 
    statement.setString(14, jobs.getCity()  );
    statement.setInt(15, jobs.getState_id() );
    statement.setInt(16, id );
    return statement;
}
});
    
}

public Integer getMaxJobsId()
{
	String sql = "select max(id) from jobs";
		 
	Integer maxJobsId = (Integer)template.queryForObject(sql,  Integer.class);
	
	return maxJobsId;
		
}

/**
 * method delete Job by id from database
 * @param id
 * @return
 */
public int delete(final int id)
{ /* 
    String sql="delete from Jobs where id="+id+"";  
    return template.update(sql); 
    */
	final String DELETE_JOB_SQL = "delete from Jobs where id = ?";
    
    return template.update(new PreparedStatementCreator() 
    {
      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
      {

        PreparedStatement statement = connection.prepareStatement(DELETE_JOB_SQL);
        
        statement.setInt(1, id);// set parameters you need in your insert
               
        return statement;
    }
});
}


public int save(final Jobs jobs)
{  
	
	// to_date('1998/05/31:12:00:00AM', 'yyyy/mm/dd:hh:mi:ssam')
 
	
final String INSERT_JOB_SQL = "INSERT INTO JOBS \r\n" + 
		" ( ID, TITLE, COMPENSATION, DESCRIPTION, EDUCATION, RESPONSIBILITIES, "
		+ " QUALIFICATION, SKILLS, U_ID, JOBSTATUS_ID, EMPLOYMENTTYPE_ID, BENEFITS, "
		+ " CONTACT_INFO, DATE_PUBLICATION, CITY, STATE_ID) " + 
		" VALUES " + 
		" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "	;

final int job_id = this.getMaxJobsId()+1;  // job id with increment of last index
 
/*

	String sql="INSERT INTO JOBS "  
			+"(ID, "                 //1
			+ "TITLE, "              //2
			+ "COMPENSATION, "       //3
			+ "DESCRIPTION, "        //4
			+ "EDUCATION, "          //5 
			+ "RESPONSIBILITIES, "   //6
			+ "QUALIFICATION,"       //7
			+ " SKILLS,"             //8
			+ " U_ID, "              //9
			+ "JOBSTATUS_ID,"        //10
			+ " EMPLOYMENTTYPE_ID,"  //11 
			+ " BENEFITS, "          //12
			+ "CONTACT_INFO, "       //13 
			+ "DATE_PUBLICATION, "   //14
			+ "CITY, "               //15 
			+ "STATE_ID) " +         //16
		"VALUES " + 
			"('"+ (this.getMaxJobsId()+1)+"', "
			+ "'"+jobs.getTitle()+"', "
			+ "'"+jobs.getCompensation()+"', "
			+ "'"+jobs.getDescription()+"', "
			+ "'"+jobs.getEducation()+"', "
			+ "'"+jobs.getResponsibilities()+"', "
			+ "'"+jobs.getQualification()+"', "
			+ "'"+jobs.getSkills()+"', "
			+ "'"+jobs.getU_id()+"', "
			+ "'"+jobs.getJobstatus_id()+"', "
			+ "'"+jobs.getEmploymenttype_id()+"', "
			+ "'"+jobs.getBenefits()+"', "
			+ "'"+jobs.getContact_info()+"', "
			+ "TO_DATE('2018-09-15 13:20:07', 'YYYY-MM-DD HH24:MI:SS'), "
			+ "'"+jobs.getCity()+"', "
			+ "'"+jobs.getState_id()+"') ";
    

    return template.update(sql); 
    
  */  
return template.update(new PreparedStatementCreator() 
{
	/*
//1	  //2     //3           //4         //5         //6                //7                         
(ID, TITLE, COMPENSATION, DESCRIPTION, EDUCATION, RESPONSIBILITIES, QUALIFICATION, 
//8      //9     //10          //11              /12       //13 
SKILLS, U_ID, JOBSTATUS_ID, EMPLOYMENTTYPE_ID, BENEFITS, CONTACT_INFO,
  //14              //15   //16
  DATE_PUBLICATION, CITY, STATE_ID) 
	*/
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

    PreparedStatement statement = connection.prepareStatement(INSERT_JOB_SQL);
    
    statement.setInt(1, job_id);// set parameters you need in your insert
    statement.setString(2, jobs.getTitle());//
    statement.setString(3,jobs.getCompensation()  );
    statement.setString(4, jobs.getDescription()  );
    statement.setString(5, jobs.getEducation()  );    
    statement.setString(6,jobs.getResponsibilities()  );
    statement.setString(7, jobs.getQualification()  );
    statement.setString(8, jobs.getSkills()  );
    statement.setInt(9, jobs.getU_id() );
    statement.setInt(10, jobs.getJobstatus_id() );
    statement.setInt(11, jobs.getEmploymenttype_id() );
    statement.setString(12, jobs.getBenefits()  );
    statement.setString(13, jobs.getContact_info()  );  
    statement.setDate(14, new java.sql.Date(System.currentTimeMillis())); 
    statement.setString(15, jobs.getCity()  );
    statement.setInt(16, jobs.getState_id() );
    
    return statement;
}
});

}



//======================================3. Employer part=========================================





public List<Jobs> getJobsWithShortDescriptionsForEmployer(int employer_id)
{  
    return template.query(" select * from jobs  where u_id = '"+employer_id+"' order by id ",new RowMapper<Jobs>()
    {  
        public Jobs mapRow(ResultSet rs, int row) throws SQLException
        {  
        	Jobs jobs = new Jobs();       	
        	
     	util.Utilit utility = new util.Utilit();
     	
        	 jobs.setId(rs.getInt(1)) ;        		
        	 jobs.setTitle(rs.getString(2)) ;        		
        	 jobs.setCompensation(rs.getString(3)) ;        	 
        	 
        	 jobs.setDescription( utility.shortDescription(rs.getString(4), 15)     ) ; 
        	 jobs.setEducation(rs.getString(5)) ;
        	 jobs.setResponsibilities(utility.shortDescription(rs.getString(6),15)) ;
        	 jobs.setQualification(utility.shortDescription(rs.getString(7),15) );
        	 jobs.setSkills(utility.shortDescription( rs.getString(8),15) ) ;
        	 jobs.setU_id(rs.getInt(9));
        	 jobs.setJobstatus_id(rs.getInt(10)) ; 
        	 jobs.setEmploymenttype_id(rs.getInt(11));  
        	 jobs.setBenefits(utility.shortDescription(rs.getString(12),15)) ;   
        	 jobs.setContact_info(rs.getString(13)) ;
        	 jobs.setDate_publication( rs.getDate(14)) ;        	 
        	 jobs.setCity(rs.getString(15));        	 
        	 jobs.setState_id(rs.getInt(16));
           /* 
        	 jobs.setUser_login(rs.getString(17));
             jobs.setState_name(rs.getString(18));
             jobs.setEmploymenttype_name(rs.getString(19));
             jobs.setState_name(rs.getString(20));
             */
             
            return jobs;  
        }  
    });  
} 
//===============================end Employer part=============================================================















	
}




























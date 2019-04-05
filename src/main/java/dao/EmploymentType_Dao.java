package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.EmploymentType;


public class EmploymentType_Dao
{

  
JdbcTemplate template;  
 
public void setTemplate(JdbcTemplate template) 
{  
   this.template = template;  
}  	

public List<EmploymentType> getEmpTypes()
{  
    return template.query("select * from Employment_Type order by et_id ",new RowMapper<EmploymentType>()
    {  
        public EmploymentType mapRow(ResultSet rs, int row) throws SQLException {  
        	EmploymentType emptype=new EmploymentType(); 
        	
        	
        	emptype.setEt_id(rs.getInt(1));
        	emptype.setName(rs.getString(2));
            return emptype;  
        }  
    });  
} 
	
}

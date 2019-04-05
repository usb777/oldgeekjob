package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.States;

public class States_Dao 
{


JdbcTemplate template;  
 
public void setTemplate(JdbcTemplate template) 
{  
   this.template = template;  
}  	

public List<States> getStates()
{  
    return template.query("select * from States order by name",new RowMapper<States>()
    {  
        public States mapRow(ResultSet rs, int row) throws SQLException 
        {  
        	States states=new States(); 
        	
              	
        	states.setSt_id(rs.getInt(1));
        	states.setShortname(rs.getString(2));
        	states.setName(rs.getString(3));
            
            return states;  
        }  
    });  
} 


	
	
}

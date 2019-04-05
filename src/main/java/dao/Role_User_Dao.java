package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Role_User;

public class Role_User_Dao 
{  
JdbcTemplate template;  
 
public void setTemplate(JdbcTemplate template) 
{  
   this.template = template;  
}  	

public List<Role_User> getRoleUsers(){  
    return template.query("select * from Role_User",new RowMapper<Role_User>(){  
        public Role_User mapRow(ResultSet rs, int row) throws SQLException {  
        	Role_User ru=new Role_User(); 
        	
        	
        	ru.setRole_id(rs.getInt(1));
        	ru.setName(rs.getString(2));
            
            return ru;  
        }  
    });  
} 



	
	
}

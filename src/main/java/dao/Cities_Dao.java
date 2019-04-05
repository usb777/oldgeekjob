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

import model.Cities;

public class Cities_Dao
{
	
	JdbcTemplate template;  
	 
	public void setTemplate(JdbcTemplate template) 
	{  
	   this.template = template;  
	}  	

	public List<Cities> getCities()
	{  
	    return template.query("select * from Cities order by City_id ",new RowMapper<Cities>()
	    {  
	        public Cities mapRow(ResultSet rs, int row) throws SQLException {  
	        	Cities cities=new Cities(); 
	        	
	        	
	        	cities.setCity_id(rs.getInt(1));
	        	cities.setName(rs.getString(2));
	        	cities.setSt_id(rs.getInt(4));
	        	cities.setZip(rs.getInt(3));	
	        	
	        	        	
	            return cities;  
	        }  
	    });  
	} 

}

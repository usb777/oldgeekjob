package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import model.Messages;



public class Messages_Dao
{

	JdbcTemplate template; 
	
private final	String SQL_MAIN = "select m.m_id, m.from_id, m.to_id, m.title, m.message, m.contact, "
		+ " m.date_message, m.status, m.attach_url,  ufrom.login as sender, uto.login as receptor  " + 
		" from Messages m  " + 
		" Join Users ufrom on ufrom.u_id = m.from_id " + 
		" Join Users uto on uto.u_id = m.to_id ";

private final	String SQL_MsgToUser = "select m.m_id, m.from_id, m.to_id, m.title, m.message, m.contact, "
		+ " m.date_message, m.status, m.attach_url,  ufrom.login as sender, uto.login as receptor  " + 
		" from Messages m  " + 
		" Join Users ufrom on ufrom.u_id = m.from_id " + 
		" Join Users uto on uto.u_id = m.to_id "
		+ " where m.to_id=?";

private final	String SQL_MsgFromUser = "select m.m_id, m.from_id, m.to_id, m.title, m.message, m.contact, "
		+ " m.date_message, m.status, m.attach_url,  ufrom.login as sender, uto.login as receptor  " + 
		" from Messages m  " + 
		" Join Users ufrom on ufrom.u_id = m.from_id " + 
		" Join Users uto on uto.u_id = m.to_id "
		+ " where m.from_id=?";

private final String New_MESSAGE_SQL="INSERT INTO MESSAGES "
+ " (M_ID, FROM_ID, TO_ID, TITLE, MESSAGE, CONTACT, DATE_MESSAGE, STATUS, ATTACH_URL) "
+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " ; 


 
private final String DELETE_MESSAGE_SQL = "Delete from Messages where m_id = ?" ;


	public void setTemplate(JdbcTemplate template) 
	{  
	   this.template = template;  
	}  
	
public List<Messages> getMessages(){  
    return template.query(SQL_MAIN, new RowMapper<Messages>()
    {  
        public Messages mapRow(ResultSet rs, int row) throws SQLException 
        {  
        	Messages msg=new Messages(); 
        	
        	
        	msg.setM_id(rs.getInt(1));
        	msg.setFrom_id(rs.getInt(2));
        	msg.setTo_id(rs.getInt(3));        	
        	msg.setTitle(rs.getString(4));
        	msg.setMessage(rs.getString(5));
        	msg.setContact(rs.getString(6));
        	msg.setDate_message(rs.getDate(7));
        	msg.setStatus(rs.getInt(8));
        	msg.setAttach_url(rs.getString(9));
        	msg.setSender(rs.getString(10) );
        	msg.setReceptor(rs.getString(11) );
            return msg;  
        }  
    });  
}



/**
 * Inbox Messages for User 
 * @param u_id
 * @return
 */

public List<Messages> getMessagesToUserId(int u_id)
{  
    return template.query(SQL_MsgToUser, new Object[]{u_id}, new RowMapper<Messages>()
    {  
        public Messages mapRow(ResultSet rs, int row) throws SQLException 
        {  
        	Messages msg=new Messages(); 
        	
        	
         	msg.setM_id(rs.getInt(1));
        	msg.setFrom_id(rs.getInt(2));
        	msg.setTo_id(rs.getInt(3));        	
        	msg.setTitle(rs.getString(4));
        	msg.setMessage(rs.getString(5));
        	msg.setContact(rs.getString(6));
        	msg.setDate_message(rs.getDate(7));
        	msg.setStatus(rs.getInt(8));
        	msg.setAttach_url(rs.getString(9));
        	msg.setSender(rs.getString(10) );
        	msg.setReceptor(rs.getString(11) );
            return msg;  
        }  
    });  
}

public List<Messages> getMessagesFromUserId(int u_id)
{  
    return template.query(SQL_MsgFromUser, new Object[]{u_id}, new RowMapper<Messages>()
    {  
        public Messages mapRow(ResultSet rs, int row) throws SQLException 
        {  
        	Messages msg=new Messages(); 
        	
        	
         	msg.setM_id(rs.getInt(1));
        	msg.setFrom_id(rs.getInt(2));
        	msg.setTo_id(rs.getInt(3));        	
        	msg.setTitle(rs.getString(4));
        	msg.setMessage(rs.getString(5));
        	msg.setContact(rs.getString(6));
        	msg.setDate_message(rs.getDate(7));
        	msg.setStatus(rs.getInt(8));
        	msg.setAttach_url(rs.getString(9));
        	msg.setSender(rs.getString(10) );
        	msg.setReceptor(rs.getString(11) );
            return msg;  
        }  
    });  
}






/**
 * return max id, used for primary key of table Users 
 * @return
 */
public Integer getMaxMessageId()
{
	String sql = "select max(m_id) from messages";
		 
	int maxUserId = template.queryForObject(sql, Integer.class);
	
	return maxUserId;
		
}



public int save(Messages msg)
{  
   //final id
   final int fromid = msg.getFrom_id();  //2
   final int toid = msg.getTo_id();  //3
   final String title = msg.getTitle();   //4
   final String message = msg.getMessage();  //5
   final String contact = msg.getContact();  //6
   final int status = msg.getStatus();  //7
   final String attachUrl = msg.getAttach_url();  //8
   
   
    
    /* Safety Sql query */
    return template.update(new PreparedStatementCreator() 
    {
    	/*
    //1	    //2     //3    //4      //5    //6           //7                 //8    //9 
    (M_ID, FROM_ID, TO_ID, TITLE, MESSAGE, CONTACT, ---DATE_MESSAGE---, STATUS, ATTACH_URL) 
    	*/
        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(New_MESSAGE_SQL);
        
        statement.setInt(1, (getMaxMessageId()+1));// set parameters you need in your insert
        statement.setInt(2, fromid  );// set parameters you need in your insert
        statement.setInt(3, toid  );//
        statement.setString(4, title  );
        statement.setString(5, message  );
        statement.setString(6, contact  );
        statement.setDate(7, new java.sql.Date(System.currentTimeMillis())); 
        
        //java.sql.Date.valueOf(java.time.LocalDate.now())
        
        statement.setInt(8, status  );
        statement.setString(9, attachUrl );
        
        return statement;
    }
});
  
    
  /**
   JdbcTemplate template = new JdbcTemplate(yourDataSource);

template.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

            PreparedStatement statement = connection.prepareStatement(ourInsertQuery);
            //statement.setLong(1, beginning); set parameters you need in your insert

            return statement;
        }
    });
    
  ALSO---    
  dbcTemplate.update(
    "INSERT INTO schema.tableName (column1, column2) VALUES (?, ?)",
    var1, var2
);



    jdbcTemplate.update(
    "INSERT INTO schema.tableName (column1, column2) VALUES (?, ?)",
    new Object[]{var1, var2}, new Object[]{Types.TYPE_OF_VAR1, Types.TYPE_OF_VAR2}
);
  
      
   */
    
    
    
} 


/**
 * Delete message method
 * @param m_id
 * @return
 */
public int delete(final int m_id)
{ 
    return template.update(new PreparedStatementCreator() 
    {
      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
      {

        PreparedStatement statement = connection.prepareStatement(DELETE_MESSAGE_SQL);
        
        statement.setInt(1, m_id);// set parameters you need in your insert
               
        return statement;
    }
});
  
    

    
    
} 



//TO_DATE('"+new Utilit().convertDateUtilToDateSql( new java.util.Date())+"', 'YYYY-MM-DD HH24:MI:SS') )



}

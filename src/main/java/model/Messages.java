package model;

import java.util.Date;

public class Messages
{
	int m_id; 
	int from_id; 
	int to_id; 
	String title; 
	String message; 
	String contact; 	
	Date date_message; 
	int status;
	String attach_url;
	
	String sender;   // Not native table fields
	String receptor; // Not native table fields
	/**
	 * @return the sender
	 */
	
	
	public Messages ()
	{
		
	}
	
	public Messages (int m_id,	int from_id,	int to_id, 	String title,	
			String message, String contact,/*	Date date_message, */	int status,	String attach_url)
	{
		this.m_id = m_id;	
		this.from_id = from_id; 	
		this.to_id = to_id; 	
		this.title = title	;	
		this.message = message; 
		this.contact = contact;	
	/*	this.date_message = date_message;	 */
		this.status = status;	
		this.attach_url = attach_url ;
	}
	
	public String getSender()
	{
		return sender;
	}
	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender)
	{
		this.sender = sender;
	}
	/**
	 * @return the receptor
	 */
	public String getReceptor()
	{
		return receptor;
	}
	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(String receptor)
	{
		this.receptor = receptor;
	}
	/**
	 * @return the m_id
	 */
	public int getM_id()
	{
		return m_id;
	}
	/**
	 * @param m_id the m_id to set
	 */
	public void setM_id(int m_id)
	{
		this.m_id = m_id;
	}
	/**
	 * @return the from_id
	 */
	public int getFrom_id()
	{
		return from_id;
	}
	/**
	 * @param from_id the from_id to set
	 */
	public void setFrom_id(int from_id)
	{
		this.from_id = from_id;
	}
	/**
	 * @return the to_id
	 */
	public int getTo_id()
	{
		return to_id;
	}
	/**
	 * @param to_id the to_id to set
	 */
	public void setTo_id(int to_id)
	{
		this.to_id = to_id;
	}
	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
	/**
	 * @return the contact
	 */
	public String getContact()
	{
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact)
	{
		this.contact = contact;
	}
	/**
	 * @return the date_message
	 */
	public Date getDate_message()
	{
		return date_message;
	}
	/**
	 * @param date_message the date_message to set
	 */
	public void setDate_message(Date date_message)
	{
		this.date_message = date_message;
	}
	/**
	 * @return the status
	 */
	public int getStatus()
	{
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}
	/**
	 * @return the attach_url
	 */
	public String getAttach_url()
	{
		return attach_url;
	}
	/**
	 * @param attach_url the attach_url to set
	 */
	public void setAttach_url(String attach_url)
	{
		this.attach_url = attach_url;
	}
	
	
	
}

package model;

import java.sql.Date;

public class Cities
{
	private int city_id; 
	private	String name; 	
	private int st_id;
	private int zip; 
	/**
	 * @return the city_id
	 */
	public int getCity_id()
	{
		return city_id;
	}
	/**
	 * @param city_id the city_id to set
	 */
	public void setCity_id(int city_id)
	{
		this.city_id = city_id;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	/**
	 * @return the st_id
	 */
	public int getSt_id()
	{
		return st_id;
	}
	/**
	 * @param st_id the st_id to set
	 */
	public void setSt_id(int st_id)
	{
		this.st_id = st_id;
	}
	
	
	
	/**
	 * @return the zip
	 */
	public int getZip()
	{
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip)
	{
		this.zip = zip;
	}


}

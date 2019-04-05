package model;

public class JobStatus 
{

private	int js_id; 
private	String name;


	public JobStatus()
	{
	}
	
	public JobStatus(int js_id, String name)
	{  this.js_id = js_id;
	   this.name = name;
	}
	




/**
 * @return the js_id
 */
public int getJs_id() {
	return js_id;
}
/**
 * @param js_id the js_id to set
 */
public void setJs_id(int js_id) {
	this.js_id = js_id;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}	
	
}

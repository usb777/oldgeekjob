package model;

public class Users 
{
	int u_id; 
	String fname; 
	String lname; 
	String login; 
	String email; 
	String telefona; 
	int role_id;
	String password;
	
	public Users()
	{}
	
	public Users( int  u_id, String fname,String lname,	String login,String email,	String telefona, int role_id,String password )
	{
		this.u_id =  u_id; 
		this.fname = fname; 
		this.lname = lname; 
		this.login = login; 
		this.email = email; 
		this.telefona = telefona; 
		this.role_id = role_id;
		this.password = password;
	}

	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefona() {
		return telefona;
	}
	public void setTelefona(String telefona) {
		this.telefona = telefona;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	} 
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() 
	{
		return "User [id=" + u_id + ", fname=" + fname + ", lname=" + lname + ", login=" + login + "]";
		
	}
	
}

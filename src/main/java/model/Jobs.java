package model;

import java.util.Date;

public class Jobs
{

	int id; 
	String title; 
	String  compensation; 
	String description; 
	String education ; 
	String responsibilities; 
	String  qualification; 
	String skills; 
	int u_id; 
	int jobstatus_id ; 
	int employmenttype_id; 
	String benefits; 
	String contact_info; 
	Date date_publication; 
	String city; 
	int state_id;
/*	
	String user_login;
	String jobstatus_name; 
	String employmenttype_name; 
	String state_name; 
	
	
	public String getUser_login()
	{
		return user_login;
	}
	
	public void setUser_login(String user_login)
	{
		this.user_login = user_login;
	}
	
	public String getJobstatus_name()
	{
		return jobstatus_name;
	}
	
	public void setJobstatus_name(String jobstatus_name)
	{
		this.jobstatus_name = jobstatus_name;
	}
	
	public String getEmploymenttype_name()
	{
		return employmenttype_name;
	}
	
	public void setEmploymenttype_name(String employmenttype_name)
	{
		this.employmenttype_name = employmenttype_name;
	}
	
	public String getState_name()
	{
		return state_name;
	}
	
	public void setState_name(String state_name)
	{
		this.state_name = state_name;
	}
	*/
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the compensation
	 */
	public String getCompensation() {
		return compensation;
	}
	/**
	 * @param compensation the compensation to set
	 */
	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return the responsibilities
	 */
	public String getResponsibilities() {
		return responsibilities;
	}
	/**
	 * @param responsibilities the responsibilities to set
	 */
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}
	/**
	 * @return the u_id
	 */
	public int getU_id() {
		return u_id;
	}
	/**
	 * @param u_id the u_id to set
	 */
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	/**
	 * @return the jobstatus_id
	 */
	public int getJobstatus_id() {
		return jobstatus_id;
	}
	/**
	 * @param jobstatus_id the jobstatus_id to set
	 */
	public void setJobstatus_id(int jobstatus_id) {
		this.jobstatus_id = jobstatus_id;
	}
	/**
	 * @return the employmenttype_id
	 */
	public int getEmploymenttype_id() {
		return employmenttype_id;
	}
	/**
	 * @param employmenttype_id the employmenttype_id to set
	 */
	public void setEmploymenttype_id(int employmenttype_id) {
		this.employmenttype_id = employmenttype_id;
	}
	/**
	 * @return the benefits
	 */
	public String getBenefits() {
		return benefits;
	}
	/**
	 * @param benefits the benefits to set
	 */
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	/**
	 * @return the contact_info
	 */
	public String getContact_info() {
		return contact_info;
	}
	/**
	 * @param contact_info the contact_info to set
	 */
	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}
	/**
	 * @return the date_publication
	 */
	public Date getDate_publication() {
		return date_publication;
	}
	/**
	 * @param date_publication the date_publication to set
	 */
	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state_id
	 */
	public int getState_id() {
		return state_id;
	}
	/**
	 * @param state_id the state_id to set
	 */
	public void setState_id(int state_id) {
		this.state_id = state_id;
	} 	
	
	

	@Override
	public String toString()
	{
	
		return "Jobs [id=" + id + ", title=" + title + ", compensation=" + compensation + ", description=" + description 
				+", education=" + education 
				+", responsibilities=" + responsibilities 
				+", qualification=" + qualification 
				+", skills=" + skills 
				+", u_id=" + u_id 
				+", jobstatus_id=" + jobstatus_id 
				+", employmenttype_id=" + employmenttype_id
				+", benefits=" + benefits
				+", contact_info=" + contact_info				
				+", date_publication=" + date_publication
				+", city=" + city
				+", state_id=" + state_id
				+"]";
	}	
	
	
}

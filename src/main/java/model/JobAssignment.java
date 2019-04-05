package model;

import java.util.Date;

public class JobAssignment
{
	
	private int ja_id;
	private int job_id;
	private int u_id;
	private Date date_assignment;
	
	private String job_title; 
	private String jobseeker; 
	private Date job_postdate; 
	private String employer ; 
	
	
	
	
	/**
	 * @return the ja_id
	 */
	public int getJa_id()
	{
		return ja_id;
	}
	/**
	 * @param ja_id the ja_id to set
	 */
	public void setJa_id(int ja_id)
	{
		this.ja_id = ja_id;
	}
	/**
	 * @return the job_id
	 */
	public int getJob_id()
	{
		return job_id;
	}
	/**
	 * @param job_id the job_id to set
	 */
	public void setJob_id(int job_id)
	{
		this.job_id = job_id;
	}
	/**
	 * @return the u_id
	 */
	public int getU_id()
	{
		return u_id;
	}
	/**
	 * @param u_id the u_id to set
	 */
	public void setU_id(int u_id)
	{
		this.u_id = u_id;
	}
	/**
	 * @return the date_assignment
	 */
	public Date getDate_assignment()
	{
		return date_assignment;
	}
	/**
	 * @param date_assignment the date_assignment to set
	 */
	public void setDate_assignment(Date date_assignment)
	{
		this.date_assignment = date_assignment;
	}
	
	//----------------FAke Fields 
	
	/**
	 * @return the job_title
	 */
	public String getJob_title()
	{
		return job_title;
	}
	/**
	 * @param job_title the job_title to set
	 */
	public void setJob_title(String job_title)
	{
		this.job_title = job_title;
	}
	/**
	 * @return the jobseeker
	 */
	public String getJobseeker()
	{
		return jobseeker;
	}
	/**
	 * @param jobseeker the jobseeker to set
	 */
	public void setJobseeker(String jobseeker)
	{
		this.jobseeker = jobseeker;
	}
	/**
	 * @return the job_postdate
	 */
	public Date getJob_postdate()
	{
		return job_postdate;
	}
	/**
	 * @param job_postdate the job_postdate to set
	 */
	public void setJob_postdate(Date job_postdate)
	{
		this.job_postdate = job_postdate;
	}
	/**
	 * @return the employer
	 */
	public String getEmployer()
	{
		return employer;
	}
	/**
	 * @param employer the employer to set
	 */
	public void setEmployer(String employer)
	{
		this.employer = employer;
	}
	

}

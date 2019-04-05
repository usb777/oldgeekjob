package model;

import java.sql.Date;

public class Profile
{

	
	private int p_id; 
	private	String description; 
	private	int u_id; 
	private	String linkedin; 
	private	String github; 
	private	String resume_url;
	private	Date date_modification;
		
		/**
		 * @return the p_id
		 */
		public int getP_id()
		{
			return p_id;
		}
		/**
		 * @param p_id the p_id to set
		 */
		public void setP_id(int p_id)
		{
			this.p_id = p_id;
		}
		/**
		 * @return the description
		 */
		public String getDescription()
		{
			return description;
		}
		/**
		 * @param description the description to set
		 */
		public void setDescription(String description)
		{
			this.description = description;
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
		 * @return the linkedin
		 */
		public String getLinkedin()
		{
			return linkedin;
		}
		/**
		 * @param linkedin the linkedin to set
		 */
		public void setLinkedin(String linkedin)
		{
			this.linkedin = linkedin;
		}
		/**
		 * @return the github
		 */
		public String getGithub()
		{
			return github;
		}
		/**
		 * @param github the github to set
		 */
		public void setGithub(String github)
		{
			this.github = github;
		}
		/**
		 * @return the resume_url
		 */
		public String getResume_url()
		{
			return resume_url;
		}
		/**
		 * @param resume_url the resume_url to set
		 */
		public void setResume_url(String resume_url)
		{
			this.resume_url = resume_url;
		}
		/**
		 * @return the dATE_MODIFICATION
		 */
		/**
		 * @return the date_modification
		 */
		public Date getDate_modification()
		{
			return date_modification;
		}
		/**
		 * @param date_modification the date_modification to set
		 */
		public void setDate_modification(Date date_modification)
		{
			this.date_modification = date_modification;
		}
		
		
		@Override
		public String toString() 
		{
			return "Profile [id=" + p_id + ", description=" + description + ", u_id = " + u_id + ","
					+ " linkedin = " + linkedin 
					+ " github = " + github 
					+ " resume_url = " + resume_url 
					+ ", date_modification=" + date_modification+"]";
			
		}	
	
	
}

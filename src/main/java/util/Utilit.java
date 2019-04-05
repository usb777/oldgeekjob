package util;

import java.io.File;

public class Utilit
{

	public String shortDescription(String str, int number_of_words)
	{
		
		String shortDescription = "";
		
	 if(str!=null)
	 {
		
		String[] tokens = str.split(" ");
		
		
		
		if (tokens.length> number_of_words ) 
		{	
		
			for (int i =0;i<number_of_words;i++)
			{
			shortDescription +=" " + tokens[i];
			}
		}
	
		else 
		{
			shortDescription = str;
		
		}
	 }
	 else 
	 {
		 shortDescription=""; 
	 }
		
		
		return shortDescription;
		
		
		
	}
	
	
	
	
	public static java.sql.Date convertDateUtilToDateSql(java.util.Date uDate)
	{
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
	
	
	
	
/**
 * method checks existence of directory, if not - create this directory
 * @param path
 */
	  public void directoryCreateAndExist(String path)
	  {  
		  
		  File filed = new File(path);
	        if(!filed.exists())
	        {  if(filed.mkdir())
	          { System.out.println("directory is created"); }
	        } 
	           else{ System.out.println("directory exist");  }
	  }
	
	  public static String getFileExtension(File file) 
		{
		    String name = file.getName();
		    int lastIndexOf = name.lastIndexOf(".");
		    if (lastIndexOf == -1) {
		        return ""; // empty extension
		    }
		    return name.substring(lastIndexOf);
		}
	
	  /**
	   * This method return extension of file from string
	   * @param fileStr
	   * @return
	   */
	  public static String getFileExtensionFromString(String fileStr) 
		{
		    String name = fileStr;
		    int lastIndexOf = name.lastIndexOf(".");
		    if (lastIndexOf == -1) {
		        return ""; // empty extension
		    }
		    return name.substring(lastIndexOf);
		}
}

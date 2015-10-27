package biblioteki;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileTypeDetermine {
	public static String GetFileTypeFromPath(String path)
	{
		String fileType = "Undetermined";  
		   final File file = new File(path);  
		   try  
		   {  
		      fileType = Files.probeContentType(file.toPath());  
		   }  
		   catch (IOException ioException)  
		   {  
		      System.out.println(  
		           "ERROR: Unable to determine file type for " + path  
		              + " due to exception " + ioException);  
		   }  
		   return fileType; 
	}
	
}

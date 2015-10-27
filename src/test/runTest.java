package test;
import biblioteki.*;


public class runTest {
	public static void main(String [] args)
	{
		String fileType = FileTypeDetermine.getFileTypeFromPath("C:\\Windows\\Media\\chord.wav");
		System.out.println(fileType);
		fileType = FileTypeDetermine.getFileTypeFromPath("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
		System.out.println(fileType);
		
		try
		{	
			//FileTypeDetermine.DisplayImage("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
			FileTypeDetermine.playSound("C:\\Windows\\Media\\chord.wav");
			
			FileTypeDetermine.previewFile("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

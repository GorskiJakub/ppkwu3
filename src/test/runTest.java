package test;
import biblioteki.*;


public class runTest {
	public static void main(String [] args)
	{
		String fileType = FileTypeDetermine.GetFileTypeFromPath("C:\\Windows\\Media\\chord.wav");
		System.out.println(fileType);
		fileType = FileTypeDetermine.GetFileTypeFromPath("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
		System.out.println(fileType);
	}
}

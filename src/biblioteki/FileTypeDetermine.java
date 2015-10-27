package biblioteki;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
	
	public static void DisplayImage(String path) throws IOException
	{

        BufferedImage img=ImageIO.read(new File(path));
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(200,300);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
	}
}

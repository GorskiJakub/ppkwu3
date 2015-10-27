package biblioteki;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileTypeDetermine {
	public static String getFileTypeFromPath(String path)
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
	
	public static void displayImage(String path) throws IOException
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
	
	public static void playSound(String path) throws Exception
	{
	    AudioInputStream stream;
	    AudioFormat format;
	    DataLine.Info info;
	    Clip clip;

	    stream = AudioSystem.getAudioInputStream(new File(path));
	    format = stream.getFormat();
	    info = new DataLine.Info(Clip.class, format);
	    clip = (Clip) AudioSystem.getLine(info);
	    clip.open(stream);
	    clip.start();
	}
	
	public static void previewFile(String path) throws Exception
	{
		String fileType = FileTypeDetermine.getFileTypeFromPath(path);
		if(fileType.contains("audio"))
		{
			FileTypeDetermine.playSound(path);
		}
		if(fileType.contains("image"))
		{
			FileTypeDetermine.displayImage(path);
		}
	}
}

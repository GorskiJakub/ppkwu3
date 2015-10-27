package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import biblioteki.FileTypeDetermine;

public class FileTypeDetermineTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testAudioType() {
		String fileType = FileTypeDetermine.getFileTypeFromPath("C:\\Windows\\Media\\chord.wav");
		assertEquals("audio/wav", fileType);
	}
	
	@Test
	public void testImageType() {
		String fileType = FileTypeDetermine.getFileTypeFromPath("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
		assertEquals("image/jpeg", fileType);
		
		fileType = FileTypeDetermine.getFileTypeFromPath("C:\\Users\\student\\pictures\\tgaSample.tga");
		assertEquals(null, fileType);
		
		fileType = FileTypeDetermine.getFileTypeFromPath("C:\\Users\\student\\pictures\\pngSample.png");
		assertEquals("image/png", fileType);
		
		fileType = FileTypeDetermine.getFileTypeFromPath("C:\\Users\\student\\pictures\\gifSample.gif");
		assertEquals("image/gif", fileType);
		
		//fileType = FileTypeDetermine.getFileTypeFromPath("C:\\bla.gif");
		
	}
	
	@Test
	public void testOpenimage() {
		//FileTypeDetermine.playSound("C:\\Windows\\Media\\chord.wav");
		thrown.expect(FileNotFoundException.class);
	}

}

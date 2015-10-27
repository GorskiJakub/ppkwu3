package test;

import static org.junit.Assert.*;

import org.junit.Test;

import biblioteki.FileTypeDetermine;

public class FileTypeDetermineTest {

	@Test
	public void testAudioType() {
		String fileType = FileTypeDetermine.getFileTypeFromPath("C:\\Windows\\Media\\chord.wav");
		assertEquals("audio/wav", fileType);
	}

}

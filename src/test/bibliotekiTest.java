package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;

import biblioteki.HttpFile;

public class bibliotekiTest {

	@Test
	public void testHttpFile() throws MalformedURLException, IOException {
		HttpFile hf = new HttpFile(new URL("https://jarekprzygodzki.wordpress.com/"));
		String content = new String(hf.getData(), hf.getEncoding());

		assert
	}

}

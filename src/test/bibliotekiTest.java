package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import biblioteki.HttpFile;

public class bibliotekiTest {

	@Test
	public void testHttpFileForWww() {
		HttpFile hf = null;
		try {
			hf = new HttpFile(new URL("https://jarekprzygodzki.wordpress.com/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String content = new String(hf.getData(), hf.getEncoding());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		assertEquals(true, hf);
	}

}

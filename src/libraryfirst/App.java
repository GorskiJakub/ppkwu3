package libraryfirst;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		
		String path = "C:\\tmpDownload\\tescik.txt";
		Zip.compress(path);
		
		String path2 = "C:\\tmpDownload\\tescik2.txt";
		try {
			UnZip.decompress("C:\\tmpDownload\\2015-11-24.zip", path2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package bibliotekaSzyfr;

import java.nio.file.Files;
import java.nio.file.Paths;
import javax.crypto.*;

public class Main {

	 public static void main(String[] args) throws Exception {
	    	
	        String FileName = "encryptedtext.txt";
	        String FileName2 = "decryptedtext.txt";

	        Szyfr.szyfrowanie(FileName, FileName2);
	        
	        return;
	    }
   
}
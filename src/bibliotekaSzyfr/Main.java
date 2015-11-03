package bibliotekaSzyfr;

public class Main {

	 public static void main(String[] args) throws Exception {
	     	
		 	String datafile = "test.TXT";
	        String FileName = "encryptedtext.txt";
	        String FileName2 = "decryptedtext.txt";
	        String pass = "dupa";
	        String secretID="sekret";
	        
	       Szyfr.szyfrowanie(FileName, pass, secretID );
	      Szyfr.deszyfrowanie(FileName2, pass, secretID);
	        
	        TestCheckSum.CheckSum(datafile);
	   

	        return;
	    }
   
}
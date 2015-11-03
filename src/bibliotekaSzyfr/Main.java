package bibliotekaSzyfr;

public class Main {

	 public static void main(String[] args) throws Exception {
	     	
		 	String datafile = "test.TXT";
	        String FileName = "encryptedtext.txt";
	        String FileName2 = "decryptedtext.txt";
	        System.out.println("test1");
	        Szyfr.szyfrowanie(FileName, FileName2);
	        System.out.println("test2");
	        TestCheckSum.CheckSum(datafile);
	   

	        return;
	    }
   
}
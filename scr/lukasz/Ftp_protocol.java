package lukasz;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Ftp_protocol {

	private static final int BUFFER_SIZE = 4096;
	
	public static void downloadFtp(){
		String ftpUrl = "ftp://%s:%s@%s/%s;type=i";
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj adres host:");
        String host = input.nextLine();
        //String host = "www.yourserver.com";
        System.out.println("Podaj usera:");
        String user = input.nextLine();
        //String user = "tom";
        System.out.println("Podaj haslo:");
        String pass = input.nextLine();
        //String pass = "secret";
        System.out.println("Podaj sciezke pliku:");
        String filePath = input.nextLine();
        //String filePath = "/project/2012/Project.zip";
        System.out.println("Podaj podaj sciezke zapisu:");
        String savePath = input.nextLine();

        //String savePath = "C:/Download/Project.zip";
 
        ftpUrl = String.format(ftpUrl, user, pass, host, filePath);
        System.out.println("URL: " + ftpUrl);
 
        try {
            URL url = new URL(ftpUrl);
            URLConnection conn = url.openConnection();
            InputStream inputStream = conn.getInputStream();
 
            FileOutputStream outputStream = new FileOutputStream(savePath);
 
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("File downloaded");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
	}
 
    public static void main(String[] args) {
        
    }
}

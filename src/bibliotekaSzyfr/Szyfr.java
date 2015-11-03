package bibliotekaSzyfr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Szyfr {

	public static void szyfrowanie(String Filename1, String pass, String secretID)
			throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {

		String plik1 = "encryptedtext.txt";

		String password = pass;
		String secret = secretID;

		// Get the Key
		byte[] key = (password).getBytes("UTF-8");
		//System.out.println((password).getBytes().length);

		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 16); // use only first 128 bit

		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

		// Instantiate the cipher
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] encrypted = cipher.doFinal((secret).getBytes());
		Files.write(Paths.get(plik1), encrypted);

		// System.out.println("encrypted string: " +
		// String.format("%02x",encrypted));

		
	}

	public static void deszyfrowanie(String Filename2, String pass, String secretID)
			throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException {

	
		String plik2 = "decryptedtext.txt";
		String password = pass;
		String secret = secretID;

		
		Path path = Paths.get("decryptedtext.txt");
		byte[] encrypted = Files.readAllBytes(path);
	
		
		byte[] key = (password).getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 16); // use only first 128 bit
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		
		byte[] decrypthed = cipher.doFinal(encrypted);
		Files.write(Paths.get(plik2), decrypthed);
		// System.out.println("Original string: " + originalString + "\nOriginal
		// string (Hex): " + String.format("%02x",original));

	}
}

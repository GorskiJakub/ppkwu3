package bibliotekaSzyfr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.*;

public class Szyfr {

	public static void szyfrowanie(String FileName1, String Filename2) throws InvalidKeyException, IOException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

		String plik1 = "encryptedtext.txt";
		String plik2 = "decryptedtext.txt";

		KeyGenerator KeyGen = KeyGenerator.getInstance("AES");
		KeyGen.init(128);

		SecretKey SecKey = KeyGen.generateKey();

		Cipher AesCipher = Cipher.getInstance("AES");

		byte[] byteText = "tekst".getBytes();

		AesCipher.init(Cipher.ENCRYPT_MODE, SecKey);
		byte[] byteCipherText = AesCipher.doFinal(byteText);
		Files.write(Paths.get(plik1), byteCipherText);

		byte[] cipherText = Files.readAllBytes(Paths.get(plik1));

		AesCipher.init(Cipher.DECRYPT_MODE, SecKey);
		byte[] bytePlainText = AesCipher.doFinal(cipherText);
		Files.write(Paths.get(plik2), bytePlainText);
	}
}

package dto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashDTO {

	public String toHash(String text) throws NoSuchAlgorithmException {
		// SHA-256（SHA-2）
		MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
		byte[] hashPass = sha256.digest(text.getBytes());
		return String.format("%040x", new BigInteger(1, hashPass));
	}

}

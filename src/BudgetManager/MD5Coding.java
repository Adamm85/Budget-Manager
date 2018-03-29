package BudgetManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Coding {

	static String md5(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("MD5");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer stringbuffer = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			stringbuffer.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		return stringbuffer.toString();
	}
	
}

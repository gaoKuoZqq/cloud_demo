package test;

import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class teeeeeest {
	@Test
	public void test1() {
		String salt = UUID.randomUUID().toString();
    	String password_cipherText= new Md5Hash("123456","gaokuo"+salt,2).toHex(); 
    	System.out.println(password_cipherText);
    	System.out.println(salt);
	}
}

package com.example.java8.security;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

public class RandomPassword {

	final static String pdSeed = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmopqrstovwxyz";
	static SecureRandom sr = new SecureRandom();
	public static void main(String[] args) {
		System.out.println(RandomPassword.getRandomPassword(10));
		System.out.println(RandomPassword.getRandomID());
		System.out.println(RandomPassword.nextSessionId());
	}
	
	public static String getRandomPassword(int length)
	{
		StringBuffer sb = new StringBuffer(length);
		while(length >= 0)
		{
		sb.append(pdSeed.charAt(sr.nextInt(pdSeed.length())));
		length--;
		}
		
		return sb.toString();
	}
	
	
	public static String getRandomID()
	{
		String randomID = UUID.randomUUID().toString();
		return randomID.replaceAll("-", "");
	}
	
    public static String nextSessionId() {
        return new BigInteger(130, sr).toString(32);
    }

}

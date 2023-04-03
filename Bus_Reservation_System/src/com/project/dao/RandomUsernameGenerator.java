package com.project.dao;
import java.util.Random;


public class RandomUsernameGenerator {
	
	private static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
	   private static final int USERNAME_LENGTH = 8; // You can adjust the length of the username as per your requirement
	   
	   public static String generate(String name, int length) {
		   String symbols = "@#$%&";
	        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" + symbols;
	        StringBuilder sb = new StringBuilder(length);
	        Random random = new Random();
	        // add name to the username
	        sb.append(name.substring(0, Math.min(name.length(), 5)));
	        // add symbol to the username
	        sb.append(symbols.charAt(random.nextInt(symbols.length())));
	        // add numbers to the username
	        int remainingChars = length - sb.length();
	        for (int i = 0; i < remainingChars; i++) {
	            sb.append(random.nextInt(10));
	        }
	        return sb.toString();

}
}

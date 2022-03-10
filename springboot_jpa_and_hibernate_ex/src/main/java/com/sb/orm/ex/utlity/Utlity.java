package com.sb.orm.ex.utlity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

public interface Utlity {
	
	public static String generateRandomName() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	public static String generateRandomCity() {
		return generateRandomText(3)+" City";
	}
	
	public static String generateRandomText(int j) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(j);
		for (int i = 0; i < j; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	public static Date createRandomDate() {
		
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int startYear= day+month+1980;
        int endYear = startYear+createRandomIntBetween(1, 40);
        int year = createRandomIntBetween(startYear, endYear);
        LocalDate dt= LocalDate.of(year, month, day);
        return java.sql.Date.valueOf( dt );
        //String timeStamp=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dt);
        //return Timestamp.valueOf(timeStamp); 
        
       
    }
    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
    
    public static boolean generateRandomBolean() {
    	Random rd = new Random();
    	return rd.nextBoolean();
    }
}

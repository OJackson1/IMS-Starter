package com.qa.ims.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
	private static Logger LOGGER = LogManager.getLogger();

	private final Scanner scanner;

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public Long getLong() { 
	       String input = null; 
	       Long longInput = null; 
	       do { 
	    	   try { input = getString(); 
	    	   		 longInput = Long.parseLong(input); 
	           
	       } catch (NumberFormatException nfe) { 
	           LOGGER.info("Error - Please enter a number"); 
	           
	       } 
	           
	       } while (longInput == null); 
	       return longInput; 
	       
	   } 
	
	public Float getFloat() {
		String input = getString();
		Float floatInput = null;
		do {
			try {
				floatInput = Float.parseFloat(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a float number");
			}
		} while (floatInput == null);
		return floatInput;
	}
	
	
	       public String getString() { 
	           return scanner.nextLine(); 
	           
	       } 
	           public Double getDouble() { 
	               String input = null; 
	               Double doubleInput = null; 
	               do { 
	                   try { 
	                	   input = getString(); 
	               doubleInput = Double.parseDouble(input); 
	                       
	                   } catch (NumberFormatException nfe) { 
	                       LOGGER.info("Error - Please enter a number"); 
	                       
	                   } 
	                   
	               } while (doubleInput == null); 
	               return doubleInput; 
	               
	           }
	           
	           
}

package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Exercise4 {

	public static void main(String[] args) {
		
		readLorem();
		
	}
	
	
	public static void readLorem() {
		int lower = 0;
        int upper = 0;
        int special = 0;
        float percent = 0;
        int vowels = 0;
        int total = 0;
        
		try {            
            URL url = new URL("http://progra.usm.cl/apunte/_static/texto.txt");             
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));             
            String line;     
            
            
            while ((line = in.readLine()) != null) {
            	for(int i=0; i<line.length(); i++) {
            		if(Character.isUpperCase(line.charAt(i))){
            			upper++;
            			total++;
            		}else if(Character.isLowerCase(line.charAt(i))){
            			lower++;
            			total++;
            		}else if(line.charAt(i) == ' '){
            			
            		}else{
            			special++;
            			total++;
            		}
            		
            		if(line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u' ||
            				line.charAt(i) == 'A' || line.charAt(i) == 'E' || line.charAt(i) == 'I' || line.charAt(i) == 'O' || line.charAt(i) == 'U') {
            			vowels++;
            			
            		}            		
            	}
            	line = line.replaceAll("[AaEeIiOoUu]", "");
        		System.out.println(line);
            }
            in.close();             
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
		
		percent = (lower*100) / total;
				
		System.out.println("\n\n\n------------------------- ");
		System.out.println("Mayusculas: "+upper);
		System.out.println("Minusculas: "+lower);
		System.out.println("Caracteres especiales: "+special);
		System.out.println("Porcentaje vocales: "+percent+"%");
		System.out.println("Vocales: "+vowels);
		
	}
	
}

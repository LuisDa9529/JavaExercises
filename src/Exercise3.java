package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Exercise3 {

	public static void main(String[] args) {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		ArrayList<Integer> accepted = new ArrayList<Integer>();
		ArrayList<Integer> rejected = new ArrayList<Integer>();
		
		
		readScores(scores);
		System.out.println("Total students: ");
		System.out.println(scores.size());
		
		obtener_listas(scores, accepted, rejected);
		System.out.println("Number of accepted: \n"+accepted.size());
		System.out.println("Number of Rejected: \n"+rejected.size());
		
		int cant_mensual = calcular_becas(accepted);
		System.out.println("Cantidad mensual otorgada:\n$"+cant_mensual);
		
		int promedio = puntaje_promedio(accepted);
		System.out.println("Puntaje promedio alumnos aceptados:\n"+promedio);
		
		double desviacion = desviacion(rejected);
		System.out.println("Desviacion estandar puntajes rechazados:\n"+desviacion);
		
	}
	
	public static void readScores(ArrayList<Integer> x) {
		try {            
            URL url = new URL("http://progra.usm.cl/apunte/_static/puntajes.txt");             
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));             
            String line;
            int number;            
            
            while ((line = in.readLine()) != null) {
              number = Integer.parseInt(line);
                x.add(number);
            }
            in.close();             
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
	}
	
	public static void obtener_listas(ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Integer> z) {
		for(int i=0; i<x.size(); i++) {
			int num = x.get(i);
			
			if(num>764) {
				y.add(x.get(i));
			}else
				z.add(x.get(i));
		}
	}
	
	public static int calcular_becas(ArrayList<Integer> alumnos) {
		int total;
		int beca = 60000;
		
		total = alumnos.size()*beca;
		
		return total;
	}
	
	public static int puntaje_promedio(ArrayList<Integer> list) {
		int average = 0;
		
		for(int i=0; i<list.size(); i++) {
			average += list.get(i);
		}
		average = average/list.size();
		
		return average;
	}
	
	public static double desviacion(ArrayList<Integer> list) {
		int mean = 0;
		int sum = 0;
		
		for(int i=0; i<list.size(); i++) {
			mean += list.get(i);
		}
		mean = mean/list.size();
		
		for(int j=0; j<list.size(); j++) {
			sum += Math.pow((list.get(j)-mean), 2) ;
		}
		
		double result = Math.sqrt(sum/list.size()) ;
		
		return result;
	}
	
}

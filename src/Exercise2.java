package src;

import java.util.Arrays; 
import java.util.*; 
import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*; 
import java.util.Collections; 

public class Exercise2 {
	
	public static void main(String[] args) {
		String[] animales = {"conejo", "ornitorrinco", "pez", "hipopotamo", "tigre"}; 

		sortAsc(animales);
		sortDes(animales);
		
		int[][] matriz = 
		{
			{6, 1, 5, 9},
			{0, 0, 4, 0, 1},
			{3, 2, 12, 1},
			{1000},
			{7, 6, 1, 0}
		};
				
		sortSum(matriz);
	
		String[][] personas = 
			{
					{"John", "Doe", "1992-12-28"},
					{"Perico", "Los Palotes", "1992-10-8"},
					{"Yayita", "Vinagre", "1991-4-17"},
					{"Fulano", "De Tal", "1992-10-4"},
			};
		
		sortLastName(personas);
		sortDoB(personas);
		sortDoBrev(personas);
	} 
	
	public static void sortAsc(String[] list){
		Arrays.sort(list, (x,y) -> Integer.compare(x.length(),y.length()));        
   		System.out.println("Ascendente: " + Arrays.toString(list));
	}
	
	public static void sortDes(String[] list){
		Arrays.sort(list, (x,y) -> Integer.compare(y.length(),x.length()));        
   		System.out.println("\nDescendente: " + Arrays.toString(list));
	}
	
	public static void sortSum(int[][] list) {
		int sum[] = new int[list.length]; 

		System.out.println("\nOrdenar por suma: ");
		Arrays.sort(list, (x,y) -> Integer.compare(sumof(x),sumof(y)));        
		for (int i = 0; i < list.length; i++)
			System.out.println(Arrays.toString(list[i]));
	}

	private static int sumof(int[] x) {
		int sum = 0;
		for(int i=0; i<x.length; i++) {
			sum += x[i];
		}
		return sum;
	}
	
	public static void sortLastName(String[][] list) {
		Arrays.sort(list, (x,y) -> getString(x, 1).compareTo(getString(y, 1)));
		System.out.println("\nOdenar por apellido:");
		for (int i = 0; i < list.length; i++)
			System.out.println(Arrays.toString(list[i]));		
	}

	private static String getString(String[] x, int y) {
		String lastN = x[y];
		return lastN;
	}
	
	public static void sortDoB(String[][] list) {
		Arrays.sort(list, (x,y) -> StringtoDate(x).compareTo(StringtoDate(y)));
		System.out.println("\nOdenar por fecha:");
		for (int i = 0; i < list.length; i++)
			System.out.println(Arrays.toString(list[i]));
	}

	private static Date StringtoDate(String[] x) {
		Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(x[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return date;
	}
	
	public static void sortDoBrev(String[][] list) {
		Arrays.sort(list, (x,y) -> StringtoDate(y).compareTo(StringtoDate(x)));
		System.out.println("\nOdenar por fecha desc:");
		for (int i = 0; i < list.length; i++)
			System.out.println(Arrays.toString(list[i]));
	}
	
	
}
	
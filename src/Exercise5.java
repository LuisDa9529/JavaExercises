package src;

import java.io.*;
import java.util.ArrayList;

public class Exercise5 {

	static ArrayList<String> inventory = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		
		try {
			readFile(inventory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(inventory);
		
		existe_producto("6213");
		por_reabastecer();
		
	}
	
	public static void readFile(ArrayList<String> list) throws IOException {
		File file = new File("src/inventario.txt"); 		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 		  
		  String st; 
		  
		  while ((st = br.readLine()) != null) {
//		    System.out.println(st); 
			  list.add(st);
		  } 
		
	}
	
	public static boolean existe_producto(String code) {
		
		boolean exist=false;
		String field = null;
		
		for(int i=0; i<inventory.size(); i++) {
			field = inventory.get(i);
			if(field.contains(code)) {
				exist = true;
				break;
			}else
				exist = false;
		}
		System.out.println(exist);
		return exist;
	}
	
	public static void por_reabastecer() {
		ArrayList<String> lista = new ArrayList<String>();
		String product;
		String [] div;
		for(int i=0; i<inventory.size(); i++) {
			product = inventory.get(i);
			div = product.split("/");
			if(Integer.valueOf(div[2])  < 10) {
				lista.add(inventory.get(i));
			}
		}
		System.out.println(lista);
		
		try{    
			FileWriter fw=new FileWriter("src/por_reabastecer.txt");    
			for(int i=0; i<lista.size(); i++) {
				fw.write(lista.get(i)+"\n");    
			}
			fw.close();    
		}catch(Exception e){System.out.println(e);}
		
	}
}

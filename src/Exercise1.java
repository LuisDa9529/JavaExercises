package src;

import java.util.Arrays;

public class Exercise1 {

	public static void main(String[] args) {
		int[] p = {1, 2, 1};
		int[] q = {4, -17};
		int[] r = {-1, 0, 0, -5, 0, 3};

		grado(p);		
		evaluar(p,3);
		sumar_polinomio(p, r);
	}

	public static void grado(int[] p) {
		int size = p.length;

		System.out.println(size);
	}

	public static void evaluar(int[] p, int x) {
		double suma = 0;

		for(int y=0; y<p.length; y++) {
			if(y==0) {
				suma = p[0];
			}else {
				suma = suma + Math.pow((p[y]*x), y);	
			}			
		}
		System.out.println(suma);	
	}

	public static void sumar_polinomio(int[] a, int[] b) {
		int size = Math.max(a.length, b.length);

		int[] c = new int[(int) size];
        for (int i = 0; i < c.length; i++) {
            if (a.length > i) {
                c[i] += a[i];
            }
            if (b.length > i) {
                c[i] += b[i];
            }
        }

        System.out.println(Arrays.toString(c));

	}

}

//[4, -9, -30, -17]
//		
//4+8x+4x2
//-17x-34x2-17x3
//
//4+-9x-30x2-17x3
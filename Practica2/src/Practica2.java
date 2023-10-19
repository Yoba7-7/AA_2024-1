/**
 * Class Practica2. Clase que modela el problema 2 de la tarea 5
 * @author Luis G. Mendez Avila. @Yoba7-7 
 */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Practica2{
	
	/**
	 * Método encuentraIndice. Sirve para buscar un índice en el arreglo.
	 * @param a areglo de números que cumplen con las especificaciones
	 * @param prim el primer elemento del arreglo
	 * @param ult el último elemento del arreglo
	 * @param z el numero a buscar en el arreglo
	 */
	public static int encuentraIndice(int[] a, int prim, int ult, int z){
		int der = a.length -1; // último indice del arreglo
		int izq = 0; // primer índice del arreglo

		/**
		 * - Mientras siga habiendo elementos entre los índices se ejecuta
		 * lo siguiente:
		 * - Se crea una variable para indicar índice de en medio.
		 * - Si hay elementos entre el índice intermedio y primero y entre
		 *   el intermedio y el úlitmo.
		 * - Si el elemento a buscar es el que está en el índice intermedio
		 *   regresa el indice
		 * - En otro caso dependerá si el elemento intermedio es menor o 
		 *   mayor. En cualquier caso corta el arreglo a la mitad y procede
		 *   a realizar la busqueda en dicha mitad.
		 * - En caso de no encontrar el elemento regresa -1 
		 */
		while(izq <= der){
			int med = (Integer) izq + (der - izq)/2;

			if((prim <= a[med]) && (a[med] <= ult)){
				if(a[med] == z){
					return med;
				}else if(a[med] < z){
					izq = med +1;
				}else{
					der = med-1;
				}
			}else if(a[med] < prim){
				izq = med + 1;
			}else{
				der = med - 1;
			}
		}

		return -1;
	}

    /**
     * Método generarArreglo. Crea un arreglo de tamaño n , donde los elementos
     * se generan aleatoriamente siguiendo las restricciones del problema dado.
     * @param n : El tamaño del arreglo.
     */
	public static int[] generarArreglo(int n) {
        int[] a = new int[n];
        Random random = new Random();

        a[0] = random.nextInt(100);

        /**
         * La forma en que se generan los elementos del arreglo es la siguiente:
         * Se crea una variable min y max que representan el valor mínimo y máximo
         * los elementos a[i] se generan aleatoriamente con random.nextInt establecido
         * entre minimo posible y máximo.
         */
        for (int i = 1; i < n; i++) {
            int min = Math.max(0, a[i - 1] - 1);
            int max = a[i - 1] + 1;
            a[i] = random.nextInt(max - min + 1) + min;
        }
        
        /**
         * Si el primer elemento es igual o mayor al útimo se intercambian
         */
        if (a[0] >= a[n - 1]) {
            int temp = a[0];
            a[0] = a[n - 1];
            a[n - 1] = temp;
        }
        
        return a;
    }

    /**
     * Metodo main. Basicamente la secuencia de instrucciones para que se usen
     * los algoritmos hechos .
     */
    public static void main(String[] args) {
    	Scanner entrada = new Scanner(System.in);
    	Random r = new Random();
    	System.out.print("Ingrese la cantidad de elementos deseados en el arreglo: ");
    	int tamano = entrada.nextInt();

    	int[] arr = generarArreglo(tamano);
    	int aux = r.nextInt(arr.length - 1);
    	int seleccion = arr[aux];

    	System.out.println("Este es tu arreglo: " + Arrays.toString(arr));
    	System.out.println("Este es elemento a buscar: " + seleccion);

    	int ind = encuentraIndice(arr, arr[0], arr[arr.length -1], seleccion);
    	System.out.println("Este es el indice donde se encuentra " + seleccion + ": " + ind);
    }
}
/**
 * Class Adoquinamiento. Clase para mostrar el problema del adoquinamiento
 * visto en clase
 * @author Yoba7_7 (Luis Geovanni Méndez Ávila) 
 * @version 1.0
 */
import java.util.Scanner;
public class Adoquinamiento{

	private int dim;
	private char[][] area;

	/**
	 * Constructor por defecto de la clase. Crea una matriz de nxn la cual
	 * será completada con O para representar las casillas vacias.
	 * @param n La dimencíón que se la dará a dicha matriz. Esta será una potencia de 2
	 * por lo tanto será el exponente de 2 a la n. Ej 4 dará una matriz de 16x16.
	 */
	public Adoquinamiento(int n){
		dim = (int) Math.pow(2,n);
		this.area = new char[dim][dim];
		for(int i = 0; i < dim; i++){
			for(int j = 0; j < dim; j++){
				this.area[i][j] = 'O';
			}
		}
	}

	/**
	 * imprime la matriz bonito
	 */
	public void imprime(){
		for(int i = 0; i < dim; i++){
			for(int j = 0; j < dim; j++){
				System.out.print(area[i][j] + " ");
			}
			System.out.println();
		}	
	}

	/**
	 * Coloca una S en la entrada destinada a ser el lugar donde se coloca
	 * el cuadrado especial. Si los argumentos ingresados superan los límites 
	 * del área entonces en automático el cuadrado especial se colocará en la
	 * equina superior izquierda.
	 * @param n posición filas
	 * @param m posición columnas 
	 */
	public void cuadradoEspecial(int n, int m){
		n = n-1; // cosas para que se ajuste a los indices
		m = m-1;
		try{
			area[n][m] = 'S';
		}catch(IndexOutOfBoundsException ex){
			area[0][0] = 'S';
		}
	}

	/**
	 * Método que devuelve el numero del cuadrante en el que se
	 * encuentra un cuandrado especial.
	 */
	public static int cuadrante(char[][] m){
		int cuadrante = 0;

		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m.length; j++){
				if(Character.compare(m[i][j], 'S') == 0){
					if(i < (m.length / 2) && j < (m.length / 2)){
						cuadrante = 1;
					}else if(i < (m.length / 2) && j > (m.length / 2)){
						cuadrante = 2;
					}else if(i > (m.length / 2) && j < (m.length / 2)){
						cuadrante = 3;
					}else if(i > (m.length / 2) && j > (m.length / 2)){
						cuadrante = 4;
					}
				}else{
					continue;
				}
			}
		}

		return cuadrante;
	}

	/**
	 * Método que dividirá el area en 4 cuadrantes para poder aplicar el 
	 * colocamiento de adoquines de manera recursiva.
	 * @param m La matriz que se dividirá en 4. La que es el área a adoquinar.
	 */
	public static char[][][] divideCuatro(char[][] m){
		int dim = m.length;
		char[][][] subMatrices = new char[4][dim/2][dim/2];

		for(int i = 0; i < dim/2; i++){
			for(int j = 0; j < dim/2; j++){
				subMatrices[0][i][j] = m[i][j];
				subMatrices[1][i][j] = m[i][j + dim/2];
				subMatrices[2][i][j] = m[i + dim/2][i];
				subMatrices[3][i][j] = m[i + dim/2][j + dim/2];
			}
		}

		return subMatrices;
	}

	/**
	 * Metodo que pone un adoquin dependiendo del cuadrante donde se esncuentre el
	 * cuadrado especial.
	 */
	public static void colocarAdoquin(char[][] m){
		
		/**
		 * Si el cuadrado especial está en el primer cuadrante entonces se 
		 * colocará un adoquin a modo que los 3 espacios ocupen uno cada uno
		 * de los cuadrantes faltantes, caso:
		 * -------
		 * |O | X|
		 * -------
		 * |X | X|
		 * -------
		 */
		if(cuadrante(m) == 1){
			m[(m.length / 2)-1][m.length / 2] = 'X';
			m[(m.length / 2)][(m.length / 2)-1] = 'X';
			m[(m.length / 2)][(m.length / 2)] = 'X';
		}

		/**
		 * Si el cuadrado especial está en el segundo cuadrante entonces se 
		 * colocará un adoquin a modo que los 3 espacios ocupen uno cada uno
		 * de los cuadrantes faltantes, caso:
		 * -------
		 * |X | O|
		 * -------
		 * |X | X|
		 * -------
		 */
		else if(cuadrante(m) == 2){
			m[(m.length / 2)-1][(m.length / 2)-1] = 'X';
			m[(m.length / 2)][(m.length / 2)-1] = 'X';
			m[(m.length / 2)][(m.length / 2)] = 'X';
		}

		/**
		 * Si el cuadrado especial está en el tercer cuadrante entonces se 
		 * colocará un adoquin a modo que los 3 espacios ocupen uno cada uno
		 * de los cuadrantes faltantes, caso:
		 * -------
		 * |X | X|
		 * -------
		 * |O | X|
		 * -------
		 */
		else if(cuadrante(m) == 3){
			m[(m.length / 2)-1][(m.length / 2)-1] = 'X';
			m[(m.length / 2)-1][(m.length / 2)] = 'X';
			m[(m.length / 2)][(m.length / 2)] = 'X';
		}

		/**
		 * Si el cuadrado especial está en el cuarto cuadrante entonces se 
		 * colocará un adoquin a modo que los 3 espacios ocupen uno cada uno
		 * de los cuadrantes faltantes, caso:
		 * -------
		 * |X | X|
		 * -------
		 * |X | O|
		 * -------
		 */
		else if(cuadrante(m) == 4){
			m[(m.length / 2)-1][(m.length / 2)-1] = 'X';
			m[(m.length / 2)-1][(m.length / 2)] = 'X';
			m[(m.length / 2)][(m.length / 2)-1] = 'X';
		}else{
			System.out.println("No hay cuadrado especial.");
		}
	}

	//Ideas, llamar a cuadrante desde acá y en colocar adoquin manejar los casos de cómo se
	// debe poner un adoquin dependiendo del cuadrante y no de la matriz en si
	public void aplicacionRecursiva(){
		char[][] area = this.area;
		char[][][] cuadrantes = divideCuatro(area);
		int tam = area.length;

		while(tam >= 2){
			if(cuadrante(area) == 1){
				colocarAdoquin(area);
				area = cuadrantes[0];
				cuadrantes = divideCuatro(area);
			}else if(cuadrante(area) == 2){
				colocarAdoquin(area);
				area = cuadrantes[1];
				cuadrantes = divideCuatro(area);
			}else if(cuadrante(area) == 3){
				colocarAdoquin(area);
				area = cuadrantes[2];
				cuadrantes = divideCuatro(area);
			}else if(cuadrante(area) == 4){
				colocarAdoquin(area);
				area = cuadrantes[3];
				cuadrantes = divideCuatro(area);
			}else{
				continue;
			}

			tam = tam/2;
		}
	} 

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingresa un numero para definir el tamaño del área: ");
		int potencia = entrada.nextInt();
		Adoquinamiento a = new Adoquinamiento(potencia);
		System.out.println("Area limpia: ");
		a.imprime();
		a.cuadradoEspecial(1,1);
		System.out.println("Area con cuadrado especial: ");
		a.imprime();

		System.out.println("Area con adoquines puestos: ");
		a.aplicacionRecursiva();
		a.imprime();
	}
}
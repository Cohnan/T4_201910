package model.util;
import java.lang.Math;

public class Sort {
	
	/**
	 * Ordenar datos aplicando el algoritmo ShellSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarShellSort( Comparable[ ] datos ) {
		// Esta es una implementacion hecha con el proposito de entender shellsort, que permite
		// el uso de diferentes secuencias con facilidad. La unica diferencia en uso de recursos
		// de esta implementacion es la creacion de la secuencia y su guardado en memoria, algo minimo.
		int[] secuencia = giveSequence(datos.length);
		
		for (int h : secuencia) hsort(datos, h);
	}
	
	private static void hsort(Comparable[] datos, int h) {
		int posOfInserting;
		for (int i = 0; i < h; i += 1) {
			// insertion-sort el h-subarray que empieza en i
			for (int j = i + h; j < datos.length ; j += h) {
				posOfInserting = j;
				while ((posOfInserting - h)>= 0 && less(datos[posOfInserting], datos[posOfInserting-h])) {
					exchange(datos, posOfInserting, posOfInserting-h);
					posOfInserting -= h;
				}
			}
		}
	}
	
	private static int[] giveSequence(int n) {
		// Usamos la secuencia 1, 4, 13, ...
		// Esto asegura que para el h maximo, cada subarray que ea h-sorted tenga longitud al menos 3
		int k = (int)(Math.log(2*n + 1)/Math.log(3) - 1);
		int[] lista = new int[k];
		for (int i = 0; i < k; i++) lista[i] = (int)((Math.pow(3, k-i) - 1)/2);
		
		return lista;
	}
	
	/**
	 * Ordenar datos aplicando el algoritmo MergeSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarMergeSort( Comparable[ ] datos ) {

		// TODO implementar el algoritmo MergeSort
	}

	/**
	 * Ordenar datos aplicando el algoritmo QuickSort
	 * @param datos - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 */
	public static void ordenarQuickSort( Comparable[ ] datos ) {

		// TODO implementar el algoritmo QuickSort
	}
	
	/**
	 * Comparar 2 objetos usando la comparacion "natural" de su clase
	 * @param v primer objeto de comparacion
	 * @param w segundo objeto de comparacion
	 * @return true si v es menor que w usando el metodo compareTo. false en caso contrario.
	 */
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	/**
	 * Intercambiar los datos de las posicion i y j
	 * @param datos contenedor de datos
	 * @param i posicion del 1er elemento a intercambiar
	 * @param j posicion del 2o elemento a intercambiar
	 */
	private static void exchange( Comparable[] datos, int i, int j)
	{
		Comparable temp = datos[i];
		datos[i] = datos[j];
		datos[j] = temp;
	}

}

package arraySorter;

import java.util.Arrays;

/**
* Clase ejecutable para demostrar el uso de {@code ArraySorter}
* @see arraySorter.ArraySorter
* @see arraySorter.ArrayGenerator
*/
public class Main {

   public static void main(String[] args) {

      Integer[] arreglo = ArrayGenerator.generarArregloDeLongitud(0, 100, 10);
      System.out.println("Arreglo random, tamaño 10 y valores entre 0 y 100:\n" + Arrays.toString(arreglo));
      ArraySorter.bubbleSort(arreglo);
      System.out.println("Arreglo ordenado con BubbleSort:\n" + Arrays.toString(arreglo));

      arreglo = ArrayGenerator.generarArregloDeLongitud(0, 100, 30);
      System.out.println("Arreglo random, tamaño 30 y valores entre 0 y 100:\n" + Arrays.toString(arreglo));
      ArraySorter.selectionSort(arreglo);
      System.out.println("Arreglo ordenado con SelectionSort:\n" + Arrays.toString(arreglo));
    
      arreglo = ArrayGenerator.generarArregloDeLongitud(0,100,20);
      System.out.println("Arreglo random, tamaño 20 y valores entre 0 y 100:\n" + Arrays.toString(arreglo));
      ArraySorter.quickSort(arreglo);
      System.out.println("Arreglo ordenado con QuickSort:\n" + Arrays.toString(arreglo));

      Integer[] array = {3, 6, 4, 1, 3, 4, 1, 4};
      System.out.println("Arreglo random, tamaño 8 y valores entre 1 y 6:\n" + Arrays.toString(array));
      ArraySorter.countingSort(array, array.length, 6);
      System.out.println("Arreglo ordenado con counting sort:\n" + Arrays.toString(array));
    }

   @SuppressWarnings("unchecked")
    private static <E> E[] crearArreglo(int elementos) {
        return (E[]) new Object[elementos];
    }

}

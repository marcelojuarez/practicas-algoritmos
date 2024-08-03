package arraySorter;

import java.util.*;

/**
* Provee métodos para ordenar arreglos de objetos comparables.
* Los algoritmos de ordenamiento provistos por esta clase son:
* <ul>
* <li>Bubble sort.</li>
* <li>Selection sort.</li>
* <li>Shell sort.</li>
* <li>Quick sort.</li>
* <li>Merge sort.</li>
* </ul>
* El invariante que deben cumplir todos los arreglos {@code array} para ser utilizados como argumentos de los distintos algoritmos de ordenamiento es:
* <pre>
* array != null &amp;&amp; for (T elem : array) {elem != null}
* </pre>
*/
public class ArraySorter {

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Bubble Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
      boolean sorted = false;
      int n = array.length; 
      for (int pass = 1; (pass < n) && !sorted; ++pass) {
         //inv : array[n-pass] a array[n-1] esta ordenado
         sorted = true;
         for (int index = 0; index < n - pass; ++index) {
            //inv: Vi : 0 <= i < index : array[i] <= array[index]
            int nextIndex = index + 1;
            if (array[index].compareTo(array[nextIndex]) > 0) {
               swap(array, index, nextIndex);
               sorted = false;
            }
         }
      }
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Selection Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("null array");
      for (int last = array.length-1;last >= 1;last--){
         //inv: array[last..n-1] esta ordenado
         int largest = indexOfLargest(array,last+1);
         swap(array, last, largest);
      }
   }


   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Shell Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void shellSort(T[] array) {
      throw new UnsupportedOperationException("TODO: implementar");    
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Quick Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void quickSort(T[] array) {
     if (array == null) throw new IllegalArgumentException("array is null, can't sort");  
      quickSortRec(array, 0, array.length-1);
   }

   private static<T extends Comparable<? super T>> void quickSortRec(Comparable[] array, int begin, int end){
      if (begin < end) {
      int p = partition(array,begin,end);
      quickSortRec(array,begin, p);
      quickSortRec(array, p+1, end);

      }
   }
   //implementacion de partition
   private static <T extends Comparable<? super T>> int partition(Comparable[] array ,int begin,int end){
      Comparable pivot = array[begin];
      int i = begin - 1;
      int j = end + 1;
      while (i < j) {
         do i++ ;while(array[i].compareTo(pivot) < 0);
         do j-- ;while(array[j].compareTo(pivot) > 0);
         if (i < j) {
            swap(array, i, j);
         }
      }
      return j;
    }
   
   
   /**
   * Ordena un arreglo, usando el orden natural de sus elementos utilizando Merge Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
      mergeSortRe(array, 0, array.length-1);   
   }

   private static <T extends Comparable> void mergeSortRe(T[] array, int begin, int end) {
      if (begin < end) {
         int mid = (begin + end) / 2;
         mergeSortRe(array, begin, mid);
         mergeSortRe(array, mid+1, end);
         merge(array, begin, mid, end);
      }
   }

   private static <T extends Comparable> void merge(T[] array, int begin, int mid, int end) {
      int leftLength = mid - begin + 1;
      int rightLength =  end - mid;
      
      //arreglo izquiero y derecho para realizar  merge
      List<T> arrayLeft = new ArrayList<>(leftLength);
      List<T> arrayRight = new ArrayList<>(rightLength);
      
      //se copian los elementos
      for (int i = 0;i < leftLength;i++) {
         arrayLeft.add(array[begin+i]);
      }

      for (int j = 0 ;j < rightLength;j++) {
         arrayRight.add(array[mid+j+1]);
      }
   
      //se realiza el join
      int i = 0,j = 0;
      int k = begin;

      while(i < leftLength && j < rightLength) {
         if (arrayLeft.get(i).compareTo(arrayRight.get(j)) <=0) {
            array[k] = arrayLeft.get(i);
            i++;
         }else{
            array[k] = arrayRight.get(j);
            j++;
         }
         k++;
      }
   
      //copio elementos restantes 
      while (i < leftLength) {
         array[k] = arrayLeft.get(i);
         k++;
         i++;
      }
   
      while (j < rightLength) {
         array[k] = arrayRight.get(j);
         j++;
         k++;
      }
   }

   public static void countingSort(Integer[] array, int n, int k) {
      int[] c = new int[k+1];

      //contamos la cantiadad de elementos iguales a array[i]
      for (int i = 0; i<n; i++) {
         c[array[i]]++;
      }

      //contamos la cantidad de elementos menores o iguales que array[i]
      for (int i = 1; i<=k; i++) {
         c[i] = c[i] + c[i-1];
      }
      
      //arreglo auxiliar para realizar el ordenamiento
      Integer[] sorted = new Integer[n];
      //se coloca cada elemento en su lugar
      for (int j = n-1; j>=0; j--) {
         sorted[c[array[j]]-1] = array[j];
         c[array[j]]--;
      }
      //reemplazo el arreglo original
      System.arraycopy(sorted, 0, array, 0, n);
   }

   /* (non-Javadoc)
   * Este método intercambia dos posiciones de un arreglo.
   */ 
   private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

   /* (non-Javadoc)
   * Este método retorna el indice del elemento mas grande. 
   */
   private static <T extends Comparable<? super T>> int indexOfLargest(T[] array, int n){
      int largest = 0;
      for (int i = 1; i < n; i++){
         if (array[i].compareTo(array[largest]) > 0){
            largest = i;
         }
      }  
      return largest;
   }


}

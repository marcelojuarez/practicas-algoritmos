package arbol;

public class MinHeap implements Heap{
  //heap
  private Integer[] heap;
  //cantidad de elementos
  private int size;

  //constructor de heap por defecto
  public MinHeap(int size){
    this.size = 0;
    this.heap = new Integer[size];
  }

  //constructor de heap con capacidad
  public MinHeap(Integer[] heap){
    this.size = heap.length;
    this.heap = heap;
  }

  // Inserta un elemento en el heap
  public void insert(Integer value){
    if (size == heap.length) {
      throw new IllegalStateException("Min-Heap lleno");
    }else{
      int pos = size;
      heap[pos] = value;
      size++;
      while (heap[pos] < heap[parent(pos)]) {
        swap(heap, pos, parent(pos));
        pos = parent(pos);
      }
    }
  }

  //metodo para intercambiar dos posiciones
  private void swap(Integer[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  //metodo para obtener el padre de una posicion dada
  private int parent(int pos) {
    if(this.heap == null || this.isEmpty()) {
      throw new IllegalStateException();
    }

    return ((pos - 1)/2);
  }
  //metodo para obtener hi de un nodo
  public int leftChild(int pos) {
    return (2*pos+1);
  }
  //metodo para obtener hd de un nodo
  public int rightChild(int pos) {
    return (2*(pos+1));
  }

  // Extrae el elemento superior del heap
  public Integer extracTop() {
    int elem = heap[0];
    if (this.size == 1) {
      this.clear();
    } else {
      //recupero la hoja mas a la derecha
      int nuevaRaiz = heap[size-1];
  
      //elimino la ultima hoja de la derecha
      heap[size-1] = null;
  
      //setteo la nueva raiz
      heap[0] = nuevaRaiz;
      int raiz = 0;
      size--;
      boolean hoja = false;
      while (!hoja) {
        //almaceno las posiciones del hi e hd
        int left = leftChild(raiz);
        int right = rightChild(raiz);
        int largest = raiz;
          if (left < size && heap[left] < heap[largest]) {
            largest = left;
          } else if (right < size && heap[right] <heap[largest]) {
            largest = right;
          }
          if (largest != raiz) {
            swap(heap, largest, raiz);
            raiz = largest;
          }else{
            hoja = true;
          }
      }
    }
    return elem;
  }

  // Retorna el elemento superior del heap sin extraerlo
  public Integer peekTop(){
    if (this.size > 0) {
      return heap[0];
    }else{
      throw new IllegalStateException("heap vacio");
    }
  }

  // Retorna el tamaño actual del heap
  public int size(){
    return this.size;
  }

  // Verifica si el heap está vacío
  public boolean isEmpty(){
    return (this.size == 0);
  }

  // Verifica si el heap está lleno (en caso de un límite de capacidad)
  public boolean isFull(){
    return false;
  }

  // Imprime el contenido del heap (solo para propósitos de demostración)
  public void printHeap(){

  }



  // Método toString para representar el heap como una cadena de texto
  public String toString(){
    String result = "[";
    for (int i = 0 ; i < this.size ;i++) {
        result += String.valueOf(heap[i]);
      if (i < this.size - 1){
        result += ",";
      }
    }
    result += "]";
    return result;
  }

  /**
  * Clear all elements from the heap
  */
  public void clear(){
    this.size = 0;
      heap = null;
  }

  // Método equals para comparar si dos heaps son iguales
  public boolean equals(Object o){
    if (o == null) {
      return false;
    }
  
    if (o == this) {
      return true;
    }
  
    if (!(o instanceof Heap)) {
        return false;
    }

    return true;
  }

  // Método repOk para verificar la invariante de representación del heap
  public boolean repOk(){
    for (int i = 1;i < size;i++){
      if (heap[parent(i)] > heap[i]){
        return false;
      }
    }
    return true;
  }
}

public class MinHeap implements HEAP{
 //cantidad maxima de elementos de un heap
  public static final int Max = 10; 
  //heap
  private int[] heap;
  //cantidad de elementos
  private int cant;

  //constructor de heap por defecto
  public MinHeap(){
    this(Max);
  }

  //constructor de heap con capacidad
  public MinHeap(int capacidad){
    if ( capacidad < 0) {
      throw new IllegalArgumentException("no se permite una cantidad negativa");
    }
    heap = new int[capacidad];
  }

  // Extrae el elemento superior del heap
  public int extract() {
    return heap[0];
  };

  // Retorna el elemento superior del heap sin extraerlo
  public int peek(){
    if (this.cant > 0) {
      return heap[0];
    }else{
      throw new IllegalStateException("heap vacio");
    }
  }

  // Retorna el tamaño actual del heap
  public int size(){
    return this.cant;
  }

  // Verifica si el heap está vacío
  public boolean isEmpty(){
    return (this.cant == 0);
  }

  // Verifica si el heap está lleno (en caso de un límite de capacidad)
  public boolean isFull(){
    return (this.cant == Max);
  }

  // Imprime el contenido del heap (solo para propósitos de demostración)
  public void printHeap();

  // Método toString para representar el heap como una cadena de texto
  public String toString(){
    String result = "[";
    for (int i = 0 ; i < this.cant ;i++) {
        result += String.valueOf(heap[i]);
      if (i < this.cant - 1){
        result += ",";
      }
    }
    result += "]";
    return result;
  }

  // Método equals para comparar si dos heaps son iguales
  public boolean equals(Object o){
    if (o == null) {
      return false;
    }
  
    if (o == this) {
      return true;
    }
  
    if (!(o instanceof HEAP)) {
        return false;
    }
  }

  // Método repOk para verificar la invariante de representación del heap
  public boolean repOk(){
    for (int i = 1;i < cant;i++){
      if (heap[parent(i)] > heap[i]){
        return false;
      }
    }
    return true;
  }
  private int parent(int pos){
    if (pos == 0) {
      throw new IllegalArgumentException("la raiz de un arbol no tiene padre");
    }
    return (i-1)/2;
  }
}
}
package arbol;

public interface Heap {
    // Inserta un elemento en el heap
    void insert(Integer value);

    // Extrae el elemento superior del heap
    Integer extracTop() throws IllegalStateException;

    // Retorna el elemento superior del heap sin extraerlo
    Integer peekTop() throws IllegalStateException;

    // Retorna el tamaño actual del heap
    int size();

    // Verifica si el heap está vacío
    boolean isEmpty();

    // Verifica si el heap está lleno (en caso de un límite de capacidad)
    boolean isFull();

    // Imprime el contenido del heap (solo para propósitos de demostración)
    void printHeap();

    // Método toString para representar el heap como una cadena de texto
    String toString();

    /**
     * Clear all elements from the heap
     */
    void clear();

    /**Object clone() throws CloneNotSupportedException;
     * Método equals para comparar si dos heaps son iguales  
     */ 
    boolean equals(Object o);

    // Método repOk para verificar la invariante de representación del heap
    boolean repOk();
}

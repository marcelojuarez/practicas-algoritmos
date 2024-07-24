package pila;

public interface Pila<T> {

    /**
     * Devuelve el elemento de la pila
     * @return elemento de la pila
     */
    public T tope();

    /**
     * Apila un elemento a la pila
     */
    public boolean apilar(T elem);

    /**
     * Desapila el ultimo elemento de la pila
     */
    public T desapilar();

    /**
     * Devuelve la cantidad de elementos que contiene la pila
     * @return la cantidad de elementos de la pila
     */
    public int elementos();

    /**
     * Devuelve si la pila está o no vacía
     * @return si la pila está vacía
     */
    public boolean esVacia();

    /**
     * Vacía la pila
     */
    public void empty();
} 

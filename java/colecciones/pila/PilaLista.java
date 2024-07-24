package pila;
import lista.Nodov2;
public class PilaLista<T> implements Pila<T> {
  //atributos
  private Nodov2<T> cabeza;
  private int cant;
    
    //constructor 1
    public PilaLista (){
      cabeza = null;
      cant = 0;
    }
    
    //constructor con un elemento
    public PilaLista (T elem){
      Nodov2<T> aux = new Nodov2<T>(elem);
      cabeza = aux;
      cant++;
    }
    
    /**
     * Devuelve el elemento de la pila
     * @return elemento de la pila
     */
    public T tope(){
      return cabeza.getInfo();
    }

    /**
     * Apila un elemento a la pila
     */
    public boolean apilar(T elem){
      Nodov2<T> aux = new Nodov2<T>(elem);
      aux.setSiguiente(cabeza);
      cabeza = aux;
      return true;
    }

    /**
     * Desapila el ultimo elemento de la pila
     */
    public T desapilar(){
      T elem = cabeza.getInfo();
      cabeza = cabeza.getSiguiente();
      return elem;
    }

    /**
     * Devuelve la cantidad de elementos que contiene la pila
     * @return la cantidad de elementos de la pila
     */
    public int elementos(){
      return cant;
    }

    /**
     * Devuelve si la pila está o no vacía
     * @return si la pila está vacía
     */
    public boolean esVacia(){
      return (cant == 0);
    }

    /**
     * Vacía la pila
     */
    public void empty(){
      cabeza = null;
      cant = 0;
    }

    @Override
    public String toString(){
      String result = "[";
      Nodov2<T> cursor = new Nodov2<T>();
      cursor = cabeza;
      while (cursor != null) {
        result += cursor.getInfo().toString();
        if(!(cursor.getSiguiente() == null)){
          result += ",";
        } 
        cursor = cursor.getSiguiente();
      }
      return result + "]";
    }
  
    @Override
    public boolean equals (Object otro){
      if (otro == null) {
        return false;
      }
    
      if (otro == this) {
        return true;
      }
    
      if (!(otro instanceof PilaLista<?>)) {
        return false;
      }
      PilaLista<T> otPil = (PilaLista<T>) otro;
      if (this.cant != otPil.elementos()){
        return false;
      }
      Nodov2<T> cursor = new Nodov2<T>();
      Nodov2<T> cursor1 = new Nodov2<T>();
      cursor = this.cabeza;
      cursor1 = otPil.cabeza;
      while (cursor != null) {
        if (!(cursor.getInfo().equals(cursor1.getInfo()))) {
          return false;
        }
        cursor = cursor.getSiguiente();
        cursor1 = cursor1.getSiguiente();
      }
      return true;
    }
  
  }

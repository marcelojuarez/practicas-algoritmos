package pila;

import pila.Pila;
import java.util.Collection;

public class PilaList<T> implements Pila<T> {
  //atributos
  private NodoPil<T> cabeza;
  private int cant;
  
  public PilaList(){
    cabeza = null;
    cant = 0;
  }

  public PilaList(T elem) {
    cabeza = new NodoPil<>(elem);
    cant = 1;
  }


  public NodoPil<T> getCabeza() {
    return cabeza;
  }

  public void setCabeza(NodoPil<T> cabeza) {
    this.cabeza = cabeza;
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
      NodoPil<T> aux = new NodoPil<>(elem);
      aux.setNext(cabeza);
      cabeza = aux;
      cant++;
      return true;
    }

    /**
     * Desapila el ultimo elemento de la pila
     */
    public T desapilar(){
        if (this.esVacia()) {
          throw new IllegalStateException("error empty stack");
        }else{
          T result = cabeza.getInfo();
          cabeza = cabeza.getNext();
          cant++;
          return result;
       }
      }

    /**
     * Devuelve la cantidad de elementos que contiene la pila
     * @return la cantidad de elementos de la pila
     */
    public int elementos() {
      return cant;
    }

    /**
     * Devuelve si la pila está o no vacía
     * @return si la pila está vacía
     */
    public boolean esVacia(){
      return cant == 0;
    }

    /**
     * Vacía la pila
     */
    public void empty(){
      cabeza = null;
      cant = 0;
    }

    @Override 
    public String toString() {
      String result = "[";
      NodoPil<T> cursor = cabeza;

      while (cursor != null) {
        result += cursor.getInfo().toString();
        if (!(cursor.getNext() == null)) {
          result += " ,"; 
        }
        cursor = cursor.getNext();
      }
      return result + "]"; 
    }
  }

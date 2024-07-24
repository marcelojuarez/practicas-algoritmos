package cola;

import cola.Cola;
import java.util.Collection;

public class ColaArr<T> implements Cola<T> {
  //atributos
  public static final int MAX = 50;
  private Object[] cola;
  private int cant;
  
  public ColaArr() {
    this(MAX);
  }

  public ColaArr(int capacidad) {
    if (capacidad < 0) {
      throw new IllegalArgumentException("no puede crear una cola de capacidad negativa");
    }
    cola = new Object[capacidad];
    this.cant = 0;

  }

  public ColaArr(Collection<T> elems) {
    if (elems == null) {
      throw new IllegalStateException("la coleccion no posee elementos");
    }
  
    cola = new Object[Math.max(MAX,elems.size())];
    for (T e : elems) {
      this.encolar(e);
    }
  }

  /**
	* Permite evaluar si la cola no tiene elementos.
	* @return {@code true} sii la cola no tiene elementos
	*/
	public boolean esVacia(){
    return cant == 0;
  }

	/**
	* Encola un elemento en el comienzo de la cola.
	* @param elem el elemento a encolar
	* @return {@code true} sii el elemento pudo ser encolado
	*/
	public boolean encolar(T elem){
    if (this.elementos() == MAX) {
      return false;
    }
    int i = this.elementos() - 1;
    while (i != (-1)) {
      cola[i+1] = cola[i];
      i--;
    }
    this.cola[0] = elem;
    this.cant++;
    return true;
  }

	/**
	* Desencola el primer elemento de la cola, y retorna el elemento desencolado, si ésta no es vacía.
	* @return el primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T desencolar(){
    T result = (T) this.cola[this.elementos()-1];
    this.cola[this.elementos()-1] = null;
    cant--;
    return result;
  }

	/**
	* Retorna el primero de la cola, si ésta no es vacía.
	* @return primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T primero(){
    if (this.esVacia()) {
      throw new IllegalStateException("empty queue");
    }
  
    return (T) this.cola[0];
  }

	/**
	* Remueve todos los elementos en la cola.
	*/
	public void vaciar(){
    if (!(this.esVacia())) {
      for (int i = 0;i < this.elementos();i++) {
        this.cola[i] = null;
      }
    }
    cant = 0;
  }

	/**
	* @return cantidad de elementos en la cola.
	*/
	public int elementos(){
    return cant;
  }

	/**
	* Invariante de clase.
	* @return {@code true} sii la cola satisface su invariante de clase
	*/
	public boolean repOK(){
    return (this.elementos() <= MAX);
  }

	@Override
	public String toString(){
    String result = "|";
    for (int i = 0 ;i < this.elementos(); i++) {
      result += this.cola[i];
      if (!(i == this.elementos()-1)) {
        result += " ,";
      }
    }
    return result + "|";
  }

	@Override
	public boolean equals(Object other){
    if (other == null) {
      return false;
    }
  
    if (other == this) {
      return true;
    }
  
    if (!(other instanceof ColaArr)) {
      return false;
    }
  
    ColaArr otro = (ColaArr) other;

    if (!(otro.elementos() == this.elementos())) {
      return false;
    }
  
    for (int i = 0 ;i < this.elementos(); i++) {
      if (! (this.cola[i].equals(otro.cola[i]))){
        return false;
      }
    }
    return true;
  }


  /**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
  public T elemento(int index) {
       return (T) cola[index];
   }
}

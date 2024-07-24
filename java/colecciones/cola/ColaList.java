 package cola;

import cola.Cola;
import cola.NodoNew;

public class ColaList<T> implements Cola<T> {
  private NodoNew<T> cabeza;
  private int nroElem;

  public ColaList(){
    cabeza = null;
    nroElem = null;
  }
  
  public ColaList(Collection<T> elems) {
    for (T e : elems) {
      this.encolar(e);
    }
  }

  public NodoNew<T> getCabeza() {
    return cabeza;
  }
  
  /**
	* Permite evaluar si la cola no tiene elementos.
	* @return {@code true} sii la cola no tiene elementos
	*/
	public boolean esVacia(){
    return nroElem == 0;
  }

	/**
	* Encola un elemento en el comienzo de la cola.
	* @param elem el elemento a encolar
	* @return {@code true} sii el elemento pudo ser encolado
	*/
	public boolean encolar(T elem){
    NodoNew<T> aux = new NodoNew<T>(elem);
    aux.setNext(this.getCabeza());
    cabeza = aux;
    nroElem++;
    return true; 
  }

	/**
	* Desencola el primer elemento de la cola, y retorna el elemento desencolado, si ésta no es vacía.
	* @return el primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T desencolar(){
    if (this.esVacia()) {
      throw new IllegalStateException("empty queue");
    }
    
    NodoNew<T> cursor = this.cabeza;

    while ((cursor.getNext()).getNext() != null) {
      cursor = cursor.getNext();
    }
    T result = (cursor.getNext()).getInfo();
    cursor.setNext(null);
    nroElem--;
    return result;
  }

	/**
	* Retorna el primero de la cola, si ésta no es vacía.
	* @return primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T primero(){
    return cabeza.getInfo();
  }

	/**
	* Remueve todos los elementos en la cola.
	*/
	public void vaciar(){
    cabeza = null;
    nroElem = 0;
  }

	/**
	* @return cantidad de elementos en la cola.
	*/
	public int elementos(){
    return nroElem;
  }

	/**
	* Invariante de clase.
	* @return {@code true} sii la cola satisface su invariante de clase
	*/
	public boolean repOK(){
    return true;
  }

	@Override
	public String toString(){
    String result = "";
    return result;
  }

	@Override
	public boolean equals(Object other){
    if (other == null) {
      return false;
    }
    
    if (other == this) {
      return true;
    }
  
    if (!(other instanceof ColaList)) {
      return false;
    }
  
    ColaList otro = (ColaList) other;

    if (!(otro.elementos() == this.elementos())) {
      return false;
    }

    NodoNew<T> cursor = cabeza;
    NodoNew<T> otroCursor = otro.getCabeza();
    while (cursor != null) {
      if (!(this.cursor.getInfo().equals(otroCursor.getInfo()))) {
        return false;
      }
      cursor = cursor.getNext();
      otroCursor = otroCursor.getNext();
    }
    return true;
  }
}

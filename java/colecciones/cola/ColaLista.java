package cola;

import colecciones.lista.Nodo;

public class ColaLista<T> implements Cola<T>{
	private Nodo<T> cabeza;
	private int cant = 0;
/**
	* Permite evaluar si la cola no tiene elementos.
	* @return {@code true} sii la cola no tiene elementos
	*/
	public boolean esVacia(){
		return (cant == 0);
	}

	/**
	* Encola un elemento en el comienzo de la cola.
	* @param elem el elemento a encolar
	* @return {@code true} sii el elemento pudo ser encolado
	*/
	public boolean encolar(T elem){
		if(this.esVacia()){
			Nodo<T> aux = new Nodo<T>(elem);
			cabeza = aux;
			aux = null;
			cant++;
			return true;
		}
		Nodo<T> cursor = new Nodo<>(elem);
		cursor = cabeza;
		while(cursor.getSiguiente() != null){
			cursor = cursor.getSiguiente();
		}	
		Nodo<T> aux = new Nodo<>(elem);
		cursor.setSiguiente(aux);
		aux.setSiguiente(null);
		cant++;
		aux = null;
		cursor = null;
		return true;
	}

	/**
	* Desencola el primer elemento de la cola, y retorna el elemento desencolado, si ésta no es vacía.
	* @return el primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T desencolar(){
		if(this.esVacia()){
			throw new IllegalStateException("cola vacia");
		}
		Nodo<T> aux = new Nodo<>(cabeza.getElem());
		cabeza = cabeza.getSiguiente();
		cant--;
		return aux.getElem();
	}

	/**
	* Retorna el primero de la cola, si ésta no es vacía.
	* @return primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T primero(){
		if(this.esVacia()){
			throw new IllegalStateException("cola vacia");
		}
		T elem = (T) cabeza.getElem();
		return elem;
	}

	/**
	* Remueve todos los elementos en la cola.
	*/
	public void vaciar(){
		cabeza = null;
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
		return(cant == elementos());
	}

	@Override
	public String toString(){
		String result = "[";
		Nodo<T> cursor = new Nodo<>(cabeza.getElem());
		cursor = cabeza;
		while(cursor != null){
			result = result + String.valueOf(cursor.getElem());
			if(!(cursor.getSiguiente() == null)){
				result = result + ",";
			}
			cursor = cursor.getSiguiente();
		}
		return result + "]";
	}

	@Override
	public boolean equals(Object other){
		if(other == null)
			return false;

		if(other == this)
			return true;
	
		if(!(other instanceof ColaLista<?>))
			return false;
		ColaLista<T> otraCola = (ColaLista<T>) other;
	
		if(!(otraCola.elementos() == this.elementos()))
			return false;

		Nodo<T> cursor = new Nodo<T>(cabeza.getElem());
		Nodo<T> cursorOtro = new Nodo<T>(cabeza.getElem());
		cursorOtro = otraCola.cabeza;
		cursor = this.cabeza;
		while(cursor != null){
			if(!(this.cabeza.getElem() == otraCola.cabeza.getElem())){
				return false;
			}	
			cursor = cursor.getSiguiente();
			cursorOtro = cursorOtro.getSiguiente();
		}	
		return true;
	}

}

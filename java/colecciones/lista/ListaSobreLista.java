package colecciones.lista;

import colecciones.lista.Lista;
import colecciones.lista.NodoNew;

public class ListaSobreLista<T> implements Lista<T> {
  //atributos
  private NodoNew<T> cabeza;
  private int cant;
  
  //getters
  public NodoNew getCabeza(){
    return cabeza;
  }

  public ListaSobreLista() {
    cabeza = null;
    cant = 0;
  }
  public ListaSobreLista(T elem){
    cabeza = new NodoNew<T>(elem);
    cant++;
  }
	/**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	public boolean agregar(T elem){

    if (cant == 0) {
      cabeza = new NodoNew<T>(elem);
      cant++;
      return true;
    } 

  NodoNew<T> cursor = cabeza;

    while (cursor.getNext()!= null) {
      cursor = cursor.getNext();
    }
    NodoNew<T> aux = new NodoNew<T>(elem);
    cursor.setNext(aux);
    cant++;
    return true;
  }
	
	/**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	public boolean agregarTodos(Lista<T> otraLista){
    if (otraLista.elementos() == 0) {
      return false;
    }
    for (int i = 0;i < otraLista.elementos();i++) {
      this.agregar(otraLista.obtener(i));
    }
    return true;
  }

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice){
		if (indice < 0 || indice > cant) {
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}
	
		if (indice == 0) {
			NodoNew<T> aux = new NodoNew<T>(elem);
			aux.setNext(cabeza);
			cabeza = aux;
			cant++;
			return true;
		}
	
		if (indice == cant) {
			this.agregar(elem);
			return true;
		}

		NodoNew<T> cursor = cabeza;
		for (int i = 0 ;i < indice -1; i++) {
			cursor = cursor.getNext();
		}
		NodoNew<T> aux = new NodoNew<T>(elem);
		aux.setNext(cursor.getNext());
		cursor.setNext(aux);
		cant++;
		return true;
	}

	/**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T eliminar(int indice){
		if (indice < 0 || indice >= this.elementos()) {
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}
		T result = this.obtener(indice);
		if (indice == 0) {
			cabeza = cabeza.getNext();
			cant--;
			return result;
		}
		NodoNew<T> cursor = cabeza;
		for (int i = 0;i < indice-1;i++){
			cursor = cursor.getNext();
		}
		NodoNew<T> aux = cursor.getNext();

		cursor.setNext(aux.getNext());
		aux = null;
		cant--;
		return result;
	}

	/**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T obtener(int indice){
    if (indice < 0 || indice >= this.cant) {
      throw new IndexOutOfBoundsException("indice fuera de rango");
    }
    T result;
      
    int i = 0;
    NodoNew<T> aux = cabeza;
    while (i < indice ) {
      aux = aux.getNext();
      i++;
    }
    result = aux.getInfo();
    return result; 
  }
	
	/**
	* Retorna la porción de esta lista entre los índice especificados {@code desdeInd}, inclusivo, y {@code hastaInd}, exclusivo, en una nueva lista.
	* Si {@code fromInd} es igual a {@code hastaInd} se retorna un a lista vacía.
	* @param desdeInd el índice inferior, inclusivo
	* @param hastaInd el índice superior, exclusivo
	* @return una nueva lista formada con los elementos entre {@code desdeInd} hasta {@code hastaInd - 1} de esta lista
	* @throws IndexOutOfBoundsException si ({@code fromInd} &lt; {@code 0} || {@code hastaInd} &gt; {@code #elementos()} || {@code desdeInd} &gt; {@code hastaInd})
	* @see #elementos() 
	*/
	public Lista<T> subLista(int desdeInd, int hastaInd){
    ListaSobreLista<T> result = new ListaSobreLista<T>();
    if (desdeInd < 0 || hastaInd >= this.cant || desdeInd > hastaInd) {
      throw new IndexOutOfBoundsException("indice fuera de rango");
    }
    
    for (int i = desdeInd ;i < hastaInd; i++) {
      result.agregar(this.obtener(i));
    }
		return result;
  }

	/**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/
	public boolean contiene(T elem){
    if (this.cant == 0) {
      return false;
    }
    NodoNew<T> cursor = cabeza;
    while (cursor != null) {
      if (cursor.getInfo().equals(elem)) {
        return true;
      }
      cursor = cursor.getNext();
    }
    return false;
  }

	/**
	* Remueve todos los elementos en la lista.
	*/
	public void vaciar(){
    cabeza = null;
    cant = 0;
  }
	
	/**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	public int elementos(){
    return cant;
  }

	/**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia(){
    return cant == 0;
  }

	/**
	* Invariante de clase.
	* @return {@code true} sii la lista satisface su invariante de clase
	*/
	public boolean repOK(){
		return true;
	}

	/**
	* Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]"). 
	* Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
	* @return una representación como {@code String} de esta lista
	*/
	@Override
	public String toString(){
    String result = "[" ;
    
		for (int i = 0 ;i < this.elementos();i++) {
				result += this.obtener(i);
			if (i != this.elementos()-1) {
				result += " ,";
			}
		}

    return result + "]";
  }
	
	/**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
	*/
	@Override
	public boolean equals(Object otro){
		if (otro == null) {
			return false;
		}
		
		if (otro == this) {
			return true;
		}
	
		if (!(otro instanceof ListaSobreLista)) {
			return false;
		}
		
		ListaSobreLista otro2 = (ListaSobreLista) otro;

		if (!(this.elementos() == otro2.elementos())) {
			return false;
		}
	
		for (int i = 0 ;i < this.elementos(); i++) {
			if (!(this.obtener(i).equals(otro2.obtener(i)))) {
				return false;
			}
		}
		return true;
	}
}

package colecciones.lista;

import java.util.List;

import colecciones.lista.Lista;

public class ListaSobreArreglo<T> implements Lista<T> {
  //atributos
  public final int MAX = 50;
  private T[] lista;
  private int nroElem;

  //constructor

  public ListaSobreArreglo(){
    lista = (T[]) new Object[MAX]; 
    nroElem = 0;
  }


  public ListaSobreArreglo(ListaSobreArreglo list) {
    lista = (T[]) new Object[MAX];
    nroElem = 0;
    for (int i = 0 ;i < list.elementos(); i++) {
      this.agregar(this.obtener(i));
      nroElem++;
    }
  }
  /**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	public boolean agregar(T elem){
    if (nroElem == MAX) {
      return false;
    }else{
      lista[nroElem] = elem;
      nroElem++;
      return true;
    }
  }
	
	/**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	public boolean agregarTodos(Lista<T> otraLista){
    if (MAX-nroElem > otraLista.elementos()) {
      for (int i = 0;i < otraLista.elementos();i++) {
        this.agregar(otraLista.obtener(i));
      }
      return true;
    }else{
      return false;
    }
  }

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice){
		if (indice < 0 || indice > nroElem) {
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}
		
		if (nroElem == MAX) {
			return false;
		}
	
		if (indice == nroElem) {
			this.agregar(elem);
		}
		
		int i = nroElem-1;
		while (i != indice-1) {
			lista[i+1] = lista[i];
			i++;
		}
		lista[indice] = elem;
		nroElem++;
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
		T result;
		if (indice < 0 || indice >= this.nroElem) {
			throw new IndexOutOfBoundsException("indice fuera de rango"); 
		}
		result = lista[indice];
		if (indice  == nroElem-1) {
			nroElem--;
			lista[indice] = null;
			return result; 
		}
	
		lista[indice] = null;
		for (int i = indice ;i < nroElem ;i++) {
			lista[i] = lista[i+1];
		}
		nroElem--;	
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
    if (indice < 0 || indice >= this.nroElem) {
      throw new IndexOutOfBoundsException("indice fuera de rango");
    }else{
      return lista[indice];
    }
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
		ListaSobreArreglo aux = new ListaSobreArreglo<>();
		if (desdeInd < 0 || hastaInd >= nroElem || desdeInd > hastaInd) {
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}
		
		for (int i = desdeInd ;i < hastaInd;i++){
			aux.agregar(this.obtener(i));
		}
		return aux;
	}

	/**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/
	public boolean contiene(T elem){
		if (this.nroElem == 0) {
			return false;
		}
	
		for (int i = 0;i < this.nroElem ;i++) {
			if (this.obtener(i).equals(elem)) {
				return true;
			}
		}
		return false;
	}

	/**
	* Remueve todos los elementos en la lista.
	*/
	public void vaciar(){
		for (int i = 0;i < nroElem;i++) {
			lista[i] = null;
		}
		nroElem = 0;
	}
	
	/**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	public int elementos(){
    return nroElem;
  }

	/**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia(){
    return nroElem == 0;
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
		String result = "[";
		for (int i = 0 ; i < nroElem; i++) {
			result += this.obtener(i).toString();
			if (i+1 != nroElem) {
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
	
		if (!(otro instanceof ListaSobreArreglo)) {
			return false;
		}
		
		ListaSobreArreglo otro2 = (ListaSobreArreglo) otro;

		if (!(this.elementos() == otro2.elementos())) {
			return false;
		}

		for (int i = 0;i < nroElem;i++) {
			if (!(this.obtener(i).equals(otro2.obtener(i)))){
				return false;
			}
		}
		return true;
	}

}
package cola;

import java.util.Collection;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	/**
	* Permite evaluar si la cola no tiene elementos.
	* @return {@code true} sii la cola no tiene elementos
	*/
	@Override
	public boolean esVacia() {
		return(elementos == 0);	
	}

	/**
	* @return cantidad de elementos en la cola.
	*/
	@Override
	public int elementos() {
		return elementos;
	}

	/**
	* Encola un elemento en el comienzo de la cola.
	* @param elem el elemento a encolar
	* @return {@code true} sii el elemento pudo ser encolado
	*/
	@Override
	public boolean encolar(T elem) {
		if(elementos == CAPACIDAD_POR_DEFECTO){
			return false;
		}else{
			arreglo[elementos] = elem;
			elementos++;
			return true;
		}		
	}

	/**
	* Desencola el primer elemento de la cola, y retorna el elemento desencolado, si ésta no es vacía.
	* @return el primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	@Override
	public T desencolar() {
		if(this.esVacia()){
			throw new IllegalStateException("cola vacia");
		}
		T elem =(T)arreglo[0];
		for(int i = 0; i< elementos - 1;i++){
			arreglo[i] = arreglo[i+1];
		}
		elementos--;
		return elem;
	}

	/**
	* Retorna el primero de la cola, si ésta no es vacía.
	* @return primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	@Override
	public T primero() {
		if(this.esVacia()){
			throw new IllegalStateException("cola vacia");
		}	
		return (T)this.arreglo[0];
	}

	
	/**
	* Remueve todos los elementos en la cola.
	*/
	@Override
	public void vaciar() {
		if (!(esVacia())){
			for (int i = 0 ; i < this.elementos(); i++){
				arreglo[i] = null;
			}
		}
		elementos = 0;	
	}

	
	/**
	* Invariante de clase.
	* @return {@code true} sii la cola satisface su invariante de clase
	*/
	@Override
	public boolean repOK() {
		return(elementos <= CAPACIDAD_POR_DEFECTO);	
	}

	@Override
	public String toString() {
		if(elementos == 0){
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}	
		String result = "[";
		for(int i = 0;i < elementos;i++){
			result = result + String.valueOf(arreglo[0]);
			if(!(i + 1 == elementos())){
				result = result + ",";
			}
		}
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if(other == null)
			return false;
		if(other == this)
			return true;
		if(!(other instanceof ColaArregloFijo<?>))	
			return false;
		ColaArregloFijo otroCola = (ColaArregloFijo) other;
		if(!(this.elementos() == otroCola.elementos()))
			return false;
		for(int i = 0;i< elementos();i++){
			if(!(arreglo[i] == otroCola.arreglo[i])){
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
        	return (T) arreglo[index];
    	}

}

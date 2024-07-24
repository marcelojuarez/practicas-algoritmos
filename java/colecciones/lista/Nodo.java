package colecciones.lista;

public class Nodo<T>{
	
	private T elem;
	private Nodo<T> siguiente;	

	//getter para obtener el valor
	public T getElem(){
		return elem;
	}

	//setter para cambiar el valor
	public void setElem(T elem){
		this.elem = elem;
	}
	
	//getter para obtener la direccion
	public Nodo<T> getSiguiente(){
		return this.siguiente;
	}
	//setter para cambiar la direccion
	public void setSiguiente(Nodo<T> siguiente){
		this.siguiente = siguiente;
	}

	//constructor 
	public Nodo(T elem){
		this.elem = elem;
		this.siguiente = null;
	}

	
}

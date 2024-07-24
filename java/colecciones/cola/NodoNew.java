package colecciones.lista;

public class NodoNew<T>{
  //atributos de nodo
  private T info;
  private NodoNew<T> next;  

  //getters
  public T getInfo(){
    return info;
  }

  public NodoNew getNext() {
    return next;
  }

  //setters
  public void setInfo(T info){
    this.info = info;
  }

  public void setNext(NodoNew next) {
    this.next = next;
  }
  //constructor
  public NodoNew() {
    this.info = null;
    this.next = null;
  }
  //constructor con parametros
  public NodoNew(T info){
    this.info = info;
    this.next = null;
  }

  //constructor con parametros
  public NodoNew(T info, NodoNew next){
    this.info = info;
    this.next = next ;
  }
}

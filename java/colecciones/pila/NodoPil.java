package pila;
public class NodoPil<T> {
  //atributos
  private T info;
  private NodoPil<T> next;

  //getters
  public T getInfo(){
    return info;
  }

  public NodoPil<T> getNext(){
    return next;
  }

  //setters 
  public void setNext(NodoPil<T> next) {
    this.next = next;
  }

  public void setInfo(T info) {
    this.info = info;
  }


  public NodoPil(){
    info = null;
    next = null;
  }

  public NodoPil(T info) {
    this.info = info;
    this.next = null;
  }

  public NodoPil(T info, NodoPil<T> next) {
    this.info = info;
    this.next = next;
  }

}

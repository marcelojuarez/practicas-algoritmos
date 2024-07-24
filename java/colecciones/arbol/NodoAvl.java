package colecciones.arbol;

public class NodoAvl<T> {
  //atributos
  private T info;
  private NodoAvl<T> izq;
  private NodoAvl<T> der;

  //constructor
  public NodoAvl(){
    info = null;
    izq = null;
    der = null;
  }

  public NodoAvl(T info) {
    this.info = info;
    izq = null;
    der = null;
  }

  public NodoAvl(T info, NodoAvl<T> izq, NodoAvl<T> der) {
    this.info = info;
    this.izq = izq;
    this.der = der;
  }

  //getters
  public T getInfo(){
    return info;
  }

  public NodoAvl<T> getIzq() {
    return this.izq;
  }

  public NodoAvl<T> getDer() {
    return this.der;
  }
  
  //setters
  public void setInfo(T info) {
    this.info = info;
  }

  public void setIzq(NodoAvl<T> izq) {
    this.izq = izq;
  }

  public void setDer(NodoAvl<T> der) {
    this.der = der;
  }
}

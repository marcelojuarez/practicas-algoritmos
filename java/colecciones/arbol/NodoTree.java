package colecciones.arbol;

public class NodoTree<T> {
  //atributos
  private T info;
  private NodoTree<T> izq;
  private NodoTree<T> der;

  //constructor
  public NodoTree(){
    info = null;
    izq = null;
    der = null;
  }

  public NodoTree(T info) {
    this.info = info;
    izq = null;
    der = null;
  }

  public NodoTree(T info, NodoTree<T> izq, NodoTree<T> der) {
    this.info = info;
    this.izq = izq;
    this.der = der;
  }

  //getters
  public T getInfo(){
    return info;
  }

  public NodoTree<T> getIzq() {
    return this.izq;
  }

  public NodoTree<T> getDer() {
    return this.der;
  }
  
  //setters
  public void setInfo(T info) {
    this.info = info;
  }

  public void setIzq(NodoTree<T> izq) {
    this.izq = izq;
  }

  public void setDer(NodoTree<T> der) {
    this.der = der;
  }
}

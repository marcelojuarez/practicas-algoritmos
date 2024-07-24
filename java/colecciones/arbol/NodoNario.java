package colecciones.arbol;

import java.util.List;
import java.util.Collection;

public class NodoNario<T> {
  //atributos
  private T info;
  private List<NodoNario<T>> hijos;

  //constructor 
  public NodoNario(T info) {
    this.info = info;
    this.hijos = null;
  }
 
  public NodoNario(T info, Collection<NodoNario<T>> hijos){
    this.info = info;
    for (NodoNario<T> n : hijos) {
      this.hijos.add(n);
    }
  }

  //setters
  public void setInfo(T info) {
    this.info = info;
  }

  public void setHijos(List<NodoNario<T>> hijos){
    this.hijos = hijos;
  }
  
  //getters
  public T getInfo(){
    return info;
  }

  public List<NodoNario<T>> getHijos() {
    return hijos;
  }
}

package colecciones.arbol;

import java.util.Comparator;

public class ArbolNario<T>  {
  //atributos
  private NodoNario<T> raiz;
  private final Comparator<? super T> comparador;

  //constructor 
  public ArbolNario(Comparator<? super T> comparador){
    this.raiz = null;
    this.comparador = comparador;
  }

  public ArbolNario(Comparator<? super T> comparador, NodoNario<T> raiz) {
    this.raiz = raiz;
    this.comparador = comparador;
  }

  

}

package colecciones.arbol;

import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class ABB<T> implements Diccionario<T> {
  //atributos
  private NodoTree<T> raiz;

  private final Comparator<? super T> comparador;

  //constructores
  public ABB(Comparator<? super T> comparador) {
    this.raiz = null;
    this.comparador = comparador;
  }

  public ABB(Comparator<? super T> comparator, Collection<T> elems) {
    if (elems.size() == 0) {
      throw new IllegalStateException("empty collection");
    }
    
    this.raiz = null;
    this.comparador = comparator;
  
    for (T e : elems) {
      this.insertar(e);
    }

  }

  public NodoTree<T> getRaiz() {
    return raiz;
  }

  public void setRaiz(NodoTree<T> newRoot) {
    this.raiz = newRoot;
  }
  

    /**
    * Inserta un elemento en el arbol, siempre que el elemento no exista.
    * @param elem El elemento a insertar.
    */
  public void insertar( T elem ){
    if (this.esVacio()) {
      raiz = new NodoTree<>(elem);
    }else{
      this.insertarRec(raiz, elem);
    }
  }

  private NodoTree<T> insertarRec(NodoTree<T> root, T elem){
    if (root == null) {
       return new NodoTree<>(elem);
    }
  
    int cmp = comparador.compare(root.getInfo(), elem);
    if (cmp == 0) {
      return root;
    }else if (cmp > 0) {
      root.setIzq(insertarRec(root.getIzq(), elem));
    }else{
      root.setDer(insertarRec(root.getDer(), elem));
    }
    return root;
  }

   /**
    * Busca un elemento dentro del arbol.
    * @param elem El elemento a encontrar. No puede ser null.
    * @return {@code true} sii encuentra elem en el arbol.
    */
   public boolean pertenece (T elem){
    return busquedaRec(this.raiz, elem);
   }

   private boolean busquedaRec(NodoTree<T> root, T elem) {
    if (root == null) {
      return false;
    }
    
    int cmp = comparador.compare(root.getInfo(), elem);

    if (cmp == 0) {
      return true;
    } else if (cmp > 0) {
      return busquedaRec(root.getIzq(), elem);
    }else{
      return busquedaRec(root.getDer(), elem);
    }
  
  }


   /**
    * Elimina un elemento dado del arbol, si el elemento existe en el arbol.
    * @param elem elemento a borrar del arbol.
    */
   public void borrar(T elem){
    if (this.esVacio() || !this.pertenece(elem)){
      return;
    }else{
      if (this.elementos() == 1) {
        this.vaciar();
      } else{
        this.borrarRec(raiz, elem);
      }
    }
   }

   private NodoTree<T> borrarRec(NodoTree<T> root, T elem){
    if (root == null) {
      return null;
    }
    int cmp = comparador.compare(root.getInfo(), elem);

    if (cmp == 0) {
      if (root.getIzq() == null && root.getDer() == null) {
        root = null;
        return null;
      } else if (root.getIzq() == null && root.getDer() != null) {
        T sucesor = this.sucesor(elem);
        root.setInfo(sucesor);
        root.setDer(borrarRec(root.getDer(), sucesor));
        return root;
      } else if (root.getIzq() != null && root.getDer() == null) {
        T predecesor = this.predecesor(elem);
        root.setInfo(predecesor);
        root.setIzq(borrarRec(root.getIzq(), predecesor));
        return root;
      }else{
        T sucesor = this.sucesor(elem);
        root.setInfo(sucesor);
        root.setDer(borrarRec(root.getDer(), sucesor));
        return root;
      }
    }else if (cmp > 0) {
      root.setIzq(borrarRec(root.getIzq(), elem));
    }else{
      root.setDer(borrarRec(root.getDer(), elem));
    } 
    return root;
  }
   
   /**
   * Elimina todos los nodos de este árbol, dejándolo vacío.
   */
  public void vaciar(){
    this.raiz = null;
  }
   
   /**
   * Retorna el valor asociado a la raíz del árbol.
   * @return el valor asociado a la raíz
   * @throws IllegalStateException si el árbol está vacío
   */
   public T raiz(){
    return raiz.getInfo();
   }

   /**
   * Retorna el subárbol izquierdo.
   * @return el subárbol izquierdo.
   */
   public Diccionario<T> subArbolIzquierdo(){
      if (this.raiz == null || this.raiz.getIzq() == null) {
        return null;
      }
      
      ABB<T> subIzq = new ABB<>(comparador);
      subIzq.setRaiz(raiz.getIzq());
      return subIzq;
    }
   
   /**
   * Retorna el subarbol derecho.
   * @return el subarbol derecho.
   */
   public Diccionario<T> subArbolDerecho(){
    if (this.raiz == null || this.raiz.getDer() == null) {
      return null;
    }
    
    ABB<T> subDer = new ABB<>(comparador);
    subDer.setRaiz(raiz.getDer());
    return subDer;
   }
   
   /**
   * Retorna la cantidad de elementos en este árbol.
   * @return cuantos elementos contiene el árbol.
   */
   public int elementos(){
    return elemRec(raiz);
   }
   
   private int elemRec(NodoTree<T> root) {
    if (root == null) {
      return 0;
    }
    
    return 1 + elemRec(root.getIzq()) + elemRec(root.getDer());
  
   }

   /**
   * Retorna la altura del árbol, definida como:
   * <ul>
   * <li>La altura de un árbol vacío es {@code 0}</li>
   * <li>La altura de un árbol no vacío es {@code 1 + } el máximo de las alturas de los sub arboles izquierdo y derecho</li>
   * </ul>
   * @return la altura del árbol.
   */
   public int altura(){
    return altRec(raiz);
   }
   private int altRec(NodoTree<T> root) {
    if (root == null) {
      return 0;
    }
   
    return 1 + Math.max(altRec(root.getIzq()), altRec (root.getDer()));
  }
   /**
   * Permite consultar si el árbol está vacío o no.
   * <p>
   * Este método es equivalente a <pre>elementos() == 0</pre> y <pre>altura() == 0</pre>
   * @return {@code true} sii este árbol está vacío.
   */
   public boolean esVacio(){
    return raiz == null;
   }


   /**
    * Retorna el mayor valor del arbol si no es vacio.
    * @return el mayor valor del arbol si no es vacio o null.
    */
   public T mayorValor(){
    if (this.esVacio()) {
      return null;
    }

    NodoTree<T> nuevaRaiz = this.raiz;

    if (nuevaRaiz.getDer() == null) {
      return nuevaRaiz.getInfo();
    }

    while(nuevaRaiz.getDer()!= null){
      nuevaRaiz = nuevaRaiz.getDer();
    }
    return nuevaRaiz.getInfo();
  }

   /**
    * Retorna el menor valor del arbol si no es vacio.
    * @return el menor valor del arbol si no es vacio o null.
    */
   public T menorValor(){
    if (this.esVacio()) {
      return null;
    }

    NodoTree<T> nuevaRaiz = this.raiz;

    if (nuevaRaiz.getIzq() == null) {
      return nuevaRaiz.getInfo();
    }

    while(nuevaRaiz.getIzq() != null){
      nuevaRaiz = nuevaRaiz.getIzq();
    }
    return nuevaRaiz.getInfo();
   }

   /**
    *  El sucesor de un elemento {@code elem} en el árbol es el elemento más pequeño mayor que elem.
    * @param elem elemento del que se quiere encontrar el inmediato sucesor.
    * @return inmediato sucesor del elemento dado si existe en el arbol.
    */
   public T sucesor(T elem){
    if (!(this.pertenece(elem))) {
      throw new IllegalArgumentException("no existe el elemento");
    }
     return sucesorRec(raiz, elem, raiz.getInfo());
   }
  
    private T sucesorRec(NodoTree<T> root, T elem, T succ) {
      int cmp = comparador.compare(root.getInfo(), elem);
      if (cmp == 0) {
        if (root.getDer() == null){
          return succ;
        }else{
          root = root.getDer();
          while (root.getIzq() != null) {
            root = root.getIzq();
          }
          return root.getInfo();
        }
      }else if (cmp > 0) {
        return sucesorRec(root.getIzq(), elem, root.getInfo());
      } else {
        return sucesorRec(root.getDer(), elem, root.getInfo());
      }
    }
   

   /**
    *  El predecesor de un elemento {@code elem} en el árbol es el elemento más grande menor que elem.
    * @param elem elemento del que se quiere encontrar el inmediato predecesor.
    * @return inmediato predecesor del elemento dado si existe en el arbol.
    */
   public T predecesor(T elem){
    if (!(this.pertenece(elem))) {
      throw new IllegalArgumentException("no existe el elemento");
    }
     return predecesorRec(raiz, elem, raiz.getInfo());
   }

   private T predecesorRec(NodoTree<T> root, T elem, T pred) {
    int cmp = comparador.compare(root.getInfo(), elem);
    if (cmp == 0) {
      if (root.getIzq() == null){
        return pred;
      }else{
        root = root.getIzq();
        while (root.getDer() != null) {
          root = root.getDer();
        }
        return root.getInfo();
      }
    }else if (cmp > 0) {
      return predecesorRec(root.getIzq(), elem, root.getInfo());
    } else {
      return predecesorRec(root.getDer(), elem, root.getInfo());
    }
   }

   /**
    * Verifica que esta instancia de {@code Diccionario} cumple con su invariante.
    * <p>
    * El invariante consiste en:
    * <ul>
    * <li>No hay ciclos, no se puede alcanzar a un nodo a partir de sus descendientes.</li>
    * <li>Todo nodo tiene a lo sumo dos descendientes (uno izquierdo y uno derecho) y no pueden ser iguales.</li>
    * <li>Todo nodo en un árbol no vacío es alcanzable desde la raíz.</li>
    * <li>Para cada nodo en el árbol existe un solo camino para alcanzarlo desde la raíz.</li>
    * <li>La cantidad de nodos en el árbol debe ser igual al resultado del método {@code elementos()}.</li>
    * <li> Los nodos del arbol se organizan en un orden total y deben cumplir que:
    *     <ul>
    *        <li> El subarbol izquierdo de un nodo contiene solo nodos con valores menores que el valor del nodo. </li>
    *        <li> El subarbol derecho de un nodo contiene solo nodos con valores mayores que el valor del nodo.</li>
    *        <li> Los subarboles izquierdo y derecho también deben ser un diccionario.</>
    *    </ul>
    * </li>
    * </ul>
    * @return {@code true} sii el invariante se cumple
    */
   public boolean repOK(){
    
    Set<NodoTree<T>> visited = new HashSet<>();
    if (!(arbolSinCiclosYAlcanzable(this.raiz, visited))) {
      return false;
    }
  
    if (visited.size() != this.elementos()) {
      return false;
    }
  
    return esOrdenado(raiz,null,null);
  }
  
  //metodo para ver si un arbol no tiene ciclos y cualquier nodo es alcanzable por la raiz 
  private boolean arbolSinCiclosYAlcanzable(NodoTree<T> root, Set<NodoTree<T>> visited){
    if (root == null) {
      return true;
    }
  
    if (visited.contains(root)){
      return false;
    }

    visited.add(root);

    return arbolSinCiclosYAlcanzable(root.getIzq(), visited) && arbolSinCiclosYAlcanzable(root.getDer(), visited);
  }
  
  //metodo para ver si el arbol esta ordenado
  private boolean esOrdenado(NodoTree<T> root, T min, T max) {
    if (root == null) {
      return true;
    }
    
    if ((min != null && comparador.compare(root.getInfo(), min) <= 0)||
        (max != null && comparador.compare(root.getInfo(), max) >= 0)  ) {
      return false;
    }

    return esOrdenado(root.getIzq(), min, root.getInfo()) &&
           esOrdenado(root.getDer(), root.getInfo(), max);
  
  }

  /**
    * Una representación del árbol ya sea en múltiples líneas mediante
    * una visita de arriba hacia abajo y de izquierda a derecha, o en una
    * sola línea utilizando un recorrido in order.
    * @return la representación de este árbol en forma de {@code String}.
    * @see Orden#INORDER
    */
   @Override
   public String toString(){
    String result;
    if (esVacio()){
      result = "{}";
    }else{
      result = String.valueOf(aLista());
    }

    return result;
   }

   /**
    * Compara dos árboles binarios, la comparación contempla no solo los valores almacenados, sino también la estructura.
    * @return {@code true} sii los árboles son iguales.
    */
   @Override
   public boolean equals(Object other){
    if (other == null) {
      return false;
    }
    
    if (other == this) {
      return false;
    }
  
    if (!(other instanceof ABB<?>)) {
      return false;
    }
    ABB<T> otro = (ABB<T>) other;

    return equalsHelper(otro.getRaiz(),this.getRaiz());
  
  }

  private boolean equalsHelper(NodoTree<T> raiz1, NodoTree<T> raiz2) {
    if (raiz1 == null && raiz2 == null) {
      return true;
    }
  
    if (raiz1 == null || raiz2 == null) {
      return false;
    }
    
    return raiz.getInfo().equals(raiz.getInfo()) && 
      equalsHelper(raiz1.getIzq(), raiz2.getIzq()) && equalsHelper(raiz1.getDer(), raiz2.getDer());
  
  }

   /**
   * Retorna una lista con los elementos almacenados en este árbol usando un recorrido {@code INORDER}.
   * <p>
   * Llamar a este método es equivalente a llamar a <pre>aLista(Orden.INORDER)</pre>
   * @return retorna una lista con los elementos de este árbol según un recorrido {@code INORDER}.
   */
   public List<T> aLista(){
    return aLista(Orden.INORDER);
   }
   
   /**
   * Retorna una lista con los elementos almacenados en este árbol usando un recorrido determinado.
   * @param orden define el recorrido que se va a utilizar para recolectar los valores.
   * @return retorna una lista con los elementos de este árbol según el recorrido definido por {@code orden}.
   */
  public List<T> aLista(Orden orden){
    List<T> elementos = new LinkedList<>();
    switch (orden) {
      case INORDER:
        return aListaInOrderIT(this.raiz, elementos);
      case PREORDER:
        return aListaPreOrder(this.raiz, elementos);
      case POSTORDER:
        return aListaPostOrder(this.raiz, elementos);
    }

    return elementos;
  }

  /* (non-Javadoc)
    * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
    * y va llenando la lista con los elementos del árbol según un recorrido in order.
    * Si bien el perfil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
    */
  private List<T> aListaInOrder(NodoTree<T> raiz,List<T> elementos) {
    if (raiz.getIzq() != null) {
      aListaInOrder(raiz.getIzq(), elementos);
    }
  
    elementos.add(raiz.getInfo());

    if (raiz.getDer() != null) {
      aListaInOrder(raiz.getDer(), elementos);
    } 
    
    return elementos;
  }

  
  private List<T> aListaInOrderIT(NodoTree<T> raiz, List<T> elementos) {
    Stack<NodoTree<T>> pila = new Stack<>();
    NodoTree<T> current = raiz;

    while (current != null || !pila.isEmpty()) {
      while(current != null) {
        pila.push(current);
        current = current.getIzq();
      }

      current = pila.pop();
      elementos.add(current.getInfo());
      current = current.getDer();
    }
    return elementos;
  }
  
    /* (non-Javadoc)
    * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
    * y va llenando la lista con los elementos del árbol según un recorrido pre order.
    * Si bien el perfil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
    */
    private List<T> aListaPreOrder(NodoTree<T> raiz,List<T> elementos) {
      elementos.add(raiz.getInfo());
      
      if (raiz.getIzq() != null) {
        aListaInOrder(raiz.getIzq(), elementos);
      }

      if (raiz.getDer() != null) {
        aListaInOrder(raiz.getDer(), elementos);
      } 
      return elementos;
    }

    /* (non-Javadoc)
    * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
    * y va llenando la lista con los elementos del árbol según un recorrido post order.
    * Si bien el perfil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
    */
  private List<T> aListaPostOrder(NodoTree<T> raiz,List<T> elementos) {
    if (raiz.getIzq() != null) {
      aListaInOrder(raiz.getIzq(), elementos);
    }

    if (raiz.getDer() != null) {
      aListaInOrder(raiz.getDer(), elementos);
    } 
    
    elementos.add(raiz.getInfo());

    return elementos;

  }

  public  List<T> treeSort(Collection<T> elems) {
    ABB<T> ab1 = new ABB<>(comparador,elems);
    List<T> result = new ArrayList<T>();
    while (!ab1.esVacio()) {
      T elem = ab1.menorValor();
      result.add(elem);
      ab1.borrar(elem);
    }
    return result;
  }

}

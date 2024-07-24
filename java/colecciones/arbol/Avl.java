package colecciones.arbol;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

/**
 * Una implementación de {@code Diccionario} mediante nodos encadenados que preserva,
 * las propiedades de ABB y ademas mantiene el arbol balanceado, es decir,
 * las alturas de los subárboles izquierdo y derecho de cada nodo difieren como máximo en uno.
 * @param <T>  Tipo del valor asociado a los nodos del árbol, debe ser posible definir un orden total para los mismos.
 * @see NodoBinario
 */
public class Avl<T> implements Diccionario<T> {

    private NodoAvl<T> raiz;

    /**
     * Comparador usado para mantener el orden en un ABB, o null.
     */
    private final Comparator<? super T> comparador;


    /**
     * Construye un nuevo árbol vacío ordenado acorde al comparador dado.
     *
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     */
    public Avl(Comparator<? super T> comparador) {
        raiz = null;
        this.comparador = comparador;
    }

    /**
     * Construye un nuevo árbol con un elemento en la raiz, ordenado acorde al comparador dado.
     *
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     * @param valor de la raiz del nuevo arbol si no es null.
     */
    public Avl(Comparator<? super T> comparador, T valor) {
        raiz = new NodoAvl<>(valor);
        this.comparador = comparador;
    }

    public Avl(Comparator<? super T> comparador, Collection<T> elems){
        if (elems.size() == 0) {
            throw new IllegalStateException("empty collection");
        }
        this.raiz = null;
        this.comparador = comparador;

        for (T e : elems) {
            this.insertar(e);
        }
    }

    public NodoAvl<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAvl<T> raiz) {
        this.raiz = raiz;
    }

    public NodoAvl<T> rotIzquierda(NodoAvl<T> k2) {
        NodoAvl<T> k1 = k2.getDer();
        k2.setDer(k1.getIzq());
        k1.setIzq(k2);;
        return k1;
    }

    private NodoAvl<T> rotDerecha(NodoAvl<T> k2){
        NodoAvl<T> k1 = k2.getIzq();
        k2.setIzq(k1.getDer());
        k1.setDer(k2);
        return k1;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void insertar( T elem ) {
        if (this.esVacio()){
            raiz = new NodoAvl<>(elem);
        }else{
            insertarRec(raiz, elem);
        }
    }

    private NodoAvl<T> insertarRec(NodoAvl<T> root, T elem) {
        if (root == null) {
             return new NodoAvl<>(elem);
        }
    
        int cmp = comparador.compare(root.getInfo(), elem);
        if (cmp == 0) {
            return root;
        }else if(cmp > 0) {
            root.setIzq(insertarRec(root.getIzq(),elem));
        }else{
            root.setDer(insertarRec(root.getDer(),elem));
        }
        
        int balRaiz = balance(root);
        int balHi = root.getIzq() != null ? balance(root.getIzq()) : 0;
        int balHd = root.getDer() != null ? balance(root.getDer()) : 0;

        if (balRaiz > 1 && balHi >= 0) {
            //rotacion R
           this.setRaiz(rotDerecha(root));
           return root;
        }

        if (balRaiz > 1 && balHi < 0) {
            //rotacion LR
            root.setIzq(rotIzquierda(root.getIzq()));
            this.setRaiz(rotDerecha(root));
        }

        if (balRaiz < (-1) && balHd <= 0) {
            //rotacion L
           this.setRaiz(rotIzquierda(root));
           return root;
        }

        if (balRaiz < (-1) && balHd > 0 ) {
            //rotacion RL
            root.setDer(rotDerecha(root.getDer()));
            this.setRaiz(rotIzquierda(root));
        }

        return root;
    }
    /**
     * {@inheritDoc}
     */
    public boolean pertenece(T elem) {
        return pertRecursivo(raiz,elem);
    }


    private boolean pertRecursivo(NodoAvl<T> root, T elem){
        if (root == null) {
            return false;
        }
    
        int cmp = comparador.compare(root.getInfo(), elem);
        if (cmp == 0) {
            return true;
        }else if (cmp > 0) {
            return pertRecursivo(root.getIzq(), elem);
        }else{
            return pertRecursivo(root.getIzq(), elem);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void borrar(T elem) {
        if (!(this.pertenece(elem) )){
            return;
        }else{
            borrarRec(raiz, elem);
        }
    }

    public NodoAvl<T> borrarRec(NodoAvl<T> root, T elem) {
        if (root == null) {
            return root;
        }
        int cmp = comparador.compare(root.getInfo(), elem);
        if (cmp == 0) {
            if (root.getIzq() == null || root.getDer() == null) {
                return null;
            } else if (root.getIzq() != null && root.getDer() == null) {
                return root.getIzq();
            } else if (root.getIzq() == null && root.getDer() != null) {
                return root.getDer();
            } else {
                return root.getDer();
            }
        }else if (cmp > 0) {
            root.setIzq(borrarRec(root.getIzq(), elem));
        }else{
            root.setDer(borrarRec(root.getDer(), elem));
        }
        

        int balRaiz = balance(root);
        int balHi = root.getIzq() != null ? balance(root.getIzq()) : 0;
        int balHd = root.getDer() != null ? balance(root.getDer()) : 0;

        if (balRaiz > 1 && balHi >= 0) {
            //rotacion R
           this.setRaiz(rotDerecha(root));
           return root;
        }

        if (balRaiz > 1 && balHi < 0) {
            //rotacion LR
            root.setIzq(rotIzquierda(root.getIzq()));
            this.setRaiz(rotDerecha(root));
        }

        if (balRaiz < (-1) && balHd <= 0) {
            //rotacion L
           this.setRaiz(rotIzquierda(root));
           return root;
        }

        if (balRaiz < (-1) && balHd > 0 ) {
            //rotacion RL
            root.setDer(rotDerecha(root.getDer()));
            this.setRaiz(rotIzquierda(root));
        }

        return root;
        
    }
    /**{@inheritDoc}*/
    @Override
    public void vaciar() {
        raiz = null;
    }

    /**{@inheritDoc}*/
    @Override
    public T raiz() {
        return raiz.getInfo();
    }

    /**{@inheritDoc}*/
    @Override
    public Avl<T> subArbolIzquierdo() {
        if ( raiz == null || raiz.getIzq() == null) {
           return null;
        }
    
        Avl<T> subIzq = new Avl<>(comparador);
        subIzq.setRaiz(raiz.getIzq());
        return subIzq;
    }

    /**{@inheritDoc}*/
    @Override
    public Avl<T> subArbolDerecho() {
        if ( raiz == null || raiz.getIzq() == null) {
            return null;
         }
     
         Avl<T> subDer = new Avl<>(comparador);
         subDer.setRaiz(raiz.getIzq());
         return subDer;
        }
    /**{@inheritDoc}*/
    @Override
    public int elementos() {
        return elementosRec(raiz);
    }

    private int elementosRec(NodoAvl<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + elementosRec(root.getIzq()) + elementosRec(root.getDer());
    } 
    /**{@inheritDoc}*/
    @Override
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoAvl<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(alturaRec(root.getIzq()), alturaRec(root.getDer()));
    }
    /**{@inheritDoc}*/
    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    /**{@inheritDoc}*/
    @Override
    public T mayorValor(){
        if (this.esVacio()) {
            return null;
        }
        
        NodoAvl<T> nuevaRaiz= raiz;
        if (nuevaRaiz.getDer() == null) {
            return nuevaRaiz.getInfo();
        }

        while (nuevaRaiz.getDer() != null) {
            nuevaRaiz = nuevaRaiz.getDer();
        }
        return nuevaRaiz.getInfo();
    }

    /**{@inheritDoc}*/
    @Override
    public T menorValor() {
        if (this.esVacio()) {
            return null;
          }
      
          NodoAvl<T> nuevaRaiz = this.raiz;
      
          if (nuevaRaiz.getIzq() == null) {
            return nuevaRaiz.getInfo();
          }
      
          while(nuevaRaiz.getIzq() != null){
            nuevaRaiz = nuevaRaiz.getIzq();
          }
          return nuevaRaiz.getInfo();
    }

    /**{@inheritDoc}*/
    @Override
    public T sucesor(T elem) {
        if (!(this.pertenece(elem))) {
            throw new IllegalArgumentException("no existe el elemento");
          }
           return sucesorRec(raiz, elem, raiz.getInfo());
    }

    
    private T sucesorRec(NodoAvl<T> root, T elem, T succ) {
            int cmp = comparador.compare(root.getInfo(), elem);
            if (cmp == 0) {
              if (root.getDer() == null){
                return succ;
              }else{
                return root.getDer().getInfo();
              }
            }else if (cmp > 0) {
              return sucesorRec(root.getIzq(), elem, root.getInfo());
            } else {
              return sucesorRec(root.getDer(), elem, root.getInfo());
            }    
        }

    /**{@inheritDoc}*/
    @Override
    public T predecesor(T elem) {
        if (!(this.pertenece(elem))) {
            throw new IllegalArgumentException("no existe el elemento");
          }
           return predecesorRec(raiz, elem, raiz.getInfo());
    }

    private T predecesorRec(NodoAvl<T> root, T elem, T pred) {
        int cmp = comparador.compare(root.getInfo(), elem);
        if (cmp == 0) {
          if (root.getIzq() == null){
            return pred;
          }else{
            return root.getIzq().getInfo();
          }
        }else if (cmp > 0) {
          return predecesorRec(root.getIzq(), elem, root.getInfo());
        } else {
          return predecesorRec(root.getDer(), elem, root.getInfo());
        }
       }
    /**
     * obtiene el balance del arbol, es decir, la diferencia de altura de sus subarboles.
     * @return diferencia de altura de los subarboles.
     */
    public int balance(){
        return balance(raiz);
    }

    private int balance(NodoAvl<T> root) {
        if (root == null) {
            return 0;
        }
        return alturaRec(root.getIzq()) - alturaRec(root.getDer());
    }

    /**{@inheritDoc}*/
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
    @Override
    public boolean repOK() {
        Set<NodoAvl<T>> visited = new HashSet<>();
        if (!(arbolSinCiclosYAlcanzable(this.raiz,visited))) {
            return false;
        }
        
        if (visited.size() != this.elementos()) {
            return false;
        }
    
        return esOrdenado(this.raiz,null,null);
    }


    private boolean arbolSinCiclosYAlcanzable(NodoAvl<T> root, Set<NodoAvl<T>> visited) {
        if (root == null) {
            return true;
        }
    
        if (visited.contains(root)) {
            return false;
        }
        visited.add(root);

        return arbolSinCiclosYAlcanzable(root.getIzq(), visited) && 
                arbolSinCiclosYAlcanzable(root.getDer(), visited);
    }

    private boolean esOrdenado(NodoAvl<T> root, T min, T max) {
        if (root == null) {
            return false;
        }
    
        if ((min != null) && (comparador.compare(root.getInfo(), min) <= 0)||
            (max != null) && (comparador.compare(root.getInfo(), max)) >= 0) {
                return false;
            }
    
    
        return esOrdenado(root.getIzq(), min, root.getInfo()) &&
                esOrdenado(root.getDer(), root.getInfo(), max);
    }

    /**{@inheritDoc}*/
    @Override
    public String toString() {
        String result = "";
        if (this.esVacio()) {
            result = "{}";
        }else{
            result = String.valueOf(aLista(Orden.INORDER));
        }
        return result;
    }

    /**{@inheritDoc}*/
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        
        if (other == this) {
            return true;
        }
    
        if (!(other instanceof Avl<?>)) {
            return false;
        }
        Avl<T> otro = (Avl<T>) other;

        return equalsHelper(this.raiz, otro.getRaiz());

    }

    private boolean equalsHelper(NodoAvl<T> raiz1, NodoAvl<T> raiz2) {
        if (raiz1 == null && raiz2 == null) {
            return true;
        }
    
        if (raiz1 == null || raiz2 == null) {
            return false;
        }
    
    
        return raiz1.getInfo().equals(raiz2.getInfo()) &&
                equalsHelper(raiz1.getIzq(), raiz2.getIzq()) && 
                equalsHelper(raiz1.getDer(), raiz2.getDer());
    }

    /**{@inheritDoc}*/
    @Override
    public List<T> aLista() {
        return aLista(Orden.INORDER);
    }

    /**{@inheritDoc}*/
    @Override
    public List<T> aLista(Orden orden) {
        List<T> elementos = new LinkedList<>();
        switch (orden) {
            case INORDER : return aListaInOrder(raiz, elementos);
            case PREORDER : return aListaPreOrder(raiz, elementos);
            case POSTORDER : return aListaPostOrder(raiz, elementos);
        }
        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido in order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaInOrder(NodoAvl<T> raiz, List<T> elementos) {
        if (raiz.getIzq() != null) {
            aListaInOrder(raiz.getIzq(), elementos);
        }

        elementos.add(raiz.getInfo());

        if (raiz.getDer() != null) {
            aListaInOrder(raiz.getDer(), elementos);
        }
        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido pre order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPreOrder(NodoAvl<T> raiz, List<T> elementos) {
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
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPostOrder(NodoAvl<T> raiz, List<T> elementos) {
        if (raiz.getIzq() != null) {
            aListaInOrder(raiz.getIzq(), elementos);
          }
      
          if (raiz.getDer() != null) {
            aListaInOrder(raiz.getDer(), elementos);
          } 
          
          elementos.add(raiz.getInfo());
      
          return elementos;
    }

}

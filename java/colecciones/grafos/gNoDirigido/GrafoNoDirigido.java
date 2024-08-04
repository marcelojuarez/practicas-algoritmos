package grafos.gNoDirigido;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Clase GrafoNoDirigido implementada con lista de adyacencias
 */
public class GrafoNoDirigido implements Grafo {

  /** Cantidad de vertices del grafo. */
  private int cantVert;

  /** Cantidad de aristas del grafo. */
  private int cantArist;

  /** Lista de vertices del grafo. */
  private List<Vertice> vertices;

  /** Lista de aristas del grafo. */
  private List<Arista> aristas;

  /**
   * Constructor por defecto del grafo vacío
   */
  public GrafoNoDirigido() {
    this.cantArist = 0;
    this.cantVert = 0;
    this.vertices = new ArrayList<>();
    this.aristas = new ArrayList<>();
  }

/**
   * Crea un grafo con todos los vertices pasados como Lista{@code Vertice}
   * y todas las aristas pasadas como Coleccion{@code Arista}.
   * @param vertices Listas de vertices del grafo a construir.
   * @param aristas coleccion de aristas del grafo a construir.
   */
  public GrafoNoDirigido(List<Vertice> vertices, Collection<Arista> aristas) {
    this.cantArist = aristas.size();
    this.cantVert = vertices.size();
    this.vertices = new ArrayList<>();
    this.aristas = new ArrayList<>();

    this.vertices.addAll(vertices);
    this.aristas.addAll(aristas);
  }

  /**
     * Agrega un nuevo nodo (vértice) al grafo.
     * @param nodo el nuevo nodo a agregar.
     * @return {@code true} sii el nodo pudo ser agregado.
     * <hr>
     * <i>Un nodo puede no ser agregado por que ya existe o por que la
     * representación interna del grafo está llena.</i>
     */
  public boolean agregarVertice(Vertice nodo) {
    if (existe(nodo)) {
      return false;
    }
    vertices.add(nodo);
    cantVert++;
    return true;
  }

/**
     * Elimina un nodo (vértice) <b>existente</b> del grafo, y elimina todas las
     * aristas que van o llegan al mismo.
     * @param nodo el nodo a eliminar.
     * @return {@code true} sii el nodo {@code nodo} existía en el grafo y fue
     * correctamente eliminado.
     */
public boolean eliminarVertice(Vertice nodo) {
  if (existe(nodo)) {
    vertices.remove(nodo);
    List<Vertice> aux1 = new ArrayList<>(this.vertices());
    for (Vertice v : aux1) {
      if (v.getAdyacentes() != null) {
        if (v.getAdyacentes().contains(nodo)) {
          v.eliminarAdyacente(nodo);
          cantArist -= 2;
        }
      }
    }

    List<Arista> aux2 = new ArrayList<>(this.aristas());
    for (Arista a : aux2) {
      if (a.getPrimero().equals(nodo) || a.getSegundo().equals(nodo)) {
        aristas.remove(a);
      }
    }
    cantVert--;
    return true;
  }
  return false;
}

  /**
     * Consulta la existencia de un nodo (vértice) en el grafo.
     * @param nodo el nodo a consultar.
     * @return {@code true} sii {@code nodo} existe en el grafo.
     */
  public boolean existe(Vertice nodo) {
    if (nodo == null) {
      return false;
    }
    if (vertices.contains(nodo)) {
      return true;
    }
    for (Vertice v: vertices) {
      if (v.equals(nodo)) {
        return true;
      }
    }
    return false;
  }

  /**
     * Retorna una coleccion con todos los vértices en el grafo.
     * @return los vertices en el grafo en una colección
     * <hr>
     * <i>Modificar los vértices obtenidos puede tener efectos en el
     * grafo.</i>
     */
  public List<Vertice> vertices() {
    return vertices;
  }

  /**
     * Retorna una coleccion con todas las aristas del grafo.
     * @return las aristas (pares de vertices adyacentes) en el grafo en una colección.
     */
  public Collection<Arista> aristas() {
    return aristas;
  }

 /**
     * Conecta dos nodos <b>existentes</b>.
     * @param vertice1 el vértice vertice1 donde sale la arista.
     * @param vertice2 el vértice vertice2 donde va la arista.
     * @return {@code true} sii la arista no existía en el grafo y fue agregada.
     */
 public boolean agregarArista(Vertice vertice1, Vertice vertice2) {
  if ((!(existe(vertice1))) || (!(existe(vertice2)))) {
    return false;
  }
  if (vertice1.getAdyacentes() != null && vertice2.getAdyacentes() != null) {
    if ((vertice1.getAdyacentes().contains(vertice2)) || (vertice2.getAdyacentes().contains(vertice1))) {
      return false;
    }
  }
  vertice1.agregarAdyacente(vertice2);
  vertice2.agregarAdyacente(vertice1);
  aristas.add(new Arista(vertice1, vertice2));
  aristas.add(new Arista(vertice2, vertice1));
  cantArist += 2;
  return true;
}

  /**
     * Elimina la arista que unia los vertices especificados.
     * @param vertice1 el vértice vertice1 donde sale la arista.
     * @param vertice2 el vértice vertice2 donde va la arista.
     * @return {@code true} sii la arista a eliminar existía y fue eliminada.
     */
  public boolean eliminarArista(Vertice vertice1, Vertice vertice2) {
    if (esVacio() || (!(existe(vertice1))) || (!(existe(vertice2)))) {
      return false;
    }
    if (!(vertice1.getAdyacentes().contains(vertice2)) || (!(vertice2.getAdyacentes().contains(vertice1)))) {
      return false;
    }
    vertice1.eliminarAdyacente(vertice2);
    vertice2.eliminarAdyacente(vertice1);
    List<Arista> aux = new ArrayList<>(this.aristas());
    for (Arista a : aux) {
      if (a.getPrimero().equals(vertice1) && a.getSegundo().equals(vertice2)) {
        aristas.remove(a);
      }
      if (a.getPrimero().equals(vertice2) && a.getSegundo().equals(vertice1)) {
        aristas.remove(a);
      }
    }
    cantArist -= 2;
    return true;
  }

  /**
     * Obtiene los vértices adyacentes a un nodo <b>existente</b>.
     * @param v el vértice sobre el cual obtener los adyacentes.
     * @return una Lista de  vértices adyancetes a {@code v}.
     */
  public List<Vertice> obtenerAdyacentes(Vertice v) {
    return v.getAdyacentes();
  }

  /**
     * Retorna cuantos vértices hay en el grafo.
     * @return la cantidad de nodos (vértices) presentes en el grafo.
     */
  public int cantidadVertices() {
    return cantVert;
  }

  /**
     * Retorna si el grafo no posee ningún vértice.
     * @return {@code true} sii no existe ningún nodo en el grafo, este método es
     * similar a ejecutar
     * <pre>
     * cantidadVertices() == 0
     * </pre>
     */
  public boolean esVacio() {
    return cantVert == 0;
  }

  /**
     * Retorna la cantidad de aristas en el grafo.
     * @return cuantas aristas existen en el grafo.
     * <hr>
     * <i>Un valor {@code 0} no implica que el grafo esté vacío.</i>
     */
  public int cantidadAristas() {
    return cantArist;
  }

 /**
     * Determina si hay un arco entre los vertices dados.
     * @param v1 Vertice de consulta si es un extremo de arco.
     * @param v2 Vertice de consulta si es un extremo de arco.
     * @return  si hay un arco entre los vertices dados.
     */
 public boolean sonArco(Vertice v1, Vertice v2) {
  if ((v1 != null && v2 != null) && v1.getAdyacentes() != null && v2.getAdyacentes() != null) {
    return v1.getAdyacentes().contains(v2) && v2.getAdyacentes().contains(v1);
  }
  return false;

}

  /**
   * Representacion del Grafo en forma de {@code String}. Cada linea corresponde
   * a un vertice y su lista de adyacentes, quienes se encuentran entre [].
   * @return Representacion de los vertices y arcos del grafo en forma de String.
   */
  @Override
  public String toString() {
    String result = "";
    if (cantVert == 0) {
      return "grafo vacio";
    }
    for (Vertice v : vertices) {
      result = result + v.getId() + " -> " + String.valueOf(v.getAdyacentes()) + "\n";
    }
    return result;
  }

  /**
   * Algoritmo para detectar si un grafo no tiene ciclos
   * Basado en dfs
   */

   public boolean hayCiclos(Vertice v) {
    List<Vertice> visited = new ArrayList<>();
    return hayCiclosAux(v,visited,null);
   }

   private boolean hayCiclosAux(Vertice v, List<Vertice> visited, Vertice parent) {
    visited.add(v);
    for (Vertice w : v.getAdyacentes()) {
      if (!visited.contains(w)) {
        if (hayCiclosAux(w, visited, v)) {
          return true;
        }
      }else if (w != parent) {
        return true;
      }
      }
      return false;
    }
  

   public boolean esArbol(Vertice v) {
    List<Vertice> visited = new ArrayList<>();
    if (hayCiclosAux(v, visited, null)) {
      return false;
    }
    if (this.cantidadVertices() != visited.size()) {
      return false;
    }

    if (this.cantArist + 1 == this.cantidadVertices()) {
      return false;
    }

    return true;
   }

}

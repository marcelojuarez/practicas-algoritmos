package grafos.colecciones;

import java.util.List;

import java.util.ArrayList;

/**
 * Representa un nodo en un grafo
 */

public class Vertice {
  /**
   * Identificador del vertice
   */
  private final String id;

  /**
   * lista de vertices adyacentes a this;
   */
  private List<Pair<Vertice,Integer>> adyacentes;
  
  /**
   * Obtiene el identificador del vertice;
   * @return el identificador del vertice;
   */
  public String getId() {
    return this.id;
  }

  /**
   * Obtiene la lista de vertices adyacentes a este 
   * @return lista de vertices adyacentes a este
   */
  public List<Pair<Vertice,Integer>> getAdyacentes() {
    return adyacentes;
  }

  public Vertice(String id) {
    this.id = id;
    adyacentes = null;
  }


  /**
   * Conecta el vertice al vertice especificado
   * @param v Vertice a unir con this
   * @return {@code true} sii la conexion con el vertice especificado fue agregada
   */
  public boolean agregarAdyacente(Pair<Vertice,Integer> v1) {
    if (adyacentes == null) {
      adyacentes = new ArrayList<Pair<Vertice,Integer>>();
    }

    if (!adyacentes.contains(v1)) {
      adyacentes.add(v1);
      return true;
    }
    return false;
  }

  /**
   * desconecta este vertice del vertice especificado
   * @param v Vertice a desconectar
   * @return {@code true} sii la conexion con el vertice especificado fue eliminada
   */
  public boolean eliminarAdyacente(Vertice v1) {
    if (adyacentes != null) {
      for (Pair<Vertice,Integer> p : adyacentes ) {
        if (p.getKey().equals(v1)) {
          adyacentes.remove(p);
          return true;
        }
      }
    }
    
    return false;
  }
  /**
   * Retorna el valor de hash para este vertice
   * El valor de hash para un vertice es el valor hash del id
   * Este asegura que si v1.equals(v2) entonces v1.hashCode() == v2.hashCode().
   * @return valor de hash para este vertice
   */
  @Override
  public int hashCode() {
    return this.id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
  
    if (obj == null) {
      return false;
    }

    if (!(obj instanceof Vertice)) {
      return false;
    }
  
    Vertice objeto = (Vertice) obj;

    return this.id.equals(objeto.getId());
  }

  @Override
  public String toString() {
    return String.valueOf(this.id);
  }
}
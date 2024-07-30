package grafos.gNoDirigido;

  import java.util.ArrayList;
  import java.util.List;

/**
 *  Representa un nodo en un grafo.
 */
public class Vertice {
  /**
   * Obtiene el identificador de vertice.
   * @return el identificador del vertice.
   */
  public Integer getId() {
    return id;
  }

  /**
   * identificador del vertice.
   */
  private final Integer id;

  /**
   * Obtiene la lista de vertices adyacentes a este.
   * @return lista de vertices adyacentes a este.
   */
  public List<Vertice> getAdyacentes() {
    return adyacentes;
  }

  /**
   * lista de vertices adyacentes a this.
   */
  private List<Vertice> adyacentes;

  /**
   * Construye un vertice con el identificador pasado como parametro.
   * @param id identificador de vertice.
   */
  public Vertice(Integer id) {
    this.id = id;
    adyacentes = null;
  }

  /**
   * Conecta este vertice al vertice especificado.
   * @param v Vertice a unir con this.
   * @return {@code true} sii la conexión con el vértice especificado fue agregada.
   */
  public boolean agregarAdyacente(Vertice v) {
    if (adyacentes == null) {
      adyacentes = new ArrayList<Vertice>();
    }
    if (!adyacentes.contains(v)) {
      adyacentes.add(v);
      return true;
    }
    return false;
  }

  /**
   * desconecta este vertice del vertice especificado.
   * @param v Vertice a desconectar.
   * @return {@code true} sii la conexión con el vertice especificado fue eliminada.
   */
  public boolean eliminarAdyacente(Vertice v) {
    if (adyacentes != null) {
      return adyacentes.remove(v);
    }
    return false;
  }

  /**
   * Retorna el valor de hash para este vertice.
   * El valor de hash para un vertice es el valor hash del id.
   * Este asegura que si v1.equals(v2) entonces v1.hashcode() == v2.hashcode().
   * @return valor de hash para este vertice.
   */
  @Override
  public int hashCode() {
    return this.id.hashCode();
  }

  /**
   * Compara el objeto especificado con this por igualdad.
   * Retorna true si el objeto a comparar es un vertice y tiene el mismo id
   * @param obj a comparar con este vertice.
   * @return true si el objeto especificado es igual a este vértice.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Vertice)) {
      return false;
    }
    Vertice objeto = (Vertice) obj;
    return this.id.equals(objeto.id);
  }

  /**
   * Representacion del id del vertice en forma de {@code String}.
   * @return Representacion del vértice en forma de String.
   */
  @Override
  public String toString() {
    return String.valueOf(this.id);
  }

}

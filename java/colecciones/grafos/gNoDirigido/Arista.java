package grafos.gNoDirigido;

public class Arista {
  /**
   * Obtiene el primer vertice de una arista.
   * @return el primer vertice de una arista.
   */
  public Vertice getPrimero() {
    return primero;
  }

  /**
   * Obtiene el segundo vertice de una arista.
   * @return el segundo vertice de una arista.
   */
  public Vertice getSegundo() {
    return segundo;
  }

  /**
   * Primer vertice de una arista.
   */
  private final Vertice primero;
  /**
   * Segundo vertice de una arista
   */
  private final Vertice segundo;

  /**
   * Constructor de una arista.
   * @param primero Primer vertice de la arista.
   * @param segundo Segundo vertice de la arista.
   */
  public Arista(Vertice primero, Vertice segundo) {
    this.primero = primero;
    this.segundo = segundo;
  }

  /**
   * Retorna el valor de hash para esta arista.
   * El valor de hash para una arista es la suma del valor de hash de cada vertice.
   * Esto asegura que a1.equals(a2) implica a1.hashcode() == a2.hashcode().
   * @return valor de hash para esta arista.
   */
  @Override
  public int hashCode() {
    return this.getPrimero().hashCode() + this.getSegundo().hashCode();
  }

  /**
   * Compara el objeto especificado con this por igualdad.
   * Retorna true si el objeto a comparar es una arista y los vertices son iguales
   * @param obj a comparar con esta arista.
   * @return true si el objeto especificado es igual a esta arista.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Arista)) {
      return false;
    }
    Arista objeto = (Arista) obj;
    return ((objeto.getPrimero()).equals(this.getPrimero()) && (objeto.getSegundo()).equals(this.getSegundo()));
  }

  /**
   * Representacion del arista en forma de {@code String}.
   * Se muestra la arista como un par de vertices
   * @return Representacion de la arista en forma de String.
   */
  @Override
  public String toString() {
    return String.valueOf("(" + primero.toString() + ", " + segundo.toString() + ")");
  }


}

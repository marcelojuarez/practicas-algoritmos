package grafos.colecciones;

public class Arista {
  /**
   * Primer vertice de una arista.
   */
  private final Vertice primero;

  /**
   * Segundo vertice de una arista.
   */
  private final Vertice segundo;

  /**
   * peso de la conexion entre los dos vertices.
   */
  private final Integer peso;


  public Vertice getPrimero() {
    return this.primero;
  }

  public Vertice getSegundo() {
    return this.segundo;
  }

  public Integer getPeso() {
    return this.peso;
  }

  public Arista(Vertice primero, Vertice segundo, Integer peso){
    if (primero == null || segundo == null || peso == null) {
      throw new IllegalArgumentException("Vertices y peso no pueden ser nulos");
    }
    
    this.primero = primero;
    this.segundo = segundo;
    this.peso = peso;
  }

  @Override
  public int hashCode(){
    return this.getPrimero().hashCode() + this.getSegundo().hashCode() + this.peso;
  }

  @Override
  public boolean equals(Object obj){
    if (obj == null) {
      return false;
    }
  
    if (this == obj){
      return true;
    }
  
    if (!(obj instanceof Arista)) {
      return false;
    }
  
    Arista objeto = (Arista) obj;

    return (objeto.getPrimero().equals(this.getPrimero()) && objeto.getSegundo().equals(this.getSegundo()) && 
            objeto.getPeso().equals(this.getPeso()));
  }

  @Override
  public String toString(){
    return String.valueOf("(" + this.getPrimero().toString() +" "+ this.getPeso() +" "+this.getSegundo().toString()+")") ;
  }
  }
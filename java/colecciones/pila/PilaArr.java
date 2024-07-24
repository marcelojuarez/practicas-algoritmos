package pila;

public class PilaArr<T> implements Pila<T> {
  //atributos
  public final static int MAX = 100;
  private Object[] pila;
  private int cant;

  //constructor
  public PilaArr(){
    this(MAX);
    this.cant = 0;
  }

  public PilaArr(int capacidad) {
    if (capacidad < 0 || capacidad > MAX) {
      throw new IllegalStateException("capacidad erronea");
    }
  
    pila = new Object[capacidad];
    cant = 0;
  }


    /**
     * Devuelve el elemento de la pila
     * @return elemento de la pila
     */
    public T tope() {
      return (T) pila[0];
    }

    /**
     * Apila un elemento a la pila
     */
    public boolean apilar(T elem){
      if (this.elementos() == MAX) {
        return false;
      }else{
        int i = this.elementos()-1;
        while (i != (-1)) {
          pila[i+1] = pila[i];
          i--;
        }
        pila[0] = (T) elem;
        cant++;
        return true;
      }
    }

    /**
     * Desapila el ultimo elemento de la pila
     */
    public T desapilar(){
      T result = (T) pila[0];
      for (int i = 0 ;i < this.elementos(); i++) {
        pila[i] = pila[i+1];
      }
      cant--;
      return result;
    }

    /**
     * Devuelve la cantidad de elementos que contiene la pila
     * @return la cantidad de elementos de la pila
     */
    public int elementos(){
      return this.cant;
    }

    /**
     * Devuelve si la pila está o no vacía
     * @return si la pila está vacía
     */
    public boolean esVacia(){
      return this.cant == 0;
    }

    /**
     * Vacía la pila
     */
    public void empty(){
      cant = 0;
      for (int i = 0 ;i < this.elementos();i++) {
        pila[i] = null;
      }
    }

    @Override 
    public String toString(){
      String result = "[";
      for (int i = 0;i < this.cant;i++) {
        result += pila[i].toString();
        if (!(i == this.cant -1)) {
          result += " ,";
        }
      }
      return result + "]";
    }
}

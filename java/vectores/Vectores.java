package vectores;


public class Vectores {
  //atributos
  public static final int MAX = 50;
  private double[] v;
  private int cant;

  public Vectores() {
    this(MAX);
    cant = 0;
  }
  

  public Vectores(int capacidad) {
    v = new double[capacidad];
    cant = 0;
  }

  public int getCant(){
    return cant;
  }

  public void agregar(double n){
    if (this.getCant() == MAX) {
      throw new IllegalStateException("vector lleno "); 
    }
    v[cant] = n;
    cant++;   
  }

  public double getElem(int index) {
    if (cant == 0) {
      throw new IllegalStateException("empty vector");
    }
  
    if (index < 0 || index >= MAX) {
      throw new IndexOutOfBoundsException("index out of bound");
    }
  
    return v[index];
  }

    //multiplicacion por escalar 
  public Vectores multEscalar(double k, Vectores vec) {
    if (vec != null) {
    Vectores aux = vec;
    for (int i = 0 ;i < vec.getCant(); i++) {
      aux.v[i] = vec.v[i] * k;
    }
    return aux;
    }else{
      return null;
    }
  }

  //suma 
  public Vectores suma (Vectores v1, Vectores v2) {
    if (v1.getCant() != v2.getCant()) {
      throw new IllegalStateException("different cant");
    }
    
    if (v1 != null && v2 != null){
      Vectores aux = new Vectores(v1.getCant());
      for (int i = 0 ; i < v1.getCant();i++) {
        aux.v[i] = v1.v[i] + v2.v[i];
        cant++;
      }
      return aux;
    }else{
      return null;
    }
  }
  //multiplicacion(producto punto) de vectores del mismo tamaño
  public static double productPunto (Vectores v1, Vectores v2) {
    if (v1.getCant() != v2.getCant()) {
      throw new IllegalStateException("different cant");
    }
    
    if (v1 != null && v2 != null){
      double acum = 0;
      for (int i = 0 ;i < v1.getCant(); i++) {
        acum += v1.v[i] * v2.v[i];
      }
      return acum;
    }else{
      throw new IllegalStateException("error v1 or v2 are null");
    }
  }
  //equals
}

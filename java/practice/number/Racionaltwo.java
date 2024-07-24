package number;

public class Racionaltwo {
  //atributos 
  private long numerador;
  private long denominador;
  
  //constructor por defecto
  public Racionaltwo(){
    this.numerador = 0;
    this.denominador = 1;
  }
   //constructor 
   public Racionaltwo (long numerador, long denominador){
    this.numerador = numerador;
    this.denominador = denominador;
   }
  //getter del numerador
  public long getNum(){
    return numerador;
  }

  //setter para el numerador
  public void setNum(long numerador){
    this.numerador = numerador;
  }

  //getter para el denominador
  public long getDen(){
    return denominador;
  }

  //setter para el denominador
  public void setDen(long denominador){
    this.denominador = denominador;
  }  

  public Racionaltwo suma(Racionaltwo n2){
    Racionaltwo n3 = new Racionaltwo();
    if(this.denominador == n2.getDen()){
      n3.setNum(this.numerador + n2.getNum());
      n3.setDen(this.denominador);
    }else{
      long a = this.numerador;
      long b = this.denominador;
      long c = n2.getNum();
      long d = n2.getDen();
      n3.setNum((a*d) + (b*c));
      n3.setDen((b*d));
    }
    return n3;
  }
  @Override
  public boolean equals(Object otro){
    if(otro == null){
      return false;
    }
    if(otro == this){
      return true;
    }
    if(!(otro instanceof Racionaltwo )){
      return false;
    }
    Racionaltwo n2 = (Racionaltwo) otro;
    long a = this.numerador * n2.getDen();
    long b = this.denominador * n2.getNum();
    return (a == b);
  }

  @Override 
  public String toString(){
    return this.numerador + "/" + this.denominador;
  }
}

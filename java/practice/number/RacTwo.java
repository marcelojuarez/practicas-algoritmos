package number;

import number.Racional;

public class RacTwo {
  //atributos
    private long numerador;
    private long denominador;

  
  //constructor sin parametros
    public RacTwo(){
      numerador = 1;
      denominador  = 1;
    }

  //constructor con parametros
    public RacTwo(long numerador, long denominador) {
      this.numerador = numerador;
      this.denominador = denominador;
    }

  //getter para numerador 
    public long getNumerador(){
      return numerador;
    }
    //getter para denominador
      public long getDenominador(){
        return denominador;
      }
    //setter para numerador 
      public void setNumerador(long numerador){
        this.numerador = numerador;
      }
    //setter para denominador
      public void setDenominador(long denominador){
        this.denominador = denominador;
      }

      //sumar
      public RacTwo sumaRac( RacTwo num2) {
        RacTwo result = new RacTwo();
        if (this.getDenominador() == num2.getDenominador()) {
          result.setNumerador(this.numerador + num2.numerador);
          result.setDenominador(this.denominador);
        } else{
          long a = this.numerador;
          long b = this.denominador;
          long c = num2.numerador;
          long d = num2.denominador;
          result.setNumerador((a*d) + (b*c));
          result.setDenominador(b*d);
        }
        return result;
      }
      //restar
      //metodo para restar dos numeros racionales
     public RacTwo resta(RacTwo num2) {
        RacTwo n3 = new RacTwo();
        
        if(this.getDenominador() == num2.getDenominador()){
            
            n3.setNumerador( (this.getNumerador() - num2.getNumerador()));
            n3.setDenominador(this.getDenominador());
           
        }else{

            long a = numerador;
            long b = denominador;
            long c = num2.getNumerador();
            long d = num2.getDenominador();

            n3.setNumerador(((a*d) - (b*c)));
            n3.setDenominador((b*d));
        }
        return n3;
    }
      //equals
      @Override
      public boolean equals(Object other) {
        if (other == null) {
          return false;
        }
      
        if (other == this) {
          return true;
        }
      
        if (!(other instanceof RacTwo)) {
          return false;
        }
      
      RacTwo otro = (RacTwo) other;
      if (!(otro.getNumerador() == this.getNumerador())){
        return false;
      }

      if (!(otro.getDenominador() == this.getDenominador())){
        return false;
      }
      
        return true;
    }
  
    @Override
    public String toString(){
      return this.numerador +"/"+ this.denominador;
    }
  
  }

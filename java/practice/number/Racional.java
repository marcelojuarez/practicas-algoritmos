package number;

public class Racional{
    //atributos de la clase racional
    private long numerador;
    private long denominador;

//constructor por defecto
public Racional(){
    numerador = 0;
    denominador = 1;
}
//creo un constructor;
public Racional(long numerador, long denominador){
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
    //metodo para sumar dos numeros racionales
    public Racional suma( Racional num2) {
        Racional n3 = new Racional();
       
        if(denominador == num2.denominador){
        
            n3.numerador = (numerador + num2.numerador);
            n3.denominador = denominador;
       
        }else{
        
            long a = numerador;
            long b = denominador;
            long c = num2.numerador;
            long d = num2.denominador;

            n3.numerador = ((a*d) + (b*c));
            n3.denominador = (b*d);
       }
        return n3;
    }
    //metodo para restar dos numeros racionales
    public Racional resta(Racional num2) {
        Racional n3 = new Racional();
        
        if(denominador == num2.denominador){
            
            n3.numerador = (numerador - num2.numerador);
            n3.denominador = denominador;
           
        }else{

            long a = numerador;
            long b = denominador;
            long c = num2.numerador;
            long d = num2.denominador;

            n3.numerador = ((a*d) - (b*c));
            n3.denominador = (b*d);
        }
        return n3;
    }
    //definicion de igualdad sobre dos numeros racionales
    //@Override
    public boolean equals(Racional n2){
        long a;
        long b;
      a = numerador * n2.denominador; 
      b = denominador * n2.numerador;
        return (a == b);
    }
    //mostrar el numero racional
    @Override
    public String toString(){
        return  numerador + "/" + denominador ;
    }

}

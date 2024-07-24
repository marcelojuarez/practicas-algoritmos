package main;

import number.RacTwo;

public class MainRacional{
    public static void main(String[]  args){
        RacTwo n1 = new RacTwo(2,5);
        RacTwo n2 = new RacTwo(1,3);
        RacTwo n4 = new RacTwo(3,9);
        RacTwo n3 = new RacTwo();
        RacTwo n5 = new RacTwo(3,5);
        
        //n3 = n1.suma(n2);
        n3 = n1.resta(n5);
        //System.out.println("el numerador :"+ n3.getNumerador());
        //System.out.println("el denominador :"+ n3.getDenominador());
        System.out.println("numero es: "+n3);
        //System.out.println("los numeros n4 y n2 son iguales? \n"+ n4.equals(n2));
        
    }
}

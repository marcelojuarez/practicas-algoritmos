package main;
import pila.PilaArreglo;
public class MainPilaArreglo {
  public static void main (String[] args){
    PilaArreglo<Integer> pila =  new PilaArreglo<>();
    pila.apilar(1);
    pila.desapilar();
    System.out.println("esta es la pila \n" + pila);
  }
}

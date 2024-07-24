package main;
import pila.PilaList;
public class MainPilaLista {
  public static void main (String[] args){
    PilaList<Integer> pila1 = new PilaList<>(1);
    pila1.apilar(2);
    pila1.apilar(3);
    pila1.apilar(4);
    pila1.apilar(5);
    pila1.apilar(6);
    System.out.println("asi se muestra la pila \n" + pila1);
    System.out.println("tope de la pila: " + pila1.tope()); 
  }
}

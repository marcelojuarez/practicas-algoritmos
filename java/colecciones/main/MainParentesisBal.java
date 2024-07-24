package main;

import pila.PilaArr;
import java.util.Scanner;
public class MainParentesisBal {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("ingrese una secuencia");
    String secuencia = scanner.nextLine();
    char[] arregloAux = new char[secuencia.length()];
    for (int i = 0 ;i < secuencia.length();i++) {
      arregloAux[i] = secuencia.charAt(i);
    }

    boolean result = parentesisBal(arregloAux);
    System.out.println(": " + result);
  
  }

  public static boolean parentesisBal(char[] arregloAux) {
    PilaArr<Character> pilaAux = new PilaArr<>(arregloAux.length);
    for (int i = 0 ;i < arregloAux.length; i++) {
      char actual = arregloAux[i];
      if (actual == '[' || actual == '('){
        pilaAux.apilar(actual);
      }else if (actual == ']' || actual == ')'){
        if (pilaAux.esVacia()) {
          return false;
        }
      
        char tope = pilaAux.tope();
        if (actual == ']' && tope == '[' || actual == ')' && tope == '(') {
          pilaAux.desapilar();
        }else{
          return false;
        }
      }
    }
    return pilaAux.esVacia();
  }

}
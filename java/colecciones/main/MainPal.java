package main;

import cola.ColaArr;
import java.util.Scanner;

public class MainPal {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("ingrese una palabra");
    String palabra = scanner.nextLine();
    ColaArr<Character> queue = new ColaArr<>(palabra.length());

    for (int i = 0 ;i < palabra.length(); i++) {
      queue.encolar(palabra.charAt(i));
    }

    boolean result = false;
    if (queue.esVacia()) {
      result = false;
    }else{
      int i = 0;
      int j = queue.elementos()-1;
      while (i < j) {
        if (queue.elemento(i) != queue.elemento(j)) {
          result = false;
          break;
        }
        result = true;
        i++;
        j--;
      }

    }

    System.out.println("queue " + queue);
    System.out.println(palabra + " ¿ es un palindromo ? " + result) ;
  }
}

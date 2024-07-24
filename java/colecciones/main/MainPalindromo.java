package main;
import cola.ColaArregloFijo;
import java.util.Scanner;

public class MainPalindromo{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese una palabra");
        String palabra = scanner.nextLine();
        ColaArregloFijo<Character> array = new ColaArregloFijo<>(palabra.length());
        
        for(int i = 0 ;i < palabra.length();i++){
            array.encolar(palabra.charAt(i));
        }
        boolean result = true;
        int i,j;
        i = 0;
        j = array.elementos() - 1;
        while(i < j/2){
            if(!(array.elemento(i) == array.elemento(j))){
                result = false;
                break;
            }
            i++;
            j--;
        }
        System.out.println("esta palabra es un palindromo?"+"\n"+result);
    } 
}
package main;

import cars.Auto;

public class MainAuto{
    public static void main(String[] args){
        Auto a1 = new Auto(10000,"Rojo",250);
        System.out.println("color del auto: "+ a1.color());
        System.out.println("kilometros del auto: "+ a1.km());
        System.out.println("precio del auto: "+ a1.precio());
    }
}
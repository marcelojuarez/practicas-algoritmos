package colecciones.lista;

import colecciones.lista.ListaSobreArreglo;

public class MainListaArreglo{
  public static void main(String[] args){
    ListaSobreArreglo array = new ListaSobreArreglo();
    ListaSobreArreglo array2 = new ListaSobreArreglo();
    ListaSobreArreglo<Integer> arreglo = new ListaSobreArreglo();
    array.agregar(1);
    array.agregar(2);
    array.agregar(3);
    array.agregar(4);
    array.agregar(5);
    array2.agregar(1);
    array2.agregar(2);
    array2.agregar(3);
    array2.agregar(4);
    array2.agregar(5);
    System.out.println(""+ array);
    System.out.println("cantidad de elementos: "+array.elementos());
    System.out.println(""+array2);
    System.out.println("cantidad de elementos: "+array2.elementos());
    System.out.println("equals de arreglo1 y arreglo2 \n"+ array.equals(array2));
    //array.insertar(17,1);
    System.out.println("esta vacio este arreglo ?: "+ array.esVacia());
    System.out.println("elemento en la posicion 0 :"+array.obtener(0));
  }
}

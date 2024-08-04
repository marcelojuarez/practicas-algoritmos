package arbol;

public class MainHeap {
    public static void main(String[] args) {
        MinHeap h1 = new MinHeap(7);

        h1.insert(5);
        h1.insert(24);
        h1.insert(15);
        //h1.insert(67);


        System.out.println("representacion en formato arreglo " + h1.toString());
        
        System.out.println("saco el primer elemento " + h1.extracTop());
        System.out.println("representacion en formato arreglo " + h1.toString());
        

   }
}

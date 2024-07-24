package vectores;
import vectores.Vectores;

public class MainVectores{
    public static void main(String[] args){
         Vectores v1 = new Vectores(2);   
         Vectores v2 = new Vectores(2);  
            double acum;
         for(int i = 0;i<2;i++){
            v1.agregar(i+1);
            v2.agregar(i+1);
        }
         //v1 = v1.multEscalar(12.0);
         System.out.println("v1 en estado inicial "+v1);
         acum = Vectores.productPunto(v1,v2);
         //System.out.println("v1 en segundo estado "+v2.toString(v2));
         System.out.println("producto punto entre v1 y v2 "+ acum);
    }
}
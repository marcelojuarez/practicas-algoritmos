package colecciones.lista;

public class MainListaLista{
    public static void main(String[] args){
        //instancio un objeto de esta clase
        ListaSobreLista<Integer> lista = new ListaSobreLista<>();
        ListaSobreLista<Integer> lista2 = new ListaSobreLista<>();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        System.out.println(""+ lista);
        System.out.println("elimino el segundo elemento?: "+lista.eliminar(1));
        System.out.println(""+ lista); 
        System.out.println("sub lista "+lista.subLista(1, 2));
        //System.out.println("lista 1 y lista 2 son iguales ? "+ lista.equals(lista2));
    }
}    

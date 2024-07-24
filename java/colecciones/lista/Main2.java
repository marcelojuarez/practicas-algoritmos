package colecciones.lista;
public class Main2 {
    public static void main(String[] args){
        ListaSobreLista<Integer> listaDeEnteros = new ListaSobreLista<>();
        for(int i = 0; i < 10; i++){
            listaDeEnteros.agregar(i);
        }

        System.out.println(listaDeEnteros.toString());
        listaDeEnteros.eliminar(4);
        System.out.println(listaDeEnteros.obtener(4));
        System.out.println(listaDeEnteros.contiene(5));
        System.out.println(listaDeEnteros.contiene(4));
        System.out.println(listaDeEnteros.esVacia());
        System.out.println(listaDeEnteros.elementos());
        //System.out.println(listaDeEnteros.repOK());
        System.out.println(listaDeEnteros.toString());

       /*  ListaSobreLista<Integer> listaDeEnteros2 = new ListaSobreLista<>();
        listaDeEnteros2 = (ListaSobreLista) listaDeEnteros.subLista(1, 4);
        System.out.println(listaDeEnteros2.toString());
        */
    }

}

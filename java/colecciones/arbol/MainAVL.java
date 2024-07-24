package colecciones.arbol;

import java.util.Comparator;
import java.util.Collection;
import java.util.List;

public class MainAVL {
    public static void main(String[] args) {
        Comparator<Integer> comp = Comparator.naturalOrder();
        Collection<Integer> elems = List.of(22,1,12,33,16);
        Avl<Integer> avl1 = new Avl<>(comp,elems);
        System.out.println("avl1: "+ avl1.toString());
    }
}

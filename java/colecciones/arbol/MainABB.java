package colecciones.arbol;

import java.util.Comparator;
import java.util.Collection;
import java.util.List;

public class MainABB {
  public static void main(String[] args) {
    Comparator<Integer> cmp = Comparator.naturalOrder();
    Collection<Integer> elems = List.of(15,9,7,12,30);
    ABB<Integer> ab1 = new ABB<>(cmp);
   
    System.out.println("collecion before TreeSort " + elems.toString());
    Collection<Integer> result = ab1.treeSort(elems);
    System.out.println("collecion after TreeSort" + result.toString());
  }
}

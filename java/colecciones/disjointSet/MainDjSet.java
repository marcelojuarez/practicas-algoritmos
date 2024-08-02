package disjointSet;

public class MainDjSet{
    public static void main(String[] args) {
        DisjointSetImp s = new DisjointSetImp(8);
        System.out.println("primer arreglo " + s.toString());
        s.union(4, 5);
        System.out.println("primer arreglo " + s.toString());
        System.out.println(" padre del 5 ?" + s.find(5));
        }
}
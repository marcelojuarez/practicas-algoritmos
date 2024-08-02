package disjointSet;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Implementacion basada en arboles, realizados con arreglos;
 */
public class DisjointSetImp implements DisjointSet {
    // atributos
    private int[] parent;
    private int[] altura;
    

    /**
     * Constructor
     * Inicialmente el arreglo que contiene las clases de equivalencia llevara (-1) ya que son todas raices
     * El arreglo altura llevara 1, para cada clase de equivalencia ya que de igual manera son todas raices 
     * @param n refleja la cantidad de clases de equivalencia 
     */
    public DisjointSetImp(int n){
        this.parent = new int[n];
        this.altura = new int[n];
        for (int i = 0 ; i<n; i++) {
            parent[i] = i;
            altura[i] = 1;
        }
    }

    /**
    * Encuentra el representante del conjunto que contiene el elemento especificado.
    * @param x el elemento del que se quiere encontrar el representante
    * @return el representante del conjunto que contiene el elemento
    */
    public int find(int x){
        if (parent[x] != x) {
            // para comprimir el arbol a medida que busco su reprensentante podria hacer parent[x] = find(parent[x])
            find(parent[x]);
        }
        return parent[x];
    }

    /**
    * Une los conjuntos que contienen los dos elementos especificados.
    * @param x el primer elemento
    * @param y el segundo elemento
    * @return {@code true} si los conjuntos fueron unidos, {@code false} si ya estaban unidos
    */
    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (altura[rootX] > altura[rootY]) {
                parent[rootY] = rootX; 
            }else if (altura[rootX] < altura[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                altura[rootX]++;
            }
        } 
            return false;
    }

    /**
    * Verifica si los dos elementos especificados están en el mismo conjunto.
    * @param elem1 el primer elemento
    * @param elem2 el segundo elemento
    * @return {@code true} si los elementos están en el mismo conjunto, {@code false} en caso contrario
    */
    public boolean connected(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    /**
    * Invariante de clase.
    * @return {@code true} si el DisjointSet satisface su invariante de clase
    */
    public boolean repOK(){
        // Verificar que cada elemento tiene un representante válido
        for(int i = 0; i<parent.length; i++) {
            if (parent[i] < 0 || parent[i] >= parent.length) {
                return false;
            }
        }
        
        // Verificar que cada elemento pertenece a un conjunto y hay una raíz
        for(int i = 0; i<parent.length; i++) {
            int root = find(i);
            if ( (root < 0) || (root >= parent.length) || (parent[root] != root) ) {
                return false;
            }
        }

        // Verificar consistencia de altura (si se usa unión por altura)
        for (int i = 0; i<parent.length; i++) {
            if (parent[i] < 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("arreglo de padres:").append(Arrays.toString(parent)).append("\n");
        result.append("arreglo de alturas :").append(Arrays.toString(altura)).append("\n");

        return result.toString();
    }
    

    @Override
    public boolean equals(Object other){
        if ( other == null) {
            return false;
        }
        
        if (other == this) {
            return true;
        }
    
        DisjointSetImp otro = (DisjointSetImp) other;
        return Arrays.equals(parent, otro.parent) && Arrays.equals(altura, otro.altura);
    }
    
}
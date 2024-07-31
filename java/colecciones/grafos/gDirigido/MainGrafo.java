package grafos.gDirigido;

import java.sql.Array;
import java.util.Arrays;

public class MainGrafo {
    public static void main(String[] args) {
        // Crear el grafo dirigido
        GrafoDirigido g1 = new GrafoDirigido();
        
        // Crear vértices
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");


        // Agregar vértices al grafo
        g1.agregarVertice(vA);
        g1.agregarVertice(vB);
        g1.agregarVertice(vC);
        g1.agregarVertice(vD);

        // Agregar aristas con pesos
        g1.agregarArista(vA, vB, 0);
        g1.agregarArista(vB, vC, 0);
        g1.agregarArista(vD, vC, 0);
        g1.agregarArista(vA, vD, 0);
    

        //matriz para el testeo de warshall
        //ejemplo del teorico
        /**
         * grafo:  2 -> [3,1]; 1 -> [2,3]; 3 -> [1] 
         */
        // Defino los pesos como una matriz bidimensional
    Integer[][] pesos = {
        {0, 4, 7},
        {1, 0, 2},
        {6, Integer.MAX_VALUE, 0}
    };
        int n = 3;
         Integer[][] graph = new Integer[n][n];
         Integer[][] dist = new Integer[n][n];
         Integer[][] path = new Integer[n][n];

         for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                graph[i][j] = pesos[i][j];
            }
         }

        // Mostrar la representación del grafo
        /**
        System.out.println("Representación del grafo g1:");
        System.out.println(g1.toString());
        System.out.println("recorrido dfs recursivo " + g1.dfs(vA));
        System.out.println("cantidad de caminos simples del grafo g1 " + g1.caminosSimples(vA, vC));
         */
         MatrixUtils utils = new MatrixUtils();
         System.out.println("representacion del grafo en formato matrix \n");
         System.out.println(utils.toString(graph));
         //print para imprimir la distancia mas corta entre cada para de nodos
         g1.warshall(graph, dist, path);
         System.out.println("distancia mas corta entre cada par de nodos\n");
         System.out.println(utils.toString(dist));
         //print para imprimir el camino mas corto entre cada para de nodos
         System.out.println("camino mas corto entre cada para de nodos \n");
         System.out.println(utils.toString(path));
    }

    public static class MatrixUtils{
        public static String toString(Integer[][] matrix) {
            StringBuilder sb = new StringBuilder();
            for (Integer[] row : matrix) {
                sb.append(Arrays.toString(row));
                sb.append("\n");
            }
            return sb.toString();
        }
    }

}

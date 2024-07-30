package grafos.colecciones;

public class MainGrafo {
    public static void main(String[] args) {
        // Crear el grafo dirigido
        GrafoDirigido g1 = new GrafoDirigido();
        
        // Crear vértices
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Vertice vG = new Vertice("G");

        // Agregar vértices al grafo
        g1.agregarVertice(vA);
        g1.agregarVertice(vB);
        g1.agregarVertice(vC);
        g1.agregarVertice(vD);
        g1.agregarVertice(vE);
        g1.agregarVertice(vF);
        g1.agregarVertice(vG);

        // Agregar aristas con pesos
        g1.agregarArista(vA, vB, 0);
        g1.agregarArista(vA, vC, 0);
        g1.agregarArista(vA, vD, 0);
        g1.agregarArista(vB, vA, 0);
        g1.agregarArista(vB, vD, 0);
        g1.agregarArista(vB, vF, 0);
        g1.agregarArista(vC, vA, 0);
        g1.agregarArista(vC, vG, 0);
        g1.agregarArista(vD, vB, 0);
        g1.agregarArista(vE, vA, 0);
        g1.agregarArista(vE, vF, 0);
        g1.agregarArista(vF, vB, 0);
        g1.agregarArista(vF, vE, 0);
        g1.agregarArista(vG, vC, 0);

        // Mostrar la representación del grafo
        System.out.println("Representación del grafo g1:");
        System.out.println(g1.toString());
        System.out.println("recorrido dfs recursivo " + g1.dfs(vA));
        System.out.println("recorrido dfs con stack " + g1.dfsWithStack(vA));
        System.out.println("recorrido bfs con queue " + g1.bfs(vA));
    }
}

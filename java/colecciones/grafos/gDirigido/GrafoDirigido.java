package grafos.gDirigido;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import cola.ColaArregloFijo;

/**
 * Clase GrafoDirigido implementada con lista de adyacencias
 */
public class GrafoDirigido implements Grafo{

    /** Cantidad de vertices del grafo. */
    private int cantVert;

    /** Cantidad de aristas del grafo. */
     private int cantArist;

    /** Lista de vertices del grafo. */
    private List<Vertice> vertices;

    /** Lista de aristas del grafo. */
    private List<Arista> aristas;

    public GrafoDirigido(){
        cantVert = 0;
        cantArist = 0;
        this.vertices = new ArrayList<Vertice>();
        this.aristas = new ArrayList<Arista>();
    }
    
    public GrafoDirigido(Collection<Vertice> vertices, Collection<Arista> aristas) {
        this.cantVert = vertices.size();
        this.cantArist = aristas.size();
        this.vertices = new ArrayList<Vertice>();
        this.aristas = new ArrayList<Arista>();

        this.vertices.addAll(vertices);
        this.aristas.addAll(aristas);
    }

    /**
     * Agrega un nuevo nodo (vértice) al grafo.
     *
     * @param nodo el nuevo nodo a agregar.
     * @return {@code true} sii el nodo pudo ser agregado.
     *         <hr>
     *         <i>Un nodo puede no ser agregado por que ya existe o por que la
     *         representación interna del grafo está llena.</i>
     */
    public boolean agregarVertice(Vertice nodo){
        if (existe(nodo)) {
            return false;
        }
        
        this.vertices.add(nodo);
        this.cantVert++;
        return true;
    }

    /**
     * Elimina un nodo (vértice) <b>existente</b> del grafo, y elimina todas las
     * aristas que van o llegan al mismo.
     *
     * @param nodo el nodo a eliminar.
     * @return {@code true} sii el nodo {@code nodo} existía en el grafo y fue
     *         correctamente eliminado.
     */
    public boolean eliminarVertice(Vertice nodo){
        if (existe(nodo)) {
            vertices.remove(nodo);
            List<Vertice> aux = new ArrayList<Vertice>(vertices);
            for (Vertice v : aux) {
                if (v.getAdyacentes().contains(nodo)) {
                    v.eliminarAdyacente(nodo);
                    cantArist--;
                }
            }

            List<Arista> aux2 = new ArrayList<Arista>(aristas);
            for (Arista a : aux2) {
                if (a.getPrimero().equals(nodo) || a.getSegundo().equals(nodo)) {
                    aristas.remove(a);
                }
            }

            cantVert--;
            return true;
        }
        return false;
    }

    /**
     * Consulta la existencia de un nodo (vértice) en el grafo.
     *
     * @param nodo el nodo a consultar.
     * @return {@code true} sii {@code nodo} existe en el grafo.
     */
    public boolean existe(Vertice nodo){
        if (nodo == null){
            return false;
        }
    
        if (vertices.contains(nodo)) {
            return true;
        }

        for (Vertice v : vertices) {
            if (v.equals(nodo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna una coleccion con todos los vértices en el grafo.
     *
     * @return los vertices en el grafo en una colección
     *         <hr>
     *         <i>Modificar los vértices obtenidos puede tener efectos en el
     *         grafo.</i>
     */
    public List<Vertice> vertices(){
        return vertices;
    }

    /**
     * Retorna una coleccion con todas las aristas del grafo.
     *
     * @return las aristas (pares de vertices adyacentes) en el grafo en una colección.
     */
   public Collection<Arista> aristas(){
    return aristas;
   }

    /**
     * Conecta dos nodos <b>existentes</b>.
     *
     * @param vertice1 el vértice vertice1 donde sale la arista.
     * @param vertice2 el vértice vertice2 donde va la arista.
     * @return {@code true} sii la arista no existía en el grafo y fue agregada.
     */
    public boolean agregarArista(Vertice vertice1, Vertice vertice2, Integer peso){
        Pair<Vertice,Integer> p1 = new Pair<Vertice,Integer>(vertice2, peso);
        if (vertice1 == null || vertice2 == null) {
            throw new IllegalArgumentException("Los vertices o el peso no pueden ser null");
        }
        if ((!(existe(vertice1))) || (!(existe(vertice2)))) {
            return false;
        }

        if (vertice1.getAdyacentes() != null) {
            if (vertice1.getAdyacentes().contains(p1)){
                return false;
            }
        }
        
        vertice1.agregarAdyacente(p1);
        aristas.add(new Arista(vertice1, vertice2, peso));
        cantArist++;
        return true;
    }
    

    /**
     * Elimina la arista que unia los vertices especificados.
     *
     * @param vertice1 el vértice vertice1 donde sale la arista.
     * @param vertice2 el vértice vertice2 donde va la arista.
     * @return {@code true} sii la arista a eliminar existía y fue eliminada.
     */
    public boolean eliminarArista(Vertice vertice1, Vertice vertice2) {
        if (esVacio() || (!(existe(vertice1))) || (!(existe(vertice2)))) {
            return false;
        }

        if (vertice1.getAdyacentes() == null) {
            return false;
        }

        if (vertice1.getAdyacentes().contains(vertice2) ) {
            return false;
        }

        vertice1.eliminarAdyacente(vertice2);
        List<Arista> aux = new ArrayList<Arista>(aristas);
        for (Arista a : aux) {
            if (a.getPrimero().equals(vertice1) && a.getSegundo().equals(vertice2)) {
                aristas.remove(a);
            }
        }
        cantArist--;
        return true;
    }

    /**
     * Obtiene los vértices adyacentes a un nodo <b>existente</b>.
     *
     * @param v el vértice sobre el cual obtener los adyacentes.
     * @return una Lista de  vértices adyancetes a {@code v}.
     */
    public List<Pair<Vertice,Integer>> obtenerAdyacentes(Vertice v){
        return v.getAdyacentes();
    }

    /**
     * Retorna cuantos vértices hay en el grafo.
     *
     * @return la cantidad de nodos (vértices) presentes en el grafo.
     */
    public int cantidadVertices(){
        return cantVert;
    }

    /**
     * Retorna si el grafo no posee ningún vértice.
     *
     * @return {@code true} sii no existe ningún nodo en el grafo, este método es
     *         similar a ejecutar
     *
     *         <pre>
     *         cantidadVertices() == 0
     *         </pre>
     *
     *         .
     */
    public boolean esVacio(){
        return cantVert == 0;
    }

    /**
     * Retorna la cantidad de aristas en el grafo.
     *
     * @return cuantas aristas existen en el grafo.
     *         <hr>
     *         <i>Un valor {@code 0} no implica que el grafo esté vacío.</i>
     */
    public int cantidadAristas(){
        return cantArist;
    }

    /**
     * Determina si hay un arco entre los vertices dados.
     * @param v1 Vertice de consulta si es un extremo de arco.
     * @param v2 Vertice de consulta si es un extremo de arco.
     * @return  si hay un arco entre los vertices dados.
     */
    public boolean sonArco(Vertice v1, Vertice v2){
        if ((v1 !=  null && v2 != null) && (v1.getAdyacentes() != null && v2.getAdyacentes() != null)){
            return v1.getAdyacentes().contains(v2) || v2.getAdyacentes().contains(v1);
        }
        return false;
    }

    @Override
    public String toString(){
        String result = "";
        if (cantVert == 0) {
            return "Grafo Vacio";
        }

        for (Vertice v : vertices) {
            result += v.getId() + " -> " + String.valueOf(v.getAdyacentes()) + "\n";
        }
        return result;
    }

    // Recorrido dfs
    public List<Vertice> dfs(Vertice v) {
        List<Vertice> visited = new ArrayList<Vertice>();
        dfsRe(v, visited);
        return visited;
    }

    private void dfsRe(Vertice v, List<Vertice> visited) {
        visited.add(v);
        if (v.getAdyacentes() != null) {
            for (Pair<Vertice,Integer> w : v.getAdyacentes()) {
                if (!visited.contains(w.getKey())) {
                    dfsRe(w.getKey(),visited);
                }
            }
        }
    }


    /** 
     * Recorrido dfs implementado con pilas
     */
    public List<Vertice> dfsWithStack(Vertice v) {
        List<Vertice> visited = new ArrayList<Vertice>();
        dfsWithStackAux(v, visited);
        return visited;
    }

    private void dfsWithStackAux(Vertice v, List<Vertice> visited) {
        Stack<Vertice> s = new Stack<Vertice>();
        s.push(v);
        visited.add(v);
        while(!s.isEmpty()) {
            Vertice u = s.peek();
            Vertice w = getUnvisitedAdj(u,visited);
            if (w != null) {
                s.push(w);
                visited.add(w);
            }else{
                s.pop();
            }
        }
    }

    private Vertice getUnvisitedAdj(Vertice v,List<Vertice> visited) {
        for (Pair<Vertice,Integer> w : v.getAdyacentes()) {
            if (!visited.contains(w.getKey())){
                return w.getKey();
            }
        }
        return null;
    }
    /**
     * Recorrido bfs usando una queue
     */
    public List<Vertice> bfs(Vertice v){
        List<Vertice> visited = new ArrayList<Vertice>();
        bfsQueue(v,visited);
        return visited;
    }

    private void bfsQueue(Vertice v, List<Vertice> visited) {
        ColaArregloFijo<Vertice> q = new ColaArregloFijo<Vertice>();
        q.encolar(v);
        visited.add(v);
        
        while (!q.esVacia()) {
            Vertice w = q.desencolar();
            
            for (Pair<Vertice, Integer> x : w.getAdyacentes()) {
                Vertice adjVertice = x.getKey(); 
                if (!visited.contains(adjVertice)) {
                    visited.add(adjVertice);
                    q.encolar(adjVertice);
                }
            }
        }
    }

    /**
     * 
     * @param x vertice origen
     * @param y vertice destino
     * @return cantidad de caminos simples entre x e y
     */
    
     public int caminosSimples(Vertice x, Vertice y) {
        List<Vertice> visited = new ArrayList<Vertice>();
       return cantSimplesAux(x, y, visited);
     }

     private int cantSimplesAux(Vertice x, Vertice y, List<Vertice> visited) {
        if (x.equals(y)) {
            return 1;
        }
        int cantCaminos = 0;
        visited.add(x);
        if (x.getAdyacentes() != null) {
            for (Pair<Vertice,Integer> p : x.getAdyacentes()){
                if (!visited.contains(p.getKey())) {
                       cantCaminos += cantSimplesAux(p.getKey(), y, visited) ;
                }
            }
         }
         //visited.remove(x);
         return cantCaminos;
   }
    
    /**
     * Implementacion de warshall-floyd
     * calcula el camino mas corto entre todos los nodos
     * graph es una matriz conteniendo el grafo, dist es la matriz en donde las distancias se
     * guardaran y path una matriz en donde se guardan los caminos
     */
    public void warshall(int[][] graph, int[][] dist, int[][] path) {
        int n = graph.length;
        //se inicializa  path y dist
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                dist[i][j] = graph[i][j];
                path[i][j] = -1;
                if (0 < graph[i][j]  && graph[i][j] < Integer.MAX_VALUE) {
                    dist[i][j] = i;
                }
            }
        }
        //se considera cada camino pasando por k
        for (int k = 1; k<n; k++) {
            for (int  i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }    
                }
            }
        }
    
    
    }
}


//algoritmo de warshall
public static void warshall(int[][]graph, int[][]d, int[][]path){
  int n = graph.length;
  //inicializo dist y path
  for (int i = 0 ;i < n ;i++) {
    for (int j = 0 ;j < n; j++) {
      d[i][j] = graph[i][j]
      path[i][j] = -1
      if (0 < graph[i][j] <inf) {
        path[i][j] = i
      }
    }
  }

  for (int k = 0; k < n; k++) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (d[i][k] + d[k][j] < d[i][j]){
          d[i][j] = d[i][k] + d[k][j]
          path[i][j] = k;
        }
      }
    }
  }
}

//algoritmo de dijkstra
public static void dijkstra(Graph g;Vertex v;int[] dist;Vertex[] prev){
  for all w in g.vertices(){
    prev[w] = null
    dist[w] = inf
  }
  //distancia al origen
  dist[v];
  //creo el conjunto s
  Set s = new Set();
  PriorityQueue q = new PriorityQueue(g.vertices())
  while(!q.isEmpty()){
    vertex u = q.getMin()
    s.insert(u)
    for each edge (u,v) && v is not in s do{
      if(dist[u] + w(u,y) < dist[y]){
        dist[y] = dist[u] + w(u,y)
        path[y] = u
        q.changeKey(y,dist[y])
      }
    }
  }

}

//algoritmo de prims
public static void prims(Graph g, Vertex v,Vertex[]path){
  for all w in g do {
    w.setKey(inf)
  }
  v.setKey(0)
  path[v]null
  PriorityQueue q = new PriorityQueue(g.vertices())
  while(!q.isEmpty()){
    vertex u = q.getMin()
    for each edge(u,w) && w is in q do {
      if (w.getKey() >g.weight(u,w)){
        path
      }
    }
  }
}
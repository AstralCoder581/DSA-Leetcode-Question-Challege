import java.util.*;

public class dijkstraAlgo {
    static class Edge{
        int src,dest,wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w; }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i<graph.length; i++) graph[i] = new ArrayList<Edge>();
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,4,100));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,50));

        graph[2].add(new Edge(2,3,20));
        graph[2].add(new Edge(2,4,60));

        graph[3].add(new Edge(3,2,20));
        graph[2].add(new Edge(3,4,60));

        graph[4].add(new Edge(4,3,60));
        graph[4].add(new Edge(4,0,100));
    }
    static class Pair implements Comparable<Pair>{
        int n,path;
        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; //sort by default in increasing order
        }
    }
    public static void dijkstra(ArrayList<Edge> graph[], int src, int V){
        int dist[] = new int[V]; //stores distance
        for (int i=0; i<V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE; // all the nodes will be set to infinity apart from the source
            }
        }
        boolean vis[] = new boolean[V]; //visited arrau
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); // source to source path is 0
        while (!pq.isEmpty()) { // see if it is visited or not
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true; //if not make it visited
                for(int i=0; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src; //source
                    int v = e.dest; //destination
                    int wt = e.wt; //weight
                    if(dist[u]+wt < dist[v]){ //update distance of src to v
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }           
        }
        for(int i=0; i<dist.length; i++) System.out.print(dist[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0, V);
    }
}


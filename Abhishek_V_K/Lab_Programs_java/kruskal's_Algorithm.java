import java.util.*;

public class KruskalsAlgo {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class Subset {
        int parent, rank;
        Subset(int parent) {
            this.parent = parent;
            this.rank = 0;
        }
    }

    static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    static void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank)
            subsets[rootX].parent = rootY;
        else if (subsets[rootX].rank > subsets[rootY].rank)
            subsets[rootY].parent = rootX;
        else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    public static void kruskalMST(List<Edge> edges, int V) {
        Collections.sort(edges);
        Subset[] subsets = new Subset[V + 1];
        for (int v = 1; v <= V; v++)
            subsets[v] = new Subset(v);

        List<Edge> result = new ArrayList<>();
        for (Edge edge : edges) {
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);
            if (x != y) {
                result.add(edge);
                union(subsets, x, y);
                if (result.size() == V - 1)
                    break;
            }
        }

        System.out.println("MST: ");
        for (Edge edge : result)
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = Arrays.asList(
            new Edge(1, 5, 5),
            new Edge(1, 2, 10),
            new Edge(2, 3, 1),
            new Edge(2, 4, 6),
            new Edge(3, 4, 2),
            new Edge(4, 5, 3),
            new Edge(5, 3, 7)
        );

        kruskalMST(edges, V);
    }
}

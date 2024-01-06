package _50_Data_Structure.Graph;

import java.util.LinkedList;
import edu.princeton.cs.algs4.In;

public class _12_DFS {
    private static boolean[] visited;
    private static int[] pathTo;

    public static void dfs(Graph G, int s) {
        visited = new boolean[G.V()];
        pathTo = new int[G.V()];
        dfsAux(G, s);
    }

    private static void dfsAux(Graph G, int v) {
        visited[v] = true;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                pathTo[w] = v;
                dfsAux(G, w);
            }
        }
    }

    public static Iterable<Integer> path(Graph G, int s, int v) {
        dfs(G, s);
        if (visited[v] == false) return null;

        LinkedList<Integer> path = new LinkedList<>();
        int i = v;
        path.addFirst(i);
        do {
            i = pathTo[i];
            path.addFirst(i);
        } while (i != s);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph(new In("_50_Data_Structure\\tinyGraph.txt"));
        System.out.println(path(g, 0, 4));
    }
}
package C_Data_Structure;

import edu.princeton.cs.algs4.In;

public class DFS {
    private static boolean[] visited;
    private static int count;

    public static void dfs(Graph G, int s) {
        visited = new boolean[G.V()];
        dfsAux(G, s);
    }

    private static void dfsAux(Graph G, int v) {
        if (visited(v)) return;

        visited[v] = true;
        count++;

        for (int w : G.adj(v)) {
            dfsAux(G, w);
        }
    }

    public static boolean visited(int v) {
        return visited[v];
    }

    public static int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph g = new Graph(new In("C_Data_Structure\\tinyGraph.txt"));
        dfs(g, 5);
        System.out.println(count);
    }
}
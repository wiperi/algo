package Graph.Graph;

import java.util.LinkedList;
import edu.princeton.cs.algs4.In;

public class _12_DFS {
    private static boolean[] visited;
    private static int[] pathTo;

    public static void dfs(_10_Graph G, int source) {
        visited = new boolean[G.V()];
        pathTo = new int[G.V()];
        dfsAux(G, source);
    }

    private static void dfsAux(_10_Graph G, int v) {
        // preorder postion
        visited[v] = true;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                pathTo[w] = v;
                dfsAux(G, w);
            }
        }

        // postorder positon
    }

    public static Iterable<Integer> path(_10_Graph G, int source, int v) {
        dfs(G, source);
        if (visited[v] == false) return null;

        LinkedList<Integer> path = new LinkedList<>();
        int i = v;
        path.addFirst(i);
        do {
            i = pathTo[i];
            path.addFirst(i);
        } while (i != source);
        return path;
    }

    public static void main(String[] args) {
        _10_Graph g = new _10_Graph(new In("_50_Data_Structure\\tinyGraph.txt"));
        System.out.println(path(g, 0, 4));
    }
}
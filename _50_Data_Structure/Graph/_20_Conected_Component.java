package _50_Data_Structure.Graph;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class _20_Conected_Component {

    private static boolean[] visited;
    private static int[] id; // id for each CC
    private static int count; // nubmer of CCs

    // method 1: use dfs
    public static int numberOfCC(Graph G) {
        // initialize data
        visited = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;
        // dfs each vertex, if it's not visited then it means we meet a new CC
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                dfsAux(G, v);
                count++;
            }
        }
        return count;
    }

    private static void dfsAux(Graph G, int v) {
        visited[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfsAux(G, w);
            }
        }
    }

    // method 2: use union find
    public static int numberOfCC_UnionFind(Graph G) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());
        for (int i = 0; i < G.V(); i++) {
            for (Integer v : G.adj(i)) {
                uf.union(i, v);
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        Graph g = new Graph("6");
        System.out.println(numberOfCC(g));
        System.out.println(numberOfCC_UnionFind(g));
    }

}
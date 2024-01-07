package _50_Data_Structure.Graph;

public class _40_hasCycle {

    private static boolean[] visited;
    private static boolean hasCycle;

    public static boolean hasCycle(_10S_Graph G) {
        visited = new boolean[G.V()];
        hasCycle = false;
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) dfs(G, v, v);
        }
        return hasCycle;
    }

    /**
     * if dfs traverse back to a visited vertex and it's not the previous vertex
     * which it just traval from. Then, there is a cycle.
     * 
     * @param G
     * @param v    current vertex
     * @param prev previous vertex
     */
    private static void dfs(_10S_Graph G, int v, int prev) {
        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w])
                dfs(G, w, v);
            else if (w != prev) hasCycle = true;
        }
    }

    public static void main(String[] args) {
        _10S_Graph nocircle = new _10S_Graph("6 / 0 1 2 / 1 3/ 2 4 / 4 5");
        _10S_Graph circle = new _10S_Graph("6 / 0 1 2 / 1 3/ 2 4 / 4 5 / 3 5");
        System.out.println(hasCycle(nocircle)); // false
        System.out.println(hasCycle(circle)); // true
    }
}

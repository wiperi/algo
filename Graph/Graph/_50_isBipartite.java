package Graph.Graph;

// reference:
// 算法第四版 P545 - P546
public class _50_isBipartite {
    private static boolean[] visited;
    private static boolean[] color;
    private static boolean isBipartite = true;

    public static boolean isBipartite(_10_Graph G) {
        visited = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++)
            if (!visited[s]) dfs(G, s);
        return isBipartite;
    }

    private static void dfs(_10_Graph G, int v) {
        visited[v] = true;
        for (int w : G.adj(v))
            if (!visited[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) isBipartite = false; // 每条边都会被遍历2遍。
                                                                  // 第一次访问该边的时候给!visvited的顶点上色并访问该顶点，第二次
                                                                  // 访问该边的时候检查两个顶点是否颜色一致，如果存在一致的颜色，则不是
                                                                  // 二分图
    }

    public static void main(String[] args) {
        _10_Graph is = new _10_Graph("5 / 1 0 2 / 4 3 2");
        _10_Graph not = new _10_Graph("5 / 1 0 2 / 4 3 2 / 3 0");
        System.out.println(isBipartite(is)); // true
        System.out.println(isBipartite(not)); // false
    }
}

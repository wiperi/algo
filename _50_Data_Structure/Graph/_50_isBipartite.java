package _50_Data_Structure.Graph;

public class _50_isBipartite {
    private static boolean[] visited;
    private static boolean[] color;
    private static boolean isBipartite = true;

    public static boolean isBipartite(Graph G) {
        visited = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++)
            if (!visited[s]) dfs(G, s);
        return isBipartite;
    }

    private static void dfs(Graph G, int v) {
        visited[v] = true;
        for (int w : G.adj(v))
            if (!visited[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) isBipartite = false; // 每条边都会在for循环被遍历到，每一条边在for循环中被访问的次数 ==
                                                                  // 2，第一次访问该边的时候给!visvited的顶点上色并访问该顶点，第二次
                                                                  // 访问该边的时候检查两个顶点是否颜色一致，如果存在一致的颜色，则不是
                                                                  // 二分图
    }

    public static void main(String[] args) {
        Graph is = new Graph("5 / 1 0 2 / 4 3 2");
        Graph not = new Graph("5 / 1 0 2 / 4 3 2 / 3 0");
        System.out.println(isBipartite(is)); // true
        System.out.println(isBipartite(not)); // false
    }
}

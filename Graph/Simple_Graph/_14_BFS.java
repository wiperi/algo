package Graph.Simple_Graph;

import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.In;

public class _14_BFS {

    private static boolean[] visited;

    // 利用并查集结构记录从起点到每一个顶点的最短路径，pathTo数组表示了一颗无环多叉树，pathTo[kid] = parent
    private static int[] pathTo;
    
    public static void bfs(_10_Graph G, int s) {
        visited = new boolean[G.V()];
        pathTo = new int[G.V()];
        bfsAux(G, s);
    }

    private static Iterable<Integer> bfsAux(_10_Graph G, int source) {
        // 1. 定义队列的初始状态
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        visited[source] = true; // *VERY IMPORTANT* 设置visited[]初始状态，避免死循环
        // 2. bfs
        while (!que.isEmpty()) {
            int v = que.poll();
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    visited[w] = true; // *VERY IMPORTANT* 必须在que.add()之前更新visited[]，否则 w 会被多次访问
                    pathTo[w] = v;
                    que.add(w);
                }
            }
        }
        return que;
    }

    public static Iterable<Integer> path(_10_Graph G, int source, int v) {
        bfs(G, source);
        if (!visited[v]) return null;

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

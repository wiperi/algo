package _50_Data_Structure.Graph.Simple_Graph;

import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.In;

public class _14_BFS {

    private static boolean[] visited;
    
    // 利用并查集结构记录从起点到每一个顶点的最短路径，pathTo数组表示了一颗无环多叉树，pathTo[kid] = parent
    private static int[] pathTo;
    
    public static void bfs(_10S_Graph G, int s) {
        visited = new boolean[G.V()];
        pathTo = new int[G.V()];
        bfsAux(G, s);
    }

    private static Iterable<Integer> bfsAux(_10S_Graph G, int s) {
        Queue<Integer> que = new LinkedList<>();
        // 1. 添加起点
        que.add(s);
        visited[s] = true;
        // 2. 开始bfs
        while (!que.isEmpty()) {
            int v = que.poll();
            for (int w : G.adj(v)) { // visit all unvisited adjacent edges
                if (!visited[w]) {
                    visited[w] = true;
                    pathTo[w] = v;
                    que.add(w);
                }
            }
        }
        return que;
    }

    public static Iterable<Integer> path(_10S_Graph G, int s, int v) {
        bfs(G, s);
        if (!visited[v]) return null;

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
        _10S_Graph g = new _10S_Graph(new In("_50_Data_Structure\\tinyGraph.txt"));
        System.out.println(path(g, 0, 4));
    }
}

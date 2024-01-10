package _50_Data_Structure.Graph.Digraph;

import java.util.LinkedList;
import java.util.List;

// reference:
// https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-03a72/huan-jian--e36de/#%E7%8E%AF%E6%A3%80%E6%B5%8B%E7%AE%97%E6%B3%95-dfs-%E7%89%88%E6%9C%AC
public class _05_Topological_Sorting_DFS {

    private static boolean[] visited;
    private static boolean[] onPath;
    private static boolean hasCycle;
    private static LinkedList<Integer> post;

    public static List<Integer> topologicalSorting(_01S_Digraph graph) {
        // 1. init
        visited = new boolean[graph.V()];
        onPath = new boolean[graph.V()];
        hasCycle = false;
        post = new LinkedList<>();
        // 2. traverse graph to get postorder list
        // if there is cycle, return empty list, if not, return inversed version of postorder list
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) dfs(graph, i);
            if (hasCycle) return new LinkedList<>();
        }
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < graph.V(); i++) {
            res.add(post.getLast());
            post.removeLast();
        }
        return res;
    }

    public static void dfs(_01S_Digraph di, int v) {
        visited[v] = true;
        onPath[v] = true;

        for (int w : di.adj(v)) {
            if (!visited[w]) dfs(di, w);
            if (visited[w] && onPath[w]) {
                hasCycle = true;
                return;
            }
        }

        post.add(v);
        onPath[v] = false;
    }
    
    public static void main(String[] args) {
        _01S_Digraph digraph1 = new _01S_Digraph("4 / 0 1 2 / 1 3/ 2 3");
        _01S_Digraph digraph2 = new _01S_Digraph("3 / 0 1 2 / 1 0");
        _01S_Digraph digraph3 = new _01S_Digraph("3 / 0 1 / 1 2 / 2 0");
        System.out.println(topologicalSorting(digraph1)); // 0 2 1 3
        System.out.println(topologicalSorting(digraph2)); // []
        System.out.println(topologicalSorting(digraph3)); // []
    }
}

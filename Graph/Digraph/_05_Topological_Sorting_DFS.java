package Graph.Digraph;

import java.util.LinkedList;
import java.util.List;

// reference:
// https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-03a72/huan-jian--e36de/#%E7%8E%AF%E6%A3%80%E6%B5%8B%E7%AE%97%E6%B3%95-dfs-%E7%89%88%E6%9C%AC
public class _05_Topological_Sorting_DFS {

    private static boolean[] visited;
    private static boolean[] onPath;
    private static boolean hasCycle;
    private static LinkedList<Integer> postList;

    public static List<Integer> topologicalSorting(_01_Digraph graph) {
        // 1. init
        visited = new boolean[graph.V()];
        onPath = new boolean[graph.V()];
        hasCycle = false;
        postList = new LinkedList<>();

        // 2. traverse graph to get postorder list
        // if there is cycle, return empty list, if not, return inversed version of postorder list
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) dfs(graph, i);
            if (hasCycle) return new LinkedList<>();
        }

        // 3. copy postList in back order to resList
        // then return res
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < graph.V(); i++) {
            res.add(postList.getLast());
            postList.removeLast();
        }
        return res;
    }

    public static void dfs(_01_Digraph di, int v) {
        visited[v] = true;
        onPath[v] = true;

        for (int w : di.adj(v)) {
            if (!visited[w]) dfs(di, w);
            if (visited[w] && onPath[w]) {
                hasCycle = true;
                return;
            }
        }

        postList.add(v);
        onPath[v] = false;
    }
    
    public static void main(String[] args) {
        _01_Digraph digraph1 = new _01_Digraph("4 / 0 1 2 / 1 3/ 2 3");
        _01_Digraph digraph2 = new _01_Digraph("3 / 0 1 2 / 1 0");
        _01_Digraph digraph3 = new _01_Digraph("3 / 0 1 / 1 2 / 2 0");
        System.out.println(topologicalSorting(digraph1)); // 0 2 1 3
        System.out.println(topologicalSorting(digraph2)); // []
        System.out.println(topologicalSorting(digraph3)); // []
    }
}

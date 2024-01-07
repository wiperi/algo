package _50_Data_Structure.Graph.Digraph;

// reference: https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-03a72/huan-jian--e36de/#%E7%8E%AF%E6%A3%80%E6%B5%8B%E7%AE%97%E6%B3%95-dfs-%E7%89%88%E6%9C%AC
public class _03_hasCycle {

    private static boolean[] visited;
    private static boolean[] onPath;
    private static boolean hasCycle = false;

    public static boolean hasCycle(_01S_Digraph di) {
        visited = new boolean[di.V()];
        onPath = new boolean[di.V()];
        for (int i = 0; i < di.V(); i++) {
            dfs(di, i);
        }
        return hasCycle;
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

        onPath[v] = false;
    }

    public static void main(String[] args) {
        _01S_Digraph digraph1 = new _01S_Digraph("3 / 0 1 2");
        _01S_Digraph digraph2 = new _01S_Digraph("3 / 0 1 2 / 1 0");
        _01S_Digraph digraph3 = new _01S_Digraph("3 / 0 1 / 1 2 / 2 0");
        System.out.println(hasCycle(digraph1)); // false
        System.out.println(hasCycle(digraph2)); // true
        System.out.println(hasCycle(digraph3)); // true
    }
}

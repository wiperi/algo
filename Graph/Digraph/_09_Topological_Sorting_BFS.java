package Graph.Digraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// reference:
// https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-03a72/huan-jian--e36de/#%E7%8E%AF%E6%A3%80%E6%B5%8B%E7%AE%97%E6%B3%95-bfs-%E7%89%88%E6%9C%AC
public class _09_Topological_Sorting_BFS {

    public static List<Integer> topologicalSorting(_01_Digraph graph) {
        Queue<Integer> que = new LinkedList<>();
        // 1. add 0 indegree vertices to queue
        for (int i = 0; i < graph.V(); i++) {
            if (graph.indegree(i) == 0) que.offer(i);
        }
        // 2. remove vertex and reduce the indegree of vertices connected to it, until
        // there is no 0 indegree vertex can be added to queue
        LinkedList<Integer> res = new LinkedList<>();
        int count = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            res.add(cur);
            count++;
            for (int next : graph.adj(cur)) {
                graph.indegree[next]--;
                if (graph.indegree(next) == 0) que.offer(next);
            }
        }
        // the bfs traverse result is the topological sorting
        if (count != graph.V()) return new LinkedList<>();
        else return res;
    }

    public static void main(String[] args) {
        _01_Digraph digraph1 = new _01_Digraph("4 / 0 1 2 / 1 3 / 2 3");
        _01_Digraph digraph2 = new _01_Digraph("3 / 0 1 2 / 1 0");
        _01_Digraph digraph3 = new _01_Digraph("3 / 0 1 / 1 2 / 2 0");
        System.out.println(topologicalSorting(digraph1)); // no cycle, 0 1 2 3
        System.out.println(topologicalSorting(digraph2)); // has cycle
        System.out.println(topologicalSorting(digraph3)); // has cycle
    }
}

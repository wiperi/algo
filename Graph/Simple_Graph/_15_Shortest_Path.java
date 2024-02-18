package Graph.Simple_Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the shortest path between 2 vertex in a simple graph
 * 
 * Ref: Algorithm 4th
 * 
 * The implementaton can also be found in the BFS.java and DFS.java
 * 
 */
public class _15_Shortest_Path {

    private static boolean[] visited;
    private static int[] pathTo;

    public static Iterable<Integer> shortestPath(int source, int target, int[][] graph) {
        // 1. init data
        visited = new boolean[graph.length];
        pathTo = new int[graph.length];
        bfs(graph, source);

        // 2. edge case
        if (!visited[target]) {
            return null;
        }

        // 3. build the path from the bottom of the tree to the top of the tree
        LinkedList<Integer> path = new LinkedList<>();
        int i = target;
        while (pathTo[i] != i) {
            path.add(i);
            i = pathTo[i];
        }
        path.add(i);

        return path;
    }

    private static void bfs(int[][] graph, int source) {
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        visited[source] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int edge : graph[cur]) {
                if (!visited[edge]) {
                    visited[edge] = true;
                    pathTo[edge] = cur;
                    que.add(edge);
                }
            }
        }
    }

    // use dfs and pathTo[] can also find a path but it's not the shortest
    public static Iterable<Integer> path(int source, int target, int[][] graph) {
        // 1. init data
        visited = new boolean[graph.length];
        pathTo = new int[graph.length];
        dfs(graph, source);

        // 2. edge case
        if (!visited[target]) {
            return null;
        }

        // 3. build the path from the bottom of the tree to the top of the tree
        LinkedList<Integer> path = new LinkedList<>();
        int i = target;
        while (pathTo[i] != i) {
            path.add(i);
            i = pathTo[i];
        }
        path.add(i);

        return path;
    }

    private static void dfs(int[][] graph, int source) {
        visited[source] = true;
        for (int edge : graph[source]) {
            if (!visited[edge]) {
                pathTo[edge] = source;
                dfs(graph, edge);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 0, 2, 3 }, { 0, 1, 4 }, { 1, 4 }, { 2, 3 } };

        int source = 0;
        int target = 4;

        Iterable<Integer> shortestPath = shortestPath(source, target, graph);

        if (shortestPath != null) {
            System.out.println("Shortest path from " + source + " to " + target + ":");
            for (int vertex : shortestPath) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("No path found from " + source + " to " + target);
        }
    }
}

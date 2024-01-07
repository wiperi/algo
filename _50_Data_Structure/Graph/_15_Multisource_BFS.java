package _50_Data_Structure.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _15_Multisource_BFS {

    private static boolean[] visited;
    private static int[] pathTo;

    public static void multisourceBFS(_10S_Graph G, int[] source) {
        visited = new boolean[G.V()];
        pathTo = new int[G.V()];
        multisoueceBFSAux(G, source);
    }

    public static void multisoueceBFSAux(_10S_Graph G, int[] source) {
        // put source into the que
        Queue<Integer> que = new LinkedList<>();
        for (int s : source) {
            que.add(s);
            visited[s] = true;
            pathTo[s] = s; // set the source vertex as root node in pathTo array
        }
        // start bfs
        while (que.isEmpty() == false) {
            int v = que.poll();
            for (Integer w : G.adj(v)) {
                if (visited[w] == false) {
                    visited[w] = true;
                    pathTo[w] = v;
                    que.add(w);
                }
            }
        }
    }

    /**
     * 
     * @param G
     * @param source
     * @param start
     * @param end
     * @return the shortest path from start to the end
     */
    public static Iterable<Integer> path(_10S_Graph G, int[] source, int start, int end) {
        multisourceBFS(G, source);
        if (!visited[end]) return null;

        LinkedList<Integer> path = new LinkedList<>();
        int i = end;
        path.addFirst(i);
        do {
            i = pathTo[i];
            path.addFirst(i);
            if (i == pathTo[i] && i != start) {
                System.out.println("between " + start + " and " + end + " such path does not exist.");
                return null;
            }
        } while (i != start);
        return path;
    }

    /**
     * 
     * @param G      the graph
     * @param source the sources of bfs
     * @param v      the target
     * @return how many steps required to reach the vertex {@code v}
     */
    public static int depth(_10S_Graph G, int[] source, int v) {
        multisourceBFS(G, source);
        if (!visited[v]) return -1;
        int res = 0;
        while (pathTo[v] != v) {
            v = pathTo[v];
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        _10S_Graph g = new _10S_Graph("7 / 6 1 2 3 4 / 0 1 2 / 5 3 4 / 1 3 / 2 4");
        System.out.println(path(g, new int[] { 0, 5 }, 0, 6)); // 0 1 6
        System.out.println(path(g, new int[] { 0, 5 }, 5, 0)); // no such path
        System.out.println(depth(g, new int[] { 0, 5 }, 6)); // 2
    }
}

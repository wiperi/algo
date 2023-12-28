package _50_Data_Structure;

import java.util.LinkedList;
import java.util.Queue;

public class Multisource_BFS {

    private static boolean[] visited;
    private static int[] pathTo;

    public static void multisourceBFS(Graph G, int[] source) {
        visited = new boolean[G.V()];
        pathTo = new int[G.V()];
        multisoueceBFSAux(G, source);
    }

    public static void multisoueceBFSAux(Graph G, int[] source) {
        // put source into the que
        Queue<Integer> que = new LinkedList<>();
        for (int s : source) {
            que.add(s);
            visited[s] = true;
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

    public static Iterable<Integer> path(Graph G, int[] source, int start, int end) {
        multisourceBFS(G, source);
        if (!visited[end]) return null;

        LinkedList<Integer> path = new LinkedList<>();
        int i = end;
        path.addFirst(i);
        do {
            i = pathTo[i];
            path.addFirst(i);
        } while (i != start);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph("7 / 6 1 2 3 4 / 0 1 2 / 5 3 4 / 1 3 / 2 4");
        System.out.println(g.toString());
    }
}

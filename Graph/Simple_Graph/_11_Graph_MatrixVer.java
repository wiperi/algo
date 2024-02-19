package Graph.Simple_Graph;

import java.util.LinkedList;
import java.util.List;

// adjacent matrix version of graph
public class _11_Graph_MatrixVer {

    boolean[][] graph;

    public _11_Graph_MatrixVer(int size) {
        graph = new boolean[size][size];
    }

    public void addEdge(int x, int y) {
        graph[x][y] = true;
        graph[y][x] = true;
    }

    public List<Integer> adj(int x) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < graph[x].length; i++) {
            if (graph[x][i] == true) {
                res.add(i);
            }
        }
        return res;
    }
}

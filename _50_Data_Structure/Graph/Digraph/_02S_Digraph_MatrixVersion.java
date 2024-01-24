package _50_Data_Structure.Graph.Digraph;

import java.util.LinkedList;
import java.util.List;

// adjacent matrix version of digraph
public class _02S_Digraph_MatrixVersion {

    boolean[][] graph;

    public _02S_Digraph_MatrixVersion(int size) {
        graph = new boolean[size][size];
    }

    public void addEdge(int x, int y) {
        graph[x][y] = true; // the only difference with simple graph
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


package Graph.Digraph;

import Graph.Graph._10_Graph;

public class _01_Digraph extends _10_Graph {

    protected int[] indegree; // record indegree of each vertex

    public _01_Digraph(String s) {
        super(s);

        indegree = new int[super.NUM_VERTEX];
        for (int v = 0; v < super.NUM_VERTEX; v++) {
            for (int w : super.adj(v)) {
                indegree[w]++; // initialize indegree in the constructor
            }
        }
    }

    @Override
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj_list[v].add(w); // the only difference between digraph and simple graph is digraph only add v->w
        if (indegree != null) indegree[w]++;
        num_edges++;
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj_list[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    public static void main(String[] args) {
        _01_Digraph digra = new _01_Digraph("4 / 0 1 / 2 1/ 3 1");
        System.out.println(digra.toString());
    }
}

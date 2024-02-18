package Graph.Digraph;

import Graph.Simple_Graph._10S_Graph;

public class _01S_Digraph extends _10S_Graph {

    protected int[] indegree; // record indegree of each vertex

    public _01S_Digraph(String s) {
        super(s);

        indegree = new int[super.V];
        for (int v = 0; v < super.V; v++) {
            for (int w : super.adj(v)) {
                indegree[w]++; // initialize indegree in the constructor
            }
        }
    }

    @Override
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w); // the only difference between digraph and simple graph is digraph only add v->w
        if (indegree != null) indegree[w]++;
        E++;
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    public static void main(String[] args) {
        _01S_Digraph digra = new _01S_Digraph("4 / 0 1 / 2 1/ 3 1");
        System.out.println(digra.toString());
    }
}

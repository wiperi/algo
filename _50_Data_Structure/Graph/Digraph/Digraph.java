package _50_Data_Structure.Graph.Digraph;

import _50_Data_Structure.Graph.Simple_Graph._10S_Graph;

public class Digraph extends _10S_Graph {

    protected int[] indegree;

    public Digraph(String s) {
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
        adj[v].add(w);
        if (indegree != null) indegree[w]++;
        E++;
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree(v);
    }

    public static void main(String[] args) {
        Digraph digra = new Digraph("4 / 0 1 / 2 1/ 3 1");
        System.out.println(digra.toString());
    }
}

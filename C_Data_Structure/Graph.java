package C_Data_Structure;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;

public class Graph {

    /************************************************************************
     * memeber variables
     ************************************************************************/

    private List<Integer>[] adj;
    private final int V;
    private int E;

    /************************************************************************
     * constructor
     ************************************************************************/

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    /**
     * Initializes a graph from the specified input stream. The format is the number
     * of vertices <em>V</em>, followed by the number of edges <em>E</em>, followed
     * by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param in the input stream
     * @throws IllegalArgumentException if {@code in} is {@code null}
     * @throws IllegalArgumentException if the endpoints of any edge are not in
     *                                  prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is
     *                                  negative
     * @throws IllegalArgumentException if the input stream is in the wrong format
     */
    @SuppressWarnings("unchecked")
    public Graph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            // build vertices
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be non negative");
            adj = (LinkedList<Integer>[]) new LinkedList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedList<Integer>();
            }
            // build edges
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a graph must be non negative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input formate in Graph constructor");
        }
    }

    /************************************************************************
     * non-static methods
     ************************************************************************/

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public Iterable<Integer> adj(int v) {
        if (v > V) throw new IllegalArgumentException("param of adj() exceed the maximum limit");
        return adj[v];
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        if (v != w) adj[w].add(v);
        E++;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < V; i++) {
            s = s + String.format("%d: %s\n", i, adj[i].toString());
        }
        return s;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    /************************************************************************
     * static methods
     ************************************************************************/

    @SuppressWarnings("unused")
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int i : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int maxDegree = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > maxDegree) maxDegree = degree(G, v);
        }
        return maxDegree;
    }

    public static double avergeDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        System.out.println(g);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 3); // self-loop

        System.out.println(g);
        System.out.println(Graph.numberOfSelfLoops(g));
    }
}

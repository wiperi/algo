package _50_Data_Structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

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

    /**
     * Initializes a graph from the String. The format is the number of vertices
     * <em>V</em>, followed by the number of edges <em>E</em>, followed by
     * <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param s the input string
     * @throws IllegalArgumentException if {@code in} is {@code null}
     * @throws IllegalArgumentException if the endpoints of any edge are not in
     *                                  prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is
     *                                  negative
     * @throws IllegalArgumentException if the input stream is in the wrong format
     */
    @SuppressWarnings("unchecked")
    public Graph(String s) {
        if (s == null) {
            throw new IllegalArgumentException("argument is null");
        }
        Scanner sc = new Scanner(s);
        try {
            // build vertices
            this.V = sc.nextInt();
            if (V < 0) {
                sc.close();
                throw new IllegalArgumentException("number of vertices in a Graph must be non negative");
            }
            adj = (LinkedList<Integer>[]) new LinkedList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedList<Integer>();
            }
            // build edges
            int E = sc.nextInt();
            if (E < 0) {
                sc.close();
                throw new IllegalArgumentException("number of edges in a graph must be non negative");
            }
            for (int i = 0; i < E; i++) {
                int v = sc.nextInt();
                int w = sc.nextInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
            sc.close();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input formate in Graph constructor");
        }
    }

    @SuppressWarnings("unchecked")
    public Graph(String s, int a) {
        ArrayList<int[]> arr = new ArrayList<>();
        String[] parts = s.split("/");
        for (String part : parts) {
            // 去除首尾空格并按空格分割数字
            String[] numberStrings = part.trim().split("\\s+");

            // 转换字符串数组为整数数组
            int[] numbers = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }
            arr.add(numbers);
        }
        // 得到节点数量，初始化adj列表
        this.V = arr.get(0)[0];
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
        // 添加edges
        for (int i = 1; i < arr.size(); i++) {
            int[] subarr = arr.get(i);
            int v = subarr[0];
            for (int w = 1; w < subarr.length; w++) {
                addEdge(v, subarr[w]);
            }
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

    /**
     * 
     * @param G the Graph
     * @param v the vertex
     * @return how many edges is incident to the vertex {@code v}
     */
    @SuppressWarnings("unused")
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int i : G.adj(v)) degree++;
        return degree;
    }

    /**
     * 
     * @param G the graph
     * @return the maximum number of edges incident to a vertex in the graph
     *         {@code G}
     */
    public static int maxDegree(Graph G) {
        int maxDegree = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > maxDegree) maxDegree = degree(G, v);
        }
        return maxDegree;
    }

    /**
     * 
     * @param G the graph
     * @return the total of edges / the total of vertices
     */
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

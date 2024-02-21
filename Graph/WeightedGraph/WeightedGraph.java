package Graph.WeightedGraph;

import java.util.*;

public class WeightedGraph {
    
    class Edge implements Comparable<Edge> {
        int v;
        int w;
        int weight;
        
        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge that) {
            return this.weight - that.weight;
        }
    }

    List<List<Edge>> adjList;
    final int NUM_VERTEX; // total vertices
    int numEdges; // total edges

    public WeightedGraph(int num_vertex) {
        this.NUM_VERTEX = num_vertex;
        adjList = new ArrayList<>();
        for (int i = 0; i < NUM_VERTEX; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int w, int weight) {
        validateVertex(v);
        validateVertex(w);
        adjList.get(v).add(new Edge(v, w, weight));
        adjList.get(w).add(new Edge(w, v, weight));
        numEdges++;
    }

    void validateVertex(int v) {
        if (v < 0 || v >= NUM_VERTEX) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (NUM_VERTEX - 1));
    }

    public int numOfVertex() {
        return NUM_VERTEX;
    }

    public int numOfEdges() {
        return numEdges;
    }

    public Iterable<Edge> adjTo(int v) {
        return adjList.get(v);
    }

    public List<Edge> edges() {
        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < NUM_VERTEX; i++) {
            for (Edge e : adjList.get(i)) {
                if (e.w > i) edges.add(e);
            }
        }
        return edges;
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph(5);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 3, 3);
        g.addEdge(0, 4, 4);
        g.addEdge(1, 2, 5);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 4, 7);
        g.addEdge(2, 3, 8);
        g.addEdge(2, 4, 9);
        g.addEdge(3, 4, 10);
        for (int i = 0; i < g.NUM_VERTEX; i++) {
            System.out.println(g.adjTo(i));
        }
    }
}

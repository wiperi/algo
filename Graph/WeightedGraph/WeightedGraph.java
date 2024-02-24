package Graph.WeightedGraph;

import java.util.*;

public class WeightedGraph {

    /************************************************************************
     * Inner class
     ************************************************************************/

    class Edge implements Comparable<Edge> {
        int origin;
        int target;
        int weight;

        public Edge(int origin, int target, int weight) {
            this.origin = origin;
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge that) {
            return this.weight - that.weight;
        }
    }

    /************************************************************************
     * Member Variables
     ************************************************************************/

    List<List<Edge>> adjList;
    final int NUM_VERTEX; // total vertices
    int numEdges; // total edges

    /************************************************************************
     * Constructor
     ************************************************************************/

    public WeightedGraph(int num_vertex) {
        this.NUM_VERTEX = num_vertex;
        adjList = new ArrayList<>();
        for (int i = 0; i < NUM_VERTEX; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    /**
     * Construct a WeightedGraph from a string.
     * <p>
     * Format: "{@code num_vertex} / {@code origin1} {@code target1}
     * {@code weight_of_target1} ... {@code targetN} {@code weight_of_targetN} / ...
     * / {@code originN} ..."
     * 
     * @param s the string format of the graph
     */
    public WeightedGraph(String s) {

        // For example, input string is "4 / 0 1 2 2 4 3 10 / 3 1 3 2 5"

        // parts = [ "4 ", "0 1 2 2 4 3 10 ", "3 1 3 2 5" ]
        String[] parts = s.split("/");

        ArrayList<int[]> arr = new ArrayList<>();
        for (String part : parts) {

            // 去除首尾空格并按空格分割数字
            String[] numberStrings = part.trim().split("\\s+");

            // 转换字符串数组为整数数组
            int[] numbers = new int[numberStrings.length];

            // numbers = [ 0, 1, 2, 2, 4, 3, 10 ]
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }
            arr.add(numbers);
        }

        // Initialize the adjacent list according to the first number readed
        this.NUM_VERTEX = arr.get(0)[0];
        if (this.NUM_VERTEX <= 0) throw new IllegalArgumentException("nubmer of vertices shouldn't lesser than 0");

        adjList = new ArrayList<>();
        for (int i = 0; i < NUM_VERTEX; i++) {
            adjList.add(new LinkedList<>());
        }

        // add edges according to the number before '/'
        for (int i = 1; i < arr.size(); i++) {
            int[] subarr = arr.get(i);
            if (subarr.length <= 1)
                throw new IllegalArgumentException("the quantity of nubmers between '/' shouldn't lesser than 1");
            int origin = subarr[0];
            for (int j = 1; j < subarr.length; j += 2) {
                int target = subarr[j];
                int weight = subarr[j + 1];
                // validate
                validateVertex(origin);
                validateVertex(subarr[j]);
                // add edge
                adjList.get(origin).add(new Edge(origin, target, weight));
                adjList.get(target).add(new Edge(target, origin, weight));
            }
        }
    }

    /************************************************************************
     * Methods
     ************************************************************************/

    public void addEdge(int v, int w, int weight) {
        validateVertex(v);
        validateVertex(w);
        adjList.get(v).add(new Edge(v, w, weight));
        adjList.get(w).add(new Edge(w, v, weight));
        numEdges++;
    }

    void validateVertex(int v) {
        if (v < 0 || v >= NUM_VERTEX)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (NUM_VERTEX - 1));
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
                if (e.target > i) edges.add(e);
            }
        }
        return edges;
    }

    public int weight(int v, int w) {
        for (Edge e : adjList.get(v)) {
            if (e.target == w) return e.weight;
        }
        return -1;
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

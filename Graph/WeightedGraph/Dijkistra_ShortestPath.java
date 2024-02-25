package Graph.WeightedGraph;

import java.util.*;

import Graph.WeightedGraph.WeightedGraph.Edge;

/**
 * <h3>Introdution:</h3>
 * 
 * Dijkitra's algorithm combines the idea of greedy algorithm and BFS. It finds
 * the shortest path from a source vertex to all other vertices in a weighted
 * graph.
 * 
 * 
 * <h3>Limitation:</h3>
 * 
 * Dijkitra's algorithm only works for weighted graph with non-negative weights.
 * 
 * <h3>Complexity:</h3>
 * 
 * O(ElogV) where E is the number of edges and V is the number of vertices.
 * 
 */
public class Dijkistra_ShortestPath {

    private static class Node {
        int vertex;
        int dist;

        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    /**
     * Standard version of Dijkistra's algorithm. It finds the minimum weight sum to
     * every vertex from source.
     * 
     * @param g
     * @param source
     * @return
     */
    public static int[] dijkistra(WeightedGraph g, int source) {

        // shortest distance from source to each vertex
        int[] distTo = new int[g.numOfVertex()];

        // initialize distTo[] to infinity except source
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[source] = 0;

        // Priority queue embodies the greedy nature of Dijkistra, only consider the
        // shortest path first.
        Queue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.dist > distTo[cur.vertex])
                // skip if it is not the shortest path to cur.vertex (lazy deletion)
                continue;

            for (Edge edges : g.adjTo(cur.vertex)) {

                int distToNext = distTo[cur.vertex] + edges.weight;

                if (distToNext < distTo[edges.target]) {
                    distTo[edges.target] = distToNext;
                    pq.add(new Node(edges.target, distToNext));
                }
            }
        }
        return distTo;
    }

    /**
     * This version finds the shortest path from source to a single destination.
     * 
     * @param g
     * @param source
     * @param target
     * @return
     */
    public static int dijkistraSingleDestination(WeightedGraph g, int source, int target) {

        int[] distTo = new int[g.numOfVertex()];

        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[source] = 0;

        Queue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // This is the only difference between dijkistra and dijkistraSinglePath.
            // Because the property of priority queue, the first time a node is polled, it
            // is the shortest path to it.
            if (cur.vertex == target)
                // Found the shortest path to target, return.
                return cur.dist;

            if (cur.dist > distTo[cur.vertex]) continue;

            for (Edge edges : g.adjTo(cur.vertex)) {

                int distToNext = distTo[cur.vertex] + edges.weight;

                if (distToNext < distTo[edges.target]) {
                    distTo[edges.target] = distToNext;
                    pq.add(new Node(edges.target, distToNext));
                }
            }
        }

        // path not found
        return Integer.MAX_VALUE;
    }

    /**
     * This version records the shortest path from source to every node in the
     * graph.
     * 
     * @param g      the graph
     * @param source
     * @return an array that record the shortest path from source to every node in
     *         the graph.
     */
    public static int[] dijkistraPath(WeightedGraph g, int source) {

        int[] distTo = new int[g.numOfVertex()];

        // union-find structure to record the shortest to each node
        int[] parent = new int[g.numOfVertex()];

        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[source] = 0;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Queue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.dist > distTo[cur.vertex]) continue;

            for (Edge edges : g.adjTo(cur.vertex)) {

                int distToNext = distTo[cur.vertex] + edges.weight;

                if (distToNext < distTo[edges.target]) {
                    distTo[edges.target] = distToNext;

                    // update the parent
                    parent[edges.target] = cur.vertex;

                    pq.add(new Node(edges.target, distToNext));
                }
            }
        }
        return parent;
    }

    // test
    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("4 / 0 1 2 2 4 3 10 / 3 1 7 2 3");

        int[] distTo = dijkistra(g, 0);
        int[] parent = dijkistraPath(g, 0);
        for (int i = 0; i < distTo.length; i++) {
            System.out.println("0 to " + i + " : " + distTo[i]);
        }

        for (int i = 0; i < parent.length; i++) {
            System.out.println("parent of " + i + " : " + parent[i]);
        }
    }
}

package Graph.WeightedGraph;

import java.util.*;

import Graph.WeightedGraph.WeightedGraph.Edge;

/**
 * Introdution:
 * <p>
 * Dijkitra's algorithm combines the idea of greedy algorithm and BFS. It finds
 * the shortest path from a source vertex to all other vertices in a weighted
 * graph.
 * 
 * Complexity:
 * <p>
 * O(ElogV) where E is the number of edges and V is the number of vertices.
 * 
 */
public class Dijkistra_ShortestPath {

    private static class Tuple {
        int vertex;
        int dist;

        public Tuple(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    public static int[] dijkistra(WeightedGraph g, int source) {

        // shortest distance from source to each vertex
        int[] distTo = new int[g.numOfVertex()];

        // initialize distTo[] to infinity except source
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[source] = 0;

        // Priority queue embodies the greedy nature of Dijkistra, only consider the
        // shortest path first.
        Queue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Tuple(source, 0));

        while (!pq.isEmpty()) {
            Tuple cur = pq.poll();

            if (cur.dist > distTo[cur.vertex])
                // skip if it is not the shortest path to cur.vertex (lazy deletion)
                continue;

            for (Edge edges : g.adjTo(cur.vertex)) {

                int distToNext = distTo[cur.vertex] + edges.weight;

                if (distToNext < distTo[edges.target]) {
                    distTo[edges.target] = distToNext;
                    pq.add(new Tuple(edges.target, distToNext));
                }
            }
        }
        return distTo;
    }

    public static int dijkistraSinglePath(WeightedGraph g, int source, int target) {

        int[] distTo = new int[g.numOfVertex()];

        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[source] = 0;

        Queue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Tuple(source, 0));

        while (!pq.isEmpty()) {
            Tuple cur = pq.poll();

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
                    pq.add(new Tuple(edges.target, distToNext));
                }
            }
        }

        // path not found
        return Integer.MAX_VALUE;
    }

    // test
    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("4 / 0 1 2 2 4 3 10 / 3 1 7 2 3");

        int[] distTo = dijkistra(g, 0);
        for (int i = 0; i < distTo.length; i++) {
            System.out.println("0 to " + i + " : " + distTo[i]);
        }
    }
}

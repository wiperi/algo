package _50_Data_Structure.Graph.Simple_Graph;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _10T_GraphTest {

    @Test
    public void testAddEdge() {
        _10S_Graph graph = new _10S_Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        Assertions.assertEquals(4, graph.E());
    }

    @Test
    public void testAdj() {
        _10S_Graph graph = new _10S_Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        Iterable<Integer> adj0 = graph.adj(0);
        Iterable<Integer> adj1 = graph.adj(1);
        Iterable<Integer> adj2 = graph.adj(2);
        Iterable<Integer> adj3 = graph.adj(3);
        Iterable<Integer> adj4 = graph.adj(4);

        Assertions.assertIterableEquals(List.of(1, 2), adj0);
        Assertions.assertIterableEquals(List.of(0, 3), adj1);
        Assertions.assertIterableEquals(List.of(0, 4), adj2);
        Assertions.assertIterableEquals(List.of(1), adj3);
        Assertions.assertIterableEquals(List.of(2), adj4);
    }

    @Test
    public void testDegree() {
        _10S_Graph graph = new _10S_Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        int degree0 = _10S_Graph.degree(graph, 0);
        int degree1 = _10S_Graph.degree(graph, 1);
        int degree2 = _10S_Graph.degree(graph, 2);
        int degree3 = _10S_Graph.degree(graph, 3);
        int degree4 = _10S_Graph.degree(graph, 4);

        Assertions.assertEquals(2, degree0);
        Assertions.assertEquals(2, degree1);
        Assertions.assertEquals(2, degree2);
        Assertions.assertEquals(1, degree3);
        Assertions.assertEquals(1, degree4);
    }

    @Test
    public void testMaxDegree() {
        _10S_Graph graph = new _10S_Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        int maxDegree = _10S_Graph.maxDegree(graph);

        Assertions.assertEquals(2, maxDegree);
    }

    @Test
    public void testAverageDegree() {
        _10S_Graph graph = new _10S_Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        double averageDegree = _10S_Graph.avergeDegree(graph);

        Assertions.assertEquals(1.6, averageDegree, 0.001);
    }

    @Test
    public void testNumberOfSelfLoops() {
        _10S_Graph graph = new _10S_Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 3); // self-loop

        int numberOfSelfLoops = _10S_Graph.numberOfSelfLoops(graph);

        Assertions.assertEquals(1, numberOfSelfLoops);
    }
}
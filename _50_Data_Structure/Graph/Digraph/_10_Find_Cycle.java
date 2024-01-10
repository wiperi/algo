package _50_Data_Structure.Graph.Digraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _10_Find_Cycle {
    private Map<Integer, List<Integer>> graph;

    public _10_Find_Cycle() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int from, int to) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

    public List<Integer> findNodesInCycle() {
        boolean[] visited = new boolean[graph.size()];
        boolean[] recursionStack = new boolean[graph.size()];
        List<Integer> cycleNodes = new ArrayList<>();

        for (int node : graph.keySet()) {
            if (!visited[node] && isCyclic(node, visited, recursionStack, cycleNodes)) {
                // If cycle is detected, add the nodes in the cycle to the list
                return cycleNodes;
            }
        }

        return cycleNodes;
    }

    private boolean isCyclic(int node, boolean[] visited, boolean[] recursionStack, List<Integer> cycleNodes) {
        visited[node] = true;
        recursionStack[node] = true;

        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    if (isCyclic(neighbor, visited, recursionStack, cycleNodes)) {
                        cycleNodes.add(node);
                        return true;
                    }
                } else if (recursionStack[neighbor]) {
                    cycleNodes.add(node);
                    cycleNodes.add(neighbor);
                    return true;
                }
            }
        }

        recursionStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        _10_Find_Cycle graph = new _10_Find_Cycle();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        List<Integer> cycleNodes = graph.findNodesInCycle();

        if (cycleNodes.isEmpty()) {
            System.out.println("No cycle in the graph.");
        } else {
            System.out.println("Nodes in the cycle: " + cycleNodes);
        }
    }
}


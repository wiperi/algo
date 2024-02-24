package Graph.WeightedGraph;

import java.util.*;
import Tree.Union_Find.*;

public class Kruskal_MinSpanningTree extends WeightedGraph {
    
    UnionFind_Weighted_PathCompressed uf;

    public Kruskal_MinSpanningTree(int num_vertex) {
        super(num_vertex);
    }

    List<Edge> krusalMST() {
        List<Edge> edges = edges();
        Collections.sort(edges);

        uf = new UnionFind_Weighted_PathCompressed(NUM_VERTEX);
        
        List<Edge> minSpanningTree = new ArrayList<>();
        for (Edge e : edges) {
            int v = e.origin;
            int w = e.target;
            if (!uf.isConnected(v, w)) {
                uf.union(v, w);
                minSpanningTree.add(e);
            }
        }

        return minSpanningTree;
    }

}

package Graph.Digraph;

import java.util.LinkedList;
import java.util.List;

public class _03_reverse {
    @SuppressWarnings("unchecked")
    public static List<Integer>[] reverse(List<Integer>[] graph) {
        List<Integer>[] reversed = (LinkedList<Integer>[]) new LinkedList[graph.length];

        for (int v = 0; v < graph.length; v++) {
            for (int w : graph[v]) {
                reversed[w].add(v); // for every edge: v->w, add edge: w->v to the new graph
            }
        }

        return reversed;
    }
}

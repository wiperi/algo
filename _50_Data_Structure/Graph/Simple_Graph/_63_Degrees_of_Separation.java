package _50_Data_Structure.Graph.Simple_Graph;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

public class _63_Degrees_of_Separation {
    public static void main(String[] args) {
        // 1. create the symbol graph and graph
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        edu.princeton.cs.algs4.Graph G = sg.graph();
        // 2. get the source
        String source = args[2];
        if (!sg.contains(source)) {
            StdOut.println(source + "not in database.");
            return;
        }
        int sourceIndex = sg.indexOf(source);
        // 3. bfs
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, sourceIndex);
        // 4. accorfing to the input, show the shortest path
        while (!StdIn.isEmpty()) {
            String tar = StdIn.readLine();
            if (sg.contains(tar)) {
                int tarIndex = sg.indexOf(tar);
                if (bfs.hasPathTo(tarIndex)) // print the path from source to target
                    for (int v : bfs.pathTo(tarIndex))
                        StdOut.println(" " + sg.nameOf(v));
                else
                    StdOut.println("Not connected");
            } else
                StdOut.println("Not in database.");
        }
    }
}
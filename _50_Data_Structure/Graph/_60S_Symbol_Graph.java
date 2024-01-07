package _50_Data_Structure.Graph;

import java.util.HashMap;

import edu.princeton.cs.algs4.In;

public class _60S_Symbol_Graph {
    private HashMap<String, Integer> st; // st as symbol table, from vertex name to vertex index
    private String[] keys; // from index of vertex to string name of vertex
    _10S_Graph G;

    public _60S_Symbol_Graph(String stream, String separator) {
        In in = new In(stream);
        st = new HashMap<>();
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(separator);
        }
    }
}

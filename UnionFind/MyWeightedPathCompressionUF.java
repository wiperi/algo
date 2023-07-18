package UnionFind;
import edu.princeton.cs.algs4.StdArrayIO;

public class MyWeightedPathCompressionUF {
    private int[] parent;
    private int[] size;

    public MyWeightedPathCompressionUF(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int a) {
        int leafnode = a;
        while (parent[a] != a) {
            a = parent[a];
        }

        /*
         * Path Compression:
         * Now, int a is the root of the current tree, but we've stored the original int
         * a in int leafnode, so we traverse the whole tree from bottom to top changing
         * the parent of every node we traversed.
         */
        while (leafnode != a) {
            int buffer = parent[leafnode];
            parent[leafnode] = a;
            leafnode = buffer;
        }
        return a;
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        } else if (size[rootA] <= size[rootB]) {

            parent[rootA] = rootB;
            size[rootB] += size[rootA];

        } else if (size[rootA] > size[rootB]) {

            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }

    public static void main(String[] args) {
        MyWeightedPathCompressionUF my = new MyWeightedPathCompressionUF(4);

        StdArrayIO.print(my.parent);
        ;
        StdArrayIO.print(my.size);

        my.union(0, 1);
        my.union(1, 2);
        my.union(2, 3);

        StdArrayIO.print(my.parent);
        ;
        StdArrayIO.print(my.size);
    }
}

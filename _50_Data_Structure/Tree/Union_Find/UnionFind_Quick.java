package _50_Data_Structure.Tree.Union_Find;

public class UnionFind_Quick {

    private int[] parent;

    public UnionFind_Quick(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        
        return find(parent[x]);
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind_Quick uf = new UnionFind_Quick(10);
        
        // Perform union operations
        uf.union(1, 2);
        uf.union(2, 8);
        uf.union(7, 8);

        uf.union(3, 4);
        uf.union(5, 6);
        
        // Find the root of an element
        int root1 = uf.find(1);
        int root2 = uf.find(5);
        
        System.out.println("Root of 1: " + root1);
        System.out.println("Root of 5: " + root2);
        System.out.println("connected: " + uf.isConnected(1, 5)); // false
    }
}

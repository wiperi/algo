package _50_Data_Structure.Tree.Union_Find;

public class UnionFind_Weighted_PathCompressed {

    private int[] parent;

    private int[] rank; // also means "depth" or "size"
                        // it record the depth of the each subtree

    public UnionFind_Weighted_PathCompressed(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // 按秩合并：
        // 按照深度，将小树合并到大树上（接到大树的根部）
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                // 当2个树深度不等，合并后2树深度不变
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                // 当2个树深度相等，被连接的树的深度+1
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] == x) return x;

        parent[x] = find(parent[x]); // 路径压缩
        return parent[x];
    }

    // find()的循环版本
    @SuppressWarnings("unused")
    private int find_iter(int x) {
        int root = x;
        while (root != parent[root])
            root = parent[root];

        while (x != root) {
            int newp = parent[x];
            parent[x] = root; // 路径压缩
            x = newp;
        }
        return root;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind_Weighted_PathCompressed uf = new UnionFind_Weighted_PathCompressed(10);

        // Perform union operations
        uf.union(1, 2);
        uf.union(2, 8);
        uf.union(8, 7);

        uf.union(3, 4);
        uf.union(4, 5);
        uf.union(5, 6);

        // Find the root of an element
        int root1 = uf.find(1);
        int root2 = uf.find(5);

        System.out.print("parent[] = ");
        for (int i = 0; i < uf.parent.length; i++) {
            System.out.print(uf.parent[i] + " ");
        }
        System.out.println();

        System.out.println("Root of 1: " + root1);
        System.out.println("Root of 5: " + root2);
        System.out.println("connected: " + uf.isConnected(1, 5)); // false
    }

}

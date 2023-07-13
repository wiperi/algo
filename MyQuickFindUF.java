public class MyQuickFindUF {
    private int[] id;
    private int count;

    public MyQuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    private void validate(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (id.length - 1));
        }
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        if (connected(q, p)) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == q) {
                id[i] = id[p];
                count--;
            }
        }
    }
}

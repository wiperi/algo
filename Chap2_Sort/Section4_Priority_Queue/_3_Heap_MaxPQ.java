package Chap2_Sort.Section4_Priority_Queue;

public class _3_Heap_MaxPQ<Key extends Comparable<Key>> implements _1_PQ_Interface<Key> {
    private Key[] pq;
    private int n = 0;

    @SuppressWarnings("unchecked")
    public _3_Heap_MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    @SuppressWarnings("unchecked")
    public _3_Heap_MaxPQ() {
        pq = (Key[]) new Comparable[11];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Key v) {
        pq[++n] = v;
        swim(n);
    }

    @Override
    public Key delMax() {
        Key temp = pq[1]; // 缓存1
        exch(1, n); // 将1交换到尾巴
        pq[n--] = null; // 删除它
        sink(1); // reheapify
        return temp;
    }

    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) { // 当k节点大于它的父节点时，上浮k节点
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) { // 当k节点的子节点没有越界时，下沉k节点
            int scout = 2 * k;
            if (scout < n && less(scout, scout + 1)) // 选择较大的子节点和k节点交换
                scout++;
            if (less(k, scout) == false)
                break;
            exch(k, scout);
            k = scout;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
        _3_Heap_MaxPQ<Integer> pq = new _3_Heap_MaxPQ<>(20);
        for (Integer integer : new Integer[] { 6, 5, 1, 3, 8, 7, 2, 3, 6 }) {
            pq.insert(integer);
        }
        int cap = pq.size();
        for (int i = 0; i < cap; i++) {
            System.out.println("current max = " + pq.delMax());
        }
    }
}

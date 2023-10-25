package Chap2_Sort.Section4_Priority_Queue;

public class _2_Ordered_Array_MaxPQ<Key extends Comparable<Key>> implements _1_PQ_Interface<Key> {
    private Key[] pq;
    private int n = 0; // 记录当前元素个数，也是队尾指针

    @SuppressWarnings("unchecked")
    public _2_Ordered_Array_MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    @SuppressWarnings("unchecked")
    public _2_Ordered_Array_MaxPQ() {
        pq = (Key[]) new Comparable[10];
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
        int i;
        for (i = n; i > 0 && less(v, pq[i - 1]); i--) { // 将Key插入到合适的位置，实现类似插入排序
            pq[i] = pq[i - 1];
        }
        pq[i] = v;
        n++;
    }

    @Override
    public Key delMax() {
        Key temp = pq[--n];
        pq[n] = null;
        return temp;
    }

    private boolean less(Key v, Key that) {
        return v.compareTo(that) < 0;
    }

    public static void main(String[] args) {
        _2_Ordered_Array_MaxPQ<Integer> pq = new _2_Ordered_Array_MaxPQ<>(20);
        for (Integer integer : new Integer[] { 6, 5, 1, 3, 8, 7, 2, 3, 6 }) {
            pq.insert(integer);
        }
        int cap = pq.size();
        for (int i = 0; i < cap; i++) {
            System.out.println("current max = " + pq.delMax());
        }
    }
}

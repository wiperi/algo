package Chap2_Sort.Section4_Priority_Queue;

import java.lang.reflect.Constructor;

public class _4_Index_MinPQ<Key extends Comparable<Key>> implements Iterable<Key> {
    private int maxN;
    private int[] pq; // pq的索引 to keys
    private int[] qp; // 外部索引 to 具体元素在pq中的索引
    private Key[] keys; // 外部索引 - 具体元素
    private int n;

    public _4_Index_MinPQ(int maxN) {
        this.maxN = maxN;
        this.pq = new int[maxN + 1];
        this.qp = new int[maxN + 1];
        for (int i = 0; i < qp.length; i++) {
            pq[i] = -1;
        }
        this.keys = (Key[]) new Comparable[maxN];
        this.n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        
    }

    public void insert(int i, Key key) {
        n++;
        keys[i] = key;
        pq[n] = i;
        qp[i] = n;

    }
}

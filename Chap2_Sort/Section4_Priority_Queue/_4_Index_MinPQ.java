package Chap2_Sort.Section4_Priority_Queue;

import java.util.Iterator;

public class _4_Index_MinPQ<Item extends Comparable<Item>> implements Iterable<Item> {
    // 参考：https://zhuanlan.zhihu.com/p/287852724

    Item[] items; // ItemIndex to priority
    int[] pq; // HeapIndex to ItemIndex
    int n; // size of pq, always points to last element
    int[] qp; // ItemIndex to HeapIndex

    // 优先队列只能访问堆顶元素，不方便，我们想访问并修改堆中任意元素

    public void insert(int itemIndex, Item item) {
        items[itemIndex] = item;

        n++;
        pq[n] = itemIndex;
        qp[itemIndex] = n;

        swim(n);
    }

    // return the itemIndex of minimum item
    public int delMin() {
        int min = pq[1]; // min itemIndex
        exch(1, n);
        n--;
        sink(1);

        qp[min] = -1; // update qp
        items[min] = null; // delete item
        return min;
    }

    private void swim(int i) {
        while (parent(i) >= 1 && less(i, parent(i))) {
            exch(i, parent(i));
            i = parent(i);
        }
    }

    private void sink(int i) {
        // sink the bigger node
        while (true) {
            int min = i;
            int leftKid = leftKid(i);
            int rightKid = rightKid(i);

            if (leftKid <= n && less(leftKid, min)) {
                min = leftKid;
            }
            if (rightKid <= n && less(rightKid, min)) {
                min = rightKid;
            }
            if (min == i) {
                break;
            }
            exch(i, min);
            i = min;
        }
    }

    public static void main(String[] args) {

    }

    private boolean less(int i, int j) {
        // i, j as heap index
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        // i , j as heap index
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        // update qp
        qp[pq[i]] = i;
        qp[pq[j]] = j;

    }

    private int parent(int i) {
        return i / 2;
    }

    private int leftKid(int i) {
        return 2 * i;
    }

    private int rightKid(int i) {
        return 2 * i + 1;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
            }

            @Override
            public Item next() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'next'");
            }

        };
    }
}

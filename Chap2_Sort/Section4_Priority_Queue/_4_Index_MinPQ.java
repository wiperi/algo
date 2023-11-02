package Chap2_Sort.Section4_Priority_Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class _4_Index_MinPQ<Item extends Comparable<Item>> implements Iterable<Integer> {
    // 参考：https://zhuanlan.zhihu.com/p/287852724
    // 优先队列只能访问堆顶元素，不方便，我们想访问并修改堆中任意元素

    private int capacity; // max capacity
    // pq[] <--> items[] -> item
    private Item[] items; // rawIndex to item, items[rawrIndex] = the item
    private int[] pq; ////// heapIndex to rawIndex, pq[heapIndex] = rawIndex
    private int[] qp; ////// rawIndex to heapIndex, qp[rawIndex] = heapIndex
    private int n; ///////// size of pq, always points to the last element

    @SuppressWarnings("unchecked")
    public _4_Index_MinPQ(int capacity) {
        this.capacity = capacity;
        this.items = (Item[]) new Comparable[capacity];
        this.n = 0;
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            qp[i] = -1; // -1 in qp means no such elements
        }
    }

    /*********************************************************************
     * Basic Functions
     *********************************************************************/
    private boolean less(int i, int j) {
        // use i, j as heap index
        // compare the acutual item in items[]
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        // use i , j as heap index
        // exch the rawIndex in pq[] and upadate the index in qp[]
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        // update qp[]
        qp[pq[i]] = i;
        qp[pq[j]] = j;

    }

    private void swim(int heapI) {
        while (parent(heapI) >= 1 && less(heapI, parent(heapI))) {
            exch(heapI, parent(heapI));
            heapI = parent(heapI);
        }
    }

    private void sink(int heapI) {
        // sink the bigger node
        while (true) {
            int min = heapI;
            int leftKid = leftKid(heapI);
            int rightKid = rightKid(heapI);

            if (leftKid <= n && less(leftKid, min)) {
                min = leftKid;
            }
            if (rightKid <= n && less(rightKid, min)) {
                min = rightKid;
            }
            if (min == heapI) {
                break;
            }
            exch(heapI, min);
            heapI = min;
        }
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

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public int size() {
        return n;
    }

    private void validate(int i) {
        if (i >= capacity || i < 0) {
            throw new IllegalArgumentException("illegal index");
        }
    }

    /*******************************************************************
     * Core Functions
     *******************************************************************/
    public void insert(int rawI, Item item) {
        validate(rawI);

        items[rawI] = item;

        n++;
        pq[n] = rawI;
        qp[rawI] = n;

        swim(n);
    }

    /**
     * @return return the raw index of minimum item
     */
    public int delMin() {
        int min = pq[1];
        exch(1, n);
        n--;
        sink(1);

        qp[min] = -1; // update qp
        items[min] = null; // delete item
        return min;
    }

    public Item itemOf(int rawIndex) {
        return items[rawIndex];
    }

    public void changeItem(int rawIndex, Item newItem) {
        items[rawIndex] = newItem;
        swim(qp[rawIndex]);
        sink(qp[rawIndex]);
    }

    public void delete(int i) {
        int target = qp[i];
        exch(target, n--);
        sink(target);
        swim(target);
        items[i] = null;
        qp[i] = -1;
    }

    public Item peekMinItem() {
        return items[pq[1]];
    }

    public int peekMinIndex() {
        return pq[1];
    }

    /**********************************************************************
     * Iterator
     **********************************************************************/
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {
        // create a new pq
        private _4_Index_MinPQ<Item> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new _4_Index_MinPQ<Item>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], items[pq[i]]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Integer next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return copy.delMin();
        }
    }

    public static void main(String[] args) {
        _4_Index_MinPQ<Integer> pq = new _4_Index_MinPQ<>(20);
        Integer[] arr = { 8, 7, 6, 5 };
        for (int i = 0; i < arr.length; i++) {
            pq.insert(i, arr[i]);
        }

        for (int i = 0; i < pq.size(); i++) {
            System.out.println(pq.itemOf(pq.pq[i + 1]));
        }
        System.out.println();

        pq.changeItem(3, 100);

        for (int i = 0; i < pq.size(); i++) {
            System.out.println(pq.itemOf(pq.pq[i + 1]));
        }
        System.out.println();
    }
}

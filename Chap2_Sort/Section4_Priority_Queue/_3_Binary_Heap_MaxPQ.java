package Chap2_Sort.Section4_Priority_Queue;

public class _3_Binary_Heap_MaxPQ<Key extends Comparable<Key>> implements _1_PQ_Interface<Key> {
    private Key[] pq;
    private int n = 0; // 当前元素个数，也是队尾指针

    @SuppressWarnings("unchecked")
    public _3_Binary_Heap_MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    @SuppressWarnings("unchecked")
    public _3_Binary_Heap_MaxPQ() {
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

    /**************************************************************************
     * Helper Functions
     **************************************************************************/
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public Integer show() {
        int levels = (int) (Math.log(n) / Math.log(2));
        int numsOnBottomRow = (int) Math.pow(2, levels); // numbers of elements on bottom row
        int lenOfBottomRow = 2 * numsOnBottomRow - 1 - 1; // the char length that the bottom row should be printed

        int leftbound = 1;
        int rightbound = 1;
        int gap = lenOfBottomRow; // the gap printed bewteem two elements that are in the same row
        while (true) {
            for (int i = 0; i < (gap / 2); i++) { // print pregap for the first elements in the row
                System.out.print(" ");
            }
            for (int i = leftbound; i <= rightbound; i++) {
                if (i >= n) { // array boundary check
                    System.out.println();
                    return null;
                }
                System.out.print(pq[i]); // print element
                for (int j = 0; j < gap; j++) { // print gap
                    System.out.print(" ");
                }
            }

            gap /= 2;
            leftbound = 2 * leftbound;
            rightbound = 2 * rightbound + 1;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        _3_Binary_Heap_MaxPQ<Integer> pq = new _3_Binary_Heap_MaxPQ<>(200);
        for (Integer integer : new Integer[] { 6, 5, 1, 3, 8, 7, 2, 3, 6, 3, 3, 3 ,3,3}) {
            pq.insert(integer);
        }
        pq.show();
        int cap = pq.size();
        for (int i = 0; i < cap; i++) {
            System.out.println("current max = " + pq.delMax());
        }
    }
}

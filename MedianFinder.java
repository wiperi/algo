import java.util.PriorityQueue;

import edu.princeton.cs.algs4.Queue;

/**
 * Solutioncopy
 */

public class MedianFinder {
    PriorityQueue<Integer> pq;
    int n;
    Queue<Integer> que = new Queue<>();

    public MedianFinder() {
        pq = new PriorityQueue<>();
        n = 0;
    }

    public void addNum(int num) {
        n++;
        if (que.size() == 0)
            pq.add(num);
        else
            pq.add(que.dequeue());

        System.out.println("be: " + pq);

        if (pq.size() > (n / 2 + 1)) {
            que.enqueue(pq.poll());
        }
        System.out.println((n / 2 + 1));
        System.out.println(pq);// de
    }

    public double findMedian() {
        if (n % 2 == 0) {
            int left = pq.poll();
            int right = pq.poll();
            double median = (left + right) / 2.0;
            pq.add(left);
            pq.add(right);
            return median;
        } else {
            double median = pq.poll();
            pq.add((int) median);
            return median;
        }
    }

    public static void main(String[] args) {
        // MedianFinder f = new MedianFinder();
        // Integer[] arr = { 1, 2, 3, 4, 5 };
        // for (Integer integer : arr) {
        // f.addNum(integer);
        // }
        // System.out.println(f.pq);

        MedianFinder ff = new MedianFinder();
        int[] arr1 = { -1, -2, -3, -4, -5, -6, -7, -8, -9 };
        for (int i : arr1) {
            ff.addNum(i);
        }
        System.out.println(ff.pq);

        // PriorityQueue<Integer> pri = new PriorityQueue<>();
        // for (Integer i : arr1) {
        // pri.add(i);
        // }
        // System.out.println(pri);
    }
}

// 维护一个大小为k的优先队列，k
/*
 * 理想下，N = 【1，2，3】，k = 2
 * k = 【1，2，3，4，5】。k = 3
 * N = 【1，2，3，4】，k = 3，两次delmax然后求平均值
 */

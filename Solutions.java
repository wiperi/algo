import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.function.IntToDoubleFunction;

import javax.swing.RowFilter.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Graph.Graph._10_Graph;
import List.LinkedList.Linked_List;
import List.LinkedList.ListNode;
import Tree.Binary_Tree.Node;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMultiwayMinPQ;

@SuppressWarnings("unused")
public class Solutions {

    class MedianFinder {

        PriorityQueue<Integer> queMax;
        PriorityQueue<Integer> queMin;
        int count;

        public MedianFinder() {
            queMax = new PriorityQueue<>(Comparator.naturalOrder());
            queMin = new PriorityQueue<>(Comparator.reverseOrder());
            count = 0;
        }

        public void addNum(int num) {
            if (queMin.isEmpty() || num <= queMin.peek()) {
                // num <= queMin.peek()
                queMin.add(num);
                // maintain balance of two queues
                if (queMax.size() + 1 < queMin.size()) {
                    queMax.add(queMin.poll());
                }
            } else {
                // num > queMin.peek()
                queMax.add(num);
                // maintain balance of two queues
                if (queMin.size() < queMax.size()) {
                    queMin.add(queMax.poll());
                }
            }
        }

        public double findMedian() {
            if (queMin.size() > queMax.size()) {
                return queMin.peek();
            } else {
                return (queMin.peek() + queMax.peek()) / 2.0;
            }
        }
    }

    class SolutionDailyTemperatures {

        public int[] dailyTemperatures(int[] temperatures) {

            Stack<Integer> stack = new Stack<>();
            int[] ret = new int[temperatures.length];

            // Adding temperatures to stack, if found a higher temperature, pop all lower
            // temperatures in the stack and calculate the result.
            for (int i = 0; i < temperatures.length; i++) {

                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    ret[stack.peek()] = i - stack.pop();
                }

                stack.push(i);
            }

            return ret;
        }
    }

    class Solution_NetworkDelayTime {

        public int networkDelayTime(int[][] times, int n, int k) {
            // build a map
            List<List<int[]>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new LinkedList<int[]>());
            }

            for (int i = 0; i < times.length; i++) {
                int from = times[i][0] - 1;
                int to = times[i][1] - 1;
                int weight = times[i][2];

                graph.get(from).add(new int[] { to, weight });
            }

            // find the shortest path
            int[] distTo = new int[n];
            Arrays.fill(distTo, Integer.MAX_VALUE);
            distTo[k - 1] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.add(new int[] { k - 1, 0 });

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int cur_vertex = cur[0];
                int disToCur = cur[1];

                for (int[] edge : graph.get(cur[0])) {
                    int next_vertex = edge[0];
                    int weight = edge[1];

                    int disToNext = distTo[cur_vertex] + weight;
                    if (disToNext < distTo[next_vertex]) {
                        distTo[next_vertex] = disToNext;
                        pq.offer(new int[] { next_vertex, disToNext });
                    }
                }
            }

            int maxIndex = 0;
            for (int i = 0; i < distTo.length; i++) {
                if (distTo[i] > distTo[maxIndex]) {
                    maxIndex = i;
                }
            }

            if (distTo[maxIndex] == Integer.MAX_VALUE) {
                return -1;
            } else {
                return distTo[maxIndex];
            }
        }
    }

    class Solution_MinimumEffortPath {

        class Node {
            int x;
            int y;
            int effortFromStart;

            public Node(int x, int y, int effortFromStart) {
                this.x = x;
                this.y = y;

                // it means the the steepest slope that need to be tacked to get here. not the
                // total height difference traveled.
                this.effortFromStart = effortFromStart;
            }
        }

        public int minimumEffortPath(int[][] heights) {
            int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
            int numRow = heights.length;
            int numCol = heights[0].length;

            int[][] effortTo = new int[numRow][numCol];
            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    effortTo[i][j] = Integer.MAX_VALUE;
                }
            }
            effortTo[0][0] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.effortFromStart - b.effortFromStart);
            pq.add(new Node(0, 0, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cur.x == numRow - 1 && cur.y == numCol - 1) {
                    return effortTo[cur.x][cur.y];
                }

                if (cur.effortFromStart > effortTo[cur.x][cur.y]) {
                    continue;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int nextX = cur.x + directions[dir][0];
                    int nextY = cur.y + directions[dir][1];

                    if (nextX < 0 || nextX >= numRow || nextY < 0 || nextY >= numCol) {
                        continue;
                    }

                    int effortForNextNode = Math.max(Math.abs(heights[nextX][nextY] - heights[cur.x][cur.y]),
                            cur.effortFromStart);

                    if (effortForNextNode < effortTo[nextX][nextY]) {
                        effortTo[nextX][nextY] = effortForNextNode;
                        pq.add(new Node(nextX, nextY, effortForNextNode));
                    }
                }
            }

            return -1;
        }
    }

    class Solution_MaxProb {

        class Node {
            int vertex;

            // success probability from start to this node
            double succProb;

            public Node(int vertex, double succProb) {
                this.vertex = vertex;
                this.succProb = succProb;
            }
        }

        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            // build a graph
            List<List<Node>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new LinkedList<Node>());
            }
            for (int i = 0; i < edges.length; i++) {
                int from = edges[i][0];
                int to = edges[i][1];
                double prob = succProb[i];

                graph.get(from).add(new Node(to, prob));
                graph.get(to).add(new Node(from, prob));
            }

            double[] probTo = new double[n];

            Arrays.fill(probTo, 0);
            probTo[start_node] = 1;

            Queue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.succProb, a.succProb));
            pq.add(new Node(start_node, 1));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cur.succProb < probTo[cur.vertex]) continue;

                for (Node edge : graph.get(cur.vertex)) {

                    double probOfNext = probTo[cur.vertex] * edge.succProb;

                    if (probOfNext > probTo[edge.vertex]) {
                        probTo[edge.vertex] = probOfNext;
                        pq.add(new Node(edge.vertex, probOfNext));
                    }
                }
            }
            return probTo[end_node];
        }
    }

    class Solution_fiwejf {

        int nrow = 0;
        int ncol = 0;

        boolean visited[][];

        public void setZeroesColRow(int[][] matrix, int row, int col) {
            for (int r = 0; r < nrow; r++) {
                matrix[r][col] = 0;
                visited[r][col] = true;
            }
            for (int c = 0; c < ncol; c++) {
                matrix[row][c] = 0;
                visited[row][c] = true;
            }
        }

        class Tuple {
            int row;
            int col;

            public Tuple(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        public void setZeroes(int[][] matrix) {
            nrow = matrix.length;
            ncol = matrix[0].length;
            visited = new boolean[nrow][ncol];
            for (int r = 0; r < nrow; r++) {
                for (int c = 0; c < ncol; c++) {
                    visited[r][c] = false;
                }
            }

            List<Tuple> target = new ArrayList<>();
            for (int r = 0; r < nrow; r++) {
                for (int c = 0; c < ncol; c++) {
                    if (matrix[r][c] == 0) {
                        target.add(new Tuple(r, c));
                    }
                }
            }

            for (Tuple t : target) {
                if (!visited[t.row][t.col]) {
                    setZeroesColRow(matrix, t.row, t.col);
                }
            }
        }

        void showMatrix(int[][] matrix) {
            for (int r = 0; r < nrow; r++) {
                for (int c = 0; c < ncol; c++) {
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    class Solution {

        public void setZeroes(int[][] matrix) {
            int nrow = matrix.length;
            int ncol = matrix[0].length;

            boolean target_row[] = new boolean[nrow];
            boolean target_col[] = new boolean[ncol];

            // mark the target rows and cols
            for (int r = 0; r < nrow; r++) {
                for (int c = 0; c < ncol; c++) {
                    if (matrix[r][c] == 0) {
                        target_row[r] = true;
                        target_col[c] = true;
                    }
                }
            }

            // set zero
            for (int r = 0; r < nrow; r++) {
                for (int c = 0; c < ncol; c++) {
                    if (target_row[r] || target_col[c]) {
                        matrix[r][c] = 0;
                    }
                }
            }
        }
    }

    class Solution138 {

        class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }

        public Node copyRandomList(Node head) {
            // copy list and build a hash table
            HashMap<Node, Node> map = new HashMap<>(0);

            Node dummy = new Node(Integer.MIN_VALUE);
            Node cur = dummy;
            for (Node p = head; p != null; p = p.next) {
                cur.next = new Node(p.val);
                map.put(p, cur.next);
                cur = cur.next;
            }

            cur = dummy.next;
            for (Node p = head; p != null; p = p.next) {
                if (p.random == null) {
                    cur.random = null;
                } else {
                    cur.random = map.get(p.random);
                }
                cur = cur.next;
            }

            return dummy.next;
        }

    }

    class Solution25 {

        ListNode next_begin;
        int stop_right_now = 0;
        int global_k;

        public ListNode reverseKGroup(ListNode head, int k) {

            global_k = k;

            ListNode new_head = reverse(head, k);

            return new_head;
        }

        public ListNode reverse(ListNode head, int k) {

            // base case 1: flip the group of k nodes
            if (k == 1) {
                next_begin = head.next == null ? null : head.next;
                return head;
            }

            // base case 2: couldn't find group of k to flip, stop immediately
            if (head == null || head.next == null) {
                stop_right_now = 1;
                next_begin = null;
                return head;
            }

            ListNode new_head = reverse(head.next, k - 1);

            if (stop_right_now == 1) {
                // return the old head
                return head;
            }

            // post order
            head.next.next = head;

            if (k == global_k) {
                head.next = reverse(next_begin, global_k);
            }

            return new_head;
        }

        public static void main(String[] args) {
            Solution25 s = new Solutions().new Solution25();

            Linked_List l = new Linked_List("1 2 3 4 5 6 7 8");
            l.head = s.reverseKGroup(l.head, 3);

            l.showAllNodes();
            System.out.println(l);
        }
    }

    class DelDup {
        static ListNode del_neg(ListNode head) {
            ListNode cur, prev;
            cur = head;
            prev = null;

            if (head == null) {
                return head;
            }

            if (head.next == null) {
                if (head.val < 0) {
                    return null;
                }
            }

            // at least two
            while (cur != null) {
                // cur from head to tail. not include null
                if (cur.val < 0) {
                    if (prev == null) {
                        // deleting first node
                        head = cur.next;
                        cur = cur.next;
                        continue;
                    } else {
                        prev.next = cur.next;
                        cur = cur.next;
                        continue;
                    }
                }

                prev = cur;
                cur = cur.next;
            }

            return head;
        }

        public static void main(String[] args) {
            Linked_List l = new Linked_List("-1 0 -1");
            l.head = del_neg(l.head);
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        DelDup.main(args);
    }

}

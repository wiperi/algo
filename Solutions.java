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
import Tree.Binary_Tree.Node;
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

    class Solution {

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

    public static void main(String[] args) {
        MedianFinder mf = new Solutions().new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

}

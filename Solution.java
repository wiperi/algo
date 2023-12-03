import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.RowFilter.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Chap3_Search.TreeNode;

@SuppressWarnings("unused")
public class Solution {

    class tanxin {

        public int maxProfit(int[] prices) {
            // find the minimum day
            int minval = prices[0], minindex = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minval) {
                    minval = prices[i];
                    minindex = i;
                }
            }

            if (minindex == prices.length - 1) return 0;

            int maxval = prices[minindex + 1], maxindex = minindex + 1;
            for (int i = minindex + 1; i < prices.length; i++) {
                if (prices[i] > maxval) {
                    maxval = prices[i];
                    maxindex = i;
                }
            }

            return maxval - minval;
        }
    }

    class MinStack {
        class Pair {
            int val;
            int min;

            Pair(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        Stack<Pair> stack = new Stack<>();

        public MinStack() {}

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Pair(val, val));
            } else {
                stack.push(new Pair(val, val < getMin() ? val : getMin()));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() { return stack.peek().min; }
    }

    public static void main(String[] args) {
        MinStack s = new Solution().new MinStack();

        for (int i : new int[] { -2, 0, -1 }) {
            s.push(i);
        }
        System.out.println(s.getMin());

    }
}
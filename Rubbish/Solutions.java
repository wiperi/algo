package Rubbish;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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

import _50_Data_Structure.Graph.Simple_Graph._10S_Graph;
import _50_Data_Structure.Tree.Binary_Tree.Node;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMultiwayMinPQ;

@SuppressWarnings("unused")
public class Solutions {
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UnionFind_Weighted_PathCompressed uf = new UnionFind_Weighted_PathCompressed(26);

            // 1. build the union find from String[]
            for (int i = 0; i < equations.length; i++) {
                if (equations[i].charAt(1) == '=') uf.union(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a');
            }

            for (int i = 0; i < equations.length; i++) {
                if (equations[i].charAt(1) == '!') {
                    if (uf.isConnected(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a')) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public class UnionFind_Weighted_PathCompressed {

        private int[] parent;

        private int[] rank; // also means "depth" or "size"
                            // it record the depth of the each subtree

        public UnionFind_Weighted_PathCompressed(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            // 按秩合并：
            // 按照深度，将小树合并到大树上（接到大树的根部）
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    // 当2个树深度不等，合并后2树深度不变
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    // 当2个树深度相等，被连接的树的深度+1
                    parent[rootX] = rootY;
                    rank[rootY]++;
                }
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;

            parent[x] = find(parent[x]); // 路径压缩
            return parent[x];
        }

        // find()的循环版本
        @SuppressWarnings("unused")
        private int find_iter(int x) {
            int root = x;
            while (root != parent[root])
                root = parent[root];

            while (x != root) {
                int newp = parent[x];
                parent[x] = root; // 路径压缩
                x = newp;
            }
            return root;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solutions().new Solution();

        System.out.println(s.equationsPossible(new String[] { "c==c", "b==d", "x!=z" }));

    }
}
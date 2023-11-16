import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

import Chap3_Search.TreeNode;
import Chap3_Search._BST;
import edu.princeton.cs.algs4.In;

@SuppressWarnings("unused")
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valToInorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToInorderIndex.put(inorder[i], i);
        }
        return buildTreeAux(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valToInorderIndex);
    }

    public TreeNode buildTreeAux(int[] preorder, int preLo, int preHi, int[] inorder, int lo, int hi,
            Map<Integer, Integer> valToInorderIndex) {

        if (preLo >= preorder.length) return null;
        int mid = valToInorderIndex.get(preorder[preLo]);
        if (mid < lo || mid > hi) return null;

        TreeNode root = new TreeNode(preorder[preLo++]);
        int leftSize = mid - lo;

        root.left = buildTreeAux(preorder, preLo, preHi, inorder, lo, mid - 1, valToInorderIndex);
        if (root.left != null) preLo++;
        root.right = buildTreeAux(preorder, preLo, preHi, inorder, mid + 1, hi, valToInorderIndex);
        return root;
    }

    public static void main(String[] args) {
        var s = new Solution();
        TreeNode root = TreeNode.buildTree(new Integer[] { 1, 2, 3 });

        TreeNode newroot = s.buildTree(new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 });
        TreeNode.show(newroot);

    }
}
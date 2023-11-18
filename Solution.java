import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

import Chap3_Search.TreeNode;

@SuppressWarnings("unused")
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listq = new ArrayList<>();
        List<TreeNode> listp = new ArrayList<>();
        findPath(root, q, new ArrayList<>(), listq);
        findPath(root, p, new ArrayList<>(), listp);

        int tail = Math.min(listq.size() - 1, listp.size() - 1);
        while (tail >= 0) {
            if (listq.get(tail) == listp.get(tail)) return listp.get(tail);
            tail--;
        }
        return root;
    }

    private void findPath(TreeNode root, TreeNode tar, List<TreeNode> path, List<TreeNode> res) {
        if (root == null) return;

        path.add(root);
        if (root == tar) {
            res.addAll(path);
            return;
        }

        findPath(root.left, tar, path, res);
        findPath(root.right, tar, path, res);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNode.buildTree(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
        TreeNode commondad = s.lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(commondad.val);
    }
}
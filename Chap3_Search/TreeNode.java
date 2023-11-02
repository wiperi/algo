package Chap3_Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int size(TreeNode root) {
        List<Integer> list = levelOrderTraversal(root);
        return list.size();
    }

    public int preorderTraversalIterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int size = 0;

        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            size++;
            
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return size;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        while (!stack.empty() || root != null) {
            if (root != null) { // 不断向左下走
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ret.add(root.val); // record
                root = root.right;
            }
        }

        return ret;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root.left);
        dfs(root.right);
        return null;
    }

    public List<Integer> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> retList = new ArrayList<>();
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode temp = que.poll(); // 取出节点
            retList.add(temp.val); // 记录节点
            que.offer(temp.left == null ? null : temp.left); // 左节点入队
            que.offer(temp.right == null ? null : temp.right); // 右节点入队
        }

        return retList;
    }
}

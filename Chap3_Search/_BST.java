package Chap3_Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.princeton.cs.algs4.BST;

public class _BST {
    private TreeNode root;

    public TreeNode search(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (val == cur.val)
                break;
            else if (val > cur.val)
                cur = cur.right;
            else
                cur = cur.left;
        }
        return cur;
    }

    public void put(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        TreeNode pre = null, cur = root;
        while (cur != null) {
            if (val == cur.val) {
                return;
            } else if (val > cur.val) {
                pre = cur;
                cur = cur.right;
            } else {
                pre = cur;
                cur = cur.left;
            }
        }

        TreeNode newNode = new TreeNode(val);
        if (val > pre.val) {
            pre.right = newNode;
        } else {
            pre.left = newNode;
        }
    }

    /************************************************************************
     * BFS
     ************************************************************************/
    public List<Integer> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> retList = new ArrayList<>();
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode temp = que.poll(); // 取出节点
            retList.add(temp.val); // 记录节点

            if (temp.left != null) // 左节点入队
                que.offer(temp.left);
            if (temp.right != null) // 右节点入队
                que.offer(temp.right);
        }
        return retList;
    }

    /************************************************************************
     * DFS
     ************************************************************************/

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();

        _BST b = new _BST();
        for (int i = 0; i < 10; i++) {
            b.put(i + 1);
        }
        List<Integer> ret = b.levelOrderTraversal(b.root);
        System.out.println(ret);

    }
}

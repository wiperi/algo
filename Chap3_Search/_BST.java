package Chap3_Search;

import edu.princeton.cs.algs4.BST;

public class _BST {
    public TreeNode root;

    /************************************************************************
     * Core Functions
     ************************************************************************/
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
     * Test
     ************************************************************************/
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        _BST b = new _BST();
        for (Integer ints : new Integer[] { 6, 4, 8, 3, 5 }) {
            b.put(ints);
            bst.put(ints, ints);
        }

        System.out.println("levelorder:");
        System.out.println(bst.levelOrder());
        System.out.println(TreeNode.levelOrder(b.root));

        System.out.println();

        System.out.println("pre, in, post order by recursion:");
        System.out.println(TreeNode.dfs(b.root, 1));
        System.out.println(TreeNode.dfs(b.root, 2));
        System.out.println(TreeNode.dfs(b.root, 3));

        System.out.println();

        System.out.println("pre, pre1, in, post order by iter:");
        System.out.println(TreeNode.preorderIter(b.root));
        System.out.println(TreeNode.preorderIter1(b.root));
        System.out.println(TreeNode.inorderIter(b.root));
        System.out.println(TreeNode.postorderIter(b.root));
    }
}

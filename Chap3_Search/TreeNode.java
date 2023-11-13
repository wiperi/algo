package Chap3_Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import edu.princeton.cs.algs4.BST;

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

    /************************************************************************
     * Helper Funtions
     ************************************************************************/
    public static int sizeOf(TreeNode root) {
        List<Integer> list = levelOrder(root);
        return list.size();
    }

    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = getHeight(root.left);
        int rightMax = getHeight(root.right);

        return 1 + Math.max(leftMax, rightMax);
    }

    public static TreeNode builtTree(int[] a) {
        int len = a.length;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode(a[i], null, null);
        }
        for (int i = 0; i < len; i++) {
            int leftKid = 2 * i + 1;
            int rightKid = 2 * i + 2;
            if (leftKid < len)
                nodes[i].left = nodes[leftKid];
            if (rightKid < len)
                nodes[i].right = nodes[rightKid];
        }
        return nodes[0];
    }

    /************************************************************************
     * BFS
     ************************************************************************/
    // 层序遍历
    public static List<Integer> levelOrder(TreeNode root) {
        // video: https://youtu.be/my9AYTFl8IM
        if (root == null) {
            return null;
        }

        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();

        que.add(root);
        while (!que.isEmpty()) {
            TreeNode temp = que.poll(); // 取出节点
            ret.add(temp.val); // 记录节点

            if (temp.left != null) // 左节点入队
                que.offer(temp.left);
            if (temp.right != null) // 右节点入队
                que.offer(temp.right);
        }
        return ret;
    }

    /************************************************************************
     * DFS
     ************************************************************************/
    @SuppressWarnings("unused")
    private static void dfsFrame(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        dfsFrame(root.left);
        // 中序位置
        dfsFrame(root.right);
        // 后序位置
    }

    private static List<Integer> retList = new ArrayList<>();

    public static List<Integer> dfs(TreeNode root, int mode) {
        retList.clear();
        return dfsRecur(root, mode);
    }

    private static List<Integer> dfsRecur(TreeNode root, int mode) {
        if (mode < 1 || mode > 3) { // 检查参数合法性
            throw new IllegalArgumentException("mode must be 1,2 or 3");
        }

        if (root == null) { // base case
            return null;
        }

        if (mode == 1)
            retList.add(root.val); // 前序

        dfsRecur(root.left, mode);

        if (mode == 2)
            retList.add(root.val); // 中序

        dfsRecur(root.right, mode);

        if (mode == 3)
            retList.add(root.val); // 后序

        return retList;
    }

    public static List<Integer> preorderSub(TreeNode root) {
        // 分解成问题：一个二叉树的前序遍历结果 = root的值 + 左子树的前序结果 +  + 右子树的前序结果
        List<Integer> ret = new ArrayList<>();

        if (root == null) return ret;

        List<Integer> left = preorderSub(root.left);
        List<Integer> right = preorderSub(root.right);

        ret.add(root.val); // 中序和后序改变add命令的位置即可
        ret.addAll(left);
        ret.addAll(right);

        return ret;
    }

    public static List<Integer> preorderIter(TreeNode root) { // 迭代先序
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            ret.add(cur.val); // 记录节点

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return ret;
    }

    public static List<Integer> preorderIter1(TreeNode root) { // 迭代先序1
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        while (!stack.empty() || root != null) {
            if (root != null) { // 不断向左下走
                stack.push(root); // 每走到一个节点就将该节点入栈
                ret.add(root.val); // 记录节点
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }

        return ret;
    }

    public static List<Integer> inorderIter(TreeNode root) { // 迭代中序
        // video: https://youtu.be/d4KBiARy_Tk
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        while (!stack.empty() || root != null) {
            if (root != null) { // 不断向左下走
                stack.push(root); // 每走到一个节点就将该节点入栈
                root = root.left; // 向左下走
            } else {
                root = stack.pop();
                ret.add(root.val); // 记录节点
                root = root.right;
            }
        }

        return ret;
    }

    public static List<Integer> postorderIter(TreeNode root) { // 迭代后序
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);

            // 先将左子树入stack1，再将右子树入stack1
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        List<Integer> ret = new ArrayList<>();
        while (!stack2.isEmpty()) {
            ret.add(stack2.pop().val);
        }
        return ret;
    }

    /************************************************************************
     * Test
     ************************************************************************/
    public static void testTraversal(String[] args) {
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
        System.out.println(TreeNode.preorderSub(b.root));
        System.out.println(TreeNode.inorderIter(b.root));
        System.out.println(TreeNode.postorderIter(b.root));
    }

    public static void main(String[] args) {
        testTraversal(args);
    }
}
package Chap3_Search;

import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.BST;

public class _BST {
    public TreeNode root;

    /************************************************************************
     * Object Methods
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
        // find the right position to attach
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
        // attach new node
        TreeNode newNode = new TreeNode(val);
        if (val > pre.val) {
            pre.right = newNode;
        } else {
            pre.left = newNode;
        }
    }

    public List<Integer> toSortedArray() {
        return TreeNode.dfs(root, 2);
    }

    /************************************************************************
     * Class Methods
     ************************************************************************/
    public static boolean isValidBST(TreeNode root) {
        isValidBSTAux(root);
        boolean res = valid;
        // reset value
        valid = true;
        preVal = null;

        return res;
    }

    private static boolean valid = true;
    private static Integer preVal;

    private static void isValidBSTAux(TreeNode root) {
        if (root == null)
            return;
        isValidBSTAux(root.left);
        // the inorder traverse of a BST must be a ascending ordered list
        if (preVal == null)
            preVal = root.val;
        else {
            if (root.val <= preVal) {
                valid = false;
                return;
            }
            preVal = root.val;
        }
        isValidBSTAux(root.right);
    }

    public boolean isValidBSTVerLabuladong(TreeNode root) {
        return isValidBSTVerLabuladongAux(root, null, null);
    }

    boolean isValidBSTVerLabuladongAux(TreeNode root, TreeNode min, TreeNode max) {
        /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
        // base case
        if (root == null)
            return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBSTVerLabuladongAux(root.left, min, root)
                && isValidBSTVerLabuladongAux(root.right, root, max);
    }

    public static TreeNode buildFromSortedArray(Integer[] a) {
        return buildFromSortedArrayAux(null, a, 0, a.length - 1);
    }

    private static TreeNode buildFromSortedArrayAux(TreeNode root, Integer[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo <= hi) {
            root = new TreeNode(arr[mid]);
        } else {
            return null;
        }

        root.left = buildFromSortedArrayAux(root.left, arr, lo, mid - 1);
        root.right = buildFromSortedArrayAux(root.right, arr, mid + 1, hi);
        return root;
    }

    private static boolean isSorted(Integer[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1])
                return false;
        }
        return true;
    }

    public static TreeNode buildFromArray(Integer[] a) {
        if (!isSorted(a))
            Arrays.sort(a);
        return buildFromSortedArray(a);
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

        System.out.println();

        System.out.println("toSortedArray");
        List<Integer> inorderList = b.toSortedArray();
        System.out.println(inorderList);
    }
}

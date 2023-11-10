import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Chap3_Search.TreeNode;
import Chap3_Search._BST;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(null, nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(TreeNode root, int[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo <= hi) {
            root = new TreeNode(arr[mid]);
        } else {
            return null;
        }

        root.left = buildBST(root.left, arr, lo, mid - 1);
        root.right = buildBST(root.right, arr, mid + 1, hi);
        return root;
    }

    public boolean wwwwwwwwwwwwwisValidBST(TreeNode root) {
        boolean valid = false;
        if (root == null)
            return true;
        else {
            if (root.right == null && root.left == null)
                valid = true;
            if (root.right != null && root.left != null) {
                if (root.right.val > root.val && root.val > root.left.val)
                    valid = true;
            }
            if (root.right == null && root.left != null) {
                if (root.val > root.left.val)
                    valid = true;
            }
            if (root.right != null && root.left == null) {
                if (root.right.val > root.val)
                    valid = true;
            }
        }
        System.out.println(root.val + " is " + valid);
        return valid && wwwwwwwwwwwwwisValidBST(root.left) && wwwwwwwwwwwwwisValidBST(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return valid;
    }

    static boolean valid = true;
    static Integer val;

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);

        // inorder position
        if (val == null)
            val = root.val;
        else {
            if (root.val <= val) {
                valid = false;
                return;
            }
            val = root.val;
        }

        dfs(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNode.builtTree(new int[] { 5, 4, 6, 3, 7 });
        System.out.println(s.wwwwwwwwwwwwwisValidBST(root));

        _BST b = new _BST();
        _BST.isValidBST(root);
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import Chap3_Search.TreeNode;
import Chap3_Search._BST;

@SuppressWarnings("unused")
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        getHeight(root, 0);
        dfs(root, 0);
        return Arrays.asList(res);
    }

    Integer[] res;
    int maxDepth = 0;

    private void dfs(TreeNode root, int level) {
        level++;
        if (root == null)
            return;

        dfs(root.right, level);
        dfs(root.left, level);
        // postorder
        if (res == null) {
            res = new Integer[maxDepth];
        }
        if (res[level - 1] == null) {
            res[level - 1] = root.val;
        }
    }

    private void getHeight(TreeNode root, int level) {
        level++;
        if (root == null)
            return;

        maxDepth = Math.max(maxDepth, level);
        getHeight(root.left, level);
        getHeight(root.right, level);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.builtTree(new Integer[] { 4, 3, 6, 1, null, 5, null, null, 2 });

        s.getHeight(root, 0);
        System.out.println(s.maxDepth);
        System.out.println(s.rightSideView(root));
    }
}
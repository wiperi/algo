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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> valToIndex = new HashMap<>(); // val to index in inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, valToIndex);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
            Map<Integer, Integer> valToIndex) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = valToIndex.get(rootVal); // root index in inorder list
        int rightSubtreeSize = inEnd - rootIndex;

        int leftInStart = inStart, leftInEnd = rootIndex - 1;
        int leftPostStart = postStart, leftPostEnd = postEnd - rightSubtreeSize - 1;
        root.left = buildTreeHelper(inorder, leftInStart, leftInEnd, postorder, leftPostStart, leftPostEnd, valToIndex);

        int rightInStart = rootIndex + 1, rightInEnd = inEnd;
        int rightPostStart = postEnd - rightSubtreeSize, rightPostEnd = postEnd - 1;
        root.right = buildTreeHelper(inorder, rightInStart, rightInEnd, postorder, rightPostStart, rightPostEnd,
                valToIndex);

        return root;
    }

    /************************************************************************
     * divide
     ************************************************************************/

    public int pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            // preorder place
            backtrack(new State(cur, targetSum, 0, new ArrayList<>()), Arrays.asList(new TreeNode[] {cur.left, cur.right}), res);

            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }

        return res.size();
    }

    class State {
        TreeNode root;
        int targetSum;
        int sum;
        List<Integer> path = new ArrayList<>();

        public State(TreeNode root, int targetSum, int sum, List<Integer> path) {
            this.root = root;
            this.targetSum = targetSum;
            this.sum = sum;
            this.path = path;
        }
    }

    void backtrack(State state, List<TreeNode> choiceSet, List<List<Integer>> res) {
        if (isSolution(state)) {
            recordSolution(state, res);
        }

        for (TreeNode choice : choiceSet) {
            if (isValid(state, choice)) {
                makeChoice(state, choice);
                backtrack(state, choiceSet, res);
                undoChoice(state, choice);
            }
        }
    }

    private boolean isValid(Solution.State state, TreeNode choice) {
        return true;
    }

    private void undoChoice(Solution.State state, TreeNode choice) {
        state.path.remove(state.path.size() - 1);
        state.sum -= choice.val;
    }

    private void recordSolution(Solution.State state, List<List<Integer>> res) {
        res.add(state.path);
    }

    private boolean isSolution(Solution.State state) {
        if (state.targetSum == state.sum) return true;
        return false;
    }

    private void makeChoice(State state, TreeNode choice) {
        state.path.add(choice.val);
        state.sum += choice.val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] inorder = { 4, 2, 5, 1, 3 };
        int[] postorder = { 4, 5, 2, 3, 1 };

        TreeNode root = s.buildTree(inorder, postorder);

        // Print the inorder traversal of the constructed tree
        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }

    private static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
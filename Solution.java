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

    /* 判断当前状态是否为解 */
    boolean isSolution(List<TreeNode> state) {
        return !state.isEmpty() && state.get(state.size() - 1).val == 7;
    }

    /* 记录解 */
    void recordSolution(List<TreeNode> state, List<List<TreeNode>> res) {
        res.add(new ArrayList<>(state));
    }

    /* 判断在当前状态下，该选择是否合法 */
    boolean isValid(List<TreeNode> state, TreeNode choice) {
        return choice != null && choice.val != 3;
    }

    /* 更新状态 */
    void makeChoice(List<TreeNode> state, TreeNode choice) {
        state.add(choice);
    }

    /* 恢复状态 */
    void undoChoice(List<TreeNode> state, TreeNode choice) {
        state.remove(state.size() - 1);
    }

    /* 回溯算法：例题三 */
    void backtrack(List<TreeNode> state, List<TreeNode> choices, List<List<TreeNode>> res) {
        // 检查是否为解
        if (isSolution(state)) {
            // 记录解
            recordSolution(state, res);
        }
        // 遍历所有选择
        for (TreeNode choice : choices) {
            // 剪枝：检查选择是否合法
            if (isValid(state, choice)) {
                // 尝试：做出选择，更新状态
                makeChoice(state, choice);
                // 进行下一轮选择
                backtrack(state, Arrays.asList(choice.left, choice.right), res);
                // 回退：撤销选择，恢复到之前的状态
                undoChoice(state, choice);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        /*
         * 在二叉树中搜索所有值为 的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为 的节点。
         */
        TreeNode root = TreeNode.buildTree(new Integer[] { 1, 7, 3, 4, 5, 6, 7, 7 });
        List<List<TreeNode>> res = new ArrayList<>();
        List<TreeNode> state = new ArrayList<>();
        List<TreeNode> choices = new ArrayList<>();
        state.add(root);
        choices.add(root.left == null ? null : root.left);
        choices.add(root.right == null ? null : root.right);
        s.backtrack(state, choices, res);

        for (List<TreeNode> subList : res) {
            for (TreeNode treeNode : subList) {
                System.out.print(treeNode.val + " ");
            }
            System.out.println();
        }
    }
}
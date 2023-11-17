import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

import Chap3_Search.TreeNode;

@SuppressWarnings("unused")
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] postorder) {
        Map<Integer, Integer> valToIndex = new HashMap<>(); // val to index in postorder
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, valToIndex);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd,
            Map<Integer, Integer> valToIndex) {

        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int indexInPost = valToIndex.get(preorder[preStart]);

        int leftSubtreeSize = indexInPost - postStart;

        int leftPreStart = preStart + 1;
        int leftPreEnd = preStart + leftSubtreeSize;
        int leftPostStart = postStart;
        int leftPostEnd = indexInPost - 1;
        root.left = buildTree(preorder, leftPreStart, leftPreEnd, postorder, leftPostStart, leftPostEnd, valToIndex);

        int rightPreStart = preStart + leftSubtreeSize + 1;
        int rightPreEnd = preEnd;
        int rightPostStart = indexInPost + 1;
        int rightPostEnd = postEnd;
        root.right = buildTree(preorder, rightPreStart, rightPreEnd, postorder, rightPostStart, rightPostEnd, valToIndex);

        return root;
    }
}
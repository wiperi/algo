import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Chap3_Search.TreeNode;

public class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }

    int res = 0;

    public int maxDepth(TreeNode root) {
        // 分解问题：最长直径 = 左子树的最长路径 + 右子树的最长路径
        if (root == null)
            return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        res = Math.max(res, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> que = new LinkedList<>();
        List<TreeNode> list = new LinkedList<>();
        List<Integer> subList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        que.offer(root);

        while (true) {
            for (TreeNode node : que) {
                list.add(node);
            }

            for (TreeNode node : list) {
                int a = node.val;
                System.out.println(a);
                subList.add(a);
            }
            res.add(subList);
            subList.clear();

            que.clear();
            for (TreeNode node : list) {
                if (node.left != null)
                    que.offer(node.left);
                if (node.right != null)
                    que.offer(node.right);
            }
            if (que.isEmpty())
                break;
            list.clear();
        }
        return res;
    }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 方法一：BFS
        // if(root == null){
        //     return new ArrayList<>();
        // }
        // List<List<Integer>> res = new ArrayList<>();
        

        // LinkedList<TreeNode> queue = new LinkedList<>();
        // queue.add(root);

        // while(!queue.isEmpty()){
        //     int size = queue.size();
        //     List<Integer> tempList = new ArrayList<>();

        //     while(size > 0){
        //         TreeNode temp = queue.poll();
        //         tempList.add(temp.val);

        //         if(temp.left != null){
        //             queue.add(temp.left);
        //         }

        //         if(temp.right != null){
        //             queue.add(temp.right);
        //         }
        //         size--;

        //     }

        //     res.add(tempList);

        // }

        // return res;


        // 方法二： DFS
        DFS(root, 0);
        return res;


    }
    List<List<Integer>> res = new ArrayList<>();

    public void DFS(TreeNode root,int  level){
        if(root == null){
            return;
        }
        
        if(res.size() == level){
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(root.val);

        DFS(root.left, level + 1);
        DFS(root.right, level + 1);

    }
}

    public List<List<Integer>> levelOrderAns(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        // while 循环控制从上向下一层层遍历
        while (!que.isEmpty()) {
            int sz = que.size();
            // 记录这一层的节点值
            List<Integer> level = new LinkedList<>();
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode cur = que.poll();
                level.add(cur.val);
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.builtTree(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(s.levelOrder(root));
    }
}
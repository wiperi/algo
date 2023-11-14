package Chap3_Search;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Integer val;
    public List<Node> children;

    public Node() {}

    public Node(Integer _val) {
        val = _val;
    }

    public Node(Integer _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    /************************************************************************
     * DFS
     ************************************************************************/
    @SuppressWarnings("unused")
    private static void dfsFrame(Node root) {
        if (root == null) return;
        // preorder position
        for (Node kid : root.children) {
            dfsFrame(kid);
        }
        // postorder postion
    }

    public static List<Integer> dfsPre(Node root) {
        List<Integer> res = new ArrayList<>();
        dfsPreAux(root, res);
        return res;
    }

    private static void dfsPreAux(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node kid : root.children) {
            dfsPreAux(kid, res);
        }
    }

    public static List<Integer> dfsPost(Node root) {
        List<Integer> res = new ArrayList<>();
        dfsPostAux(root, res);
        return res;
    }

    private static void dfsPostAux(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node kid : root.children) {
            dfsPostAux(kid, res);
        }
        res.add(root.val);
    }

}
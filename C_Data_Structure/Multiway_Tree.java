package C_Data_Structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class Multiway_Tree {

    public static class Node {
        public Integer val;
        public List<Node> children;

        public Node() {}

        public Node(Integer _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(Integer _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /************************************************************************
     * DFS
     ************************************************************************/

    // dfs frame of multi-way tree
    @SuppressWarnings("unused")
    private static void dfs(Node root) {
        if (root == null) return;
        // preorder position
        for (Node kid : root.children) { // there is no inorder position cause it can't be defined
            dfs(kid);
        }
        // postorder postion
    }

    /**
     * 
     * @param root
     * @return return the preorder traverse of given tree
     */
    public static List<Integer> dfsPreorder(Node root) {
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

    /**
     * 
     * @param root
     * @return return the postorder traverse of given tree
     */
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

    /************************************************************************
     * unit test
     ************************************************************************/

    public static void testDfsPreorder(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // Add children to the root node
        node1.children = new ArrayList<>();
        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);
        node1.children.add(node5);

        Assertions.assertEquals(dfsPreorder(node1), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println("test dfsPreorder() passed");
    }

    public static void main(String[] args) {
        testDfsPreorder(args);
    }
}

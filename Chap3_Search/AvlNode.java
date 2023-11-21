package Chap3_Search;

public class AvlNode {
    public int val;
    public int height;
    public AvlNode left, right;

    public AvlNode(int val, AvlNode left, AvlNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

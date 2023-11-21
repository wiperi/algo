package Chap3_Search;

public class _AVL_Tree {
    private AvlNode root;

    /************************************************************************
     * Public Methods
     ************************************************************************/

    public void insert(int key) {
        // Implementation here
    }

    public void delete(int key) {
        // Implementation here
    }

    public boolean contains(int key) {
        // Implementation here
    }

    public int findMin() {
        // Implementation here
    }

    public int findMax() {
        // Implementation here
    }

    /************************************************************************
     * Private Methods
     ************************************************************************/

    
    private int height(AvlNode node) { /* 获取节点高度 */
        // 空节点高度为 -1 ，叶节点高度为 0
        return node == null ? -1 : node.height;
    }

    
    private void updateHeight(AvlNode node) { /* 更新节点高度 */
        // 节点高度等于最高子树高度 + 1
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private AvlNode rotateRight(AvlNode dad) {
        AvlNode kid = root.left;
        AvlNode grandKid = kid.right;
        kid.right = dad;
        dad.left = grandKid;
        updateHeight(kid);
        updateHeight(dad);
        return kid;
    }

    private AvlNode rotateLeft(AvlNode x) {
        // Implementation here
    }

    private int getBalance(AvlNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private AvlNode insert(AvlNode node, int key) {
        // Implementation here
    }

    private AvlNode minValueNode(AvlNode node) {
        // Implementation here
    }

    private AvlNode deleteNode(AvlNode root, int key) {
        // Implementation here
    }
}
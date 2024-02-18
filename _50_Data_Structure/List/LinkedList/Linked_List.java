package _50_Data_Structure.List.LinkedList;
import edu.princeton.cs.algs4.Queue;

/**
 * Leetcode compatible version of Linked List.
 */
public class Linked_List {

    public Queue<ListNode> que = new Queue<ListNode>();
    public ListNode head;

    public Linked_List() {
        head = null;
    }

    /**
     * Create a linked list from a string of numbers separated by space.
     * 
     * @param s string of numbers separated by space
     */    
    public Linked_List(String s) {
        String[] tokens = s.split("\\s+");
        for (String string : tokens) {
            addBack(Integer.parseInt(string));
        }
    }

    /**
     * Create a linked list from an array.
     * 
     * @param a array of integers
     */
    public Linked_List(int[] a) {
        for (int i : a) {
            addBack((int) Integer.valueOf(i));
        }
    }

    /**
     * 
     * @return head of the linked list
     */
    public ListNode getHead() {
        return head;
    }

    /**
     * Add a node to the front of the linked list.
     * 
     * @param val
     */
    public void addFront(int val) {
        ListNode newNode = new ListNode(val, head);
        que.enqueue(newNode);
        head = newNode;
    }

    /**
     * Add a node to the back of the linked list.
     * 
     * @param val
     */
    public void addBack(int val) {
        ListNode newNode = new ListNode(val, null);
        que.enqueue(newNode);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    @Override
    public String toString() {
        ListNode cur = head;
        String s = "-> ";
        while (cur != null) {
            s += cur.val + " -> ";
            cur = cur.next;
        }
        s += cur;
        return s;
    }

    /**
     * Show all nodes that have been added to the linked list.
     */
    public void showAllNodes() {
        for (ListNode node : que) {
            System.out.println(node.val + "-> " + (node.next == null ? null : node.next.val));
        }
    }

    // unit testing
    public static void main(String[] args) {
        Linked_List l = new Linked_List("1 2 3 4 5");
        System.out.println(l);
        l.showAllNodes();
    }
}
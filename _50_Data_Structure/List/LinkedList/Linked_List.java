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
     * 由字符串构建链表
     * 
     * @param s 用于构建链表的字符串
     */
    public Linked_List(String s) {
        String[] tokens = s.split("\\s+");
        for (String string : tokens) {
            addBack(Integer.parseInt(string));
        }
    }

    /**
     * 由数组构建链表
     * 
     * @param a 用于构建链表的数组
     */
    public Linked_List(int[] a) {
        for (int i : a) {
            addBack((int) Integer.valueOf(i));
        }
    }

    public ListNode getHead() {
        return head;
    }

    public void addFront(int val) {
        ListNode newNode = new ListNode(val, head);
        que.enqueue(newNode);
        head = newNode;
    }

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

    public void print() {
        ListNode cur = head;
        System.out.print("-> ");
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.print(cur + "\n");
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

    public void showAllNodes() {
        for (ListNode node : que) {
            System.out.println(node.val + "-> " + (node.next == null ? null : node.next.val));
        }
    }

    public static void main(String[] args) {
        Linked_List l = new Linked_List("1 2 3 4 5");
        l.print();
        System.out.println(l);
        l.showAllNodes();
    }
}
import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

class ListNode {
    public Integer item;
    public ListNode next;

    public ListNode(Integer item, ListNode next) {
        this.item = item;
        this.next = next;
    }

}

public class Linked_List_Leet_Ver {

    public Queue<ListNode> q = new Queue<ListNode>();
    public ListNode head;

    public Linked_List_Leet_Ver() {
        head = null;
    }

    /**
     * 生成一条链表，当且仅当泛型参数为{@code String}的时候使用此构造函数，该函数接受一个字符串，读取其中每一个由空格分隔的元素生成一条链表
     * 
     * @param s 用于构建链表的字符串
     */
    public Linked_List_Leet_Ver(String s) {
        int[] nodes = new In(new Scanner(s)).readAllInts();
        for (int i : nodes) {
            addBackNode(i);
        }
    }

    public ListNode getHead() {
        return head;
    }

    public void addFrontNode(Integer item) {
        ListNode newNode = new ListNode(item, head);
        head = newNode;
    }

    public void addBackNode(int item) {
        ListNode newNode = new ListNode(item, null);
        q.enqueue(newNode);
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
            System.out.print(cur.item + " -> ");
            cur = cur.next;
        }
        System.out.print(cur + "\n");
    }

    @Override
    public String toString() {
        ListNode cur = head;
        String s = "-> ";
        while (cur != null) {
            s += cur.item.toString() + " -> ";
            cur = cur.next;
        }
        s += cur;
        return s;
    }

    public void printExisted() {
        for (ListNode node : q) {
            System.out.println(node.item + "-> " + (node.next == null ? null : node.next.item));
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
    }
}
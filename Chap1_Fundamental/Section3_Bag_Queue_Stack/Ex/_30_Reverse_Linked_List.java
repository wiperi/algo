package Chap1_Fundamental.Section3_Bag_Queue_Stack.Ex;

import Chap1_Fundamental.Section3_Bag_Queue_Stack._0_Linked_List_Tester;
import Chap1_Fundamental.Section3_Bag_Queue_Stack._0_Linked_List_Tester.Node;

/**
 * 1.3.30 编写一个函数，接受一条链表的首结点作为参数，（破坏性地）将链表反转并返回结果链表的
 * 首结点。
 */
public class _30_Reverse_Linked_List<Item> {

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        _0_Linked_List_Tester<String> l = new _0_Linked_List_Tester<>("1 2 3 4 5");

        l.print();
        l.head = reverseList(l.getHead());
        l.print();
    }
}

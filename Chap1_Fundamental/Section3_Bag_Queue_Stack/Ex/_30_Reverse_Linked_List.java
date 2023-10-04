package Chap1_Fundamental.Section3_Bag_Queue_Stack.Ex;

import Chap1_Fundamental.Section3_Bag_Queue_Stack.Linked_List;
import Chap1_Fundamental.Section3_Bag_Queue_Stack.Node;

/**
 * 1.3.30 编写一个函数，接受一条链表的首结点作为参数，（破坏性地）将链表反转并返回结果链表的
 * 首结点。
 */
public class _30_Reverse_Linked_List<Item> {

    public static <Item> Node<Item> reverseList(Node<Item> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Item> last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static <Item> Node<Item> reverseListLoop(Node<Item> head) {
        if (head == null || head.next == null) { // edge case
            return head;
        }

        Node<Item> first = null; //////// reverse将指向的目标
        Node<Item> reverse = head; ////// 需要被翻转元素
        Node<Item> second = head.next; // second用来判断是否需要翻转当前的reverse元素
        while (second != null) {
            reverse.next = first;

            first = reverse;
            reverse = second;
            second = second.next;
        }
        reverse.next = first;
        return reverse;
    }

    public static void main(String[] args) {
        Linked_List<String> l = new Linked_List<>("1 2 3 4 5");
        l.print();
        l.head = reverseList(l.getHead());
        l.print();
        Linked_List<String> l2 = new Linked_List<>("1 2 3 4 5");
        l2.print();
        l2.head = reverseListLoop(l2.getHead());
        l2.print();
    }
}

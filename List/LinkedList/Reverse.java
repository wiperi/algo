package List.LinkedList;

import org.junit.jupiter.api.Assertions;

public class Reverse {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode new_head = reverse(head.next);

        // change each node's next pointer to point to the previous node
        head.next.next = head;
        // make sure to set the next of the head node to null
        head.next = null;

        return new_head;
    }

    public static ListNode reverse_Iter(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        testReverse();
        System.out.println("passed");
    }

    static void testReverse() {
        Linked_List l = new Linked_List("1 2 3");
        l.head = reverse(l.head);
        Assertions.assertEquals("-> 3 -> 2 -> 1 -> null", l.toString());
    }

}

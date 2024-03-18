package List.LinkedList;

import org.junit.jupiter.api.Assertions;

public class CRUD {

    static ListNode delete(ListNode head, int val) {
        if (head == null) {
            throw new IllegalArgumentException("Node not in list.");
        } else if (head.val == val) {
            head = head.next;
        } else if (head.val == head.val) {
            head.next = delete(head.next, val);
        }
        return head;
    }

    static ListNode find(ListNode head, int val) {
        if (head == null || head.val == val) {
            return head;
        }

        return find(head.next, val);
    }

    static ListNode insert(ListNode head, int val) {
        if (head == null || head.val >= val) {
            return new ListNode(val, head);
        }

        head.next = insert(head.next, val);

        return head;
    }

    public static void main(String[] args) {
        testInsert();
        testFind();
        testDelete();
        System.out.println("passed");
    }

    static void testInsert() {
        Linked_List l = new Linked_List("1 3 4");
        l.head = insert(l.head, 2);
        Assertions.assertEquals("-> 1 -> 2 -> 3 -> 4 -> null", l.toString());
    }

    static void testFind() {
        Linked_List l = new Linked_List("1 2 3");
        ListNode node = find(l.head, 2);
        Assertions.assertEquals(2, node.val);
    }

    static void testDelete() {
        Linked_List l = new Linked_List("1 2 3");
        l.head = delete(l.head, 2);
        Assertions.assertEquals("-> 1 -> 3 -> null", l.toString());
    }
}

package List.LinkedList;

public class CRUD_On_LinkedList {
    
    static ListNode delete(ListNode head, int val) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        } else if (head.val == val) {
            head = head.next;
        } else if (head.val == head.val) {
            head.next = delete(head.next, val);
        }
        return head;
    }

    public static void main(String[] args) {
        Linked_List l = new Linked_List("1 2 3");
        l.head = delete(l.head, 2);
        System.out.println(l); // 1 -> 3
        l.head = delete(l.head, 1);
        System.out.println(l); // 3
    }
}

package List.LinkedList;

public class Remove_Duplicate {

    /**
     * Remove duplicates from an unsorted linked list
     * 
     * @param head
     */
    static void removeDuplicate(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Linked_List l = new Linked_List("1 2 3 3 2 1 4 1 2 3 4");
        removeDuplicate(l.head);
        System.out.println(l.toString());

    }
}
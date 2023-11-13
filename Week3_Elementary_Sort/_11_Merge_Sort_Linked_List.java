package Week3_Elementary_Sort;
import Chap1_Fundamental.Linked_List_Queue_Ver;
import Chap1_Fundamental.Node;

public class _11_Merge_Sort_Linked_List {

    public static Node<Integer> sortList(Node<Integer> head) {
        if (head == null || head.next == null) { // base case
            return head;
        }

        // divide
        Node<Integer> slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node<Integer> RList = slow.next;
        slow.next = null; // cut off

        Node<Integer> left = sortList(head);
        Node<Integer> right = sortList(RList);

        // merge
        Node<Integer> dummy = new Node<>(0, null);
        Node<Integer> cur = dummy;
        while (left != null && right != null) {
            if (left.item < right.item) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        Linked_List_Queue_Ver<Integer> l = new Linked_List_Queue_Ver<>(new int[] { 4, 3, 2, 1 });
        l.head = sortList(l.head);
        l.print();
    }
}
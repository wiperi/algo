package Sort.Merge_Sort;

public class _11_MG_Linked_List {

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    public static Node<Integer> sortList(Node<Integer> head) {

        if (head == null || head.next == null) { // base case
            return head;
        }

        // pre-order

        // 1. divide
        Node<Integer> slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node<Integer> right_side_list = slow.next;
        // cut the list to two halves
        slow.next = null;

        Node<Integer> left = sortList(head);
        Node<Integer> right = sortList(right_side_list);

        // post-order

        // 2. merge

        // merge left list and right list into a new dummy list in ascending order, then return it.
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
    }
}
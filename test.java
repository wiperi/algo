public class test {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;
        while (l1 != null || l2 != null) {

            int sum = (l1 == null) ? 0 : l1.val + (l2 == null ? 0 : l2.val);
            carry = sum / 10;
            if (cur != pre) {
                cur = new ListNode(sum % 10);
            } else {
                cur.val = sum % 10;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return cur;
    }
}

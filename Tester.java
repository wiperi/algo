import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class LinkedList {
    private ListNode head;

    LinkedList() {
        head = null;
    }

    // 增加节点
    public void addNode(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    // 修改节点
    public void updateNode(int index, int val) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            if (count == index) {
                curr.val = val;
                break;
            }
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            System.out.println("Index out of bounds.");
        }
    }

    // 删除节点
    public void deleteNode(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            ListNode prev = null;
            ListNode curr = head;
            int count = 0;
            while (curr != null) {
                if (count == index) {
                    prev.next = curr.next;
                    break;
                }
                prev = curr;
                curr = curr.next;
                count++;
            }
            if (curr == null) {
                System.out.println("Index out of bounds.");
            }
        }
    }

    // 查找节点
    public int searchNode(int val) {
        ListNode curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.val == val) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    // 打印链表
    public void printList() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}

public class Tester {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // 从数组生成链表
        int[] arr = {1, 2, 3};
        for (int num : arr) {
            list.addNode(num);
        }
        list.printList();

        // 从用户输入生成链表
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入以逗号分隔的整数序列：");
        String input = scanner.nextLine();
        String[] nums = input.split(",");
        for (String num : nums) {
            list.addNode(Integer.parseInt(num.trim()));
        }
        list.printList();

        scanner.close();
    }
}
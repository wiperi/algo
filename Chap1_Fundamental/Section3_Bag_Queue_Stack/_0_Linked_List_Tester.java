package Chap1_Fundamental.Section3_Bag_Queue_Stack;

public class _0_Linked_List_Tester<Item> {
    public Node head;

    public class Node {
        public Item item;
        public Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public _0_Linked_List_Tester() {
        head = null;
    }

    public _0_Linked_List_Tester(String s) {
        Item[] tokens = (Item[]) s.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            addBackNode(tokens[i]);
        }
    }

    public Node getHead() {
        return head;
    }

    public void addFrontNode(Item item) {
        Node newNode = new Node(item, head);
        head = newNode;
    }

    public void addBackNode(Item item) {
        Node newNode = new Node(item, null);
        if (head == null) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void print() {
        Node cur = head;
        System.out.print("-> ");
        while (cur != null) {
            System.out.print(cur.item + " -> ");
            cur = cur.next;
        }
        System.out.print(cur + "\n");
    }

    @Override
    public String toString() {
        Node cur = head;
        String s = "-> ";
        while (cur != null) {
            s += cur.item.toString() + " -> ";
            cur = cur.next;
        }
        s += cur;
        return s;
    }

    public static void main(String[] args) {
        _0_Linked_List_Tester<String> l = new _0_Linked_List_Tester<>("1 2 3 4 5");
        System.out.println(l);
    }
}
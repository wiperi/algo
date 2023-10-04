package Chap1_Fundamental.Section3_Bag_Queue_Stack;

public class Linked_List<Item> {
    public Node<Item> head;

    public Linked_List() {
        head = null;
    }

    public Linked_List(String s) {
        Item[] tokens = (Item[]) s.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            addBackNode(tokens[i]);
        }
    }

    public Node<Item> getHead() {
        return head;
    }

    public void addFrontNode(Item item) {
        Node<Item> newNode = new Node<Item>(item, head);
        head = newNode;
    }

    public void addBackNode(Item item) {
        Node<Item> newNode = new Node<Item>(item, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<Item> cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void print() {
        Node<Item> cur = head;
        System.out.print("-> ");
        while (cur != null) {
            System.out.print(cur.item + " -> ");
            cur = cur.next;
        }
        System.out.print(cur + "\n");
    }

    @Override
    public String toString() {
        Node<Item> cur = head;
        String s = "-> ";
        while (cur != null) {
            s += cur.item.toString() + " -> ";
            cur = cur.next;
        }
        s += cur;
        return s;
    }

    public static void main(String[] args) {
        Linked_List<String> l = new Linked_List<>("1 2 3 4 5");
        l.print();
        System.out.println(l);
    }
}
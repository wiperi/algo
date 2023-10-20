import edu.princeton.cs.algs4.Queue;

class Node<Item> {
    public Item item;
    public Node<Item> next;

    public Node(Item item, Node<Item> next) {
        this.item = item;
        this.next = next;
    }
}

public class Linked_List_Queue_Ver<Item> {

    public Queue<Node<Item>> q = new Queue<Node<Item>>();
    public Node<Item> head;

    public Linked_List_Queue_Ver() {
        head = null;
    }

    /**
     * 构建链表，当且仅当类型参数为{@code String}的情况下使用
     * 
     * @param s 用于构建链表的字符串
     */
    @SuppressWarnings("unchecked")
    public Linked_List_Queue_Ver(String s) {
        Item[] tokens = (Item[]) s.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            addBackNode(tokens[i]);
        }
    }

    /**
     * 构建链表，当且仅当类型参数为{@code Integer}的情况下使用
     * 
     * @param a 用于构建链表的数组
     */
    @SuppressWarnings("unchecked")
    public Linked_List_Queue_Ver(int[] a) {
        for (int i : a) {
            addBackNode((Item) Integer.valueOf(i));
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
        q.enqueue(newNode);
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

    public void printExisted() {
        for (Node<Item> node : q) {
            System.out.println(node.item + "-> " + (node.next == null ? null : node.next.item));
        }
    }

    public static void main(String[] args) {
        Linked_List_Queue_Ver<String> l = new Linked_List_Queue_Ver<>("1 2 3 4 5");
        l.print();
        System.out.println(l);

        Node<String> cur = l.getHead();
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
        for (Node<String> node : l.q) {
            System.out.println(node.item + "-> " + (node.next == null ? null : node.next.item));
        }
    }
}
package Chap1_Fundamental;

public class Linked_List_Raw_Ver<Item> {
    public Node<Item> head;

    public Linked_List_Raw_Ver() {
        head = null;
    }

    /**
     * 当且仅当泛型参数为{@code String}的时候可以使用此构造函数，该函数接受一个字符串，读取其中每一个由空格分隔的元素，生成一条链表
     * 
     * @param s 用于构建链表的字符串
     */
    @SuppressWarnings("unchecked")
    public Linked_List_Raw_Ver(String s) {
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
        Linked_List_Raw_Ver<String> l = new Linked_List_Raw_Ver<>("1 2 3 4 5");
        l.print();
        System.out.println(l);
    }
}
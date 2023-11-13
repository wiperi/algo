package Chap1_Fundamental;

public class Node<Item> {
    public Item item;
    public Node<Item> next;

    public Node(Item item, Node<Item> next) {
        this.item = item;
        this.next = next;
    }
}
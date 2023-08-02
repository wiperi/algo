package Week2_StackssAndQueques.Programming_Task_Deque;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items; // array to store items
    private int size; // number of items in randomized queue

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot enqueue null item");
        }
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Randomized queue is empty");
        }
        int index = StdRandom.uniformInt(size);
        Item item = items[index];
        items[index] = items[--size];
        items[size] = null;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Randomized queue is empty");
        }
        int index = StdRandom.uniformInt(size);
        return items[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // inner class that implements the iterator interface
    private class RandomizedQueueIterator implements Iterator<Item> {
        private int current;
        private Item[] shuffledItems;

        public RandomizedQueueIterator() {
            current = 0;
            shuffledItems = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                shuffledItems[i] = items[i];
            }
            StdRandom.shuffle(shuffledItems);
        }

        public boolean hasNext() {
            return current < size;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items to return");
            }
            return shuffledItems[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported");
        }
    }

    // helper method to resize the array
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    // unit testing
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        for (int i : rq) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(rq.dequeue());
        System.out.println(rq.sample());
        for (int i : rq) {
            System.out.print(i + " ");
        }
    }
}
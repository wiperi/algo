package Chap2_Sort.Section4_Priority_Queue;

public interface _1_PQ_Interface<Key extends Comparable<Key>> {
    public int size();

    public boolean isEmpty();

    public void insert(Key v);

    public Key delMax();

}

package io.gimo.datastructure.list;

public class LinkedList<E> implements List<E> {

    private Node head;
    private int size;

    private class Node {
        public E e;
        public Node next;

        public Node() {
        }

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void add(E e, int index) {

    }

    @Override
    public void remove(E e) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int find(E e) {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }
}

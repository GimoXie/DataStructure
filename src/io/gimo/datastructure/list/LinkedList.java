package io.gimo.datastructure.list;

public class LinkedList<E> implements List<E> {

    private Node dummyHead;
    private int size;

    private class Node {
        public E e;
        public Node next;

        public Node() {
        }

        public Node(E e) {
            this.e = e;
        }

        public Node(Node next) {
            this.next = next;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = new Node(e, cur.next);
        size++;
    }

    @Override
    public void remove(E e) {
        Node cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.e.equals(e)) {
                break;
            }
            cur = cur.next;
        }
        if (cur.next != null) {
            Node target = cur.next;
            cur.next = target.next;
            target.next = null;
            size--;
        }
    }

    @Override
    public void remove(int index) {
        if (index <0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size.");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node target = cur.next;
        cur.next = target.next;
        target.next = null;
        size --;
    }

    @Override
    public int find(E e) {
        Node cur = dummyHead;
        for (int i = 0 ; i < size ; i++) {
            if (cur.next != null) {
                cur = cur.next;
                if (cur.e.equals(e)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if (index <0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size.");
        }
        Node cur = dummyHead;
        for (int i = 0 ; i <= index ; i ++) {
            cur = cur.next;
        }
        return cur.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList: size = %d\n", size));
        res.append('[');
        Node prev = dummyHead;
        for (int i = 0; i < size; i++) {
            prev = prev.next;
            res.append(prev);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.add(3,3);
        list.add(4,4);
        list.add(5,5);
        list.add(6,6);
        System.out.println(list.find(6));
        System.out.println(list.get(3));
    }
}

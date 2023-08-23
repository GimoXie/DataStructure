package io.gimo.datastructure.list;

public class LinkedList<E> implements List<E> {

    private final Node dummyHead;
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

    /*public Node recursiveRemove(Node head, E e) {
        if (head == null) {
            return null;
        }
        head.next = recursiveRemove(head.next, e);
        return head.e.equals(e) ? head.next : head;
    }*/

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size.");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node target = cur.next;
        cur.next = target.next;
        target.next = null;
        size--;
    }

    @Override
    public int find(E e) {
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
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
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size.");
        }
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
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
            res.append(prev.e);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    // 迭代法反转
    public void reverse() {
        Node prev = null, next;
        Node cur = dummyHead.next;
        while (cur != null) {
            // 暂存后续节点信息
            next = cur.next;
            // 将当前节点的后继反转
            cur.next = prev;
            // 移动prev指针
            prev = cur;
            // 移动cur指针
            cur = next;
        }
        dummyHead.next = prev;
    }

    public void recursiveReverse() {
        dummyHead.next = reverse(dummyHead.next);
    }

    public Node reverse(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        // 暂存后续节点信息
        Node next = head.next;
        // 反转自链表
        Node newHead = reverse(next);
        // 将当前节点的后继反转
        next.next = head;
        // 切断原先的指针
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 2);
        list.add(3, 3);
        list.add(4, 4);
        list.add(5, 5);
        list.add(6, 6);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        list.recursiveReverse();
        System.out.println(list);
    }
}

package io.gimo.datastructure.heap;

import io.gimo.datastructure.array.Array;

import java.util.Arrays;

public class Heap<E extends Comparable<E>> {

    private final Array<E> data;

    public Heap() {
        this.data = new Array<>();
    }

    public Heap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public Heap(E[] elements) {
        this.data = new Array<>(elements.length);

        for (E ele : elements) {
            this.data.addLast(ele);
        }

        for (int i = parent(this.data.getSize()); i >= 0; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return this.data.getSize();
    }

    public boolean isEmpty() {
        return this.data.getSize() == 0;
    }

    public void insert(E ele) {
        data.addLast(ele);
        shiftUp(data.getSize() - 1);
    }

    public E extract() {
        E element = data.get(0);
        data.swap(data.getSize() - 1, 0);
        data.removeLast();
        shiftDown(0);
        return element;
    }

    private void shiftDown(int index) {
        // 如果有左孩子 进行循环
        while (index * 2 + 1 <= data.getSize() - 1) {
            int child = 2 * index + 1;
            if (child + 1 <= data.getSize() - 1 && data.get(child + 1).compareTo(data.get(child)) > 0) {
                child += 1;
            }
            if (data.get(index).compareTo(data.get(child)) >= 0) {
                break;
            }
            data.swap(index, child);
            index = child;
        }
    }

    private void shiftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        if (index <= 0) {
            return 0;
        }
        return index / 2 - (index % 2 != 0 ? 0 : 1);
    }

    private boolean isHeap(int index) {
        // 左孩子索引
        int left = 2 * index + 1;
        // 右孩子索引
        int right = left + 1;

        // 当前节点小于左孩子
        if (left <= data.getSize() - 1 && data.get(index).compareTo(data.get(left)) < 0) {
            return false;
        }

        // 当前节点小于右孩子
        if (right <= data.getSize() - 1 && data.get(index).compareTo(data.get(right)) < 0) {
            return false;
        }

        // 判断左子树是否为堆
        boolean leftIsHeap = true;
        if (left <= data.getSize() - 1) {
            leftIsHeap = isHeap(left);
        }

        // 判断右子树是否为堆
        boolean rightIsHeap = true;
        if (right <= data.getSize() - 1) {
            rightIsHeap = isHeap(right);
        }

        // 左右子树都是堆，整棵树才是堆
        return leftIsHeap && rightIsHeap;
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        Integer[] sample = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : sample) {
            heap.insert(i);
        }
        heap.insert(99);
        System.out.println(heap.extract());
        System.out.println(heap.isHeap(0));
    }

}

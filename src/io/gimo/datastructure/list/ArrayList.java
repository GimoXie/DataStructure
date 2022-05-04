package io.gimo.datastructure.list;

import io.gimo.datastructure.array.Array;

public class ArrayList<E> implements List<E> {

    private final Array<E> array;

    public ArrayList(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void add(E e, int index) {
        array.add(e, index);
    }

    @Override
    public void remove(E e) {
        array.remove(e);
    }

    @Override
    public void remove(int index) {
        array.remove(index);
    }

    @Override
    public int find(E e) {
        return array.find(e);
    }

    @Override
    public E get(int index) {
        return array.get(index);
    }
}

package io.gimo.datastructure.stack;

import io.gimo.datastructure.array.Array;

/**
 * Created by zmxie on 2019/1/3.
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.getSize() == 0;
    }

    @Override
    public void push(E element) {
        data.addLast(element);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }
}

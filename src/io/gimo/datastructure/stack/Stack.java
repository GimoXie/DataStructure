package io.gimo.datastructure.stack;

/**
 * Created by gimo on 2019/1/3.
 */
public interface Stack<E> {
    /**
     * 获取当前栈的大小
     */
    int getSize();

    /**
     * 判断栈是否为空
     */
    boolean isEmpty();

    /**
     * 将元素压入栈顶
     */
    void push(E element);

    /**
     * 弹出栈顶元素
     */
    E pop();

    /**
     * 获取栈顶元素
     */
    E peek();
}

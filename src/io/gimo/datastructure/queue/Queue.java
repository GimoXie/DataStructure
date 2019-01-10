package io.gimo.datastructure.queue;

public interface Queue<E> {

    /**
     * 获取队列大小
     */
    int getSize();

    /**
     * 判断队列是否为空
     */
    boolean isEmpty();

    /**
     * 入队
     */
    void enqueue(E e);

    /**
     * 出队
     */
    E dequeue();

    /**
     * 获取队首元素
     */
    E getFront();
}

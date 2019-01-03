package io.gimo.datastructure.array;

/**
 * Created by zmxie on 2019/1/3.
 */
public class Array<E> {
    // 实际存储数据的数组
    private E[] data;
    // 数组当前大小(指针位置)
    private int size;

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 构造函数，传入数组的容量capacity构造Array
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 获取数组当前的大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容积
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 往指定位置插入元素
     *
     * @param index   插入的位置(以0开始)
     * @param element 插入的元素
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        // 指针越界 触发扩容
        if (index == size) {
            resize(size * 2);
        }
        // 从 size-1 开始 每个元素向后移动一个位置
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /**
     * 在第一个元素前插入元素
     *
     * @param element 插入的元素
     */
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * 在最后一个元素后插入元素
     *
     * @param element 插入的元素
     */
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * 删除指定位置的元素 并返回之
     *
     * @param index 待删除的位置
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index <= size.");
        }
        E element = data[index];
        // 从 index+1 开始 每个元素向前移动一个位置
        System.arraycopy(data, index + 1, data, index + 1 - 1, size - (index + 1));
        size--;
        data[size] = null;

        // 如果当前数组大小为容积的1/4，并且容积大于1
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return element;
    }

    /**
     * 删除第一个元素 并返回之
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素 并返回之
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素
     *
     * @param element 待删除的元素
     */
    public void remove(E element) {
        int index = find(element);
        if (index == -1) {
            throw new IllegalArgumentException("Remove failed. Element is not exist.");
        }
        remove(index);
    }

    /**
     * 修改指定索引的元素
     *
     * @param index   元素的位置(以0开始)
     * @param element 修改的值
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index <= size.");
        }
        data[index] = element;
    }

    /**
     * 获取指定位置的数据
     *
     * @param index 元素的位置(以0开始)
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index <= size.");
        }
        return data[index];
    }

    /**
     * 获取第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素
     */
    public E getLast() {
        return get(getSize() - 1);
    }

    /**
     * 查询指定元素所在的位置
     *
     * @param element 查找的元素
     */
    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 调整数组容积
     *
     * @param capacity 容积
     */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        System.arraycopy(data, 0, temp, 0, size);
        data = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}

package io.gimo.datastructure.list;

public interface List<E> {

    /**
     * 获取列表当前大小
     * @return 当前列表元素个数
     */
    int getSize();

    /**
     * 判断列表是否为空
     * @return size为0时返回true
     */
    boolean isEmpty();

    /**
     * 向列表中添加元素
     *
     * @param e     待插入元素
     * @param index 下标从0开始计算
     */
    void add(E e, int index);

    /**
     * 删除列表中的指定元素
     *
     * @param e 待删除的元素
     */
    void remove(E e);

    /**
     * 删除列表总指定位置的元素
     *
     * @param index 下标从0开始计算
     */
    void remove(int index);

    /**
     * 查找指定元素在列表中的位置
     *
     * @param e 待查找的元素
     * @return 若不存在，返回-1
     */
    int find(E e);

    /**
     * 获取指定位置元素
     * @param index 下标从0开始计算
     * @return 若不存在，返回null
     */
    E get(int index);
}

package io.gimo.datastructure.array;

/**
 * Created by gimo on 2019/1/4.
 */
public class Client {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 100; i ++) {
            array.addLast(i);
        }
        System.out.println(array);
    }
}

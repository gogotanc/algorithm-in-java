package org.tanc.algorithm.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class DynamicSortArrayTest {

    @Test
    public void add() {
        DynamicSortArray<Integer> array = new DynamicSortArray<>(2);
        array.add(123);
        array.add(283);
        array.add(100);
        array.add(123);
        array.add(283);
        array.add(100);
        array.add(123);
        array.add(283);
        array.add(100);
        System.out.println(array);
    }

    @Test
    public void delete() {
        DynamicSortArray<Integer> array = new DynamicSortArray<>();
        array.add(123);
        array.add(283);
        array.add(100);
        Integer result = array.delete(123);
        System.out.println(result);
    }

    @Test
    public void get() {
        DynamicSortArray<Integer> array = new DynamicSortArray<>();
        array.add(123);
        array.add(283);
        array.add(100);
        System.out.println(array);
    }
}
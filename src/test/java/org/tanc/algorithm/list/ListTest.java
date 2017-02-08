package org.tanc.algorithm.list;

import org.junit.Test;
import org.tanc.algorithm.list.impl.ArrayListImpl;
import org.tanc.algorithm.list.impl.LinkListImpl;

import static org.junit.Assert.*;

/**
 * 列表测试类
 */
public class ListTest {

    @Test
    public void arrayListTest() throws Exception {
        BaseList<Integer> list = new ArrayListImpl<>();
        list.add(3);
        list.add(5);
        list.set(1, 4);
        list.add(5);
        // list -> 3,4,5
        assertEquals(true, list.contains(4));
        assertEquals(3, list.size());
        assertEquals(5, list.get(2).intValue());
        assertEquals(4, list.get(1).intValue());
        assertEquals(true, list.contains(5));
        assertEquals(false, list.contains(2));
        list.remove(2);
        // list -> 3,4
        assertEquals(2, list.size());
        assertEquals(3, list.get(0).intValue());
        assertEquals(true, list.contains(3));
        assertEquals(false, list.contains(5));
        list.remove(0);
        // list -> 4
        assertEquals(1, list.size());
    }

    @Test
    public void updateArraySize() {
        ArrayListImpl<Integer> list = new ArrayListImpl<>();
        list.add(0);
        list.add(1);
        // list 中数组实际长度为 2
        list.add(2);
        list.add(3);
        // list 中数组实际长度为 4
        list.add(4);
        // list 中数组实际长度为 8
        assertEquals(5, list.size());
    }

    @Test
    public void linkList() {
        BaseList<Integer> list = new LinkListImpl<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(0, list.get(1).intValue());
        list.set(1, 1);
        list.set(1, 2);
        assertEquals(1, list.get(2).intValue());
    }
}
package org.tanc.algorithm.heap;

import org.junit.Test;
import org.tanc.algorithm.heap.impl.BinaryHeapArrayImpl;

import static org.junit.Assert.*;

/**
 * 堆测试
 * Created by tanc on 2017/2/14.
 */
public class BaseHeapTest {

    @Test
    public void insert() throws Exception {
        BaseHeap<Integer> heap = new BinaryHeapArrayImpl<>();
        heap.insert(3);
        heap.insert(2);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        heap.printHeap();
        assertEquals(1, heap.deleteMin().intValue());
    }

}
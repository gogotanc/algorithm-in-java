package org.tanc.algorithm.heap;

import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.tanc.algorithm.heap.impl.BinaryHeapArrayImpl;
import org.tanc.algorithm.heap.impl.BinomialQueue;

import static org.junit.Assert.*;

/**
 * 堆测试
 * Created by tanc on 2017/2/14.
 */
public class BaseHeapTest {

    @Test
    public void heap() throws Exception {
        BaseHeap<Integer> heap = new BinaryHeapArrayImpl<>();
        heap.insert(3);
        heap.insert(2);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        heap.printHeap();
        assertEquals(1, heap.deleteMin().intValue());
    }

    @Test
    public void binomialQueue() throws Exception {
        BaseHeap<Integer> heap = new BinomialQueue<>();
        heap.insert(3);
        heap.insert(2);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);
        heap.insert(10);
        heap.insert(11);
        heap.insert(12);
        heap.insert(13);
        heap.printHeap();
        System.out.println("-------------------------------");
        assertEquals(1, heap.deleteMin().intValue());
        heap.printHeap();
        System.out.println("-------------------------------");
        assertEquals(2, heap.deleteMin().intValue());
        heap.printHeap();
        System.out.println("-------------------------------");
    }

}
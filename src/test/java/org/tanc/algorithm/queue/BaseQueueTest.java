package org.tanc.algorithm.queue;

import org.junit.Test;
import org.tanc.algorithm.queue.impl.ArrayQueueImpl;
import org.tanc.algorithm.queue.impl.LinkedQueueImpl;

import static org.junit.Assert.*;

/**
 * 队列测试
 * Created by tanc on 2017/2/9.
 */
public class BaseQueueTest {

    @Test
    public void linkedQueue() throws Exception {
        BaseQueue<Integer> queue = new LinkedQueueImpl<>();
        testCase(queue);
    }

    @Test
    public void arrayQueue() throws Exception {
        BaseQueue<Integer> queue = new ArrayQueueImpl<>();
        testCase(queue);
    }

    private void testCase(BaseQueue<Integer> queue) {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        assertEquals(4, queue.size());
        assertEquals(1, queue.pop().intValue());
        assertEquals(2, queue.pop().intValue());
        assertEquals(3, queue.pop().intValue());
        assertEquals(1, queue.size());
    }
}
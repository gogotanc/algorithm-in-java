package org.tanc.algorithm.stack;

import org.junit.Test;
import org.tanc.algorithm.stack.impl.ArrayStackImpl;
import org.tanc.algorithm.stack.impl.LinkedStackImpl;

import static org.junit.Assert.*;

/**
 * 栈测试
 * Created by tanc on 2017/2/9.
 */
public class BaseStackTest {

    @Test
    public void linkedStack() throws Exception {
        BaseStack<Integer> stack = new LinkedStackImpl<>();
        testCase(stack);
    }

    @Test
    public void arrayStack() throws Exception {
        BaseStack<Integer> stack = new ArrayStackImpl<>();
        testCase(stack);
    }

    private void testCase(BaseStack<Integer> stack) {
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        assertEquals(11, stack.size());
        assertEquals(10, stack.top().intValue());
        assertEquals(11, stack.size());
        stack.pop();
        assertEquals(10, stack.size());
    }
}
package org.tanc.algorithm.stack;

import org.junit.Test;
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
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(0);
        assertEquals(4, stack.size());
        assertEquals(0, stack.top().intValue());
        assertEquals(4, stack.size());
        stack.pop();
        assertEquals(3, stack.size());
    }

}
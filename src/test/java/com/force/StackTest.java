package com.force;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void testStack() {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        stack.push("a");
        stack.push("a");
        stack.push("a");
        stack.push("a");
        Assertions.assertEquals(4, stack.size());
        Assertions.assertFalse(stack.empty());
        Assertions.assertEquals("a", stack.pop());
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    public void testNodeStack() {
        NodeStack<String> stack = new NodeStack<String>();
        stack.push("h");
        stack.push("e");
        stack.push("l");
        Assertions.assertEquals(3, stack.size());
        Assertions.assertEquals("l", stack.pop());
    }

    @Test
    public void testQueue() {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("ha");
        queue.enqueue("he");
        Assertions.assertEquals(2, queue.size());
        Assertions.assertEquals("ha", queue.dequeue());
        Assertions.assertEquals("he", queue.dequeue());
        Assertions.assertEquals(0, queue.size());
        Assertions.assertNull(queue.dequeue());
    }
}

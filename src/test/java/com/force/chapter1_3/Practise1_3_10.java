package com.force.chapter1_3;

import com.force.Node;
import com.force.NodeStack;
import com.force.Queue;
import com.force.ResizingArrayStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 编写一个程序,将中序表达式转换为后序表达式
 */
public class Practise1_3_10 {

    public String inFixToPostFix(String s) {
        Queue<Character> queue = new Queue<Character>();
        ResizingArrayStack<Character> stack = new ResizingArrayStack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case '+':
                case '-':
                    while (!stack.empty() && !stack.peek().equals('(')) {
                        queue.enqueue(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '*':
                case '/':
                    while (!stack.empty() && (stack.peek().equals('/') || stack.peek().equals('*'))) {
                        queue.enqueue(stack.pop());
                    }
                    stack.push(c);
                    break;
                case ')':
                    while (stack.peek() != '(') {
                        queue.enqueue(stack.pop());
                    }
                    stack.pop();
                    break;
                case ' ':
                    break;
                default:
                    queue.enqueue(c);
                    break;
            }
        }
        while (!stack.empty()) {
            queue.enqueue(stack.pop());
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.empty()) {
            builder.append(queue.dequeue());
        }
        return builder.toString();
    }

    @Test
    public void testInFixToPostFix() {
        String s = inFixToPostFix("2 + 4 * 5");
        System.out.println(s);
        Assertions.assertEquals("245*+", s);
        System.out.println(inFixToPostFix("(3 + 4) * 3"));
    }

    /**
     * 1.3.11 编写一段程序 EvaluatePostfix, 从标准输入中得到一个后序表达式, 求值并打印结果.
     * @param s 后续表达式
     * @return 表达式结果
     */
    private int evaluatePostfix(String s) {
        NodeStack<Integer> stack = new NodeStack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int a, b;
            switch (c) {
                case ' ':
                    break;
                case '+':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case '-':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case '*':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case '/':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Character.getNumericValue(c));
                    break;
            }
        }
        return stack.pop();
    }

    @Test
    public void testEvaluatePostfix() {
        String s = inFixToPostFix("2 + 4 * 5");
        int i = evaluatePostfix(s);
        System.out.println(i);
    }

    /**
     * 1.3.19 给出一段代码, 删除链表的尾节点, 其中链表的首结点为 first.
     */
    public void practise_1_3_19(Node<String> first) {
        if (first == null) return;
        while (first != null) {
            Node<String> next = first.next;
            if (next.next == null) {
                System.out.println(next.item);
                first.next = null;
                break;
            }
            first = next;
        }
    }

    @Test
    public void test1_3_19() {
        Node<String> first = new Node<String>();
        first.item = "a";
        Node<String> node2 = new Node<String>();
        node2.item = "b";
        first.next = node2;
        Node<String> node3 = new Node<String>();
        node3.item = "c";
        node2.next = node3;
        practise_1_3_19(first);
        while (first != null) {
            System.out.println(first.item);
            first = first.next;
        }
    }
}

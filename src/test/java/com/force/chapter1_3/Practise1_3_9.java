package com.force.chapter1_3;

import com.force.NodeStack;
import org.junit.jupiter.api.Test;

/**
 * 从标准输入中得到一个缺少左括号的表达式, 打印出补全后的表达式.
 */
public class Practise1_3_9 {

    public void complete(String s) {
        NodeStack<String> stack = new NodeStack<String>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == ')') {
                StringBuilder builder = new StringBuilder("(");
                builder.append(" ");
                String b = stack.pop();
                String op = stack.pop();
                String a = stack.pop();
                builder.append(a).append(" ")
                        .append(op).append(" ")
                        .append(b).append(" ")
                        .append(c).append(" ");
                stack.push(builder.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }
        System.out.println(stack.pop());
    }

    @Test
    public void testComplete() {
        complete("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
    }
}

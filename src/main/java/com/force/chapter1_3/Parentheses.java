package com.force.chapter1_3;

import com.force.NodeStack;

/**
 * 编写一个 Stack 的用例,  从标准输入中读取一个文本流并使用栈判断其中的括号是否匹配完整.
 */
public class Parentheses {

    public boolean check(String s) {
        NodeStack<Character> stack = new NodeStack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case ']':
                    if (stack.pop() == '[') {
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if ('{' != stack.pop())
                        return false;
                    break;
                case ')':
                    if ('(' != stack.pop())
                        return false;
                    break;
                default:
                    break;
            }
        }
        return stack.empty();
    }
}

package com.force.chapter1_3;

import com.force.Node;

/**
 * 前移编码. 从标准输入中读取一串字符, 使用链表保存这些字符并清楚重复字符, 当你读取了一个从未见过的字符时,
 * 将它插入表头. 当你读取了一个重复字符时, 将它从链表中删除并重新插入表头. 它实现了著名的前移编码策略, 这
 * 种策略假设最近访问过的元素很可能再次访问, 因此可以用于缓存, 数据压缩等许多场景.
 */
public class Practise_1_3_40 {

    private Node<Character> head;

    private void findAndDelete(Character c) {
        if (head == null) {
            return;
        }

        if (head.item == c) {
            head = head.next;
            return;
        }
        Node<Character> node = head;
        while (node != null) {
            if (node.next != null && node.next.item == c) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
    }

    private void moveToHead(Character c) {
        Node<Character> node = new Node<Character>();
        node.item = c;
        node.next = head;
        head = node;
    }

    public String handle(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            findAndDelete(c);
            moveToHead(c);
        }
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.item);
            head = head.next;
        }
        return builder.toString();
    }
}

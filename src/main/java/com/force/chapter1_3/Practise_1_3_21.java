package com.force.chapter1_3;

import com.force.Node;

/**
 * 编写一个方法 find(), 接受一条链表和一个字符串 key 作为参数. 如果链表中某个
 * 节点的 item 的值为 key, 则方法返回 true, 否则返回 false.
 */
public class Practise_1_3_21 {

    public static boolean find(Node<String> head, String key) {
        while (head != null) {
            if (head.item.equals(key)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

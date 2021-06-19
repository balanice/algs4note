package com.force.chapter1_3;

import com.force.Node;

import java.util.Arrays;

/**
 * 编写一个方法 delete(), 接受一个 int 参数 k, 删除链表的第 k 个元素(如果它有的话)
 */
public class Practise_1_3_20 {

    public static <T> void delete(Node<T> node, int k) {
        int i = 1;
        while (node != null) {
            if (i == k - 1) {
                if (node.next != null)
                    node.next = node.next.next;
                break;
            }
            node = node.next;
            i++;
        }
    }
}

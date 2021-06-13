package com.force;

import java.util.Iterator;

/**
 * 链表实现队列
 */
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int length;

    public boolean empty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (empty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        length++;
    }

    public int size() {
        return length;
    }

    public Item dequeue() {
        if (empty()) {
            return null;
        }
        Item i = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        }
        length--;
        return i;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        private Node<Item> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
        }
    }
}

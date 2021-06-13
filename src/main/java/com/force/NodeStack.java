package com.force;

import java.util.Iterator;

public class NodeStack<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int length;

    public boolean empty() {
        return first == null;
    }

    public int size() {
        return length;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        length++;
    }

    public Item pop() {
        if (empty()) return null;
        Item item = first.item;
        first = first.next;
        length--;
        return item;
    }

    public Item peek() {
        if (empty()) return null;
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<Item> {
        private Node<Item> n = first;

        public boolean hasNext() {
            return n != null;
        }

        public Item next() {
            Item i = n.item;
            n = n.next;
            return i;
        }

        public void remove() {
        }
    }

    private static class Node<Item> {
        public Item item;
        public Node<Item> next;
    }

    public static <T> NodeStack<T> copy(NodeStack<T> stack) {
        NodeStack<T> nodeStack = new NodeStack<T>();
        for (T t : stack) {
            nodeStack.push(t);
        }
        return nodeStack;
    }
}

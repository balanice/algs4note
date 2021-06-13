package com.force;

import java.util.Iterator;

/**
 * 下压堆栈, 数组实现.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] arr = (Item[]) new Object[16];
    private int length;

    public int size() {
        return length;
    }

    public boolean empty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == arr.length;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(arr, 0, temp, 0, length);
        arr = temp;
    }

    public void push(Item item) {
        if (length == arr.length) {
            resize(arr.length * 2);
        }
        arr[length++] = item;
    }

    public Item pop() {
        if (empty()) return null;
        Item i = arr[--length];
        arr[length] = null;
        if (length > 0 && length == arr.length / 4) {
            resize(arr.length / 2);
        }
        return i;
    }

    public Item peek() {
        if (empty()) return null;
        return arr[length - 1];
    }

    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<Item> {
        private int i = length;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return arr[--i];
        }

        public void remove() {
        }
    }
}

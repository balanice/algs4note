package com.force;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

// 二叉查找树递归实现
public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private int N;
        private Node left, right;
        private Key key;
        private Value value;
        private int height;

        public Node(Key key, Value value, int N, int height) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.height = height;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;
        return root.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, 1, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height1(node.left), height1(node.right)) + 1;
        return node;
    }

    // 最小的键
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    // 最大的键
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null)
            return node;
        return max(node.right);
    }

    // 排行位 k 的键
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if (node == null)
            return null;
        int t = size(node.left);
        if (t > k)
            return select(node.left, k);
        else if (t < k)
            return select(node.right, k - t - 1);
        else
            return node;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    // 返回以 node 位根节点的树中小于 key 的键的数量
    private int rank(Node node, Key key) {
        if (node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(node.left, key);
        else if (cmp > 0)
            return 1 + size(node.left) + rank(node.right, key);
        else
            return size(node.left);
    }

    // 删除键最小的节点
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height1(node.left), height1(node.right)) + 1;
        return node;
    }

    // 删除键最大的节点
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null)
            return node.left;
        node.right = deleteMax(node.right);
        node.N = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height1(node.left), height1(node.right)) + 1;
        return node;
    }

    // 删除指定键的节点, 由被删除节点右子树的最小节点进行补位, 这样需要删除右子树的最小节点
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
            node.N = size(node.right) + size(node.left) + 1;
            node.height = Math.max(height1(node.right), height1(node.left)) + 1;
        }
        return node;
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node == null)
            return;
        print(node.left);
        StdOut.println(node.key + ": " + node.value);
        print(node.right);
    }

    // 查找树中所有的 Key
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    // 根据范围查找所有的 Key
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
        if (node == null)
            return;
        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);
        if (cmplo < 0)
            keys(node.left, queue, lo, hi);
        if (cmphi > 0)
            keys(node.right, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(node.key);
        }
    }

    // 递归计算树的高度
    public int height0() {
        return height0(root);
    }

    private int height0(Node node) {
        if (node == null)
            return 0;
        int heightLeft = height0(node.left);
        int heightRight = height0(node.right);
        return Math.max(heightLeft, heightRight) + 1;
    }

    // 根据添加属性的方法获取树的高度
    public int height1() {
        return height1(root);
    }

    private int height1(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }
}

package com.force;

/**
 * 而叉查找树的非递归实现
 */
public class BST1<Key extends Comparable<Key>, Value> {

    private class Node {
        private int N;
        private Node left, right;
        private Key key;
        private Value value;
        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private Node root;

    public Value get(Key key) {
        Node node = getNode(key);
        if (node == null)
            return null;
        else
            return node.value;
    }

    // 根据 key 查找节点
    private Node getNode(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }
        return null;
    }

    public void put(Key key, Value value) {
        Node node = new Node(key, value, 1);
        if (root == null) {
            root = node;
            return;
        }

        Node parent = root;
        Node x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else {
                x.value = value;
                return;
            }
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            parent.left = node;
        else
            parent.right = node;
    }
}

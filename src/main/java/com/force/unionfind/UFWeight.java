package com.force.unionfind;

/**
 * 加权 quick-union.
 */
public class UFWeight extends UF {
    public UFWeight(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];  // 更新最短路径
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
}

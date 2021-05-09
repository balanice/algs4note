package com.force.unionfind;

/**
 * quick union.
 */
public class UF2 extends UF {

    public UF2(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        id[pRoot] = qRoot;
        count--;
    }
}

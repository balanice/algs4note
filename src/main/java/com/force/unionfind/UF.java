package com.force.unionfind;

public abstract class UF {
    protected int[] id;
    protected int count;
    protected int[] size;

    public UF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }
    }

    public abstract int find(int p);
    public abstract void union(int p, int q);

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public void toIDString() {
        for (int i: id) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}

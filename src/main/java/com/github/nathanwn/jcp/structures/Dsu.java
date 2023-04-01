package com.github.nathanwn.jcp.structures;

public class Dsu {
    private int[] parent;
    private int[] depth;

    public Dsu(int n) {
        parent = new int[n];
        depth = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            depth[i] = 0;
        }
    }

    public int find(int u) {
        while (u != parent[u]) {
            u = parent[u];
        }
        return u;
    }

    public boolean merge(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return false;
        }
        if (depth[u] > depth[v]) {
            parent[v] = u;
        } else if (depth[u] < depth[v]) {
            parent[u] = v;
        } else { // depth[u] == depth[v]
            parent[u] = v;
            depth[v]++;
        }
        return true;
    }
}

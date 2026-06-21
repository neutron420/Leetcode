import java.util.*;

class Solution {
    class DisjointSet {
        int[] parent, size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findUPar(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findUPar(parent[node]);
        }

        void unionBySize(int u, int v) {
            int pu = findUPar(u);
            int pv = findUPar(v);
            if (pu == pv)
                return;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int removeStones(int[][] stones) {
        DisjointSet ds = new DisjointSet(stones.length);
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    ds.unionBySize(i, j);
                }
            }
        }
        int components = 0;
        for (int i = 0; i < stones.length; i++) {
            if (ds.findUPar(i) == i ) {
                components++;
            }
        }
        return stones.length - components;
    }
}
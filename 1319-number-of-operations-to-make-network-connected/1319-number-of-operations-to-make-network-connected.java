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
            if (pu == pv) return;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.findUPar(u) == ds.findUPar(v)) {
                extraEdges++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUPar(i) == i) {
                components++;
            }
        }
        int requiredEdges = components - 1;
        if (extraEdges >= requiredEdges) {
            return requiredEdges;
        }
        return -1;
    }
}
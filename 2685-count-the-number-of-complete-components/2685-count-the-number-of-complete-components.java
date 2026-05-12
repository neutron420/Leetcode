class Solution {
    public int countCompleteComponents(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[V];
        int components = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;
                int nodes = 0;
                int edgeCount = 0;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    nodes++;
                    edgeCount += adj.get(node).size();
                    for (int nbr : adj.get(node)) {
                        if (!visited[nbr]) {

                            visited[nbr] = true;
                            q.offer(nbr);
                        }
                    }
                }
                edgeCount = edgeCount / 2;

                if (edgeCount == (nodes * (nodes - 1)) / 2) {
                    components++;
                }
            }
        }
        return components;
    }
}
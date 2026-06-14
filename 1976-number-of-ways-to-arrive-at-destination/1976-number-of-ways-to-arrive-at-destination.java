class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];
        int mod = 1000000007;
        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});
        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            long dis = curr[0];
            int node = (int)curr[1];
            if(dis > dist[node]) continue;
            for(int[] nbr : adj.get(node)) {

                int adjNode = nbr[0];
                int wt = nbr[1];

                if(dis + wt < dist[adjNode]) {

                    dist[adjNode] = dis + wt;
                    ways[adjNode] = ways[node];

                    pq.offer(new long[]{dist[adjNode], adjNode});
                }
                else if(dis + wt == dist[adjNode]) {
                    ways[adjNode] =
                        (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
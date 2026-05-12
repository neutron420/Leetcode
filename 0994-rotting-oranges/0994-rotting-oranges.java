class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = true;
                }

                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        int count = 0;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int i = curr.row;
            int j = curr.col;
            int t = curr.time;

            time = Math.max(time, t);
            // top
            if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
                q.offer(new Pair(i - 1, j, t + 1));
                vis[i - 1][j] = true;
                count++;
            }
            // right
            if (j + 1 < m && !vis[i][j + 1] && grid[i][j + 1] == 1) {
                q.offer(new Pair(i, j + 1, t + 1));
                vis[i][j + 1] = true;
                count++;
            }
            // bottom
            if (i + 1 < n && !vis[i + 1][j] && grid[i + 1][j] == 1) {
                q.offer(new Pair(i + 1, j, t + 1));
                vis[i + 1][j] = true;
                count++;
            }
            // left
            if (j - 1 >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
                q.offer(new Pair(i, j - 1, t + 1));
                vis[i][j - 1] = true;
                count++;
            }
        }
        if (count != fresh) {
            return -1;
        }

        return time;
    }
}
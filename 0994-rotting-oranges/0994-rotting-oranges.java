class Solution {
    public int orangesRotting(int[][] grid) {
        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        LinkedList<int[]> s = new LinkedList<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] == 2) s.add( new int[]{i,j} );
            }
        }
        int time = 0, size, curx, cury;
        int[] pos;
        while (s.size()!=0){
            size = s.size();
            for (int k=0;k<size;k++){
                pos = s.poll();
                for (int p=0;p<dirs.length;p++){
                    curx = pos[0] + dirs[p][0];
                    cury = pos[1] + dirs[p][1];
                    if (curx<0||curx>=grid.length
                        ||cury<0||cury>=grid[0].length) continue;
                    if (grid[curx][cury]==1){
                        grid[curx][cury] = 2;
                        s.add(new int[]{curx,cury});
                    }
                }
            }
            time ++;
        }
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] == 1) return -1;
            }
        }
        return time-1>=0? time-1 : 0;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty() && fresh > 0) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int[] dir : directions) {
                    int dr = r + dir[0];
                    int dc = c + dir[1];
                    if (dr >= 0 && dc >= 0 && dr < grid.length && dc < grid[0].length && grid[dr][dc] == 1) {
                        grid[dr][dc] = 2;
                        q.offer(new int[]{dr, dc});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}

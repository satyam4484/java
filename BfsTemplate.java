import java.util.*;

/**
 * Utility class providing a BFS template for grid problems.
 *
 * Contains a simple Pair helper for coordinates and an implementation of
 * the "rotten oranges" problem using multi-source BFS.
 */
class BfsTemplate   {

    /**
     * Simple coordinate pair used for queue entries (row, column).
     */
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * Check whether the cell at (r, c) is within grid bounds and contains a fresh
     * orange (represented by 1).
     *
     * @param r row index
     * @param c column index
     * @param grid 2D grid where 0 = empty, 1 = fresh orange, 2 = rotten orange
     * @return true if (r, c) is inside the grid and grid[r][c] == 1
     */
    public boolean isValid(int r, int c, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1);
    }

    /**
     * Compute the minimum number of minutes required to rot all fresh oranges.
     *
     * Uses multi-source BFS: all initially rotten oranges (value 2) are added to
     * the queue and spread the rot to adjacent fresh oranges (value 1) each
     * minute (BFS level). If any fresh orange remains unreachable, returns -1.
     *
     * @param grid 2D array where 0 = empty, 1 = fresh orange, 2 = rotten orange
     * @return minimum minutes to rot all oranges, or -1 if impossible
     */
    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        // Step 1: Add all rotten oranges to queue and count fresh ones
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int[][] dir = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        // Step 2: BFS - each loop iteration represents one minute
        while (!q.isEmpty()) {

            int size = q.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();
                int x = curr.first;
                int y = curr.second;

                for (int[] d : dir) {

                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (isValid(nx, ny, grid)) {

                        grid[nx][ny] = 2;
                        fresh--;
                        q.add(new Pair(nx, ny));
                        rottedThisRound = true;
                    }
                }
            }

            if (rottedThisRound) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
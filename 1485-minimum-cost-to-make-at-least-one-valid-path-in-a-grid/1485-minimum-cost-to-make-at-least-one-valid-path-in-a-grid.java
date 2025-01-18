class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Create DP table to store the minimum cost to reach each cell
        int[][] dp = new int[n][m];
        
        // Initialize all cells in dp table with a large value
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Starting point
        dp[0][0] = 0;
        
        // Directions: right, left, down, up
        int[] drow = {0, 0, 1, -1};
        int[] dcol = {1, -1, 0, 0};
        
        // Use a queue for breadth-first exploration of the grid
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // Starting point (0, 0)
        
        // Perform BFS using the queue
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            
            // Explore all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                
                // Check if the new cell is within bounds
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    // Calculate the cost to reach the next cell
                    int newCost = dp[r][c] + ((grid[r][c] - 1 != i) ? 1 : 0);
                    
                    // If a lower cost is found, update the dp table and add the new cell to the queue
                    if (dp[nrow][ncol] > newCost) {
                        dp[nrow][ncol] = newCost;
                        queue.offer(new int[]{nrow, ncol});
                    }
                }
            }
        }
        
        // Return the minimum cost to reach the bottom-right corner
        return dp[n - 1][m - 1];
    }
}

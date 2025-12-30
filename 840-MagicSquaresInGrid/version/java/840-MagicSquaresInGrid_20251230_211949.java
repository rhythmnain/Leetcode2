// Last updated: 12/30/2025, 9:19:49 PM
1class Solution {
2    private boolean isMagicSquare(int[][] grid, int i, int j) {
3        // Check for distinct numbers from 1 to 9
4        boolean[] seen = new boolean[10];
5        for (int x = 0; x < 3; x++) {
6            for (int y = 0; y < 3; y++) {
7                int num = grid[i + x][j + y];
8                if (num < 1 || num > 9 || seen[num]) return false;
9                seen[num] = true;
10            }
11        }
12
13        int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];  // First row sum
14        
15        // Check rows
16        for (int x = 0; x < 3; x++) {
17            if (sum != grid[i + x][j] + grid[i + x][j + 1] + grid[i + x][j + 2]) return false;
18        }
19
20        // Check columns
21        for (int y = 0; y < 3; y++) {
22            if (sum != grid[i][j + y] + grid[i + 1][j + y] + grid[i + 2][j + y]) return false;
23        }
24
25        // Check diagonals
26        if (sum != grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]) return false;
27        if (sum != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2]) return false;
28
29        return true;
30    }
31    
32    public int numMagicSquaresInside(int[][] grid) {
33        int count = 0;
34        int rows = grid.length;
35        int cols = grid[0].length;
36
37        for (int i = 0; i <= rows - 3; i++) {
38            for (int j = 0; j <= cols - 3; j++) {
39                if (isMagicSquare(grid, i, j)) {
40                    count++;
41                }
42            }
43        }
44
45        return count;
46    }
47}
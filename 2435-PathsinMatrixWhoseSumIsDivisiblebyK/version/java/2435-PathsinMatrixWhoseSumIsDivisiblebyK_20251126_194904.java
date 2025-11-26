// Last updated: 11/26/2025, 7:49:04 PM
1class Solution {
2    private static final int MOD = (int) 1e9 + 7;
3
4    public int numberOfPaths(int[][] grid, int k) {
5        int m = grid.length, n = grid[0].length;
6        int[][] prev = new int[n][k];
7        int[][] curr = new int[n][k];
8
9        int sum = 0;
10        for (int j = 0; j < n; j++) {
11            sum = (sum + grid[0][j]) % k;
12            prev[j][sum] = 1;
13        }
14
15        sum = grid[0][0] % k;
16
17        for (int i = 1; i < m; i++) {
18            sum = (sum + grid[i][0]) % k;
19            Arrays.fill(curr[0], 0);
20            curr[0][sum] = 1;
21
22            for (int j = 1; j < n; j++) {
23                Arrays.fill(curr[j], 0);
24                int val = grid[i][j];
25
26                for (int r = 0; r < k; r++) {
27                    int nr = (r + val) % k;
28                    curr[j][nr] = (prev[j][r] + curr[j - 1][r]) % MOD;
29                }
30            }
31
32            int[][] tmp = prev;
33            prev = curr;
34            curr = tmp;
35        }
36
37        return prev[n - 1][0];
38    }
39}
// Last updated: 1/19/2026, 11:20:02 PM
1class Solution {
2    public int maxSideLength(int[][] mat, int threshold) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        // Prefix sum matrix (extra row & column to handle boundaries safely)
7        int[][] prefixSum = new int[m + 1][n + 1];
8
9        // Build the prefix sum matrix
10        // prefixSum[i][j] stores sum of elements from (0,0) to (i-1,j-1)
11        for (int i = 1; i <= m; i++) {
12            for (int j = 1; j <= n; j++) {
13                prefixSum[i][j] = mat[i - 1][j - 1]
14                        + prefixSum[i - 1][j]      // sum from top
15                        + prefixSum[i][j - 1]      // sum from left
16                        - prefixSum[i - 1][j - 1]; // remove double counted area
17            }
18        }
19
20        int maxSide = 0; // stores the largest valid square size found
21
22        // Try to expand the square gradually
23        for (int i = 1; i <= m; i++) {
24            for (int j = 1; j <= n; j++) {
25
26                int nextSide = maxSide + 1; // check only the next larger square
27
28                // Make sure the square fits within matrix bounds
29                if (i >= nextSide && j >= nextSide) {
30
31                    // Calculate sum of square ending at (i, j) in O(1)
32                    int sum = prefixSum[i][j]
33                            - prefixSum[i - nextSide][j]
34                            - prefixSum[i][j - nextSide]
35                            + prefixSum[i - nextSide][j - nextSide];
36
37                    // If sum is within threshold, update answer
38                    if (sum <= threshold) {
39                        maxSide = nextSide;
40                    }
41                }
42            }
43        }
44
45        return maxSide; // return maximum possible square side length
46    }
47}
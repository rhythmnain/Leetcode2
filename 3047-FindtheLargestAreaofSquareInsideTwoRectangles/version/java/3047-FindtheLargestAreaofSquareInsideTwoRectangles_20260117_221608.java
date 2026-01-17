// Last updated: 1/17/2026, 10:16:08 PM
1class Solution {
2
3    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
4        int n = bottomLeft.length;
5        long maxSide = 0;
6
7        for (int i = 0; i < n; i++) {
8            for (int j = i + 1; j < n; j++) {
9                int w =
10                    Math.min(topRight[i][0], topRight[j][0]) -
11                    Math.max(bottomLeft[i][0], bottomLeft[j][0]);
12                int h =
13                    Math.min(topRight[i][1], topRight[j][1]) -
14                    Math.max(bottomLeft[i][1], bottomLeft[j][1]);
15                int side = Math.min(w, h);
16
17                maxSide = Math.max(maxSide, side);
18            }
19        }
20
21        return maxSide * maxSide;
22    }
23}
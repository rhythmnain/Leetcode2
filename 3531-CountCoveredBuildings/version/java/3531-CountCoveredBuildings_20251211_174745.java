// Last updated: 12/11/2025, 5:47:45 PM
1class Solution {
2
3    public int countCoveredBuildings(int n, int[][] buildings) {
4
5        int[] rMax = new int[n + 1];
6        int[] rMin = new int[n + 1];
7        int[] cMax = new int[n + 1];
8        int[] cMin = new int[n + 1];
9
10        Arrays.fill(rMin, n + 1);
11        Arrays.fill(cMin, n + 1);
12
13        for (int[] p : buildings) {
14            int x = p[0], y = p[1];
15
16            rMax[y] = Math.max(rMax[y], x);
17            rMin[y] = Math.min(rMin[y], x);
18
19            cMax[x] = Math.max(cMax[x], y);
20            cMin[x] = Math.min(cMin[x], y);
21        }
22
23        int cnt = 0;
24
25        for (int[] p : buildings) {
26            int x = p[0], y = p[1];
27
28            if (x > rMin[y] && x < rMax[y] &&
29                y > cMin[x] && y < cMax[x]) 
30            {
31                cnt++;
32            }
33        }
34
35        return cnt;
36    }
37}
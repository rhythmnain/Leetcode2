// Last updated: 12/1/2025, 7:23:54 PM
1class Solution {
2    public long maxRunTime(int n, int[] batteries) {
3        long sum = 0;
4        for (int b : batteries) sum += b;
5
6        long left = 0, right = sum / n;
7
8        while (left < right) {
9            long mid = (left + right + 1) >> 1;
10            long need = mid * n, have = 0;
11
12            for (int b : batteries) 
13                have += Math.min(b, mid);
14
15            if (have >= need) left = mid;
16            else right = mid - 1;
17        }
18
19        return left;
20    }
21}
// Last updated: 12/10/2025, 7:47:25 PM
1class Solution {
2    public int countPermutations(int[] complexity) {
3        int n = complexity.length, min = complexity[0];
4        int MOD = (int) 1e9 + 7;
5
6        for (int i = 1; i < n; i++) {
7            if (complexity[i] <= min) return 0;
8        }
9
10        long ft = 1;
11        for (int i = 2; i < n; i++) {
12            ft = (ft * i) % MOD;
13        }
14
15        return (int) ft;
16    }
17}
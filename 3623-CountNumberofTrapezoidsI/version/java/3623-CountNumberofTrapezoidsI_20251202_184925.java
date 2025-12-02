// Last updated: 12/2/2025, 6:49:25 PM
1class Solution {
2    public int countTrapezoids(int[][] points) {
3        long MOD = 1_000_000_007L;
4        java.util.HashMap<Integer, Long> map = new java.util.HashMap<>();
5        for (int[] p : points) {
6            map.put(p[1], map.getOrDefault(p[1], 0L) + 1);
7        }
8        java.util.ArrayList<Long> seg = new java.util.ArrayList<>();
9        for (long k : map.values()) {
10            if (k >= 2) seg.add((k * (k - 1) / 2) % MOD);
11        }
12        long sum = 0, ans = 0;
13        for (long v : seg) {
14            ans = (ans + v * sum) % MOD;
15            sum = (sum + v) % MOD;
16        }
17        return (int) ans;
18    }
19}
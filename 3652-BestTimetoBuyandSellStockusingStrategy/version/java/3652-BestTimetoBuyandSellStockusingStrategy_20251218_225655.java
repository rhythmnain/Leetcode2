// Last updated: 12/18/2025, 10:56:55 PM
1class Solution {
2    public long maxProfit(int[] prices, int[] strategy, int k) {
3        int n = prices.length, h = k >> 1;
4        long base = 0, prev = 0, nxt = 0, best = 0;
5
6        for (int i = 0; i < n; i++) base += (long) strategy[i] * prices[i];
7
8        for (int i = 0; i < k; i++) {
9            prev += (long) strategy[i] * prices[i];
10            if (i >= h) nxt += prices[i];
11        }
12
13        best = Math.max(0, nxt - prev);
14
15        for (int r = k; r < n; r++) {
16            int l = r - k + 1;
17            prev += (long) strategy[r] * prices[r]
18                 - (long) strategy[l - 1] * prices[l - 1];
19            nxt += prices[r] - prices[l - 1 + h];
20            best = Math.max(best, nxt - prev);
21        }
22
23        return base + best;
24    }
25}
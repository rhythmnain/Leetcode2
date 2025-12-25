// Last updated: 12/25/2025, 7:01:59 PM
1public class Solution {
2    public long maximumHappinessSum(int[] happiness, int k) {
3        Arrays.sort(happiness);
4        long res = 0;
5        int n = happiness.length, j = 0;
6
7        for (int i = n - 1; i >= n - k; --i) {
8            happiness[i] = Math.max(happiness[i] - j++, 0);
9            res += happiness[i];
10        }
11
12        return res;
13    }
14}
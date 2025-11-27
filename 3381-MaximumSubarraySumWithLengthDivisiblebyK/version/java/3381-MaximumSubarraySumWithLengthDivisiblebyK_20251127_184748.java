// Last updated: 11/27/2025, 6:47:48 PM
1class Solution {
2    public long maxSubarraySum(int[] nums, int k) {
3        long[] minPrefix = new long[k];
4        final long INF = Long.MAX_VALUE;
5
6        for (int i = 0; i < k; i++) minPrefix[i] = INF;
7        minPrefix[0] = 0;
8
9        long prefix = 0;
10        long answer = Long.MIN_VALUE;
11
12        for (int i = 0; i < nums.length; i++) {
13            prefix += nums[i];
14            int mod = (i + 1) % k;
15
16            if (minPrefix[mod] != INF) {
17                answer = Math.max(answer, prefix - minPrefix[mod]);
18            }
19
20            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
21        }
22
23        return answer;
24    }
25}
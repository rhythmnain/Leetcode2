// Last updated: 1/2/2026, 2:36:53 PM
1class Solution {
2    public int repeatedNTimes(int[] nums) {
3        boolean[] seen = new boolean[10001];
4        
5        for (int num : nums) {
6            if (seen[num]) {
7                return num;
8            }
9            seen[num] = true;
10        }
11        
12        return 0;
13    }
14}
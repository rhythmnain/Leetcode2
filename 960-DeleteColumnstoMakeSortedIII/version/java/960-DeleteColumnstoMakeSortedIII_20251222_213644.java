// Last updated: 12/22/2025, 9:36:44 PM
1class Solution {
2    public int minDeletionSize(String[] s) {
3        int n = s.length, m = s[0].length();
4        int size = 0;
5        int[] dp = new int[m];
6
7        for (int i = 0; i < m; i++) {
8            dp[i] = 1;
9        }
10
11        int max_keep = 1;
12        for (int i = 0; i < m; i++) {
13            for (int j = 0; j < i; j++) {
14                boolean valid = true;
15                for (int k = 0; k < n; k++) {
16                    if (s[k].charAt(j) > s[k].charAt(i)) {
17                        valid = false;
18                        break;
19                    }
20                }
21                if (valid) {
22                    dp[i] = Math.max(dp[i], dp[j] + 1);
23                }
24            }
25            max_keep = Math.max(max_keep, dp[i]);
26        }
27
28        return m - max_keep;
29    }
30}
// Last updated: 1/10/2026, 7:29:08 PM
1class Solution {
2    public int minimumDeleteSum(String s1, String s2) {
3        int total_sum = 0, n1 = s1.length(), n2 = s2.length();
4        for (int i = 0; i < n1; i++) total_sum += s1.charAt(i);
5        for (int i = 0; i < n2; i++) total_sum += s2.charAt(i);
6        
7        int[][] dp = new int[n1 + 1][n2 + 1];
8        for (int i = 1; i <= n1; i++) {
9            for (int j = 1; j <= n2; j++) {
10                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
11                    int ascii_value = (int)s1.charAt(i - 1);
12                    dp[i][j] = dp[i - 1][j - 1] + ascii_value;
13                } else {
14                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
15                }
16            }
17        }
18
19        return total_sum - 2 * dp[n1][n2];
20    }
21}
// Last updated: 12/16/2025, 9:06:15 PM
1class Solution {
2    List<Integer>[] tree;
3    int[] buyPrice, sellPrice;
4    int budget;
5    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
6        this.buyPrice = present;
7        this.sellPrice = future;
8        this.budget = budget;
9        tree = new ArrayList[n];
10        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
11
12        for (int[] h : hierarchy) {
13            int boss = h[0] - 1;
14            int emp  = h[1] - 1;
15            tree[boss].add(emp);
16        }
17        int[][] dp = dfs(0);
18        return dp[budget][0];
19    }
20
21    public int[][] dfs(int u) {
22        int[][] dp = new int[budget + 1][2];
23        for (int v : tree[u]) {
24            int[][] child = dfs(v);
25            int[][] next = new int[budget + 1][2];
26
27            for (int b = 0; b <= budget; b++) {
28                for (int cb = 0; cb <= b; cb++) {
29                    next[b][0] = Math.max(next[b][0],
30                            dp[b - cb][0] + child[cb][0]);
31                    next[b][1] = Math.max(next[b][1],
32                            dp[b - cb][1] + child[cb][1]);
33                }
34            }
35            dp = next;
36        }
37
38        int[][] ans = new int[budget + 1][2];
39
40        for (int b = 0; b <= budget; b++) {
41            ans[b][0] = dp[b][0];
42            if (b >= buyPrice[u]) {
43                ans[b][0] = Math.max(ans[b][0],
44                        sellPrice[u] - buyPrice[u] + dp[b - buyPrice[u]][1]);
45            }
46
47            int discounted = buyPrice[u] / 2;
48            ans[b][1] = dp[b][0];
49            if (b >= discounted) {
50                ans[b][1] = Math.max(ans[b][1],
51                        sellPrice[u] - discounted + dp[b - discounted][1]);
52            }
53        }
54        return ans;
55    }
56}
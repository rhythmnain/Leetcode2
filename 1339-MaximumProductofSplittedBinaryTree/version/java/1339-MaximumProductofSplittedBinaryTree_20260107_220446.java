// Last updated: 1/7/2026, 10:04:46 PM
1class Solution {
2    long MOD = 1000000007L;
3    long ans = 0;
4
5    private long dfs(TreeNode node) {
6        if (node == null) return 0;
7
8        node.val += dfs(node.left) + dfs(node.right);
9        return node.val;
10    }
11
12    public int maxProduct(TreeNode root) {
13        long total = dfs(root);
14
15        Queue<TreeNode> q = new LinkedList<>();
16        q.add(root);
17
18        while (!q.isEmpty()) {
19            TreeNode node = q.poll();
20            if (node == null) continue;
21
22            long cur = (total - node.val) * node.val;
23            ans = Math.max(ans, cur);
24
25            if (node.left != null) q.add(node.left);
26            if (node.right != null) q.add(node.right);
27        }
28
29        return (int)(ans % MOD);
30    }
31}
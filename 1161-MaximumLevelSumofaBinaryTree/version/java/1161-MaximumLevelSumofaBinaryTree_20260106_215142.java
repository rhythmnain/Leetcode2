// Last updated: 1/6/2026, 9:51:42 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17        public int maxLevelSum(TreeNode root) {
18        int max = Integer.MIN_VALUE, maxLevel = 1;
19        Queue<TreeNode> q = new LinkedList<>();
20        q.offer(root);
21        for (int level = 1; !q.isEmpty(); ++level) {
22            int sum = 0;
23            for (int sz = q.size(); sz > 0; --sz) {
24                TreeNode n = q.poll();
25                sum += n.val;
26                if (n.left != null) { 
27                    q.offer(n.left);
28                }
29                if (n.right != null) {
30                    q.offer(n.right);
31                }
32            }
33            if (max < sum) {
34                max = sum;
35                maxLevel = level;
36            }
37        }
38        return maxLevel;
39    }
40}
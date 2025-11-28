// Last updated: 11/28/2025, 6:04:34 PM
1class Solution {
2    public int maxKDivisibleComponents(int n, int[][] edges, int[] vals, int k) {
3        if (n < 2) return 1;
4        
5        List<List<Integer>> graph = new ArrayList<>();
6        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
7        int[] degree = new int[n];
8        
9        for (int[] edge : edges) {
10            graph.get(edge[0]).add(edge[1]);
11            graph.get(edge[1]).add(edge[0]);
12            degree[edge[0]]++;
13            degree[edge[1]]++;
14        }
15        
16        long[] nodeVals = new long[n];
17        for (int i = 0; i < n; i++) nodeVals[i] = vals[i];
18        Queue<Integer> leafQ = new LinkedList<>();
19        for (int i = 0; i < n; i++) if (degree[i] == 1) leafQ.add(i);
20        
21        int compCnt = 0;
22        while (!leafQ.isEmpty()) {
23            int curr = leafQ.poll();
24            degree[curr]--;
25            long carry = 0;
26            
27            if (nodeVals[curr] % k == 0) compCnt++;
28            else carry = nodeVals[curr];
29            
30            for (int nbr : graph.get(curr)) {
31                if (degree[nbr] == 0) continue;
32                degree[nbr]--;
33                nodeVals[nbr] += carry;
34                if (degree[nbr] == 1) leafQ.add(nbr);
35            }
36        }
37        
38        return compCnt;
39    }
40}
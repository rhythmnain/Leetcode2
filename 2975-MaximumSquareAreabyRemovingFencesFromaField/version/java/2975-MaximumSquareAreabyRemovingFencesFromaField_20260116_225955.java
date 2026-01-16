// Last updated: 1/16/2026, 10:59:55 PM
1class Solution {
2    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
3
4        // Add the outer boundaries of the field to the horizontal fence positions
5        // This allows us to consider squares that touch the top or bottom edge
6        int[] h = Arrays.copyOf(hFences, hFences.length + 2);
7        h[hFences.length] = 1;
8        h[hFences.length + 1] = m;
9
10
11        // Add the outer boundaries of the field to the vertical fence positions
12        // This allows us to consider squares that touch the left or right edge
13        int[] v = Arrays.copyOf(vFences, vFences.length + 2);
14        v[vFences.length] = 1;
15        v[vFences.length + 1] = n;
16        
17
18        // Sort both fence arrays so distances can be calculated correctly
19        Arrays.sort(h);
20        Arrays.sort(v);
21
22        // Compute every possible height that can be formed by removing horizontal fences
23        // Each pair of horizontal fences defines one potential side length
24        Set<Integer> hGaps = new HashSet<>();
25        for (int i = 0; i < h.length; i++) {
26            for (int j = i + 1; j < h.length; j++) {
27                hGaps.add(h[j] - h[i]);
28            }
29        }
30
31        // For each possible vertical distance, check whether the same length
32        // exists in the horizontal direction to form a valid square
33        long maxSide = -1;
34        for (int i = 0; i < v.length; i++) {
35            for (int j = i + 1; j < v.length; j++) {
36                int currentGap = v[j] - v[i];
37                if (hGaps.contains(currentGap)) {
38                    maxSide = Math.max(maxSide, currentGap);
39                }
40            }
41        }
42
43        // If no common side length was found, forming a square is impossible
44        if (maxSide == -1) return -1;
45
46        // Return the area of the largest square under the modulo constraint
47        long MOD = 1_000_000_007;
48        return (int) ((maxSide * maxSide) % MOD);
49    }
50}
// Last updated: 1/15/2026, 8:46:47 PM
1class Solution {
2    private int maxLen(int[] Bars) {
3        int count = 2, length = 2;
4        for(int i = 1; i < Bars.length; i++) {
5            if(Bars[i] - Bars[i-1] == 1) count++;
6            else count = 2;
7            length = Math.max(length, count);
8        }
9        return length;
10    }
11    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
12        Arrays.sort(hBars);
13        Arrays.sort(vBars);
14        int side = Math.min(maxLen(hBars), maxLen(vBars));
15        return side * side; 
16    }
17}
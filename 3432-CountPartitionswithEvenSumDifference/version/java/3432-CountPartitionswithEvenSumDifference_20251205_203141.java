// Last updated: 12/5/2025, 8:31:41 PM
1class Solution {
2    public int countPartitions(int[] A) {
3        int total = Arrays.stream(A).sum();
4        return (total & 1) == 0 ? A.length - 1 : 0;
5    }
6}
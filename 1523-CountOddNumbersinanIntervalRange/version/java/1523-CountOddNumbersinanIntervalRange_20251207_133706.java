// Last updated: 12/7/2025, 1:37:06 PM
1class Solution {
2    public int countOdds(int low, int high) {
3        int nums=high-low+1;
4       if(low%2!=0 && high%2!=0) return nums/2 + 1;
5       else return nums/2;
6    }
7}
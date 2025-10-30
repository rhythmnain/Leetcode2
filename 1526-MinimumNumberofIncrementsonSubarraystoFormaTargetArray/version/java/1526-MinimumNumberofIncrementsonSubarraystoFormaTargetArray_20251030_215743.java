// Last updated: 10/30/2025, 9:57:43 PM
class Solution {
    public int minNumberOperations(int[] target) {
        final int n=target.length;
        int ans=target[0];
        for(int i=1; i<n; i++)
            ans+=Math.max(target[i]-target[i-1], 0);
        return ans;
    }
}
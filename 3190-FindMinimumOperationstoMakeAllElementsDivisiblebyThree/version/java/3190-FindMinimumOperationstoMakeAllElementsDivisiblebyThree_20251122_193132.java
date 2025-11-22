// Last updated: 11/22/2025, 7:31:32 PM
class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            if(num % 3 != 0) ans++;
        }
        return ans;
    }
}
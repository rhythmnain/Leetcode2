// Last updated: 11/17/2025, 5:37:43 PM
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastOccured = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastOccured != -1) {
                    int gap = i - lastOccured - 1;
                    if (gap < k) return false;
                }
                lastOccured = i;
            }
        }
        return true;
    }
}
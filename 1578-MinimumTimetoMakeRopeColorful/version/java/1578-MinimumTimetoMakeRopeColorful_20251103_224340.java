// Last updated: 11/3/2025, 10:43:40 PM
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        int n = colors.length();
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                time += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return time;
    }
}
// Last updated: 10/25/2025, 7:35:49 PM
class Solution {
    int triSum(int n) {
        return (n * (n + 1)) >> 1;
    }

    public int totalMoney(int days) {
        int nWeeks = days / 7;
        int rDays = days % 7;

        return triSum(days) - 42 * triSum(nWeeks - 1) - 6 * nWeeks * rDays; 
    }
}
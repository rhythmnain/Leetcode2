// Last updated: 10/20/2025, 11:16:49 AM
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if (op.contains("+")) x++;
            else x--;
        }
        return x;
    }
}
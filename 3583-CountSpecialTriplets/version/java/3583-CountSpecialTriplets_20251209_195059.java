// Last updated: 12/9/2025, 7:50:59 PM
1class Solution {
2    public int specialTriplets(int[] nums) {
3        int n = nums.length;
4        long count = 0;
5        int MOD = (int) 1e9 + 7, MAX_VAL = 100001;
6        
7        int[] left_count = new int[2 * MAX_VAL], right_count = new int[2 * MAX_VAL];
8        for (int num : nums) right_count[num]++;
9        
10        for (int j = 0; j < n; j++) {
11            int num_j = nums[j];
12            right_count[num_j]--;
13            
14            int target = num_j * 2;
15            if (target <= 2 * MAX_VAL) {
16                count += (long) left_count[target] * right_count[target];
17            }
18            
19            left_count[num_j]++;
20        }
21        
22        return (int) (count % MOD);
23    }
24}
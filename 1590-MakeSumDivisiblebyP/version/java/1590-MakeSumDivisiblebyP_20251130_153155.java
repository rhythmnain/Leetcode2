// Last updated: 11/30/2025, 3:31:55 PM
1class Solution {
2    public int minSubarray(int[] nums, int p) {
3        long totalSum =0;
4        for (int num : nums) {
5            totalSum += num;
6        }
7
8        // Find remainder when total sum is divided by p
9        int rem = (int)(totalSum % p);
10        if (rem == 0) return 0; // If remainder is 0, no subarray needs to be removed
11
12        HashMap<Integer, Integer> prefixMod = new HashMap<>();
13        prefixMod.put(0, -1);  // Initialize to handle full prefix
14        long prefixSum = 0;
15        int minLength = nums.length;
16
17        for (int i = 0; i < nums.length; ++i) {
18            prefixSum += nums[i];
19            int currentMod = (int)(prefixSum % p);
20            int targetMod = (currentMod - rem + p) % p;
21
22            if (prefixMod.containsKey(targetMod)) {
23                minLength = Math.min(minLength, i - prefixMod.get(targetMod));
24            }
25
26            prefixMod.put(currentMod, i);
27        }
28
29        return minLength == nums.length ? -1 : minLength;
30
31    }
32}
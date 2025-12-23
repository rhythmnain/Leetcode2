// Last updated: 12/23/2025, 10:58:49 PM
1class Solution {
2    public int maxTwoEvents(int[][] events) {
3        int n = events.length;
4        
5        // Step 1: Sort the events by their start time
6        Arrays.sort(events, (a, b) -> a[0] - b[0]);
7        
8        // Step 2: Create the suffix array for the maximum event value from each event onward
9        int[] suffixMax = new int[n];
10        suffixMax[n - 1] = events[n - 1][2];  // Initialize the last event's value
11        
12        // Populate the suffixMax array
13        for (int i = n - 2; i >= 0; --i) {
14            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
15        }
16        
17        // Step 3: For each event, find the next event that starts after it ends
18        int maxSum = 0;
19        
20        for (int i = 0; i < n; ++i) {
21            int left = i + 1, right = n - 1;
22            int nextEventIndex = -1;
23            
24            // Perform binary search to find the next non-overlapping event
25            while (left <= right) {
26                int mid = left + (right - left) / 2;
27                if (events[mid][0] > events[i][1]) {
28                    nextEventIndex = mid;
29                    right = mid - 1;
30                } else {
31                    left = mid + 1;
32                }
33            }
34            
35            // If a valid next event is found, update the max sum
36            if (nextEventIndex != -1) {
37                maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextEventIndex]);
38            }
39            
40            // Also consider the case where we take only the current event
41            maxSum = Math.max(maxSum, events[i][2]);
42        }
43        
44        return maxSum;
45    }
46}
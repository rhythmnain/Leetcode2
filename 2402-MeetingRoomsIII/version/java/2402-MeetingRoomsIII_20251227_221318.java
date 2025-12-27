// Last updated: 12/27/2025, 10:13:18 PM
1
2
3class Solution {
4    public int mostBooked(int n, int[][] meetings) {
5        int[] ans = new int[n];
6        long[] times = new long[n];
7        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
8
9        for (int i = 0; i < meetings.length; i++) {
10            int start = meetings[i][0], end = meetings[i][1];
11            boolean flag = false;
12            int minind = -1;
13            long val = Long.MAX_VALUE;
14            for (int j = 0; j < n; j++) {
15                if (times[j] < val) {
16                    val = times[j];
17                    minind = j;
18                }
19                if (times[j] <= start) {
20                    flag = true;
21                    ans[j]++;
22                    times[j] = end;
23                    break;
24                }
25            }
26            if (!flag) {
27                ans[minind]++;
28                times[minind] += (end - start);
29            }
30        }
31
32        int maxi = -1, id = -1;
33        for (int i = 0; i < n; i++) {
34            if (ans[i] > maxi) {
35                maxi = ans[i];
36                id = i;
37            }
38        }
39        return id;
40    }
41}
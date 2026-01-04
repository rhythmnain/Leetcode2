// Last updated: 1/4/2026, 9:18:40 PM
1class Solution {
2    public int sumFourDivisors(int[] nums) {
3        int total = 0;
4        for (int x : nums) {
5            int cnt = 0;
6            int sum = 0;
7            for (int i = 1; i * i <= x; i++) {
8                if (x % i == 0) {
9                    int j = x / i;
10                    cnt++;
11                    sum += i;
12                    if (i != j) {
13                        cnt++;
14                        sum += j;
15                    }
16                    if (cnt > 4) break; // early stop
17                }
18            }
19            if (cnt == 4) total += sum;
20        }
21        return total;
22    }
23}
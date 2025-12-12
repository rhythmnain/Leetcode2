// Last updated: 12/12/2025, 8:23:22 PM
1class Solution {
2    private static final int MOD = 105;
3    private static final int MOD1 = MOD - 1;
4    private static final int[] m = new int[200];
5    private static final int[] offline = new int[200];
6
7    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
8        final int[] r = new int[numberOfUsers];
9        int all = 0;
10        int mlen = 0;
11        for (var event : events) {
12            final int ts = parseInt(event.get(1));
13            final String ids = event.get(2);
14            if (event.getFirst().equals("MESSAGE")) {
15                if (ids.equals("ALL")) {
16                   all++;
17                } else if (ids.equals("HERE")) {
18                    m[mlen++] = ts * MOD + MOD1;
19                } else {
20                    for (int i = 0;;) {
21                        final int nextSpace = ids.indexOf(' ', i);
22                        if (nextSpace < 0) {
23                            r[parseInt(ids, i + 2, ids.length())]++;
24                            break;
25                        }
26                        r[parseInt(ids, i + 2, nextSpace)]++;
27                        i = nextSpace + 1;
28                    }
29                }
30            } else {
31                final int id = parseInt(ids);
32                m[mlen++] = ts * MOD + id + 1;
33                m[mlen++] = (ts + 60) * MOD;
34            }
35        }
36
37        int os = 0;
38        int oe = 0;
39        Arrays.sort(m, 0, mlen);
40        for (int i = 0; i < mlen; i++) {
41            final var message = m[i] % MOD;
42            if (message == 0) {
43                os++;
44            } else if (message == MOD1) {
45                all++;
46                for (int j = os; j < oe; j++) {
47                    r[offline[j]]--;
48                }
49            } else {
50                offline[oe++] = message - 1;
51            }
52        }
53        if (all > 0) {
54            for (int i = 0; i < numberOfUsers; i++) {
55                r[i] += all;
56            }
57        }
58        return r;
59    }
60    private static final int parseInt(String s) {
61        return parseInt(s, 0, s.length());
62    }
63
64    private static final int parseInt(String ids, int start, int end) {
65        int r = ids.charAt(start) - '0';
66        for (int i = start + 1; i < end; i++) {
67            r = r * 10 + ids.charAt(i) - '0';
68        }
69        return r;
70    }
71}
// Last updated: 12/8/2025, 9:02:36 PM
1class Solution {
2    public static int GCD(int x, int y){
3        final int bx=Integer.numberOfTrailingZeros(x);
4        final int by=Integer.numberOfTrailingZeros(y);
5        final int bb=(bx<by)?bx:by;
6        x>>=bx; y>>=by;
7        for(int r; y>0; y=Math.min(y, r)){
8            r=x%y;
9            x=y;
10            y=r;
11        }
12        return x<<bb;
13    }
14    static public int countTriples(int n) {
15        int cnt=0;
16        int nsqrt=(int)Math.sqrt((double)n);
17        for (int s=2; s<=nsqrt; s++) {
18            for (int t=1+(s&1); t<s; t+=2) {
19                if (GCD(s, t)!=1) continue;
20
21                int c=s*s+t*t;
22
23                if (c>n) break;
24
25                // k multiples: ka, kb, kc
26                int kmax=n/c;
27                // count (a,b,c) and (b,a,c)
28                cnt+=2*kmax;
29            }
30        }
31        return cnt;
32    }
33}
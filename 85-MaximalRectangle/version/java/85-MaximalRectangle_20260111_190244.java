// Last updated: 1/11/2026, 7:02:44 PM
1class Solution {
2    public int maximalRectangle(char[][] m) {
3        int h[][]=new int[m.length+1][m[0].length+1];
4        int b[][]=new int[m.length+1][m[0].length+1];
5        int res[][]=new int[m.length][m[0].length];
6        int maxi=Integer.MIN_VALUE;
7        for(int i=0;i<m.length;i++){
8            for(int j=0;j<m[0].length;j++){
9                if(m[i][j]=='0') continue;
10                else{
11                    h[i+1][j+1]=h[i][j+1]+1;
12                    b[i+1][j+1]=b[i+1][j]+1;
13                    maxi=Math.max(maxi,Math.max(h[i+1][j+1],b[i+1][j+1]));
14                }
15            }
16        }
17        for(int i=0;i<m.length;i++){
18            for(int j=0;j<m[0].length;j++){
19                if(m[i][j]=='0') continue;
20                if(b[i][j+1]!=0 && b[i+1][j+1]!=0 && h[i+1][j+1]!=0){
21                    int val=find(h,b,i,j,Math.min(b[i][j+1],b[i+1][j+1]));
22                    res[i][j]=val;
23                    maxi=Math.max(maxi,val);
24                }
25                else res[i][j]=1;
26            }
27        }
28        return maxi==Integer.MIN_VALUE?0:maxi;
29    }
30    public int find(int[][] h,int[][] b,int i,int j,int len){
31        int mini=Integer.MIN_VALUE;
32        int v=0,cur=0;
33        for(int k=1;k<=len;k++){
34            if(k==1){
35                v=h[i+1][j+1];
36                cur=h[i+1][j+1];
37            }
38            else{
39                cur=Math.min(cur,h[i+1][j+1]);
40                v=k*cur;
41            }
42            mini=Math.max(mini,v);
43            j--;
44        }
45        return mini;
46    }
47}
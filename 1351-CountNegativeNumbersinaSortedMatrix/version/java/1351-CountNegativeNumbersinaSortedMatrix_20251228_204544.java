// Last updated: 12/28/2025, 8:45:44 PM
1class Solution {
2    public int countNegatives(int[][] grid) {
3        int rows = grid.length;
4        int cols = grid[0].length;
5        int res =0; 
6        int neg = cols-1;
7
8        for(int i=0; i<rows; i++){
9            if(grid[i][0] <0){
10                res+=cols;
11                continue;
12            }
13            if(grid[i][cols-1]>0){
14                continue;
15            }
16            
17        int start=0;
18        int end =neg;
19        int mid;
20
21        while(start<= end){
22            mid = start+(end-start)/2;
23            if(grid[i][mid]<0){
24                end = mid-1;
25            } else{
26                start= mid+1;
27            }
28        }
29        res+=(cols-start); neg =start;
30        
31        }
32    return res;
33}
34}
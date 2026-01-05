// Last updated: 1/5/2026, 7:52:17 PM
1class Solution {
2    public long maxMatrixSum(int[][] matrix) {
3    int min = Integer.MAX_VALUE;
4    long sum = 0;
5    int negCount = 0; 
6    for(int i=0; i<matrix.length; i++)
7    for(int j=0; j<matrix[0].length; j++)
8    {
9     if(matrix[i][j]<0)
10     negCount++;
11     int ab = Math.abs(matrix[i][j]);
12     min = Math.min(min, ab);
13     sum += ab;    
14    }
15    if(negCount%2==0)
16    return sum; 
17    return sum - 2*min;
18}
19}
class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res =0; 
        int neg = cols-1;

        for(int i=0; i<rows; i++){
            if(grid[i][0] <0){
                res+=cols;
                continue;
            }
            if(grid[i][cols-1]>0){
                continue;
            }
            
        int start=0;
        int end =neg;
        int mid;

        while(start<= end){
            mid = start+(end-start)/2;
            if(grid[i][mid]<0){
                end = mid-1;
            } else{
                start= mid+1;
            }
        }
        res+=(cols-start); neg =start;
        
        }
    return res;
}
}
// Last updated: 12/31/2025, 6:29:58 PM
1class Solution {
2    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
3    private int rows, cols;
4    
5    public int latestDayToCross(int row, int col, int[][] cells) {
6        this.rows = row;
7        this.cols = col;
8        
9        int left = 1, right = cells.length, answer = 0;
10        
11        while (left <= right) {
12            int mid = left + (right - left) / 2;
13            
14            if (canCross(mid, cells)) {
15                answer = mid;
16                left = mid + 1;
17            } else {
18                right = mid - 1;
19            }
20        }
21        
22        return answer;
23    }
24    
25    private boolean canCross(int day, int[][] cells) {
26        int[][] grid = new int[rows][cols];
27        
28        for (int i = 0; i < day; i++) {
29            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
30        }
31        
32        Queue<int[]> queue = new LinkedList<>();
33        boolean[][] visited = new boolean[rows][cols];
34        
35        for (int c = 0; c < cols; c++) {
36            if (grid[0][c] == 0) {
37                queue.offer(new int[]{0, c});
38                visited[0][c] = true;
39            }
40        }
41        
42        while (!queue.isEmpty()) {
43            int[] curr = queue.poll();
44            int r = curr[0], c = curr[1];
45            
46            if (r == rows - 1) return true;
47            
48            for (int[] dir : directions) {
49                int nr = r + dir[0];
50                int nc = c + dir[1];
51                
52                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
53                    !visited[nr][nc] && grid[nr][nc] == 0) {
54                    visited[nr][nc] = true;
55                    queue.offer(new int[]{nr, nc});
56                }
57            }
58        }
59        
60        return false;
61    }
62}
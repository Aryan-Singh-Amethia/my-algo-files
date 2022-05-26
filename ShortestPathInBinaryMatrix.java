class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int n=grid.length,res=0;
        int coor[][]={{1,1},{-1,-1},{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,1}};
        Queue<int[]> queue=new LinkedList<int[]>();
        queue.add(new int[]{0,0});
        grid[0][0]=1;
        while(!queue.isEmpty()){
            int s=queue.size();
            res++;
            for(int i=0;i<s;i++){
                int cur[]=queue.poll();
                if(cur[0]==n-1 && cur[1]==n-1)
                   return res;
                for(int[] co : coor){
                    int a= cur[0]+co[0];
                    int b= cur[1]+co[1];
                    if(a<0 || a>=n || b<0 || b>=n || grid[a][b]==1) continue;
                    queue.add(new int[]{a,b});
                    grid[a][b]=1;
                }

            }
        }
        return -1;
    }
}

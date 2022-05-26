class Solution {
    //Bipartite Check using BFS.
    public boolean bfs(int graph[][],int color[],int v){
        Queue<Integer> queue = new LinkedList<Integer>();
        color[v]=1;
        queue.add(v);
        while(!queue.isEmpty()){
            int q = queue.poll();
            for(int i : graph[q]){
                if(color[i]==-1){
                    color[i]=1-color[q];
                    queue.add(i);
                }
                else if(color[i]==color[q])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[]= new int[V];
        Arrays.fill(color,-1);
        boolean ans=false;
        for(int i=0;i<V;i++){
            if(color[i]==-1)
              ans = bfs(graph,color,i);
            if(ans==false)
                return ans;
        }
        return ans;
    }
}
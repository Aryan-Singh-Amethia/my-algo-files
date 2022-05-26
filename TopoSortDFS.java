// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    static void dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],Stack<Integer> stack,int curr){
        visited[curr]=true;
        for(Integer e : adj.get(curr)){
          if(visited[e]!=true)    
            dfs(adj,visited,stack,e);
        }
        stack.push(curr);
    }
 //   Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean visited[]=new boolean[V];
        Arrays.fill(visited,false);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<V;i++){
            if(visited[i]!=true)
              dfs(adj,visited,stack,i);
        }
        int []topoOrder=new int[V];
        int p=0;
        while(!stack.isEmpty()){
            topoOrder[p++]=stack.pop();
        }
        return topoOrder;
    }
    static void bfs(ArrayList<ArrayList<Integer>> adj,List<Integer> ansList,int inDeg[],int V){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDeg[i]==0)
              queue.add(i);
        }
        while(!queue.isEmpty()){
            int e= queue.poll();
            ansList.add(e);
            for(Integer edge : adj.get(e)){
                if(--inDeg[edge] == 0){
                    queue.add(edge);
                }
            }
        }
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       int inDeg[] = new int[V];
       for(List<Integer> edges : adj ){
           for(Integer edge : edges){
               ++inDeg[edge];
           }
       }
       List<Integer> ansList = new ArrayList<>();
       bfs(adj,ansList,inDeg,V);
       int ans[]=new int[V];
       int p=0;
       for(int e : ansList){
           ans[p++]=e;
       }
       return ans;
    }
    
}

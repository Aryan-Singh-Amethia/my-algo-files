// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class DriverClass
    {
        public static void main(String args[]) throws IOException {
    
            BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                String str[] = read.readLine().trim().split(" ");
                int V = Integer.parseInt(str[0]);
                int E = Integer.parseInt(str[1]);
        
                ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
                for(int i=0;i<V;i++)
                {
                    adj.add(new ArrayList<ArrayList<Integer>>());
                }
                
                int i=0;
                while (i++<E) {
                    String S[] = read.readLine().trim().split(" ");
                    int u = Integer.parseInt(S[0]);
                    int v = Integer.parseInt(S[1]);
                    int w = Integer.parseInt(S[2]);
                    ArrayList<Integer> t1 = new ArrayList<Integer>();
                    ArrayList<Integer> t2 = new ArrayList<Integer>();
                    t1.add(v);
                    t1.add(w);
                    t2.add(u);
                    t2.add(w);
                    adj.get(u).add(t1);
                    adj.get(v).add(t2);
                }
                
                int S = Integer.parseInt(read.readLine());
                
                Solution ob = new Solution();
                
                int[] ptr = ob.dijkstra(V, adj, S);
                
                for(i=0; i<V; i++)
                    System.out.print(ptr[i] + " ");
                System.out.println();
            }
        }
    }// } Driver Code Ends
    
    
    //User function Template for Java
    
    
    class Solution
    {
        //Function to find the shortest distance of all the vertices
        //from the source vertex S.
        static final int INF=Integer.MAX_VALUE;
        static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
        {
            // Write your code here
            boolean visited[]=new boolean[V];
            int distance[]=new int[V];
            Arrays.fill(distance, INF);
            Arrays.fill(visited,false);
            PriorityQueue<List<Integer>> heap = new PriorityQueue<List<Integer>>(
                (a,b)->a.get(1)-b.get(1)
            );
            distance[S]=0;
            for(List<Integer> nbr : adj.get(S)){
                    if(distance[S]+nbr.get(1)<distance[nbr.get(0)]){
                        distance[nbr.get(0)]=distance[S]+nbr.get(1);
                        heap.add(nbr);
                    }
            }
            visited[S]=true;
            while(!heap.isEmpty()){
                List<Integer> curr= heap.poll();
                if(visited[curr.get(0)]==true) continue;
                visited[curr.get(0)]=true;
                for(List<Integer> nbr : adj.get(curr.get(0))){
                    if(distance[nbr.get(0)]>distance[curr.get(0)]+nbr.get(1)){
                        distance[nbr.get(0)]=distance[curr.get(0)]+nbr.get(1);
                        heap.add(nbr);
                    }
                }
            }
            return distance;
        }
    }
    
    

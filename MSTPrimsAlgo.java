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
                
                Solution ob = new Solution();
                
                System.out.println(ob.spanningTree(V, adj));
            }
        }
    }// } Driver Code Ends
    
    
    // User function Template for Java
    
        class Solution
        {
            //Function to find sum of weights of edges of the Minimum Spanning Tree.
            static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
            {
                // Add your code here
                int cost=0;
                boolean visited[]= new boolean[V];
                Arrays.fill(visited,false);
                PriorityQueue<List<Integer>> heap = new PriorityQueue<List<Integer>>(
                    (a,b)->{
                        return a.get(1)-b.get(1);
                    }
                );
                for(List<Integer> nbr : adj.get(0)){
                    heap.add(nbr);
                }
                visited[0]=true;
                while(!heap.isEmpty()){
                    List<Integer> curr= heap.poll();
                  if(visited[curr.get(0)]==true) continue;    
                    visited[curr.get(0)]=true;
                    cost+=curr.get(1);
                    for(List<Integer> nbr : adj.get(curr.get(0))){
                       if(visited[nbr.get(0)]!=true)
                         heap.add(nbr);
                    }
                }
                return cost;
            }
        }
    
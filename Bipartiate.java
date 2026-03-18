import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static ArrayList<ArrayList<Integer>>createAdjancencyList(int V, int [][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i< V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] it: edges) {
            int u = it[0];
            int v = it[1];

            adj.get(u).add(v);
            // if undirected graph then add the below line
            adj.get(v).add(u);
        }
        return adj;
    }
    
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = createAdjancencyList(V,edges);
        int[] color = new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0;i<V;i++) {
            if(color[i] == -1) {
                Queue<Integer>q = new LinkedList<>();
                color[i]=0;
                q.offer(i);
                
                while(!q.isEmpty()){
                    int u=q.poll();
                    
                    for(int v: adj.get(u)){
                        if(color[v] == -1) {
                            color[v] = 1-color[u];
                            q.offer(v);
                        }else if(color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
        
    }
}
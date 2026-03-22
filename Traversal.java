import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

    // BFS for connected, undirected and unweighted graph
    /**
     * Perform BFS traversal starting from vertex 0 and return visit order.
     * Assumes graph is connected; if not, only the component containing 0 is returned.
     *
     * @param adj adjacency list representation of the graph
     * @return list of vertices in the order they were visited by BFS
     */
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
            int V = adj.size();
            boolean [] visited = new boolean[V];
            ArrayList<Integer> results = new ArrayList<>();
            int src = 0;
            Queue<Integer> q = new LinkedList<>();
            visited[src] = true;
            q.add(src);

            while(!q.isEmpty()){
                int current = q.poll();
                results.add(current);
                for(int x: adj.get(current)) {
                    if(!visited[x]) {
                        visited[x] = true;
                        q.add(x);
                    }
                }
            }
            return results;
    }
    /**
     * Depth-first traversal (recursive) that records visit order.
     *
     * @param adj adjacency list
     * @param src starting vertex for this DFS call
     * @param visited boolean array tracking visited vertices
     * @param results list to append visit order to
     */
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean [] visited, ArrayList<Integer> results) {
        visited[src] = true;
        results.add(src);
        for(int x: adj.get(src)) {
            if(!visited[x]) {
                dfs(adj, x, visited, results);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int [][] edges = {{0, 1}, {1, 2}, {0,2} , {1,3}, {2,4}, {3,4}};
        ArrayList<ArrayList<Integer>> adj = GraphImpl.createAdjancencyList(V, edges);
        
        boolean [] visited = new boolean[V]; 
        ArrayList<Integer> results = new ArrayList<>();
        
        ArrayList<Integer> bfsResult = bfs(adj);
        dfs(adj, 2, visited, results);
        
        System.out.println("DFS Result: " + results);
        System.out.println("BFS Result: " + bfsResult);
    }
}
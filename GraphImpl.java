import java.util.ArrayList;
import java.util.Collections;

/**
 * Small utility class demonstrating adjacency matrix/list creation for graphs.
 */
public class GraphImpl {
    
    // Adjacency Matrix representation of graph
    /**
     * Create an adjacency matrix representation for a graph with V vertices.
     * For undirected graphs the matrix is symmetric.
     *
     * @param V number of vertices (0-based indexing)
     * @param edges list of directed/undirected edges where each entry is [u, v]
     * @return adjacency matrix as a list of rows where 1 indicates an edge
     */
    public static ArrayList<ArrayList<Integer>> createAdjancencyMatrix(int V, int [][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // initialise the graph
        for (int i = 0 ; i < V; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(V, 0));
            adj.add(row);
        }

        for(int [] it: edges) {
            int u = it[0];
            int v = it[1];
            adj.get(u).set(v,1);
            // for undirected graph then add the below line
            adj.get(v).set(u,1);
        }

        return adj;
    }

    /**
     * Create an adjacency list representation for a graph.
     *
     * @param V number of vertices
     * @param edges list of edges where each entry is [u, v]
     * @return adjacency list where adj.get(u) contains neighbors of u
     */
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
    public static void main(String[] args) {
        int V = 3;
        int [][] edges = {{0, 1}, {1, 2}, {2, 0}};
        // ArrayList<ArrayList<Integer>> adj = createAdjancencyMatrix(V, edges);
        ArrayList<ArrayList<Integer>> adj = createAdjancencyList(V, edges);

        for(int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for(int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
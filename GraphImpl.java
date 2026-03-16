import java.util.ArrayList;
import java.util.Collections;

public class GraphImpl {
    
    // Adjacency Matrix representation of graph
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

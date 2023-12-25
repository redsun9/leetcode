package advent.year2023.day25.first;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FordFulkerson {

    // Number of vertices in the graph
    // Returns true if there is a path from source 's' to sink 't' in
    // residual graph. Also fills parent[] to store the path
    private static boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        int V = rGraph.length;
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[t];
    }

    // Returns the maximum flow from s to t in the given graph
    public static int fordFulkerson(int graph[][], int s, int t) {
        int u, v;
        int V = graph.length;

        // Create a residual graph and fill the residual graph with
        // given capacities in the original graph as residual capacities
        // in the residual graph in the beginning
        int rGraph[][] = new int[V][V]; // Residual graph where rGraph[i][j] indicates
        // residual capacity of edge from i to j (if there
        // is an edge). If rGraph[i][j] is 0, then there is
        // not
        //
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int parent[] = new int[V]; // This array is filled by BFS and to store path

        int max_flow = 0; // There is no flow initially

        // Augument the flow while tere is path from source to sink
        while (bfs(rGraph, s, t, parent)) {
            // Find minimum residual capacity of the edhes along the
            // path filled by BFS. Or we can say find the maximum flow
            // through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // update residual capacities of the edges and reverse edges
            // along the path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            // add path flow to overall flow
            max_flow += path_flow;
        }

        // Return the overall flow
        return max_flow;
    }

    // Driver program to test above functions
    public static void main(String[] args) throws Exception {
        // Let us create a graph shown in the above example
        int graph[][] = {{0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println("The maximum possible flow is " + fordFulkerson(graph, 0, 5));
    }
}

package Graph;

public class unionFindCheckCycle {


    static class Graph {

        // class to represent edge
        class Edge {
            int src, dest;
        }

        int V, E;
        Edge[] edge;

        Graph(int v, int e) {
            this.V = v;
            this.E = e;
            edge = new Edge[E];
            for (int i = 0; i < E; i++) {
                edge[i] = new Edge();
            }
        }

        private int find(int i, int[] parent) {
            if(i == parent[i]) {
                return i;
            }

            int res = find(parent[i], parent);
            parent[i] = res;

            return res;
        }

        private boolean isCycle(Graph graph) {
            int[] parent = new int[graph.V];
            int[] rank = new int[graph.V];

            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            for(Edge e : graph.edge) {
                int parentX = find(e.src, parent);
                int parentY = find(e.dest, parent);

                if(parentX == parentY) {
                    return true;
                }

                if(rank[parentX] < rank[parentY]) {
                    parent[parentX] = parentY;
                } else if(rank[parentY] < rank[parentX]) {
                    parent[parentY] = parentX;
                } else {
                    parent[parentX] = parentY;
                    rank[parentY]++;
                }
            }

            return false;


        }

    }

    public static void main(String[] args) {
        /* Let us create the following graph
            0
            | \
            | \
            1-----2 */

        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph))
            System.out.println("Graph contains cycle");
        else
            System.out.println(
                    "Graph doesn't contain cycle");
    }
}

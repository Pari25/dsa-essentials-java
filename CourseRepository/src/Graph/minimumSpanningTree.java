package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class minimumSpanningTree {

    static class Graph {

        // class to represent edge
        static class Edge {
            int src, dest, wt;
            Edge(int src, int dest, int w) {
                this.src = src;
                this.dest = dest;
                this.wt = w;
            }
        }

        int V, E;
        List<Edge> edge;

        Graph(int v, int e) {
            this.V = v;
            this.E = e;
            edge = new ArrayList<>(E);
        }

        private int find(int i, int[] parent) {
            if(i == parent[i]) {
                return i;
            }

            int res = find(parent[i], parent);
            parent[i] = res;

            return res;
        }

        public void kruskal() {

            List<Edge> result = new ArrayList<>();
            int[] parent = new int[V];
            int[] rank = new int[V];
            edge.sort(new Comparator<Edge>() {
              public int compare(Edge a, Edge b) {
                  return a.wt - b.wt;
              }
            });

            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            int j = 0, countOfEdge = 0;
            while(countOfEdge < V - 1) {
                Edge e = edge.get(j++);
                int parentX = find(e.src, parent);
                int parentY = find(e.dest, parent);
                if(parentX != parentY) {
                    result.add(e);
                    countOfEdge++;
                    if(rank[parentX] < rank[parentY]) {
                        parent[parentX] = parentY;
                    } else if(rank[parentY] < rank[parentX]) {
                        parent[parentY] = parentX;
                    } else {
                        parent[parentX] = parentY;
                        rank[parentY]++;
                    }
                }
            }



            // built MST
            System.out.println(
                    "Following are the edges of the constructed MST:");
            int minCost = 0;
            for (int i = 0; i < countOfEdge; i++) {
                System.out.println(result.get(i).src + " -- "
                        + result.get(i).dest + " == "
                        + result.get(i).wt);
                minCost += result.get(i).wt;
            }
            System.out.println("Total cost of MST: " + minCost);

        }
    }

    public static void main(String[] args) {
        /* Let us create the following graph
            0
            | \
            | \
            1-----2 */

        int V = 4, E = 5;
        Graph graph = new Graph(V, E);
        graph.edge.add( new Graph.Edge(0, 1, 10));
        graph.edge.add( new Graph.Edge(0, 2, 6));
        graph.edge.add( new Graph.Edge(0, 3, 5));
        graph.edge.add( new Graph.Edge(1, 3, 15));
        graph.edge.add( new Graph.Edge(2, 3, 4));


        graph.kruskal();
    }
}

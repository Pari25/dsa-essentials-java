package Graph;

import java.util.*;

public class DijkstraAlgo {

    static class Pair {
        private int index;
        private int weight;

        Pair(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    static class Graph {

        private int V;
        private List<List<Pair>> adj = new ArrayList<>();

        Graph(int v) {
            this.V = v;
            for(int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int w, boolean undir) {
            adj.get(u).add(new Pair(v, w));
            if(undir) {
                adj.get(v).add(new Pair(u, w));
            }
        }

        public int dijkstra(int src, int dest) {
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.weight - o2.weight;
                }
            });

            queue.add(new Pair(src, 0));
            while(!queue.isEmpty()) {
                Pair cur = queue.poll();
                for(Pair child : adj.get(cur.index)) {
                    if(dist[child.index] > dist[cur.index] + child.weight) {
                        dist[child.index] = dist[cur.index] + child.weight;
                        queue.add(new Pair(child.index, dist[child.index]));
                    }
                }
            }

            //Single Source Shortest Dist to all other nodes
            for(int i = 0; i < V; i++){
                System.out.println("Node i "+i +" Dist "+dist[i]);
            }

            return dist[dest];

        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1,1, true);
        g.addEdge(1,2,1, true);
        g.addEdge(0,2,4, true);
        g.addEdge(0,3,7, true);
        g.addEdge(3,2,2, true);
        g.addEdge(3,4,3, true);

        System.out.println( g.dijkstra(0,4));
    }
}

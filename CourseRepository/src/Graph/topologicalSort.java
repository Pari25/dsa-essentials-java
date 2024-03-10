package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topologicalSort {

    static class Graph{

        int V;
        ArrayList<ArrayList<Integer>> list;

        Graph(int v){
            V = v;
            list = new ArrayList<>();
            for(int i = 0; i < v; i++){
                list.add(new ArrayList<>());
            }
        }

        void addEdge(int i,int j,boolean undir){
            list.get(i).add(j);
            if(undir){
                list.get(j).add(i);
            }
        }

        void printAdjList(){
            //Iterate over all the rows
            for(int i=0;i<V;i++){
                System.out.print(i + "-->");
                //every element of ith linked list
                for(int node: list.get(i)){
                    System.out.print(node + ", ");
                }
                System.out.println();
            }


        }

        void topologicalSort() {
            int[] indegree = new int[V];
            for(ArrayList<Integer> l : list) {
                for(Integer i : l) {
                    indegree[i]++;
                }
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for( int i = 0; i < indegree.length; i++) {
                if(indegree[i] == 0) {
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()) {
                Integer cur = queue.poll();
                System.out.println(cur);
                for(Integer child : list.get(cur)) {
                    indegree[child]--;
                    if(indegree[child] == 0) {
                        queue.add(child);
                    }
                }
            }

        }

    }

    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.addEdge(0,2, false);
        g.addEdge(1,2, false);
        g.addEdge(2,3, false);
        g.addEdge(3,5, false);
        g.addEdge(1,4, false);
        g.addEdge(4,5, false);

        g.topologicalSort();
        //g.printAdjList();

    }

}

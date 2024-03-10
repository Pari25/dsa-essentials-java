package Graph;


/** Given a start graph, find the center of the star **/
public class FindStarInGraph {


    //Since it is given that graph is a star graph, only the center node will appear in all the edges. rest nodes will appear only once.
    //So, just compare first 2 edges. Node which is common in both the edges will be the center as any node having edges more than 1 wll be the center).

    private static int findCenter(int[][] edges) {

        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }

        return edges[0][1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {2, 3},
                {4, 2}
        };
        System.out.println(findCenter(arr));

    }
}

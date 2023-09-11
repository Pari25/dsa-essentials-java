package basicSorting;

import java.util.*;

public class CartesianSorting {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void cartesianSort(List<Pair> list) {

       Collections.sort(list, new Comparator<Pair>() {
           @Override
           public int compare(Pair pair1, Pair pair2) {
               return (pair1.x == pair2.x) ? (pair1.y - pair2.y) : (pair1.x - pair2.x);
           }
       });
    }



    public static void main(String[] args){

        List<Pair> list = new ArrayList<>();
        list.add(new Pair(3, 4));
        list.add(new Pair(2, 3));
        list.add(new Pair(3, 7));
        list.add(new Pair(1, 5));
        list.add(new Pair(3, 4));

        cartesianSort(list);

        for(Pair p: list){
            System.out.println(p.x + "," + p.y);
        }
    }

}

package basicSorting;

import java.util.*;

public class inBuildSort {



    public static void main(String[] args){

        int arr[] = {10,9,8,6,5,4,3,2,11,16,8};
        int n = arr.length;

        Arrays.sort(arr);
        List<Integer> list = Arrays.asList(10,9,8,6,5,4,3,2,11,16,8);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(Integer k : list) {
            System.out.println(k);
        }

//        for(int k: arr){
//            System.out.println(k);
//        }
    }

}

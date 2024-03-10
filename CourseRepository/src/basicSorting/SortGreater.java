package basicSorting;

import java.util.Arrays;
import java.util.Collections;

public class SortGreater {

    private static void sortBasedOnFlag(Integer[] arr, boolean flag) {

        if(flag) {
            Arrays.sort(arr);
        } else {
            Arrays.sort(arr, Collections.reverseOrder());
        }
    }



    public static void main(String[] args){

        Integer[] arr = {10,9,8,6,5,4,3,2,11,16,8};

        sortBasedOnFlag(arr, true);

        for(int k: arr){
            System.out.print(k + " ");
        }

        System.out.println();

        sortBasedOnFlag(arr, false);
        for(int k: arr){
            System.out.print(k+ " ");
        }


    }

}

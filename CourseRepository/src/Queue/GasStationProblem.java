package Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GasStationProblem {

    public static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {

        int sum = 0;
        int front = 0;
        int totalSum = 0;

        for(int i = 0; i < A.size(); i++) {
            totalSum += A.get(i) - B.get(i);
            if(sum >= 0) {
                sum += A.get(i) - B.get(i);
            } else {
                sum = A.get(i) - B.get(i);
                front = i;
            }
        }

        if(totalSum < 0) return -1;

        return front;


    }

    public static void main(String[] arg) {

        System.out.println(canCompleteCircuit(new ArrayList<>(Arrays.asList(1, 2, 1, 3)), new ArrayList<>(Arrays.asList(2, 1, 3, 1))));
    }
}

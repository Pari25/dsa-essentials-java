package basicSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class defenceKingdom {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int findLargestUndefendedRectangle(List<Pair> list, int width, int height) {

        int[] x = new int[list.size()];
        int[] y = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            x[i] = list.get(i).x;
            y[i] = list.get(i).y;
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int dx = x[0];
        int dy = y[0];
        for(int i = 0; i < list.size() - 1; i++) {
            dx = Math.max(dx, x[i + 1] - x[i]);
            dy = Math.max(dy, y[i + 1] - y[i]);
        }
        dx = Math.max(dx, width - x[list.size() - 1]);
        dy = Math.max(dy, height - y[list.size() - 1]);

        return (dx - 1) * (dy - 1);
    }


    public static void main(String[] args) {

        int width = 15, height = 8;
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(3, 8));
        list.add(new Pair(11, 2));
        list.add(new Pair(8, 6));

        System.out.println(findLargestUndefendedRectangle(list, width, height));
    }
}

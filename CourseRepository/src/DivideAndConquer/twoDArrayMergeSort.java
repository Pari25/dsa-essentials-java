package DivideAndConquer;

public class twoDArrayMergeSort {

    private static void mergeRows(int[][] arr, int rowS, int rowE, int colS, int colE, int midCol) {

        if(rowS > rowE) return;;

        int[] temp = new int[colE - colS + 1];
        int ptr1 = colS, ptr2 = midCol + 1;
        int index = 0;

        while(ptr1 <= midCol && ptr2 <= colE) {
            if(arr[rowS][ptr1] < arr[rowS][ptr2]) {
                temp[index++] = arr[rowS][ptr1];
                ptr1++;
            } else {
                temp[index++] = arr[rowS][ptr2];
                ptr2++;
            }
        }
        while(ptr1 <= midCol) {
            temp[index++] = arr[rowS][ptr1];
            ptr1++;
        }
        while(ptr2 <= colE) {
            //System.out.println(rowS + " " + rowE + " " + colS + " " + colE + " " + midCol + " " + index + "  " + ptr2);
            temp[index++] = arr[rowS][ptr2];
            ptr2++;
        }

        index = 0;
        for(int j = colS; j <= colE; j++) {
            arr[rowS][j] = temp[index++];
        }

        mergeRows(arr, rowS + 1, rowE, colS, colE, midCol);

    }

    private static void mergeColumns(int[][] arr, int rowS, int rowE, int colS, int colE, int midRow) {

        if(colS > colE) return;

        int[] temp = new int[rowE - rowS + 1];
        int ptr1 = rowS, ptr2 = midRow + 1;
        int index = 0;

        while(ptr1 <= midRow && ptr2 <= rowE) {
            if(arr[ptr1][colS] < arr[ptr2][colS]) {
                temp[index++] = arr[ptr1][colS];
                ptr1++;
            } else {
                temp[index++] = arr[ptr2][colS];
                ptr2++;
            }
        }
        while(ptr1 <= midRow) {
            temp[index++] = arr[ptr1][colS];
            ptr1++;
        }
        while(ptr2 <= rowE) {
            temp[index++] = arr[ptr2][colS];
            ptr2++;
        }

        index = 0;
        for(int i = rowS; i <= rowE; i++) {
            arr[i][colS] = temp[index++];
        }

        mergeColumns(arr, rowS, rowE, colS + 1, colE, midRow);
    }


    private static void mergeSort(int[][] arr, int rowS, int rowE, int colS, int colE) {
        if(rowS >= rowE && colS >= colE) return;

        int midRow = (rowS + rowE) / 2;
        int midCol = (colS + colE) / 2;

        mergeSort(arr, rowS, midRow, colS, midCol);
        mergeSort(arr, rowS, midRow, midCol + 1, colE);
        mergeSort(arr, midRow + 1, rowE, colS, midCol);
        mergeSort(arr, midRow + 1, rowE, midCol + 1, colE);

        mergeRows(arr, rowS, rowE, colS, colE, midCol);
        mergeColumns(arr, rowS, rowE, colS, colE, midRow);
    }

    public static void main(String[] args) {

        int[][] arr = new int[][] {
                {18,4,16,8},
                {23,13,20,11},
                {28,24,26,25},
                {1,30,15,19}};

        int m = 4;
        int n = 4;
        mergeSort(arr,0, m - 1,0, n - 1);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j]  + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] arr2 = new int[][] {
                {18,9,11},
                {1,4,15},
                {13,23,20}};

        m = 3;
        n = 3;
        mergeSort(arr2,0, m - 1,0, n - 1);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr2[i][j]  + " ");
            }
            System.out.println();
        }

    }
}

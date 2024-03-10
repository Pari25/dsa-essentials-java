package Recursion;

public class RecursionSearch {

    //my version
    static int firstOcc(int i, int[] arr, int key) {
        if(i == arr.length) return -1;

        if(arr[i] == key) return i;
        return firstOcc(i + 1, arr, key);
    }

    //my version
    static int lastOcc(int i, int[] arr, int key) {

        if(i == arr.length) return -1;
        int res = lastOcc(i + 1, arr, key);
        if(res != - 1) return res;

        if(arr[i] == key) return i;

        return -1;

    }




    static int firstOcc(int i, int arr[],int n,int key){

        //base case
        if(i == n){
            return -1;
        }
        //rec case
        if(arr[i]==key){
            return 0;
        }
        int subIndex = firstOcc(i+1, arr, n, key);
        if(subIndex!=-1){
            return subIndex + 1;
        }
        return -1;
    }

    static int lastOcc(int i, int arr[],int n,int key){
        //Complete this Code
        //base case
        if(i == n){
            return -1;
        }

        //rec case
        int subIndex = lastOcc(i+1,arr , n, key);
        if(subIndex==-1){
            if(arr[i]==key){
                return 0;
            }
            else{
                return -1;
            }
        }
        else{
            return subIndex + 1;
        }
    }


    public static void main(String[] args) {

        int[] arr = {1,3,5,8,7,6,2,8,7,11,21};
        int n = arr.length;
        int key = 21;
        System.out.println(firstOcc(0,arr,n,key));
        //my version
        System.out.println(firstOcc(0,arr,key));

        System.out.println(lastOcc(0,arr,n,key));

        //my version
        System.out.println(lastOcc(0,arr,key));

    }
}

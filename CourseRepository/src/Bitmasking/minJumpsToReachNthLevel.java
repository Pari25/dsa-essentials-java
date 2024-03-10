package Bitmasking;


//Calculate min no. of jumps to n th level starting from 0, if the jump can be made in powers of 2.
//e.g, n = 7, means min steps = 3, ----> 4 + 2 + 1
public class minJumpsToReachNthLevel {

    //brute force
    private static int minJumpsToReachNthLevel(int n) {

        int count = 0;
        while(n > 0) {
            int pow = 0;
            int res = 1;
            while(res <= n) {
                pow++;
                res = res << 1;
            }
            n = n - (res >> 1);
            count++;
        }

        return count;
    }


    // 7 = 111 = 3 set bits = 3 min moves because 111 = (100 + 10 + 1) . 100, 10, 1 are all powers of 2, which can be reached in 1 step.
    private static int minJumpsToReachNthLevelOptimised(int n) {
        int setBits = 0;
        while(n > 0) {
            if((n & 1) != 0) {
                setBits++;
            }
            n = n >> 1;
        }

        return setBits;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(minJumpsToReachNthLevel(n));
        System.out.println(minJumpsToReachNthLevelOptimised(n));
    }
}

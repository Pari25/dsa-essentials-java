package Bitmasking;

import java.util.Scanner;

public class common_ops {


    static int getIthBit(int n,int i){
        int mask = (1<<i);
        return (n & mask) > 0 ? 1 : 0;
    }

    static int setIthBit(int n,int i){

        int mask = (1<<i);
        n = (n|mask);
        return n;
    }

    static int clearIthBit(int n,int i){

        int mask = ~(1<<i);
        n = n & mask;
        return n;
    }

    static int updateIthBit(int n,int i,int v){
        clearIthBit(n,i);
        int mask = (v<<i);
        n = n|mask; //sets the right value
        return n;
    }

    static int clearLastIBits(int n,int i){
        /** 0 in 32 bit form will be 000000000..... ~0 will be 1111111........ ~0 is same as -1.
         * Negative numbers are stored in 2s complement form.
         * MSB represents sign and magnitude is represented by negating the number and adding 1 to it. **/
        int mask = (~0 << i); // You can also do (-1 << i) here.
        n = n & mask;
        return n;
    }

    static int clearBitsInRange(int n,int i,int j){
        //ex: a = 111000000....b = 000000111...mask = 111000000111 ans then you can get n
        int a = (~0)<<(j+1);
        int b = (1<<i) - 1;
        int mask = a|b;
        n = n & mask;
        return n;
    }


    public static void main(String[] args){

        int n = 31;
        int i=1;
        int j=3;
        System.out.println(getIthBit(n,i));
        System.out.println(setIthBit(n,i));
        System.out.println(clearIthBit(n,i));
        System.out.println(updateIthBit(n,i,0));
        n = 15; i = 2;
        System.out.println(clearLastIBits(n,i));
        n = 31; i = 1; j = 3;
        System.out.println(clearBitsInRange(n,i,j));
    }
}

package characterArray;

import java.util.Arrays;

public class removeDuplicates {


    //O(n) time complexity and constant extra space. But it is not in place.
    private static String removeDuplicates(String s1) {

        //Keep it 256 if all alphabets digits spaces are considered.
        int[] count = new int[128];
        StringBuilder result = new StringBuilder("");

        for(int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }

        for(int i = 0; i < 128; i++) {
            if(count[i] != 0) {
                result.append((char) i);
            }

        }

        return result.toString();

    }


    //Removing duplicates In Place - O(nlogn) time but no auxiliary space
    private static String removeDuplicatesInPlace(String s1) {

       char[] charArray = s1.toCharArray();
       Arrays.sort(charArray);
       s1 = new String(charArray);

       int resIndex = 0;

       for(int i = 1; i < s1.length(); i++) {

           if(i < s1.length() && s1.charAt(i) != s1.charAt(i - 1)) {
                resIndex++;
                charArray[resIndex] = s1.charAt(i);
           }
       }

       s1 = new String(charArray);
       return s1.substring(0, resIndex + 1);

    }

    public static void main(String[] args) {


        String s1 = "test";
        System.out.println(removeDuplicates(s1));

        s1 = "geeksforgeeks";
        System.out.println(removeDuplicates(s1));

        s1 = "test";
        System.out.println(removeDuplicatesInPlace(s1));

        s1 = "geeksforgeeks";
        System.out.println(removeDuplicatesInPlace(s1));


    }
}

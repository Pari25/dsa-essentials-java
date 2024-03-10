package characterArray;

public class checkPalindrome {

    private static boolean checkPalindrome(String test) {
        int start = 0, end = test.length() - 1;

        while(start < end) {
            if(test.charAt(start) != test.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String test = "abba";
        System.out.println(checkPalindrome(test));
    }
}

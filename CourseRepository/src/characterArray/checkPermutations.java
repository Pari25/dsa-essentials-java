package characterArray;

public class checkPermutations {

    private static boolean arePermutations(String s1, String s2) {

        if(s1.length() != s2.length()) return false;

        //Keep it 256 if all alphabets digits spaces are considered.
        int[] count = new int[128];

        for(int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for(int i = 0; i < 128; i++) {
            if(count[i] != 0) return false;
        }

        return true;

    }

    public static void main(String[] args) {


        String s1 = "test";
        String s2 = "esti";

        System.out.println(arePermutations(s1, s2));

        s1 = "test";
        s2 = "estt";

        System.out.println(arePermutations(s1, s2));


    }

}

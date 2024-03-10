package BackTracking;

import java.util.Arrays;
import java.util.List;

public class wordBreak {



    private static int findTotalWaysToBreakWord(String s, List<String> dict, int i) {

        if(i == s.length()) {
            return 1;
        }

        int totalWays = 0;
        for(int j = i + 1; j <= s.length(); j++) {
            if(dict.contains(s.substring(i, j))) {
                totalWays += findTotalWaysToBreakWord(s, dict, j);
            }
        }

        return totalWays;
    }

    public static void main(String[] args) {
        String s = "ilikesamsungmobile";
        List<String> dict = Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile");

        System.out.println(findTotalWaysToBreakWord(s, dict, 0));
    }
}

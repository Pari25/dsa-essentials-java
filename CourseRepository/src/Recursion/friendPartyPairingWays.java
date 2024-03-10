package Recursion;

/**
 * Given n friends, each one can remain single or can be paired up with some other friend.
 * Each friend can be paired only once. Find out the total number of ways in which friends can remain single or
 * can be paired up.
 * for n = 3, output = 4
 * {1}, {2}, {3} : all single
 * {1}, {2,3} : 2 and 3 paired but 1 is single.
 * {1,2}, {3} : 1 and 2 are paired but 3 is single.
 * {1,3}, {2} : 1 and 3 are paired but 2 is single.
 *
 * Note that {1,2} and {2,1} are considered
 */
public class friendPartyPairingWays {

    private static int countFriendsPairings(int n) {

        if (n == 0) return 1;
        if(n == 1) return 1;

        //the last person can either choose to be single i.e. f(n - 1) ways  or it can choose to pair.
        // He can pair with someone in (n - 1) ways and remaining (n - 2) people can pair in f(n - 2) ways.
        return countFriendsPairings(n - 1) + ((n - 1) * countFriendsPairings(n - 2));
    }

    public static void main(String[] args) {

        int n = 3;

        System.out.println(countFriendsPairings(n));

    }

}

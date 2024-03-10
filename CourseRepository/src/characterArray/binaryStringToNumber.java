package characterArray;

public class binaryStringToNumber {

    private static int getNumberFromBinaryString(String s) {
        int n = s.length();
        int count = 0;
        int power = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                count = count + (1 << power);
            }
            power++;
        }

        //Alternatively you can also use inbuilt function
        //Integer.parseInt(s, 2);

        return count;
    }

    public static void main(String[] args) {
        String s1 = "11";
        System.out.println(getNumberFromBinaryString(s1));
    }
}

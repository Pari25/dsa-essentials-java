package characterArray;

public class printVowels {

    private static void printVowels(String s) {

        String vowels = "aeiou";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    sb.append(s.charAt(i));
                    break;
            }
        }

        System.out.println(sb);

    }

    public static void main(String[] args) {
        String s1 = "aeoibsddaeioudb";
        printVowels(s1);
    }
}

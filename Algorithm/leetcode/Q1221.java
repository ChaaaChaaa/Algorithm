package leetcode;

public class Q1221 {
    private static final char R = 'R';
    private static final char L = 'L';

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";

        System.out.println(balancedStringSplit(s));

    }

    public static int balancedStringSplit(String s) {
        int R = 0;
        int L = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                R++;
            } else if (s.charAt(i) == 'L') {
                L++;
            }

            if (R == L) {
                R = 0;
                L = 0;
                count++;
            }
        }
        return count;
    }
}

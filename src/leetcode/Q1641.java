package leetcode;

public class Q1641 {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));
    }

    public static int countVowelStrings(int n) {
        backTrack(n, 0);
        return count;
    }

    private static void backTrack(int cnt, int currentDepth) {
        if (cnt == 0) {
            count++;
            return;
        }
        for (int i = currentDepth; i < 5; i++){
            backTrack(cnt - 1, i);
        }

    }
}

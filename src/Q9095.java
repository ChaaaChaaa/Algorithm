import java.util.Scanner;

public class Q9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        PlusOneTwoThree plus = new PlusOneTwoThree();

        while (tc > 0) {
            int n = sc.nextInt();
            System.out.println(plus.backtracking(0, n));
            tc--;
        }
    }
}

class PlusOneTwoThree {
    int backtracking(int sum, int ans) {
        if (sum > ans) {
            return 0;
        }

        if (sum == ans) {
            return 1;
        }

        int count = 0;

        for (int i = 1; i <= 3; i++) {
            count += backtracking(sum + i, ans);
        }

        return count;
    }
}

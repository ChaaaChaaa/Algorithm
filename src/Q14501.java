import java.util.Scanner;

public class Q14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] periodToFinishConsult = new int[N];
        int[] moneyAfterConsult = new int[N];

        for (int i = 0; i < N; i++) {
            periodToFinishConsult[i] = sc.nextInt();
            moneyAfterConsult[i] = sc.nextInt();
        }

        Resignation resignation = new Resignation(periodToFinishConsult, moneyAfterConsult, N);
        resignation.recursion(0, 0);
        System.out.println(resignation.getMaximumProfit());
    }
}

class Resignation {
    private static final int increasingDay = 1;
    private int[] periodToFinishConsult;
    private int[] moneyAfterConsult;
    private int N;
    private int maximumProfit = 0;

    Resignation(int[] periodToFinishConsult, int[] moneyAfterConsult, int N) {
        this.periodToFinishConsult = periodToFinishConsult;
        this.moneyAfterConsult = moneyAfterConsult;
        this.N = N;
    }

    void recursion(int day, int totalMoney) {
        if (day == N) {
            maximumProfit = Math.max(maximumProfit, totalMoney);
            return;
        }

        recursion(day + increasingDay, totalMoney);

        if (day + periodToFinishConsult[day] <= N) {
            recursion(day + periodToFinishConsult[day], totalMoney + moneyAfterConsult[day]);
        }
    }

    int getMaximumProfit() {
        return maximumProfit;
    }


}

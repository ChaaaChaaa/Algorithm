import java.util.Scanner;

public class Q14889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[][] a = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        StartToLink startToLink = new StartToLink(num, a);
        startToLink.belongToTeam(0, 0);

        System.out.println(startToLink.getMin());

    }
}

class StartToLink {
    private int[][] a;
    private int num;
    private boolean[] isTeamStart;
    private int min = Integer.MAX_VALUE;


    StartToLink(int num, int[][] a) {
        this.a = a;
        this.num = num;
        isTeamStart = new boolean[num];
    }

    void belongToTeam(int countToMakeTwoTeam, int changeToTrue) {
        int sumA = 0;
        int sumB = 0;

        if (isDivideIntoTwoTeam(countToMakeTwoTeam)) {
            for (int i = 0; i < num; i++) {
                for (int j = i + 1; j < num; j++) {
                    if (isNotChosenTeam(i, j)) {
                        continue;
                    }
                    if (isTeamStart[i]) {
                        sumA += a[i][j] + a[j][i];
                    }
                    if (!isTeamStart[i]) {
                        sumB += a[i][j] + a[j][i];
                    }
                }
            }
            compareMinValue(sumA, sumB);
            return;
        }
        recursion(countToMakeTwoTeam, changeToTrue);
    }

    private boolean isDivideIntoTwoTeam(int countRecursion) {
        return countRecursion == num / 2;
    }

    private boolean isNotChosenTeam(int i, int j) {
        return isTeamStart[i] != isTeamStart[j];
    }

    private void recursion(int countToMakeTwoTeam, int changeToTrue) {
        for (int i = changeToTrue; i < num; i++) {
            isTeamStart[i] = true;
            belongToTeam(countToMakeTwoTeam + 1, i + 1);
            isTeamStart[i] = false;
        }
    }


    private void compareMinValue(int sumA, int sumB) {
        min = Math.min(min, Math.abs(sumA - sumB));
    }

    int getMin() {
        return min;
    }

}

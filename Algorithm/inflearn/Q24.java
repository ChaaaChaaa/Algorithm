package inflearn;

import java.util.Scanner;

public class Q24 {
    public int q24(int n, int m, int[][] arr) {
        int ans = 0;
        for (int mento = 1; mento <= n; mento++) { //i의 등수 멘토
            for (int mentee = 1; mentee <= n; mentee++) { //j의 등수 멘티
                int cnt = 0;
                for (int testCount = 0; testCount < m; testCount++) { //테스트 번호(세로열)
                    int positionMento = 0, positionMentee = 0;
                    for (int position = 0; position < n; position++) { //등수(가로열)
                        if (arr[testCount][position] == mento) { //i학생일때
                            positionMento = position; //i의 등수
                        }
                        if (arr[testCount][position] == mentee) {//j학생일때
                            positionMentee = position; //j의 등수
                        }
                    }
                    if (positionMento < positionMentee) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q24 q24 = new Q24();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(q24.q24(n, m, arr));
    }
}

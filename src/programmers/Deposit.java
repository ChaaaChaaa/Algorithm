package programmers;

import java.util.Arrays;

public class Deposit {
    public int solution(int[] d, int budget) {
        int cnt = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {

            budget -= d[i];
            if (budget < 0) {
                continue;

            }
            cnt++;

        }
        return cnt;
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coinType = new int[n];

        for (int i = 0; i < coinType.length; i++) {
            coinType[i] = Integer.parseInt(br.readLine());
        }

        greedy(coinType, k, 0);
    }

    private static void greedy(int[] coinType, int target, int count) {
        for (int currentCoin = coinType.length - 1; currentCoin >= 0; currentCoin--) {
            if (target >= coinType[currentCoin]) {
                count += target / coinType[currentCoin];
                target = target % coinType[currentCoin];
            }
            if (target <= 0) {
                break;
            }
        }
        System.out.println(count);
    }
}

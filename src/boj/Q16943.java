package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16943 {
    private static boolean[] visit;
    private static char[] wordA;
    private static int wordB;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        wordA = st.nextToken().toCharArray();
        wordB = Integer.parseInt(st.nextToken());

        visit = new boolean[10];

        backTrack(0, 0, "");

        System.out.println(result);
    }

    private static void backTrack(int currentDepth, int count, String newNum) {
        int wordASize = wordA.length;
        if (wordASize == count) {
            if (isContain(Integer.parseInt(newNum))) {
                result = Math.max(result, Integer.parseInt(newNum));
            }
        }

        for (int i = 0; i < wordASize; i++) {
            if (visit[i] || (currentDepth == 0 && wordA[i] - '0' == 0)) {
                continue;
            }

            visit[i] = true;
            backTrack(i + 1, count + 1, newNum + wordA[i]);
            visit[i] = false;
        }
    }

    private static boolean isContain(int wordC) {
        if (wordC <= wordB) {
            return true;
        }
        return false;
    }
}

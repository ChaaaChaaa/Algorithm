package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1062_Bitmask {
    private static int n;
    private static int k;
    private static int status; // 배운 알파벳을 bitmasking으로 저장
    private static int[] wordBits; // 읽을 단어들
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        wordBits = new int[n];

        for (int i = 0; i < n; i++) {
            wordBits[i] = wordToBit(br.readLine());
        }

        if (k < 5) {
            System.out.println(0);
            return;
        }

        status = wordToBit("antic"); //antic을 배워서 저장

        String other = "bdefghjklmopqrsuvwxyz";

        max = Integer.MIN_VALUE;
        dfs(other, k - 5, 0, status);
        System.out.println(max);
    }

    static int addWord(int status, char c) {
        return status | 1 << (c - 'a'); //하나라도 true면 true
    }

    static boolean isContain(int status, char c) {
        return (status & 1 << (c - 'a')) != 0; // status에서 c가 포함되어있는가
    }


    public static int wordToBit(String str) {
        int status = 0;
        for (int i = 0; i < str.length(); i++) {
            status = addWord(status, str.charAt(i));
        }
        return status;
    }

    public static boolean check(int status, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isContain(status, str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(String str, int depth, int index, int status) {
        if (depth == 0) {
            System.out.println(Integer.toBinaryString(status));

            int cnt = 0;
            for (int wordBit : wordBits) {
                if ((wordBit | status) == status) {
                    //status = 내가 읽을 수 있는 전체집합 true면 새로운 단어는 없다.
                    cnt++;
                }
            }
            max = Math.max(cnt, max);
            return;
        }

        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isContain (status,c)) {
                continue;
            }
            dfs(str, depth - 1, i,addWord(status,c));
        }
    }
}

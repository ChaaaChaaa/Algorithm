package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1062_Recursion {
    private static int n;
    private static int k;
    private static String[] words;
    private static boolean[] visited = new boolean[26];
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        if (k < 5) {
            System.out.println("0");
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        backTracking(0, 5);
        System.out.println(max);
    }

    public static void backTracking(int index, int depth) {
        if (depth == k) {
            int count = n;

            for (int i = 0; i < n; i++) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    if (!visited[word.charAt(j) - 'a']) {
                        count--;
                        break;
                    }
                }
            }
            max = Math.max(count, max);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }

    }
}

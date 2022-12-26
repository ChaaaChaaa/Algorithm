package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2529 {

    public static int n;
    public static char[] a;
    public static ArrayList<String> ans = new ArrayList<String>();
    public static boolean[] check = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = st.nextToken().charAt(0);
        }

        go(0, "");

        Collections.sort(ans);
        int m = ans.size();
        System.out.println(ans.get(m - 1));
        System.out.println(ans.get(0));
    }

    static boolean good(char x, char y, char op) {
        if (op == '<') {
            if (x > y) {
                return false;
            }
        }

        if (op == '>') {
            if (x < y) {
                return false;
            }
        }

        return true;
    }

    static void go(int index, String num) {
        if (index == n + 1) {
            ans.add(num);
        }

        for (int i = 0; i <= 9; i++) {
            if (check[i]) {
                continue;
            }
            if (index == 0 || good(num.charAt(index - 1), (char) (i + '0'), a[index])) {
                check[i] = true;
                go(index + 1, num + i);
                check[i] = false;
            }
        }
    }
}


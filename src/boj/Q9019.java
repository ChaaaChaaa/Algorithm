package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Q9019 {
    private static String[] operation = {"D", "S", "L", "R"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int initNum = Integer.parseInt(st.nextToken());
            int finalNum = Integer.parseInt(st.nextToken());

            String res = process(initNum, finalNum);
            sb.append(res + "\n");
        }
        System.out.println(sb);
    }

    private static String process(int initNum, int finalNum) {
        Queue<RegisterCalculator> queue = new LinkedList<>();
        boolean[] visit = new boolean[10000];
        queue.add(new RegisterCalculator(initNum, ""));

        while (!queue.isEmpty()) {
            RegisterCalculator current = queue.poll();
            if (current.n == finalNum) {
                return current.command;
            }

            for (int i = 0; i < 4; i++) {
                int res = command(current, i);
                if (!visit[res]) {
                    visit[res] = true;
                    queue.add(new RegisterCalculator(res, current.command + operation[i]));
                }
            }
        }
        return "";
    }

    private static int command(RegisterCalculator now, int command) {
        switch (command) {
            case 0:
                return (now.n * 2) % 10000;
            case 1:
                if (now.n == 0) {
                    return 9999;
                }
                return now.n - 1;
            case 2:
                return (now.n % 1000) * 10 + (now.n / 1000);
            case 3:
                return (now.n % 10) * 1000 + (now.n / 10);
        }
        return 0;
    }
}

class RegisterCalculator {
    int n;
    String command;

    public RegisterCalculator(int n, String command) {
        this.n = n;
        this.command = command;
    }
}

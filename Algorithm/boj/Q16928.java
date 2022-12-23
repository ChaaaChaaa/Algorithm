package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16928 {
    private static int[] map;
    private static int current = 0;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[101]; //x에 도착한 이후에 가야할 곳


        for (int i = 1; i <= 100; i++) {
            map[i] = i;
        }

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int k = 0; k < n + m; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //사다리
            int y = Integer.parseInt(st.nextToken()); //뱀
            map[x] = y;//뱀
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        visit = new boolean[101];
        Queue<UserPosition> queue = new LinkedList<>();

        visit[1] = true;
        queue.add(new UserPosition(1, 0));

        while (!queue.isEmpty()) {
            UserPosition userPosition = queue.poll();
            int cnt = userPosition.cnt;
            int position = userPosition.position;

            if (position == 100) {
                current = cnt;
                break;
            }


            for (int add = 1; add <= 6; add++) {
                int next = position + add;
                if (next > 100) {
                    break;
                }
                if (visit[next]) {
                    continue;
                }

                if (map[next] == 0) {
                    queue.add(new UserPosition(map[next], cnt + 1));
                    visit[next] = true;
                } else {
                    queue.add(new UserPosition(map[next], cnt + 1));
                    visit[next] = true;
                    visit[map[next]] = true;
                }
            }
        }
        return current;
    }
}

class UserPosition {
    int position;
    int cnt;

    UserPosition(int position, int cnt) {
        this.position = position;
        this.cnt = cnt;
    }
}

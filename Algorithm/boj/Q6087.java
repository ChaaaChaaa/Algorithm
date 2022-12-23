package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6087 {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] dist;
    private static char[][] map;
    private static int H, W;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];

        boolean isStart = false;

        Position start = null;
        Position end = null;

        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'C') {
                    if (!isStart) {
                        start = new Position(i, j);
                        isStart = true;
                    } else
                        end = new Position(i, j);
                }
            }
        }

        bfs(start, end);
        System.out.println(result);
    }

    private static void bfs(Position start, Position end) {
        Queue<Position> queue = new LinkedList<>();
        dist = new int[H][W];
        queue.add(start);

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            if (dist[end.x][end.y] != 0) {
                result = Math.min(result,dist[end.x][end.y]-1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;


                while (isIn(nx, ny) && map[nx][ny] != '*') {
                    if (dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[now.x][now.y] + 1;
                        queue.add(new Position(nx, ny));
                    }
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        return;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < H && y < W;
    }
}
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3055 {
    private static char[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Position> waterPosition = new LinkedList<>();
        Queue<Position> hedgehogPosition = new LinkedList<>();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    waterPosition.add(new Position(i, j));
                } else if (map[i][j] == 'S') {
                    hedgehogPosition.add(new Position(i, j));
                }
            }
        }

        int result = bfs(waterPosition, hedgehogPosition);
        if (result == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(Queue<Position> waterPosition, Queue<Position> hedgehogPosition) {
        int time = 0;
        int size = waterPosition.size();

        while (!hedgehogPosition.isEmpty()) {
            ++time;

            for (int i = 0; i < size; i++) {
                Position water = waterPosition.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = dx[d] + water.x;
                    int ny = dy[d] + water.y;

                    if (nx >= R || nx < 0 || ny >= C || ny < 0 || map[nx][ny] == '*') {
                        continue;
                    }

                    if(map[nx][ny] == 'X' || map[nx][ny] == 'D'){
                        continue;
                    }

                    map[nx][ny] = '*';
                    waterPosition.add(new Position(nx,ny));
                }
            }

            size = hedgehogPosition.size();

            for (int i = 0; i < size; i++) {
                Position hedgehog = hedgehogPosition.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = dx[d] + hedgehog.x;
                    int ny = dy[d] + hedgehog.y;

                    if (nx >= R || nx < 0 || ny >= C || ny < 0 || map[nx][ny] == 'S') {
                        continue;
                    }

                    if(map[nx][ny] == '*' || map[nx][ny] == 'X'){
                        continue;
                    }

                    if(map[nx][ny] == 'D'){
                        return time;
                    }

                    map[nx][ny] = 'S';
                    hedgehogPosition.add(new Position(nx,ny));
                }
            }
        }
        return 0;
    }
}

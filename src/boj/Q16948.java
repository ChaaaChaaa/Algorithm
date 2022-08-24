package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q16948 {
    private static final int[] dr = {-2, -2, 0, 0, 2, 2};
    private static final int[] dc = {-1, 1, -2, 2, -1, 1};
    private static boolean[][] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mapSize = Integer.parseInt(br.readLine());

        visit = new boolean[mapSize][mapSize];

        String[] s = br.readLine().split("\\s");
        int startR = Integer.parseInt(s[0]);
        int startC = Integer.parseInt(s[1]);
        int endR = Integer.parseInt(s[2]);
        int endC = Integer.parseInt(s[3]);

        System.out.println(bfs(mapSize, startR, startC, endR, endC));

    }

    private static int bfs(int mapSize, int startR, int startC, int endR, int endC) {
        Queue<ChessPosition> chessPositions = new LinkedList<>();
        chessPositions.add(new ChessPosition(startR, startC, 0));
        visit[startR][startC] = true;

        while (!chessPositions.isEmpty()) {
            ChessPosition chessPosition = chessPositions.poll();
            int r = chessPosition.r;
            int c = chessPosition.c;

            if (r == endR && c == endC) {
                return chessPosition.cnt;
            }

            for (int i = 0; i < 6; i++) {
                int nr = dr[i] + r;
                int nc = dc[i] + c;

                if (!isWall(nr, nc, mapSize) || visit[nr][nc]) {
                    continue;
                }

                visit[nr][nc] = true;
                chessPositions.add(new ChessPosition(nr, nc, chessPosition.cnt + 1));
            }
        }
        return -1;
    }

    private static boolean isWall(int r, int c, int mapSize) {
        return ((r >= 0 && r < mapSize) && (c >= 0 && c < mapSize));
    }
}

class ChessPosition {
    int r;
    int c;
    int cnt;

    ChessPosition(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

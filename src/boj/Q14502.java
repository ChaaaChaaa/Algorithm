package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Q14502 {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static final int BLANK = 0;
    private static int wallCnt = 0;
    private static final int VIRUS = 2;
    private static final int WALL = 1;
    private static int[][] virusMap;
    private static int n, m;
    private static int answer = Integer.MIN_VALUE;
    private static ArrayList<Position> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        virusMap = new int[n][m];
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                virusMap[i][j] = Integer.parseInt(st.nextToken());
                if (virusMap[i][j] == WALL) {
                    wallCnt++;
                }
                if (virusMap[i][j] == VIRUS) {
                    virus.add(new Position(i, j));
                }
            }
        }
        setUpWall(0);
        System.out.println(answer);
    }

    private static void setUpWall(int cnt) {
        if (cnt == 3) {
            spreadVirus();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == BLANK) {
                    virusMap[i][j] = WALL;
                    setUpWall(cnt + 1);
                    virusMap[i][j] = BLANK;
                }
            }
        }
    }

    private static void spreadVirus() {
        Queue<Position> queue = new LinkedList<>();
        int virusCnt = 0;
        boolean[][] visit = new boolean[n][m];


        for (int i = 0; i < virus.size(); i++) {
            Position originalVirusPosition = virus.get(i);
            queue.add(new Position(originalVirusPosition.x, originalVirusPosition.y));

            while (!queue.isEmpty()) {
                Position current = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + current.x;
                    int ny = dy[j] + current.y;

                    if (!isWall(nx, ny) || visit[nx][ny] || virusMap[nx][ny] != 0) {
                        continue;
                    }

                    visit[nx][ny] = true;
                    virusCnt++;
                    queue.add(new Position(nx, ny));
                }
            }
        }
        calAnswer(virusCnt);
    }

    private static boolean isWall(int x, int y) {
        return ((x >= 0 && x < n) && (y >= 0 && y < m));
    }

    public static void calAnswer(int virusCnt) {
        answer = Math.max(answer, (n * m) - wallCnt - 3 - virusCnt - virus.size());
    }
}

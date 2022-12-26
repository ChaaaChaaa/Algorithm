package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16236_Short {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static int n;
    private static int ans;
    private static SharkPosition sharkPosition;
    private static PriorityQueue<SharkPosition>   eatingFishPQ = new PriorityQueue<>();
    private static Queue<SharkPosition> movingQueue = new LinkedList<>();
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];



        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    visited[i][j] = true;
                    movingQueue.add(new SharkPosition(i, j, 0, 0, 2));
                }
            }
        }
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        while (!movingQueue.isEmpty()) {
            if (eatingFishPQ.size() > 0) {
                SharkPosition sharkPosition = eatingFishPQ.poll();
                map[sharkPosition.row][sharkPosition.col] = 0;
                eatingFishPQ.clear();
                movingQueue.clear();
                visited = new boolean[n][n];

                if (sharkPosition.eat == sharkPosition.size) { //아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
                    sharkPosition.size = sharkPosition.size + 1;
                    sharkPosition.eat = 0;
                }
                ans = sharkPosition.cnt;
                movingQueue.add(new SharkPosition(sharkPosition.row, sharkPosition.col, sharkPosition.cnt, sharkPosition.eat, sharkPosition.size));
            }

            int size = movingQueue.size();

            for (int i = 0; i < size; i++) {
                SharkPosition sharkPosition = movingQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + sharkPosition.row;
                    int ny = dy[j] + sharkPosition.col;

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }

                    if (visited[nx][ny] || map[nx][ny] > sharkPosition.size) {
                        continue;
                    }

                    if (map[nx][ny] > 0 && map[nx][ny] < sharkPosition.size) {
                        eatingFishPQ.add(new SharkPosition(nx, ny, sharkPosition.cnt + 1, sharkPosition.eat + 1, sharkPosition.size));
                    }

                    visited[nx][ny] = true;
                    movingQueue.add(new SharkPosition(nx, ny, sharkPosition.cnt + 1, sharkPosition.eat, sharkPosition.size));
                }
            }
        }
    }
}

class SharkPosition implements Comparable<SharkPosition> {
    int row;
    int col;
    int cnt;
    int eat;
    int size;

    public SharkPosition(int row, int col, int cnt, int eat, int size) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
        this.eat = eat;
        this.size = size;
    }

    @Override
    public int compareTo(SharkPosition o) {
        if (this.row == o.row) {
            return Integer.compare(this.col, o.col);
        }
        return Integer.compare(this.row, o.row);
    }
}
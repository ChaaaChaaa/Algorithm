package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16236 {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] map;
    private static boolean[][] visited;
    private static int moveCnt;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        Shark shark = null;
        StringTokenizer st = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    shark = new Shark(i, j, 2, 0, 0);
                }
            }
        }

        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }

        bfs(shark);
        System.out.println(moveCnt);
    }

    private static void bfs(Shark shark) {
        Queue<Shark> queue = new LinkedList<>();
        queue.add(shark);

        visited = new boolean[n][n];
        visited[shark.x][shark.y] = true;

        int targetDepth = -1;

        PriorityQueue<Fish> targetFishList = new PriorityQueue<>();

        Shark front = null;

        findFish:
        while (!queue.isEmpty()) {
            front = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = front.x + dx[i];
                int ny = front.y + dy[i];

                if (isWall(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0 || map[nx][ny] == front.size) {
                        queue.add(new Shark(nx, ny, front.size, front.depth + 1, front.eatCnt));
                    } else if (map[nx][ny] < front.size) {
                        if (targetDepth == -1 || targetDepth == front.depth + 1) {
                            Fish fish = new Fish(nx, ny, map[nx][ny], front.depth + 1);
                            targetFishList.add(fish);
                            targetDepth = fish.depth;
                        } else {
                            break findFish;
                        }
                    }
                }
            }
        }
        if(targetFishList.isEmpty()){
            return;
        }
        else{
            Fish forEat = targetFishList.poll();

            front.eat(forEat.size);
            map[forEat.x][forEat.y] = 0;
            moveCnt += forEat.depth;
            bfs(new Shark(forEat.x,forEat.y,front.size,0,front.eatCnt));
        }
    }

    static boolean isWall(int x, int y){
        return 0<=x && 0<= y && x<n && y<n;
    }
}

class Shark {
    int x;
    int y;
    int size;
    int depth;
    int eatCnt;

    public Shark(int x, int y, int size, int depth, int eatCnt) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.depth = depth;
        this.eatCnt = eatCnt;
    }

    public void eat(int cnt) { //한번에 한마리씩 먹고 몸집만큼 먹으면 크기 변경
        eatCnt++;
        if (eatCnt == size) {
            eatCnt = 0;
            size++;
        }
    }
}

class Fish implements Comparable<Fish> {
    int x;
    int y;
    int size;
    int depth;

    public Fish(int x, int y, int size, int depth) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.depth = depth;
    }

    //1순위 depth, 2순위 세로 위쪽, 3순위 가로 왼쪽
    @Override
    public int compareTo(Fish o) {
        if (depth == o.depth) {
            if (x == o.x) {
                return Integer.compare(y, o.y);
            } else {
                return Integer.compare(x, o.x);
            }
        } else {
            return Integer.compare(depth, o.depth);
        }
    }
}



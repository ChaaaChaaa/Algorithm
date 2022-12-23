package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
    private static int[][] map;
    private static boolean[][][] visit;
    private static Queue<PositionBreakWall> queue;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, m;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m][2];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
          String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        queue.add(new PositionBreakWall(0,0,1,0));
        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            PositionBreakWall position = queue.poll();

            if(position.x == n-1 && position.y == m-1){
                result = position.distance;
                break;
            }

            int x = position.x;
            int y = position.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if(!isWall(nx,ny)){
                    continue;
                }
                if(map[nx][ny] == 0){
                    if(visit[nx][ny][position.breakWallCnt]){
                        continue;
                    }
                    queue.add(new PositionBreakWall(nx,ny,position.distance+1,position.breakWallCnt));
                    visit[nx][ny][position.breakWallCnt] = true;
                }

                else{
                    if(position.breakWallCnt != 0 || visit[nx][ny][position.breakWallCnt+1]){
                        continue;
                    }
                    queue.add(new PositionBreakWall(nx,ny,position.distance+1,position.breakWallCnt+1));
                    visit[nx][ny][position.breakWallCnt+1] = true;
                }
            }
        }
       return result;
    }

    private static boolean isWall(int nx, int ny) {
        return ((nx >= 0 && nx < n) && (ny >= 0 && ny < m)) ;
    }
}

class PositionBreakWall{
    int x;
    int y;
    int distance;
    int breakWallCnt;

    PositionBreakWall(int x, int y,int distance,int breakWallCnt){
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.breakWallCnt = breakWallCnt;
    }
}

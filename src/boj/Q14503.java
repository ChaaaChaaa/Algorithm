package boj;

import java.util.*;
import java.io.*;

class Q14503 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m,r,c,cnt;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        cnt = 0;

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int direction) {
        map[x][y] = 2;
        boolean isBack = true;
        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            int nx = dx[direction] + x;
            int ny = dy[direction] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < m &&  map[nx][ny] == 0) {
                cnt++;
                isBack = false;
                //일반적인 dfs는 가다가 길이 막히면 다시 되돌아와서 해당 위치부터 계산하지만, 이 문제는 후진할 때만 이전 길을 되돌가 가며 확인할 수 있으므로 return을 해서 다시 되돌아 와도 더 이상 움직이면 안된다.
                dfs(nx,ny,direction);
                return;
            }
        }

        //반목문을 빠져 나왔단는 것은 주변에 더 이상 청소할 공간이 없다는 의미이다.
        if(isBack){
            int back = (direction+2)%4;
            int nx = dx[back] + x;
            int ny = dy[back] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 1){
                dfs(nx,ny,direction); //후진할 때 방향을 유지해야 한다.
            }
        }
    }
}
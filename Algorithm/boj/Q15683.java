package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15683 {
    private static int n,m,res, cnt;
    private static CCTV[] cctvs;
    private static int [] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    static int[][][] ccDir = { // 각 cctv가 볼 수 있는 영역(회전)
            {{0}},
            {{1}, {2}, {3}, {0}}, // 1번 cctv
            {{1, 3}, {0, 2}}, // 2번 cctv
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 cctv
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, // 4번 cctv
            {{0, 1, 2, 3}}, // 5번 cctv
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        int[][] map = new int[n][m];
        cctvs = new CCTV[8];

        int remain = n * m;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // CCTV일 경우
                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs[cnt++] = new CCTV(map[i][j], i, j);
                }
                // 벽일경우
                else if(map[i][j] == 6) remain--;
            }
        }

        res = Integer.MAX_VALUE;

        backTrack(0, remain - cnt, map);

        System.out.println(res);
    }


    private static void backTrack(int index, int remain, int[][] map){
        if(index == cnt){
            print(map);
            System.out.println();
            res = Math.min(res,remain);
            return;
        }

        int[][] newMap = new int[n][m];
        copy(newMap, map);

        CCTV cctv = cctvs[index];

        //결국 ccDir[cc.type].length 는 해당 CCTV가 회전할 수 있는 방법의 수
        for(int i=0; i<ccDir[cctv.type].length; i++){
            int check = 0;
            //ccDir[cc.type][j].length 는 해당 CCTV가 j번째 회전 방법으로 감시할 수 있는 방향의 수

            for(int j=0; j<ccDir[cctv.type][i].length; j++){

               int d = ccDir[cctv.type][i][j];
                System.out.println(cctv.type);
                check+= observation(cctv.x,cctv.y,d,newMap);
            }
            backTrack(index+1, remain-check,newMap);

            copy(newMap,map);
            //다른 방향으로도 감시해보기 위해 map 상태를 되돌리는 작업이다.
        }
    }

    private static int observation(int x, int y, int d, int[][] map){
        int cnt =0;
        while(true){
            x += dx[d];
            y += dy[d];

            if(x<0 || x>= n || y<0 || y>=m || map[x][y] == 6){
                return cnt;
            }
            if((map[x][y] >= 1 && map[x][y] <=5) || map[x][y] == -1){
                continue;
            }
            map[x][y] = -1;
            cnt++;
        }
    }

    private static void copy(int[][] newMap, int[][] map){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                newMap[i][j] = map[i][j];
            }
        }
    }

    public static void print(int[][] newMap){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(newMap[i][j]+" ");
            }
            System.out.println();
        }
    }

    static class CCTV{
        int type, x, y;
        public CCTV(int type, int x, int y){
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}

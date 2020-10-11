package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Q14502 {
    private static final int[] dx =  {0,0,1,-1};
    private static final int[] dy = {1,-1,0,0};
    private static final int BLANK = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    private static int[][] inputArr;
    private static int[][] map;
    private static int n, m;
    private static int answer= Integer.MIN_VALUE;



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        inputArr = new int[n][m];
        map = new int[n][m];

        for(int i = 0; i < n; i++)
            for(int j = 0 ; j < m; j++)
                inputArr[i][j] = map[i][j] = sc.nextInt();


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(inputArr[i][j] == BLANK){
                    map[i][j] = WALL;
                    dfs(1);
                    map[i][j] = BLANK;
                }
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int cnt) {
        if(cnt == 3){
            bfs();
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == BLANK){
                    map[i][j] = WALL;
                    dfs(cnt+1);
                    map[i][j] = BLANK;
                }
            }
        }
    }

    private static void bfs(){
        int[][] virusMap = new int[n][m];
        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                virusMap[i][j] = map[i][j];
            }
        }
        Queue<Position> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(virusMap[i][j] == VIRUS){
                    queue.add(new Position(i,j));
                }
            }
        }

        while (!queue.isEmpty()){
            Position position = queue.remove();

            for(int i=0; i<4; i++){
                int nx = dx[i]+position.x;
                int ny = dy[i]+position.y;

                if(0<=nx&&nx<n&&0<=ny&&ny<m){
                    if(virusMap[nx][ny] == BLANK){
                        virusMap[nx][ny]  = VIRUS;
                        queue.add(new Position(nx,ny));
                    }
                }
            }
        }
        calAnswer(virusMap);
    }

    public static void calAnswer(int[][] virusMap){
        int cnt= 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(virusMap[i][j] == BLANK){
                    ++cnt;
                }
            }
        }
        answer = Math.max(cnt,answer);
    }
}
